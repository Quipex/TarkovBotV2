package tarkov.notifier.deal.barter;

import tarkov.notifier.deal.Deal;
import tarkov.notifier.deal.DealRepository;
import tarkov.notifier.deal.ResourceAmount;

import java.util.ArrayList;
import java.util.List;

public class BarterRepository extends DealRepository {
    private Barter[] barters = new Barter[]{
            new Barter("Сумка Mr.Holodilnik", 1, 320000, "Егерь", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Горячий электрод", 10),
                            new ResourceAmount("ТарКола", 5),
                            new ResourceAmount("Сельдь", 5),
                            new ResourceAmount("Кабачковая икра", 5)
                    })),
            new Barter("Ключ от кпп", 1, 245630, "Егерь", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Техническая документация", 2),
                            new ResourceAmount("Бутылка водки Тарковская", 5),
                            new ResourceAmount("Банка говядины", 3),
                    })),
            new Barter("Оружейный кейс", 1, 874566, "Механик", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Двигатель", 8),
                            new ResourceAmount("Пучок проводов", 15),
                            new ResourceAmount("Сломанный LCD дисплей", 4),
                            new ResourceAmount("Фазийная решетка РЛС", 1),
                    })),
            new Barter("Медицинский кейс", 1, 366106, "Хабибулина", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Шприц", 7),
                            new ResourceAmount("Набор для переливания крови", 7),
                            new ResourceAmount("Вазелин", 7),
                    })),
            new Barter("Маленький кейс S I C C", 1, 750000, "Егерь", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Моток паракорда", 10),
                            new ResourceAmount("Монтажный скотч", 15),
                            new ResourceAmount("Изолента", 10),
                            new ResourceAmount("Пачка гвоздей", 12),
                    })),
            new Barter("Ледоруб", 1, 70000, "Егерь", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Сухое горючее", 15),
                            new ResourceAmount("Баллон пропана", 15),
                            new ResourceAmount("Присадка для топлива", 10),
                    })),
            new Barter("Кейс для вещей", 1, 1300000, "Хабибулина", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Офтальмоскоп", 20),
                            new ResourceAmount("Медицина", 10)
                    })),
            new Barter("Ключ от двери магазина KIBA", 1, 1300000, "Хабибулина", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Сгущёнка", 60),
                            new ResourceAmount("Овсяные хлопья", 10)
                    })),
            new Barter("T H I C C Кейс для вещей", 1, 7300000, "Хабибулина", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Самогон", 50),
                            new ResourceAmount("Бутылка виски Dan Jackiel", 35),
                            new ResourceAmount("Бутылка водки Тарковская", 30),
                    })),
            new Barter("T H I C C Кейс для вещей", 1, 7300000, "Хабибулина", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Дефибриллятор", 10),
                            new ResourceAmount("LED-x", 10),
                            new ResourceAmount("Ибупрофен", 8),
                    })),
            new Barter("Оружейный кейс T H I C C", 1, 2250000, "Механик", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Монета биткоина", 35)
                    })),
            new Barter("Броня Гжель", 1, 113829, "Барахольщик L3", 3,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Кофе", 3),
                            new ResourceAmount("Золотая цепочка", 2)
                    })),
            new Barter("Tactec разгрузочный жилет", 1, 91000, "Барахольщик L2", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Цепочка", 8),
                            new ResourceAmount("Золотой ТТ", 4),
                    })),
            new Barter("РБ-ПСП2 ключ", 1, 50000, "Егерь", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Литиевая аккумуляторная батарейка GreenBat", 10),
                            new ResourceAmount("Аккумулятор Циклон", 7),
                            new ResourceAmount("Длинная плоская отвертка", 5),
                    })),
            new Barter("Бронезабрало ЗШ-1-2М", 1, 17351, "Барахольщик L2", 0,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оргстекло", 2)
                    })),
            new Barter("Бронезабрало ЛШЗ-2ДТМ", 1, 29000, "Барахольщик L3", 3,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оргстекло", 3)
                    })),
            new Barter("Gen4 мобильный", 1, 118774, "Барахольщик", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("GP монета", 10)
                    })),
            new Barter("Шлем Маска-1Щ", 1, 126327, "Барахольщик L3", 2,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("GP монета", 3)
                    })),
            new Barter("Tactec разгрузочный жилет", 1, 91000, "Барахольщик L3", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Противогаз ГП-5", 4),
                            new ResourceAmount("Неопреновая маска", 6)
                    })),
            new Barter("AVS бронеразгруз", 1, 85600, "Барахольщик L3", 2,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Шампунь", 5),
                            new ResourceAmount("Зубная паста Ortodontox", 3)
                    })),
            new Barter("TV-110 Бронеразгруз", 1, 91200, "Барахольщик L3", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Отбеливатель", 4),
                            new ResourceAmount("Шампунь", 2)
                    })),
            new Barter("Забрало Алтын", 1, 43460, "Барахольщик L4", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оргстекло", 4),
                    })),
            new Barter("Забрало Вулкан", 1, 54320, "Барахольщик L4", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Оргстекло", 7),
                    })),
            new Barter("Жук-6а армор", 1, 125000, "Барахольщик L4", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Антикварная ваза", 2),
                            new ResourceAmount("Антикварный чайник", 3),
                    })),
            new Barter("Рюкзак Blackjack", 1, 82500, "Барахольщик L4", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Отбеливатель", 7),
                    })),
            new Barter("Шлем алтын", 1, 160327, "Барахольщик L4", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Круглые кусачки", 5),
                            new ResourceAmount("Рулетка", 5),
                            new ResourceAmount("Плоскогубцы", 4),
                    })),
            new Barter("6Б43 Армор", 1, 144968, "Барахольщик L4", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Самогон", 1),
                            new ResourceAmount("Бутылка водки Тарковская", 5),
                    })),
            new Barter("Gen4 штурмовой", 1, 137002, "Барахольщик L4", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Золотой череп", 3),
                            new ResourceAmount("Золотая цепочка", 6),
                    })),
            new Barter("ФОРТ Редут-Т5", 1, 188296, "Барахольщик L4", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Воздушный фильтр для противогаза", 4),
                            new ResourceAmount("Моток паракорда", 2),
                    })),
            new Barter("Tactec разгрузочный жилет", 1, 91000, "Барахольщик L4", 2,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Антикварная ваза", 1),
                            new ResourceAmount("Цепочка", 6),
                    })),
            new Barter("M-2 Tactical Sword", 1, 1570000, "Лыжник, квест Кремень", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Считыватель UHF RFID", 2),
                            new ResourceAmount("Ключ от кпп", 1),
                            new ResourceAmount("Цепь с медальоном Prokill", 2),
                            new ResourceAmount("Фазийная решетка РЛС", 2)
                    })),
            new Barter("АШ-12", 1, 0, "Прапор, квест ОФЗ", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Бутылка водки Тарковская", 3)
                    })),
            new Barter("Планшет для документов", 1, 167469, "Хабибулина L2", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Фигурка кота", 1),
                            new ResourceAmount("Бронзовая статуетка льва", 1),
                            new ResourceAmount("Фигурка лошади", 5),
                    })),
            new Barter("Папка с разведданными", 1, 29000, "Миротворец L3", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Тонкий ежедневник", 2),
                            new ResourceAmount("Дневник", 2),
                    })),
            new Barter("Кейс для патронов", 1, 162552, "Механик L2", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Порох \"Коршун\" (синий)", 5),
                            new ResourceAmount("Оружейный порох \"Орел\"(зелёный)", 2),
                    })),
            new Barter("Видеокарта", 1, 60375, "Механик L4", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("SAS диск", 2),
                            new ResourceAmount("SSD диск", 2),
                    })),
            new Barter("ВОГ-17 граната 'Хаттабка'", 1, 5935, "Механик L1", 5,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Запал", 1),
                    })),
            new Barter("REAP-IR тепловизор", 1, 215794, "Егерь L3", 1,
                    resources(new ResourceAmount[]{
                            new ResourceAmount("Спираль накаливания", 10)
                    })),

    };

    @Override
    public List<String> itemNames() {
        List<String> items = new ArrayList<>();
        for (Barter barter : barters) {
            items.add(barter.getItemName());
            for (ResourceAmount resource : barter.getResources()) {
                items.add(resource.getName());
            }
        }
        return items;
    }

    @Override
    public List<Deal> getDeals() {
        return List.of(barters);
    }
}
