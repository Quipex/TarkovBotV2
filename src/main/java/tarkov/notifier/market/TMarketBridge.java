package tarkov.notifier.market;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import tarkov.notifier.Configuration;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.google.common.base.Preconditions.checkNotNull;

@Slf4j
public class TMarketBridge {
    private static String T_MARKET = Configuration.getOSVariable("T_MARKET_ITEM_ENDPOINT");
    private static String API_KEY = Configuration.getOSVariable("API_KEY");
    private static int REQUESTS_PER_MINUTE = Integer.parseInt(Configuration.getOSVariable("REQS_PER_MIN"));
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private LocalDateTime latestRegisteredMinute;
    private int requestsCount;

    public TMarketBridge() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public TMarketItem getItemByUID(String uid) {
        checkNotNull(uid);
        if (!outOfLimit()) {
            HttpRequest request = buildRequest(uid);
            HttpResponse<String> response = sendRequest(request);
            if (isValid(response)) {
                log.debug("Got response {}\nResponse body: {}", response.statusCode(), response.body());
                return parseMarketItem(response.body());
            } else {
                log.error("Wrong response code:{}\nBody:\n{}", response.statusCode(), response.body());
                throw new TMarketException("Wrong response " + response.statusCode());
            }
        } else {
            try {
                log.warn("Max requests per minute, waiting...");
                wait(1000);
            } catch (InterruptedException e) {
                log.error("Interrupted while sleeping", e);
                throw new TMarketException(e);
            }
            return getItemByUID(uid);
        }
    }

    private boolean isValid(HttpResponse<String> response) {
        return response.statusCode() == 200;
    }

    private TMarketItem parseMarketItem(String body) {
        try {
            TMarketItem[] tMarketItems = objectMapper.readValue(body, TMarketItem[].class);
            if (tMarketItems.length != 1) {
                String msg = "Wrong size of item array in TMarket response (must be 1): " + tMarketItems.length;
                TMarketException exception = new TMarketException(msg);
                log.error(msg);
                throw exception;
            }
            return tMarketItems[0];
        } catch (JsonProcessingException e) {
            String message = "Can't parse the response";
            log.error("{}\nBody:\n{}", message, body);
            throw new TMarketException(message, e);
        }

    }

    private HttpResponse<String> sendRequest(HttpRequest request) {
        try {
            log.debug("Sending request:\n{}", request.toString());
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error("Got an error while requesting item from TMarket", e);
            throw new TMarketException(e);
        }
    }

    private HttpRequest buildRequest(String uid) {
        return HttpRequest.newBuilder(URI.create(T_MARKET + "?uid=" + uid))
                .setHeader("x-api-key", API_KEY)
                .build();
    }

    private boolean outOfLimit() {
        LocalDateTime now = LocalDateTime.now();
        if (latestRegisteredMinute == null) {
            latestRegisteredMinute = now;
            return false;
        }
        long secondsPassed = ChronoUnit.SECONDS.between(latestRegisteredMinute, now);
        if (secondsPassed > 61) {
            resetLimit(now);
            return false;
        } else {
            if (requestsCount >= REQUESTS_PER_MINUTE) {
                return true;
            } else {
                requestsCount++;
                return false;
            }
        }
    }

    private void resetLimit(LocalDateTime now) {
        requestsCount = 1;
        latestRegisteredMinute = now;
    }
}
