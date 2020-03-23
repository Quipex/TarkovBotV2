package tarkov.notifier.market;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TMarketItem {
    /**
     * Example: "f0fa8457-6638-4ad2-b7e8-4708033d8f39"
     */
    private String uid;
    /**
     * Example: "Secure Flash drive"
     */
    private String name;
    /**
     * Example: "Flash drive"
     */
    private String shortName;
    /**
     * Example: 57999
     */
    private int price;
    /**
     * Example: 56850
     */
    private int avg24hPrice;
    /**
     * Example: 53705
     */
    private int avg7daysPrice;
    /**
     * Example: "Peacekeeper"
     */
    private String traderName;
    /**
     * Example: 586
     */
    private int traderPrice;
    /**
     * Example: "$"
     */
    private String traderPriceCur;
    /**
     * Example: "2020-03-16T10:53:43.212Z"
     */
    private ZonedDateTime updated;
    /**
     * Example: 1
     */
    private int slots;
    /**
     * Example: 2.02
     */
    private float diff24h;
    /**
     * Example: 8
     */
    private float diff7days;
    /**
     * Example: "https://vignette.wikia.nocookie.net/escape-from-tarkov/images/5/5d/Secure_Flash_drive_icon.png/revision/latest?cb=20190911040040"
     */
    private String icon;
    /**
     * Example: "https://tarkov-market.com/item/secure_flash_drive"
     */
    private String link;
    /**
     * Example: "https://escapefromtarkov.gamepedia.com/Secure_Flash_drive"
     */
    private String wikiLink;
    /**
     * Example: "https://gamepedia.cursecdn.com/escapefromtarkov_gamepedia/b/b7/Secure_Flash_drive_Icon.png?version=dee0172505650e34c8dc4c404de6f78a"
     */
    private String img;
    /**
     * Example: "https://gamepedia.cursecdn.com/escapefromtarkov_gamepedia/thumb/a/a8/Secure_Flash_drive.png/320px-Secure_Flash_drive.png?version=cbfa8ecbd440c7aeb4ee5ba63a5caa40"
     */
    private String imgBig;
    private String bsgId;
    /**
     * Example: "https://www.patreon.com/tarkov_market"
     */
    private String reference;
}
