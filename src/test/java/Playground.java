import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiParser;
import org.junit.Test;
import tarkov.notifier.Telegram;

import java.io.IOException;

public class Playground {
    @Test
    public void testRun() {
        System.out.println(taxes(6300000, 1, 70000));
    }

    public int taxes(int price, int quantity, int baseval) {
        int offerVal = baseval * quantity;
        return (int) Math.round(offerVal * 0.025 * Math.pow(4, Math.log10(offerVal / (float) price)) +
                price * 0.025 * Math.pow(4, Math.log10(price / (float) offerVal)));
    }

    @Test
    public void testTelegram() throws IOException, InterruptedException {
        Telegram.sendMessage(EmojiParser.parseToUnicode("100% :fire:"));
    }
}
