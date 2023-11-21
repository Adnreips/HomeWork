package project1.example.json;

import java.io.IOException;
import java.util.Arrays;

class AdIdToDebitCardJson {


    public static void main(String[] args) throws IOException {

        String s = "{\"entityName\": \"MasterCard Мультикарта\", \"debitCardSubtype\": \"1\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта\", \"debitCardSubtype\": \"1\"},\n" +
                "          {\"entityName\": \"MIR MIR MC_Salary_ВоенПенс\", \"debitCardSubtype\": \"pens_mir\"},\n" +
                "          {\"entityName\": \"Кобренд ВТБ-Магнит\", \"debitCardSubtype\": \"11\"},\n" +
                "          {\"entityName\": \"MasterCard Мультикарта ECO\", \"debitCardSubtype\": \"3\"},\n" +
                "          {\"entityName\": \"MIR Мультикарта ECO\", \"debitCardSubtype\": \"3\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта ECO\", \"debitCardSubtype\": \"3\"},\n" +
                "          {\"entityName\": \"Кобейдж MIR-Maestro ECO\", \"debitCardSubtype\": \"3\"},\n" +
                "          {\"entityName\": \"MasterCard Мультикарта Troika\", \"debitCardSubtype\": \"5\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта Troika\", \"debitCardSubtype\": \"5\"},\n" +
                "          {\"entityName\": \"MIR Мультикарта с ТП Тройка\", \"debitCardSubtype\": \"7\"},\n" +
                "          {\"entityName\": \"Кобейдж МИР-Maestro\", \"debitCardSubtype\": \"mir_maestro\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта\", \"debitCardSubtype\": \"2\"},\n" +
                "          {\"entityName\": \"MasterCard Мультикарта Детская\", \"title\": \"Мультикарта Детская \"},\n" +
                "          {\"entityName\": \"MIR Мультикарта Детская\", \"title\": \"Мультикарта Детская\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта Детская\", \"title\": \"Мультикарта Детская\"},\n" +
                "          {\"entityName\": \"MasterCard WBE МК Детская\", \"title\": \"Дебетовая карта Детская\"},\n" +
                "          {\"entityName\": \"Visa Signature МК Детская\", \"title\": \"Дебетовая карта Детская\"},\n" +
                "          {\"entityName\": \"MC World Elite Прайм+ Детская\", \"title\": \"Дебетовая карта Прайм Детская\"},\n" +
                "          {\"entityName\": \"Visa Infinite Прайм+ Детская\", \"title\": \"Дебетовая карта Прайм Детская\"},\n" +
                "          {\"entityName\": \"Cirrus Maestro\", \"title\": \"Дебетовая карта Maestro\"},\n" +
                "          {\"entityName\": \"Cirrus Maestro RUR Sal VTB Bank\", \"title\": \"Дебетовая карта Maestro\"},\n" +
                "          {\"entityName\": \"MasterCard Gold\", \"title\": \"Дебетовая карта MasterCard Gold\"},\n" +
                "          {\"entityName\": \"Master Card Gold FREE_YEAR RUR\", \"title\": \"Дебетовая карта MasterCard Gold\"},\n" +
                "          {\"entityName\": \"MasterCard Gold IPO\", \"title\": \"Дебетовая карта MasterCard Gold\"},\n" +
                "          {\"entityName\": \"MasterCard Gold RUR Sal VTB Bank\", \"title\": \"Дебетовая карта MasterCard Gold\"},\n" +
                "          {\"entityName\": \"MasterCard Platinum\", \"title\": \"Дебетовая карта MasterCard Platinum\"},\n" +
                "          {\"entityName\": \"MasterCard Standard\", \"title\": \"Дебетовая карта MasterCard Standard\"},\n" +
                "          {\"entityName\": \"MasterCard Standard IPO\", \"title\": \"Дебетовая карта MasterCard Standard\"},\n" +
                "          {\"entityName\": \"Master Card Standard FREE_YEAR RUR\", \"title\": \"Дебетовая карта Master Card Standard\"},\n" +
                "          {\"entityName\": \"MasterCard Stnd RUR Sal VTB Bank\", \"title\": \"Дебетовая карта Master Card Standard\"},\n" +
                "          {\"entityName\": \"MasterCard World Black Edition\", \"title\": \"Дебетовая карта World Black Edition\"},\n" +
                "          {\"entityName\": \"MasterCard Business\", \"title\": \"Дебетовая карта MasterCard Business\"},\n" +
                "          {\"entityName\": \"MasterCard Unembossed\", \"title\": \"Дебетовая карта MasterCard  Unembossed\"},\n" +
                "          {\"entityName\": \"MasterCard World Elite\", \"title\": \"Дебетовая карта MasterCard World Elite\"},\n" +
                "          {\"entityName\": \"Visa Classic\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Visa Classic Two\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Visa Classic FREE_YEAR\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Visa Classic IPO\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Visa Classic Pats\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Visa Classic Pats Chip\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Visa Classic RUR Sal VTB Bank\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"VISA Classic Unembossed\", \"title\": \"Дебетовая карта Visa Classic Unembossed\"},\n" +
                "          {\"entityName\": \"Кредитная линия\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Visa Classic Unembossed Instant Issue\", \"title\": \"Дебетовая карта Visa Classic Unembossed\"},\n" +
                "          {\"entityName\": \"Visa Electron\", \"title\": \"Дебетовая карта Visa Electron\"},\n" +
                "          {\"entityName\": \"Visa Electron Pats\", \"title\": \"Дебетовая карта Visa Electron\"},\n" +
                "          {\"entityName\": \"Visa Electron Pats Chip\", \"title\": \"Дебетовая карта Visa Electron\"},\n" +
                "          {\"entityName\": \"Visa Electron RUR Sal VTB Bank\", \"title\": \"Дебетовая карта Visa Electron\"},\n" +
                "          {\"entityName\": \"Visa Gold\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold NEW\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold FREE_YEAR\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold IPO\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"VisaGold Mirax\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold Pats\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold Pats Chip\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold RUR Sal VTB Bank\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Infinite\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"Visa Infinite New\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"Visa Instant Issue\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa Instant Issue (EXPRESS)\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa Platinum\", \"title\": \"Дебетовая карта Visa Platinum\"},\n" +
                "          {\"entityName\": \"Visa Signature\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"VISA Business\", \"title\": \"Дебетовая карта VISA Business \"},\n" +
                "          {\"entityName\": \"Master Card World Gold\", \"title\": \"Дебетовая карта MC World Gold\"},\n" +
                "          {\"entityName\": \"MasterCard World Platinum\", \"title\": \"Дебетовая карта MC World Platinum\"},\n" +
                "          {\"entityName\": \"MasterCard World Standard\", \"title\": \"Дебетовая карта MC World Standard\"},\n" +
                "          {\"entityName\": \"MC Black Edition Автокарта\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"MasterCard Black Edition_Salary\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"MasterCard Black Edition Карта мира\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"MC Black Edition Впечатлений\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"MC Gold Автокарта\", \"title\": \"Дебетовая карта MC Gold\"},\n" +
                "          {\"entityName\": \"MasterCard Gold_Salary\", \"title\": \"Дебетовая карта MC Gold\"},\n" +
                "          {\"entityName\": \"MC Gold Впечатлений\", \"title\": \"Дебетовая карта MC Gold\"},\n" +
                "          {\"entityName\": \"MasterCard Platinum privileged\", \"title\": \"Дебетовая карта MC Platinum\"},\n" +
                "          {\"entityName\": \"MC Platinum Автокарта\", \"title\": \"Дебетовая карта MC Platinum\"},\n" +
                "          {\"entityName\": \"MC Platinum_Salary (privileged)\", \"title\": \"Дебетовая карта MC Platinum\"},\n" +
                "          {\"entityName\": \"MasterCard Platinum_Salary VTB24\", \"title\": \"Дебетовая карта MC Platinum\"},\n" +
                "          {\"entityName\": \"MC Platinum Впечатлений\", \"title\": \"Дебетовая карта MC Platinum\"},\n" +
                "          {\"entityName\": \"MC Standard Cash Back 1%\", \"title\": \"Дебетовая карта MC Standard Cash Back 1%\"},\n" +
                "          {\"entityName\": \"MasterCard Standard_Salary\", \"title\": \"Дебетовая карта MasterCard Standard\"},\n" +
                "          {\"entityName\": \"MasterCard Standard_Salary VTB24\", \"title\": \"Дебетовая карта MasterCard Standard\"},\n" +
                "          {\"entityName\": \"MasterCard Unemb Instant Issue\", \"title\": \"Дебетовая карта MasterCard Unemb\"},\n" +
                "          {\"entityName\": \"MC StandardUnembossed_Salary\", \"title\": \"Дебетовая карта MC Standard Unembossed\"},\n" +
                "          {\"entityName\": \"MC World Elite Автокарта\", \"title\": \"Дебетовая карта MC World Elite\"},\n" +
                "          {\"entityName\": \"MCWorldElite Карта впечатлений\", \"title\": \"Дебетовая карта MC World Elite\"},\n" +
                "          {\"entityName\": \"Priority Pass MC Black Edition\", \"title\": \"Priority Pass MC Black Edition\"},\n" +
                "          {\"entityName\": \"Priority Pass MC World Elite\", \"title\": \"Priority Pass MC World Elite\"},\n" +
                "          {\"entityName\": \"Priority Pass Visa Infinite\", \"title\": \"Priority Pass Visa Infinite\"},\n" +
                "          {\"entityName\": \"Priority Pass Visa Signature\", \"title\": \"Priority Pass Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Classic Cash Back 1%\", \"title\": \"Дебетовая карта Visa Classic Cash Back 1%\"},\n" +
                "          {\"entityName\": \"Visa Classic_Salary\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Visa Classic_Salary VTB24\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Visa Gold Автокарта\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold_Salary\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold_Salary VTB24\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold Карта мира\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold Travel Promo\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Gold Карта впечатлений\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Visa Infinite Автокарта\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"Visa Infinite Карта мира\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"VisaInfinite Карта впечатлений\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"Visa Platinum privileged\", \"title\": \"Дебетовая карта Visa Platinum\"},\n" +
                "          {\"entityName\": \"Visa Platinum Автокарта\", \"title\": \"Дебетовая карта Visa Platinum\"},\n" +
                "          {\"entityName\": \"Visa Platinum_Salary (platinum)\", \"title\": \"Дебетовая карта Visa Platinum\"},\n" +
                "          {\"entityName\": \"Visa Platinum_Salary VTB24\", \"title\": \"Дебетовая карта Visa Platinum\"},\n" +
                "          {\"entityName\": \"Visa Platinum Карта мира\", \"title\": \"Дебетовая карта Visa Platinum\"},\n" +
                "          {\"entityName\": \"Visa Platinum Travel Promo\", \"title\": \"Дебетовая карта Visa Platinum\"},\n" +
                "          {\"entityName\": \"Visa Platinum Карта впечатлений\", \"title\": \"Дебетовая карта Visa Platinum\"},\n" +
                "          {\"entityName\": \"Visa Signature Автокарта\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature_Salary\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature_Salary VTB24\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Карта мира\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Впечатлений\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Travel Promo\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Unembossed_Salary\", \"title\": \"Дебетовая карта Visa Unembossed\"},\n" +
                "          {\"entityName\": \"MIR Classic Overdraft\", \"title\": \"Дебетовая карта МИР Classic Overdraft\"},\n" +
                "          {\"entityName\": \"MIR Name Debit\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR NO Name Debit\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR Premium Overdraft\", \"title\": \"Дебетовая карта МИР Premium Overdraft\"},\n" +
                "          {\"entityName\": \"Классическая МИР\", \"title\": \"Дебетовая карта МИР Classic\"},\n" +
                "          {\"entityName\": \"Золотая МИР\", \"title\": \"Дебетовая карта МИР Gold\"},\n" +
                "          {\"entityName\": \"Платиновая МИР\", \"title\": \"Дебетовая карта МИР Platinum\"},\n" +
                "          {\"entityName\": \"Привилегия МИР\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Классическая МИР Salary\", \"title\": \"Дебетовая карта МИР Classic\"},\n" +
                "          {\"entityName\": \"Золотая МИР Salary\", \"title\": \"Дебетовая карта МИР Gold\"},\n" +
                "          {\"entityName\": \"Платиновая МИР Salary\", \"title\": \"Дебетовая карта МИР Platinum\"},\n" +
                "          {\"entityName\": \"Привилегия МИР Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Классическая МИР Salary_VTB24\", \"title\": \"Дебетовая карта МИР Classic\"},\n" +
                "          {\"entityName\": \"Золотая МИР Salary_VTB24\", \"title\": \"Дебетовая карта МИР Gold\"},\n" +
                "          {\"entityName\": \"Платиновая МИР Salary_VTB24\", \"title\": \"Дебетовая карта МИР Platinum\"},\n" +
                "          {\"entityName\": \"Привилегия МИР Salary_VTB24\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Классическая МИР Salary Минобороны\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Золотая МИР Salary Минобороны\", \"title\": \"Дебетовая карта МИР Gold\"},\n" +
                "          {\"entityName\": \"Платиновая МИР Salary Минобороны\", \"title\": \"Дебетовая карта МИР Platinum\"},\n" +
                "          {\"entityName\": \"Классическая МИР Salary Минздрав\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Золотая МИР Salary Минздрав\", \"title\": \"Дебетовая карта МИР Gold\"},\n" +
                "          {\"entityName\": \"MC Black Edition Автокарта Сервисная\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"MasterCard Black Edition Карта мира Сервисная\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"MC Black Edition Впечатлений Сервисная\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"Visa Signature Автокарта Сервисная\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Карта мира Сервисная\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Впечатлений Сервисная\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"MC Мультикарта Salary\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"MC Мультикарта Salary VTB24\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта Salary\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта Salary VTB24\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта Salary VTB24\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MasterCard Standard KAMAZ_Salary\", \"title\": \"Дебетовая карта MasterCard Standard\"},\n" +
                "          {\"entityName\": \"MasterCard Gold KAMAZ_Salary\", \"title\": \"Дебетовая карта MasterCard Gold\"},\n" +
                "          {\"entityName\": \"MasterCard Standard AVID_Salary\", \"title\": \"Дебетовая карта MasterCard Standard\"},\n" +
                "          {\"entityName\": \"MasterCard Gold AVID_Salary\", \"title\": \"Дебетовая карта MasterCard Gold\"},\n" +
                "          {\"entityName\": \"MasterCard Platinum AVID_Salary\", \"title\": \"Дебетовая карта MasterCard Platinum\"},\n" +
                "          {\"entityName\": \"Мир-MasterCard Привилегия\", \"title\": \"Дебетовая карта Мир-MasterCard\"},\n" +
                "          {\"entityName\": \"Мир-MasterCard Мультикарта\", \"title\": \"Дебетовая карта Мир-MasterCard\"},\n" +
                "          {\"entityName\": \"Мир-MasterCard Привилегия Salary\", \"title\": \"Дебетовая карта Мир-MasterCard\"},\n" +
                "          {\"entityName\": \"Мир-MasterCard Мультикарта Salary\", \"title\": \"Дебетовая карта Мир-MasterCard\"},\n" +
                "          {\"entityName\": \"MIR ВШЭ Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта FIFA\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта Troika_Salary\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"MasterCard Мультикарта Troika_Salary\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"Visa Signature Troika\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Troika_Salary\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"MasterCard Black Edition Troika\", \"title\": \"Дебетовая карта MasterCard Black Edition\"},\n" +
                "          {\"entityName\": \"MasterCard Black Edition Troika_Salary\", \"title\": \"Дебетовая карта MasterCard Black Edition\"},\n" +
                "          {\"entityName\": \"MC Multicard KAMAZ_Salary\", \"title\": \"Дебетовая карта MasterCard \"},\n" +
                "          {\"entityName\": \"MC Multicard AVID_Salary\", \"title\": \"Дебетовая карта MasterCard \"},\n" +
                "          {\"entityName\": \"MIR Multicard Salary_MO\", \"title\": \"Дебетовая карта МИР \"},\n" +
                "          {\"entityName\": \"MIR ВШЭ Мультикарта Salary\", \"title\": \"Дебетовая карта МИР \"},\n" +
                "          {\"entityName\": \"MC Black Edition Сбережения\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"VisaSignature Сбережения\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Infinite Коллекция FIFA\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"Visa Infinite Автокарта FIFA\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"Visa Infinite Карта мира FIFA\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"Visa Infinite Впечатлений FIFA\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"Visa Signature FIFA\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Авто FIFA\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Сбережения FIFA\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Карта мира FIFA\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature ВпечатленийFIFA\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта РЖД_Salary\", \"title\": \"Дебетовая карта Visa \"},\n" +
                "          {\"entityName\": \"MC Black Edition Мультикарта\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"MC Black Edition Мультикарта_Sal\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"МИР Привилегия Мультикарта\", \"title\": \"Дебетовая карта МИР Привилегия\"},\n" +
                "          {\"entityName\": \"МИР Привилегия Мультикарта_Sal\", \"title\": \"Дебетовая карта МИР Привилегия\"},\n" +
                "          {\"entityName\": \"Visa Signature Мультикарта\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature Мультикарта_Sal\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта Росжелдор_Salary\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта Северсталь_Salary\", \"title\": \"Дебетовая карта Visa \"},\n" +
                "          {\"entityName\": \"Visa Мультикарта МВидео_Salary\", \"title\": \"Дебетовая карта Visa \"},\n" +
                "          {\"entityName\": \"MC Black Edition Впечатлений\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"MasterCard Black Edition_Salary\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"MasterCard Black Edition_Salary VTB24\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"MC Gold Автокарта\", \"title\": \"Дебетовая карта MC Gold\"},\n" +
                "          {\"entityName\": \"MasterCard Gold_Salary VTB24\", \"title\": \"Дебетовая карта MC Gold\"},\n" +
                "          {\"entityName\": \"VS Мультикарта FIFA\", \"title\": \"Дебетовая карта Visa \"},\n" +
                "          {\"entityName\": \"МИР Мультикарта МВД Огарева_Salary\", \"title\": \"Дебетовая карта МИР \"},\n" +
                "          {\"entityName\": \"МИР Мультикарта ЕКП для участников зарплатного проекта\", \"title\": \"Дебетовая карта МИР \"},\n" +
                "          {\"entityName\": \"Visa Unembossed Instant Issue (Мультикарта)\", \"title\": \"Дебетовая карта VISA\"},\n" +
                "          {\"entityName\": \"MIR Unembossed Instant Issue (Дебетовая)\", \"title\": \"Дебетовая карта МИР \"},\n" +
                "          {\"entityName\": \"Кобейдж МИР-Maestro Salary\", \"title\": \"Дебетовая карта МИР-Maestro\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта ЕКП\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта ЕКП для участников зарплатного проекта\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта ФПК_Salary\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"MasterCard Мультикарта ФПК_Salary\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"MasterCard Мультикарта КВС_Salary\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта ФСС_Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Visa Кобренд ВТБ-МВидео\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта МВД_Петровка_с_ТП_Тройка_Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MC World Elite Прайм+\", \"title\": \"Дебетовая карта MC World Elite\"},\n" +
                "          {\"entityName\": \"Visa Infinite Прайм+\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"MC World Elite Прайм+ драг\", \"title\": \"Дебетовая карта MC World Elite\"},\n" +
                "          {\"entityName\": \"Visa Infinite Прайм+ драг\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"МИР Прайм+ драг\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта Эльдорадо_Salary\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa Signature Мультикарта_Совкомфлот для участников зарплатного проекта\", \"title\": \"Дебетовая карта Visa Signature \"},\n" +
                "          {\"entityName\": \"MC Мультикарта_ОДК-ПМ для участников зарплатного проекта\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта Prime+\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Привилегия МИР Prime+\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR Мультикарта с ТП Тройка Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR PRIVILEGE Мультикарта с ТП Тройка\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR PRIVILEGE Мультикарта с ТП Тройка Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR PRIVILEGE Мультикарта ЕКП\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR PRIVILEGE Мультикарта ЕКП Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MasterCard Instant Issue\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"Visa Classic Instant Issue\", \"title\": \"Дебетовая карта Visa Classic\"},\n" +
                "          {\"entityName\": \"Мир Карта учащегося\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР Мультикарта КМ\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR Prime Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Visa Infinite Salary\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"MasterCard World Elite Salary\", \"title\": \"Дебетовая карта MasterCard World\"},\n" +
                "          {\"entityName\": \"Visa Infinite Прайм+ FIFA\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"Мультикарта\", \"title\": \"Дебетовая Мультикарта\"},\n" +
                "          {\"entityName\": \"Мультикарта PR\", \"title\": \"Дебетовая Мультикарта\"},\n" +
                "          {\"entityName\": \"ПривилегияМК\", \"title\": \"Дебетовая карта Привилегия\"},\n" +
                "          {\"entityName\": \"ПривилегияМК PR\", \"title\": \"Дебетовая карта Привилегия\"},\n" +
                "          {\"entityName\": \"Единая карта петербуржца (дебетовая)\", \"title\": \"Единая карта Петербуржца \"},\n" +
                "          {\"entityName\": \"MasterCard Мультикарта Динамо\", \"title\": \"Дебетовая Мультикарта\"},\n" +
                "          {\"entityName\": \"МИР-Maestro Привилегия\", \"title\": \"Дебетовая карта МИР-Maestro Привилегия\"},\n" +
                "          {\"entityName\": \"МИР-Maestro Привилегия Salary\", \"title\": \"Дебетовая карта МИР-Maestro Привилегия\"},\n" +
                "          {\"entityName\": \"МИР Карта Москвича_Salary\", \"title\": \"Карта Москвича МИР \"},\n" +
                "          {\"entityName\": \"МИР Карта Москвича_Salary_Kam\", \"title\": \"Карта Москвича МИР \"},\n" +
                "          {\"entityName\": \"МИР МК ДА МИД Тройка Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Мир Привилегия МК КМ\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Мир Привилегия МК KM Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MC Black Edition МК ECO\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"МИР Привилегия МК ECO\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Visa Signature Мультикарта ECO\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"МИР-Maestro Привилегия МК ECO\", \"title\": \"Дебетовая карта МИР-Maestro\"},\n" +
                "          {\"entityName\": \"Visa Infinite Прайм+ ECO\", \"title\": \"Дебетовая карта Visa Infinite\"},\n" +
                "          {\"entityName\": \"MC World Elite Прайм+ ECO\", \"title\": \"Дебетовая карта MC World Elite\"},\n" +
                "          {\"entityName\": \"MIR Мультикарта Прайм+ ECO\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Мир МК МО Минимальный\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Мир МК МО Средний\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Мир МК МО Максимальный\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"Мир СКМ\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MC Black Edition Travel\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"MC Black Edition МК БКТП НН\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"MC BE МК БКТП НН Salary\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"MC BlackEdition МК БКТП НН Фото\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"MC BE МК БКТП НН Фото Salary\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"MIR Мультикарта Travel\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР Привилегия Travel\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR Мультикарта БКТП НН\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR МК БКТП НН Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР Привилегия МК БКТП НН\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР ПМК БКТП НН Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR Мультикарта БКТП НН Фото\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MIR МК БКТП НН Фото Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР Привилегия МК БКТП НН Фото\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР ПМК БКТП НН Фото Salary\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"MasterCard Travel\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"MC Мультикарта БКТП НН\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"MC МК БКТП НН Salary\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"MC Мультикарта БКТП НН Фото\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"MC МК БКТП НН Фото Salary\", \"title\": \"Дебетовая карта MasterCard\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта Travel\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта БКТП НН\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa МК БКТП НН Salary\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa Мультикарта БКТП НН Фото\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa МК БКТП НН Фото Salary\", \"title\": \"Дебетовая карта Visa\"},\n" +
                "          {\"entityName\": \"Visa Signature Travel\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature МК БКТП НН\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"VS МК БКТП НН Salary\", \"title\": \"Дебетовая карта Visa \"},\n" +
                "          {\"entityName\": \"Visa Signature МК БКТП НН Фото\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"VS МК БКТП НН Фото Salary\", \"title\": \"Дебетовая карта Visa \"},\n" +
                "          {\"entityName\": \"Мир Мультикарта МП\", \"title\": \"Дебетовая карта МИР \"},\n" +
                "          {\"entityName\": \"MasterCard QR\", \"title\": \"Дебетовая карта MasterCard \"},\n" +
                "          {\"entityName\": \"Visa Signature КВ\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"MC Black Edition КВ\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"Visa Signature КВ Travel\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"MC Black Edition КВ Travel\", \"title\": \"Дебетовая карта MC Black Edition\"},\n" +
                "          {\"entityName\": \"Visa_Карта \", \"title\": \"Дебетовая карта VISA\"},\n" +
                "          {\"entityName\": \"MC_Неименная к автокредиту \", \"title\": \"Дебетовая карта MasterCard \"},\n" +
                "          {\"entityName\": \"Мир МК Приморец Salary\", \"title\": \"Дебетовая карта МИР \"},\n" +
                "          {\"entityName\": \"Мир Мультикарта Приморец\", \"title\": \"Дебетовая карта МИР \"},\n" +
                "          {\"entityName\": \"MC Black Edition КВ Travel digital\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"MC Black Edition КВ digital\", \"title\": \"Дебетовая карта MC Black Edition \"},\n" +
                "          {\"entityName\": \"МС World КВ digital\", \"title\": \"Дебетовая карта MasterCard \"},\n" +
                "          {\"entityName\": \"Visa Signature КВ Travel digital\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Signature КВ digital\", \"title\": \"Дебетовая карта Visa Signature\"},\n" +
                "          {\"entityName\": \"Visa Gold КВ digital\", \"title\": \"Дебетовая карта Visa Gold\"},\n" +
                "          {\"entityName\": \"Мир Мультикарта Кузбасс\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР МК Самара Город ЭлКошелек\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР МК Самара Ракета ЭлКошелек\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР МК Самара Город МесБезлим\", \"title\": \"Дебетовая карта МИР\"},\n" +
                "          {\"entityName\": \"МИР МК Самара Ракета МесБезлим\", \"title\": \"Дебетовая карта МИР\"}";
        String[] strings = s.split(",\n");
//        System.out.println(Arrays.toString(strings));
        System.out.println(strings.length);
        for (int i = 0; i < strings.length; i++) {
//            System.out.println(strings[i]);
            strings[i] = strings[i].replace("}",", "+ "\"id\": " + i + "}");
        }

        System.out.println(Arrays.toString(strings));
    }


}

