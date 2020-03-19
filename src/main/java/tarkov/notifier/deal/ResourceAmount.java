package tarkov.notifier.deal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResourceAmount {
    private String name;
    private int amount;

    public ResourceAmount(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
