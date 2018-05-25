package testing.Lab3.constants;

public enum IndexConstants {
    url("https://jdi-framework.github.io/tests/index.htm"),
    title("Index Page"),

    login("epam"),
    password("1234"),
    username("PITER CHAILOVSKII"),

    pictureNumber(4),
    pictureTexts(new String[] {
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM projec",
            "To be flexible and\n" +
                    "customizable",
            "To be multiplatform",
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…"
    }),

    mainHeader("EPAM FRAMEWORK WISHES…"),
    mainText("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                    "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
                    " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI" +
                    " UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN" +
                    " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),

    dropdownTexts(new String[] {
            "Support",
            "Dates",
            "Complex Table",
            "Simple Table",
            "Table With Pages",
            "Different Elements"
    });

    public String[] strArrayValue;
    public String strValue;
    public Integer intValue;

    IndexConstants(String str){
        strValue = str;
    }

    IndexConstants(Integer i){
        intValue = i;
    }

    IndexConstants(String[] i){
        strArrayValue = i;
    }
}
