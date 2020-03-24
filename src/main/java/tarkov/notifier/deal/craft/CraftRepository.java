package tarkov.notifier.deal.craft;

import tarkov.notifier.deal.Deal;
import tarkov.notifier.deal.DealRepository;
import tarkov.notifier.deal.ResourceAmount;

import java.util.ArrayList;
import java.util.List;

public class CraftRepository extends DealRepository {
    private Craft[] crafts = new Craft[]{
            new Craft("5.56х45 М995", 140, 0, 146, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оружейный порох \"Орел\"(зелёный)", 1),
                            new ResourceAmount("Снаряд ОФЗ", 1)
                    })),
            new Craft("9x19 RIP", 180, 0, 125, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оружейный порох \"Ястреб\"(красный)", 1),
                            new ResourceAmount("Пучок проводов", 4)
                    })),
            new Craft("9х39 СП-6", 200, 0, 141, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оружейный порох \"Орел\"(зелёный)", 1),
                            new ResourceAmount("Монтажная пена Xenomorph", 1),
                            new ResourceAmount("7.62x39 HP", 60),
                    })),
            new Craft("5.45x39 Игольник", 150, 0, 157, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оружейный порох \"Орел\"(зелёный)", 1),
                            new ResourceAmount("Оружейный порох \"Ястреб\"(красный)", 1),
                            new ResourceAmount("Порох \"Коршун\" (синий)", 1),
                    })),
            new Craft("7.62х51 М61", 130, 0, 166, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оружейный порох \"Ястреб\"(красный)", 1),
                            new ResourceAmount("Спираль накаливания", 3),
                    })),
            new Craft("Пучок проводов", 8, 0, 118, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Силовой кабель", 2),
                    })),
            new Craft("Граната 'Хаттабка' на базе ВОГ-25", 8, 0, 66, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Запал", 5),
                            new ResourceAmount("40mm ВОГ-25", 5),
                    })),
            new Craft("7.62x39 БП", 120, 0, 150, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оружейный порох \"Орел\"(зелёный)", 1),
                    })),
            new Craft("AP-20 бронебойная пуля", 120, 0, 148, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оружейный порох \"Ястреб\"(красный)", 1),
                            new ResourceAmount("Поврежденный жесткий диск", 2),
                    })),
            new Craft("9x39 7Н12 БП", 80, 0, 159, Craft.CraftPlace.BENCH,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Военный фильтр питания", 1),
                            new ResourceAmount("Оружейный порох \"Ястреб\"(красный)", 1),
                    })),
            new Craft("Папка с разведданными", 1, 0, 2053, Craft.CraftPlace.INTELLIGENCE,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Флешка", 3),
                    })),
            new Craft("Флешка", 3, 0, 1900, Craft.CraftPlace.INTELLIGENCE,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Сломанный G-phone", 1),
                            new ResourceAmount("Сломанный GPX", 1),
                            new ResourceAmount("SSD диск", 1),
                    })),
            new Craft("Воздушный фильтр для противогаза", 1, 0, 2, Craft.CraftPlace.TOILET,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Противогаз ГП-5", 1),
                    })),
            new Craft("Гофрированный шланг", 2, 0, 201, Craft.CraftPlace.TOILET,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Силиконовая трубка", 1),
                            new ResourceAmount("Пучок проводов", 3),
                            new ResourceAmount("Изолента", 3),
                    })),
            new Craft("Поглотитель пыли ФП-100", 1, 82000, 156, Craft.CraftPlace.TOILET,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Воздушный фильтр для противогаза", 2),
                            new ResourceAmount("Водный фильтр", 2),
                            new ResourceAmount("Набор инструментов", 1),
                    })),
            new Craft("Экспедиционная топливная канистра", 1, 18700, 28, Craft.CraftPlace.TOILET,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Зажигалка Zibbo", 6),
                            new ResourceAmount("Зажигалка Crickent", 8),
                    })),
            new Craft("Кейс для магазинов", 1, 425000, 292, Craft.CraftPlace.TOILET,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Экспедиционная топливная канистра", 2),
                            new ResourceAmount("Ножницы для резки металла", 1),
                            new ResourceAmount("Болты", 3),
                            new ResourceAmount("Гайки", 3),
                    })),
            new Craft("Шампунь", 2, 0, 35, Craft.CraftPlace.TOILET,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Бутылка воды", 1),
                            new ResourceAmount("Мыло", 1),
                    })),
            new Craft("Аптечка Salewa", 1, 0, 22, Craft.CraftPlace.MEDICAL,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Анальгин", 1),
                            new ResourceAmount("Бинт", 1),
                            new ResourceAmount("Шина", 1),
                    })),
            new Craft("Аптечка Grizzly", 1, 0, 58, Craft.CraftPlace.MEDICAL,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Медицина", 5),
                    })),
            new Craft("Вода с фильтром 'Aquamari'", 8, 0, 110, Craft.CraftPlace.KITCHEN,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Канистра с очищенной водой", 1),
                            new ResourceAmount("Силиконовая трубка", 1),
                    })),
            new Craft("Пачка сахара", 1, 0, 83, Craft.CraftPlace.KITCHEN,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Шоколад Алёнка", 2),
                    })),
            new Craft("Бутылка водки Тарковская", 10, 0, 95, Craft.CraftPlace.KITCHEN,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Самогон", 1),
                            new ResourceAmount("Бутылка воды", 5),
                    })),
            new Craft("Сигареты Wilston", 5, 0, 101, Craft.CraftPlace.KITCHEN,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Пачка чая", 1),
                            new ResourceAmount("Сигареты Apollo", 1),
                    })),
            new Craft("Батончик Slikers", 7, 0, 71, Craft.CraftPlace.KITCHEN,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Шоколад Алёнка", 1),
                            new ResourceAmount("Овсяные хлопья", 1),
                            new ResourceAmount("Хлебцы армейские", 1),
                    })),
            new Craft("Сгущёнка", 3, 0, 81, Craft.CraftPlace.KITCHEN,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Пачка сахара", 1),
                            new ResourceAmount("Пакет молока", 1),
                    })),
            new Craft("Сухпаек искра", 2, 0, 48, Craft.CraftPlace.KITCHEN,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Хлебцы армейские", 2),
                            new ResourceAmount("Банка говядины", 1),
                            new ResourceAmount("Кабачковая икра", 1),
                    })),

    };

    @Override
    public List<String> itemNames() {
        List<String> items = new ArrayList<>();
        for (Craft barter : crafts) {
            items.add(barter.getItemName());
            for (ResourceAmount resource : barter.getResources()) {
                items.add(resource.getName());
            }
        }
        return items;
    }

    @Override
    public List<Deal> getDeals() {
        return List.of(crafts);
    }
}
