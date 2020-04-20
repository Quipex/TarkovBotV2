package tarkov.notifier.deal.item;

import com.google.common.base.Preconditions;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ItemsRepositoryStub implements ItemsRepository {
    private static final String[][] itemNamesToUidsArray = {
            {"Сумка Mr.Holodilnik", "b9eb01ad-7ab5-43c5-a81c-2c6e40f54bdf"},
            {"ТарКола", "d7bcfca7-6dca-455d-bf0a-472df37a900f"},
            {"Сельдь", "45c47deb-6595-4cb5-91d6-102dea6dcd43"},
            {"Горячий электрод", "ed7ee2cb-19d6-479e-9f96-2cfbb1f0707c"},
            {"Кабачковая икра", "a3cb95b9-addd-496e-8fcf-971e085fa19a"},
            {"Техническая документация", "d767941f-1ed9-48df-b8a9-ac3e1f5ec08a"},
            {"Банка говядины", "60036b01-88aa-4653-955c-24e303188e62"},
            {"Оружейный кейс", "adab4fd3-2389-4c44-b20a-70fb4bc8bae6"},
            {"Двигатель", "cb46d0e2-3e86-4806-a30a-1ac65cb8a8ae"},
            {"Сломанный LCD дисплей", "a6d02924-76b6-4148-9b0b-0f4d6fa51afb"},
            {"Фазийная решетка РЛС", "90e51404-e9c2-4821-abe2-07cadf6bbfe7"},
            {"Ключ от кпп", "4f615ebf-4384-4c76-94d6-1a6b808981bb"},
            {"Ножницы для резки металла", "d51aa682-63ad-437f-97d2-e3323340ad2e"},
            {"Экспедиционная топливная канистра", "e0723cd1-8eb0-4b6a-8ed0-72e3997754c9"},
            {"Болты", "45bc4c86-cb1e-4e87-8b6e-f4abcb890cd4"},
            {"Гайки", "633a0cf4-dcc1-4d35-bd94-31f4caec38d9"},
            {"Кейс для магазинов", "b888fad6-7f3a-412c-b272-f59cde556263"},
            {"Вазелин", "4fa3994d-8255-4be7-a8b7-c80d141289fb"},
            {"Шприц", "b2a21047-6fb6-4c52-b858-96498186f479"},
            {"Набор для переливания крови", "c73ab957-7754-480b-b6bb-9ee3baa8d932"},
            {"Медицинский кейс", "4e17db7f-678f-46ff-9502-ce9e79d566bb"},
            {"Маленький кейс S I C C", "28ac76b3-69dd-4db9-9b09-6ac2c6d496ab"},
            {"Моток паракорда", "f2d80ab6-47f0-424a-bb6f-4b8e5c742aec"},
            {"Монтажный скотч", "782dd190-626e-4a1d-b5d9-7b09a721e13e"},
            {"Изолента", "8cb829b2-2a5d-43c2-a86d-a372ed8d917f"},
            {"Пачка гвоздей", "21a8189b-6e32-4823-8de6-ae64aedac6a2"},
            {"Поглотитель пыли ФП-100", "0e60570c-edea-4527-ac38-a285a570d95d"},
            {"Набор инструментов", "b0b586cc-e560-43d9-a478-dfb151098939"},
            {"Водный фильтр", "73395a87-0869-4c15-84f2-89607ff37888"},
            {"Воздушный фильтр для противогаза", "ef03bd7f-3b02-4bc5-9a9c-a7bb51bdbaa0"},
            {"Ледоруб", "98dfcb46-6cae-4d1d-81d2-6473f11e1424"},
            {"Сухое горючее", "0850ec42-4a23-4b32-a87c-2f706fd289a4"},
            {"Присадка для топлива", "6af1c257-a3ac-426a-8f4f-90dfaefd5a78"},
            {"Баллон пропана", "440cc522-a5dd-4fd6-8aba-e59354e98ad9"},
            {"Кейс для вещей", "e29c4ed8-18f2-4182-ada4-b7674593ca60"},
            {"Офтальмоскоп", "6d59aee8-84cc-4c8d-8aa3-df18f68fa513"},
            {"Медицина", "d360967f-ca12-4ed8-99b5-bdc0922be0ae"},
            {"T H I C C Кейс для вещей", "44ae1d9d-1bf6-4015-9995-a9cb2fea53fb"},
            {"Самогон", "fb7e9a19-7029-4076-83a6-f913c3c8e9f8"},
            {"Бутылка виски Dan Jackiel", "2fa0f9fc-fb8f-48a8-8510-1992cf5d20b1"},
            {"Бутылка водки Тарковская", "f591d0d2-1926-46a2-9924-a32610e202ca"},
            {"5.56х45 М995", "79da7191-3bd2-4b6d-a02c-607ed02c2aff"},
            {"Оружейный порох \"Орел\"(зелёный)", "58553b5c-a917-401c-b168-368da57d5256"},
            {"Снаряд ОФЗ", "9f963a09-d431-436d-9430-bb9a053617ef"},
            {"9х39 СП-6", "b610ec3c-55f4-43e1-a462-7229596b4185"},
            {"Монтажная пена Xenomorph", "cc00b56a-5359-4244-a09a-378b1decbb75"},
            {"7.62x39 HP", "cb889ca9-bbca-435d-b571-119476c2c910"},
            {"9x19 RIP", "ba864652-d13e-4f9e-b1a0-6060352d3b56"},
            {"Оружейный порох \"Ястреб\"(красный)", "3a7442b7-18ab-4f06-baa5-73ab382b0b34"},
            {"Пучок проводов", "e5485530-9cc5-4ce2-b724-007213d8feec"},
            {"7.62x39 БП", "b626bcf8-c73c-467e-8882-1b61908d9939"},
            {"7.62х51 М61", "b797a65d-5a99-454c-97e5-ba9e9bfd6d01"},
            {"Спираль накаливания", "090b69eb-01e2-44e6-8479-73398606c653"},
            {"9x39 7Н12 БП", "9609f8dd-3869-4d92-a62d-2cbf3a5e33fc"},
            {"Военный фильтр питания", "567f5735-0d95-4882-8c50-59cf2c1cc935"},
            {"Оружейный кейс T H I C C", "4a80b831-9b65-4f2d-98c3-5b761974110f"},
            {"Монета биткоина", "5ac84494-465a-424a-b36e-fe22869ba5ec"},
            {"Броня Гжель", "e7ebc526-09f6-45d1-886e-f04ced269a0a"},
            {"Кофе", "6a242801-43d3-454b-ad01-56f452b554a1"},
            {"Золотая цепочка", "29c327c0-3df9-4d6e-8fc9-6733a407033c"},
            {"Tactec разгрузочный жилет", "4f835164-d52c-44e5-b7dc-1ae3b0964b3d"},
            {"Цепочка", "1586a968-a72f-406f-9759-ec08ca583b1e"},
            {"Золотой ТТ", "0b561eb9-bedd-4100-a2f6-1e582a4f1013"},
            {"РБ-ПСП2 ключ", "5c9bfa96-0595-49e7-a5f1-132a36aec62a"},
            {"Литиевая аккумуляторная батарейка GreenBat", "9b2efc09-ed97-48da-8441-3fa587983572"},
            {"Длинная плоская отвертка", "a0bf67cf-6c0b-4344-b740-9c2ef9043a37"},
            {"Аккумулятор Циклон", "82ae274f-81f1-4ad6-98de-7fd5ee9c9279"},
            {"Бронезабрало ЗШ-1-2М", "91376e89-35ad-41ce-b282-38b24761a7f2"},
            {"Оргстекло", "b08377f5-0cf7-4e72-9ae0-bc7d37d3807c"},
            {"ЛШЗ бронезабрало", "2c11ff72-d3b9-4522-8d9a-382813115201"},
            {"GP монета", "224e608c-5186-454a-b2ac-5ba3161e7dad"},
            {"Шлем Маска-1Щ", "81d55273-4796-4e01-93be-0d25d5b5dbb9"},
            {"AVS бронеразгруз", "11481452-51ba-438d-a361-bfb2b9fb3894"},
            {"Противогаз ГП-5", "59a0f8cf-1d3b-4df1-9880-449e98e9ecd2"},
            {"Неопреновая маска", "31a0f6d4-366e-412b-a9ee-749176b4a90b"},
            {"Шампунь", "ced612bd-bb94-49ce-9748-c7ea6677121e"},
            {"Зубная паста Ortodontox", "4513e42d-ae28-4f39-b3db-11b693077e0e"},
            {"Бронезабрало ЛШЗ-2ДТМ", "74688e96-62f0-45d8-b951-7f5235d0bbe8"},
            {"Gen4 мобильный", "7cbf3bc6-f5e6-45bc-a962-76c9c0241d7d"},
            {"M-2 Tactical Sword", "43ae98d6-98d0-40e5-bbd5-d1baecde315d"},
            {"Считыватель UHF RFID", "c1e876ab-e0ef-4305-b392-6c72b751aac7"},
            {"Цепь с медальоном Prokill", "f6ec24a8-e756-4985-a1d6-f1e648165994"},
            {"АШ-12", "3522164a-3fab-44eb-ba5a-4c2e7b3043b1"},
            {"Планшет для документов", "dd066bf7-377a-446a-8de7-6e6ee1321772"},
            {"Фигурка кота", "23cd6ce1-4f19-4133-aa24-269f721ae76b"},
            {"Бронзовая статуетка льва", "8a44cb7c-38c3-4b9c-aba8-893180091bdf"},
            {"Фигурка лошади", "f159cf91-480e-4f50-aab6-badb0850af5b"},
            {"Порох \"Коршун\" (синий)", "487f7d84-50f0-48e1-85cf-e5323e36cc38"},
            {"Кейс для патронов", "0080307d-3596-440c-be38-bdded3cbf4cf"},
            {"SAS диск", "cb021f9d-4c11-4a7b-af23-8b6bc886c5b1"},
            {"SSD диск", "33c15349-44e6-4553-9705-1b6417a1ad6a"},
            {"Папка с разведданными", "09e22fbe-fd90-4aad-81ea-11b7a9ebdc2b"},
            {"Тонкий ежедневник", "fcb0f675-890e-49d9-a3b9-535cd7b491e8"},
            {"Дневник", "48739ac3-f4e2-4779-a0de-bec4c673f04f"},
            {"Видеокарта", "c760ea3c-b3b6-4b9f-83d7-5302b3f084f7"},
            {"TV-110 Бронеразгруз", "c0e0fbbf-49f7-4e95-8bf4-04fc4a09d84d"},
            {"Отбеливатель", "9379a547-681c-4a1c-bab0-ec11195a83de"},
            {"Забрало Алтын", "f84a1bfa-5fdc-4403-bf3e-ccec77f62195"},
            {"Забрало Вулкан", "eb8df6a6-b075-4c7f-b3dd-83730f05eb22"},
            {"Жук-6а армор", "f7bcdd1f-e8b6-40e6-8996-fb7820fbdc6f"},
            {"Рюкзак Blackjack", "3e949401-61ba-4ff3-905b-3f8bb8e27b14"},
            {"Антикварная ваза", "97a20526-1234-4ea3-8e3d-8a77e6e249be"},
            {"Антикварный чайник", "c8f6ab75-7cbf-4e82-b0fe-46ec1a15c382"},
            {"Шлем алтын", "c5b31ff5-f95d-434c-8bd7-c1b3eed6d516"},
            {"Круглые кусачки", "2a8f6120-960c-49ea-92ac-36538189ca96"},
            {"Рулетка", "acad7790-99d4-475e-b7a5-9fd590e5bffd"},
            {"Плоскогубцы", "db32e698-23f7-4835-a62c-2eacdb0b84cb"},
            {"6Б43 Армор", "d3d73205-18dc-46b3-8cae-86dd385cda39"},
            {"Gen4 штурмовой", "702233cd-e04d-4a04-992b-ffdef5bae93b"},
            {"Золотой череп", "2ba0c1d8-79d1-44b9-87c4-bd525a913d45"},
            {"ФОРТ Редут-Т5", "cc77832a-0e94-40e2-96bd-59ef405beaea"},
            {"ВОГ-17 граната 'Хаттабка'", "9c90b90f-6a1b-4fa8-8fb7-5b481deebc2f"},
            {"Запал",  "755e0a03-3765-4cc6-b57b-a615a82db9d3"},
            {"Силовой кабель", "7f1f9e1c-d7d5-4fa0-b881-f552fedca979"},
            {"Граната 'Хаттабка' на базе ВОГ-25", "1f986ad8-16f6-47d7-b6d9-530f01eca19f"},
            {"40mm ВОГ-25", "a0632f1d-b7ec-4dd8-8887-583fe21c69ed"},
            {"5.45x39 Игольник", "df4eca2e-79fa-4780-afe9-78e9b226fb07"},
            {"AP-20 бронебойная пуля", "b1f346ba-dcc2-4a61-91da-36deed4880da"},
            {"Поврежденный жесткий диск", "93da40d6-cbb2-4030-aed9-145fcef8b8c0"},
            {"Флешка", "f0fa8457-6638-4ad2-b7e8-4708033d8f39"},
            {"Сломанный G-phone", "734eb422-a419-42e5-ae8b-d510166647a5"},
            {"Сломанный GPX", "e7a85d68-562a-4d6f-b2aa-7810d9bbdbf7"},
            {"Зажигалка Zibbo", "4b1e2cda-bec2-4578-9ff1-1309481c6168"},
            {"Зажигалка Crickent", "7359d2ef-faeb-4a33-ac2e-62e5e38b2a26"},
            {"Бутылка воды", "d43e286e-2165-40f3-a036-63cfca09b4d7"},
            {"Мыло", "512394c7-b133-4662-b68b-5271d30ed267"},
            {"Аптечка Salewa", "aed566f6-dc68-4263-a933-061c645098fc"},
            {"Анальгин", "37fb7f36-7009-4357-8cdb-bd1d9ba829df"},
            {"Бинт", "aed304d4-69dc-4fb7-899c-defe5a4eafba"},
            {"Шина", "d1dc0512-6f00-4e76-a0a9-687548f3299d"},
            {"Вода с фильтром 'Aquamari'", "0e8eb783-df57-4731-9640-0b7829dae7f4"},
            {"Канистра с очищенной водой", "97d6daa1-5164-4c04-8ffa-d7e6e4cb3508"},
            {"Сгущёнка", "32a27784-a21d-46d6-866e-44d377020bee"},
            {"Сигареты Wilston", "8248e222-1197-4347-adf0-6b0f11b6c277"},
            {"Пачка чая", "8b1e494b-21b1-4386-b6d1-6f75d4025c41"},
            {"Сигареты Apollo", "78a23d00-329f-4ac1-aa24-51ac15a93e20"},
            {"Шоколад Алёнка", "f0d412b4-b4e5-42a2-8efd-084e46d2e7f1"},
            {"Овсяные хлопья", "93bc90cc-99a2-4fc0-bd63-9d60f07181cf"},
            {"Пакет молока", "2ec4162b-d64d-4212-8779-c7919b6bcf86"},
            {"Хлебцы армейские", "4c82de8e-8b09-41b8-beed-dfb17ad94fa2"},
            {"Пачка сахара", "67f383be-d8dd-415c-8b2d-337e98e67f8c"},
            {"Сухпаек искра", "c22766d5-d8ae-4b54-aafd-48f651a05284"},
            {"Гофрированный шланг", "7dcee9c6-2886-42a8-8c13-8ba3affb5141"},
            {"Силиконовая трубка", "cf20fa8b-8754-4aed-be69-5aa81e0fd2a0"},
            {"Аптечка Grizzly", "20e89468-f9c4-4e42-858e-c569557435cf"},
            {"Батончик Slikers", "e537d6b4-2964-4a3d-bef2-9e3298ad3272"},
            {"Ибупрофен", "fd17e27b-0a49-431a-a6cb-95944e20c4cf"},
            {"LED-x", "a7f7568c-61fb-437e-9f71-06e58aae26ba"},
            {"Дефибриллятор", "24110968-b66b-46d9-861a-ba9c976332b1"},
            {"Ключ от двери магазина KIBA", "36f30c05-7865-409c-bad2-cc309fca4bd3"},
            {"Боевой стимулятор SJ1", "f292e3a9-7800-4fc2-bda0-6d43aa112271"},
            {"Бутылка физраствора", "71a6b6db-d0d2-44e0-a5f7-683ad4bb1ff8"},
            {"Пропитал", "48839bcc-faf3-4bbe-b0b4-625be67351fa"},
            {"Морфий", "00e82880-064b-484c-9ebe-09befbfa4988"},
            {"REAP-IR тепловизор", "160c7064-3b9d-446d-9d1a-e05bc174e73b"},
            {"Беспроводной передатчик сигналов COFDM", "8a1bb9dd-f6e3-4890-965f-6910f5bbb5d7"},

    };
    private static BidiMap<String, String> itemNameToUid = new DualHashBidiMap<>();
    private static ItemsRepositoryStub INSTANCE;

    private ItemsRepositoryStub() {
    }

    static {
        populateItemNameToUid();
    }

    public static ItemsRepositoryStub instance() {
        if (INSTANCE == null) {
            INSTANCE = new ItemsRepositoryStub();
        }
        return INSTANCE;
    }

    private static void populateItemNameToUid() {
        for (String[] nameUidArray : itemNamesToUidsArray) {
            itemNameToUid.put(nameUidArray[0], nameUidArray[1]);
        }
        itemNameToUid.forEach((s, s2) -> {
            Preconditions.checkNotNull(s);
            Preconditions.checkNotNull(s2);
        });
    }

    @Override
    public String getUidByItemName(String itemName) {
        String uid = itemNameToUid.get(itemName);
        if (uid == null) {
            throw new RuntimeException("uid for '" + itemName + "' is null");
        }
        return uid;
    }

    @Override
    public Set<String> getUidsByItemNames(Collection<String> itemNames) {
        Set<String> uids = new HashSet<>();
        for (String itemName : itemNames) {
            uids.add(getUidByItemName(itemName));
        }
        return uids;
    }

    @Override
    public String getItemNameByUid(String uid) {
        return itemNameToUid.getKey(uid);
    }

    @Override
    public Set<String> getItemNamesByUids(Collection<String> uids) {
        Set<String> names = new HashSet<>();
        for (String uid : uids) {
            names.add(getItemNameByUid(uid));
        }
        return names;
    }
}
