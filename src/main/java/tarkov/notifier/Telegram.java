package tarkov.notifier;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Slf4j
public class Telegram {
    private static final String FALLBACK_ID = Configuration.getOSVariable("FALLBACK_ID");
    private static final String BOT_TOKEN = Configuration.getOSVariable("ERROR_BOT");
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public static void sendError(Exception exception) {
        log.error("Sending an error to telegram", exception);
        String exceptionAsString = exceptionToString(exception);
        try {
            sendMessage(exceptionAsString);
        } catch (IOException | InterruptedException e) {
            log.error("Got exception while sending error to Telegram bot" + e);
        }
    }

    public static void sendMessage(String sentMessage) throws IOException, InterruptedException {
        String message = URLEncoder.encode("Tarkov-Market API bot:\n" + sentMessage, StandardCharsets.UTF_8);
        String link = "https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage?chat_id=" + FALLBACK_ID + "&text=" + message;
        HttpRequest request = HttpRequest.newBuilder(URI.create(link)).build();
        HttpResponse<String> response = sendRequest(request);
        int statusCode = response.statusCode();
        String logMsg = "Sent error, got " + statusCode;
        if (statusCode == 200) {
            log.info(logMsg);
        } else {
            log.error(logMsg);
        }
    }

    private static HttpResponse<String> sendRequest(HttpRequest request) throws IOException, InterruptedException {
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static String exceptionToString(Exception exception) {
        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
