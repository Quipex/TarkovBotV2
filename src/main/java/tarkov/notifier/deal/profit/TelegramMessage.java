package tarkov.notifier.deal.profit;

import lombok.Data;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public abstract class TelegramMessage {
    private String title;
    private List<Profit> profits;
    private DecimalFormat priceFormat = new DecimalFormat("#,###");

    public TelegramMessage(String title, List<Profit> profits) {
        this.title = title;
        this.profits = profits;
    }

    public String generateMessage() {
        StringBuilder message = new StringBuilder();
        message.append("#").append(title.toUpperCase()).append(" ").append(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM HH:mm:ss"))).append("\n");
        for (Profit profit : profits) {
            message.append(generatePart(profit)).append("\n");
        }
        return message.toString();
    }

    private String generatePart(Profit profit) {
        int resultItemAmount = profit.getDeal().getItemAmount();
        String message = formatHashCode(profit.getDeal().getItemName()) + " x" + resultItemAmount +
                " [#" + profit.getDeal().category() + "] " + "\n" +
                "Реальная прибыль " + formatPrice(profit.getProfit());
        if (resultItemAmount > 1) {
            message += "(" + profit.getFleaPrice() / resultItemAmount + ")";
        }
        message += " (" + profit.getProfitPercents() + "%)";
        if (profit.getTaxes() > 0) {
            message += ", комиссия " + formatPrice(profit.getTaxes());
        }
        message += ".\nНа барахолке " + formatPrice(profit.getFleaPrice()) + ", на самом деле " + formatPrice(profit.getRealPrice()) + ".\n";
        message += additionalInfo(profit).isBlank() ? "" : additionalInfo(profit) + "\n";
        message += "Ресурсы:\n";
        StringBuilder resourceListText = new StringBuilder();
        profit.getResourcesToPrice().forEach(((resourceAmount, price) ->
                resourceListText.append(resourceAmount.getName()).append(" { цена: ").append(formatPrice(price))
                .append(", кол-во: ").append(resourceAmount.getAmount()).append(" }\n")));
        message += resourceListText.toString();
        return message;
    }

    protected abstract String additionalInfo(Profit profit);

    private String formatHashCode(String resultItemName) {
        return "#" + resultItemName.replace(' ', '_')
                .replace('.', '_')
                .replace('-', '_');
    }


    protected String formatPrice(int price) {
        return priceFormat.format(price);
    }
}
