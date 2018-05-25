package testing.Lab3.constants;

public enum DifferentElementsConstants {

    checkboxNumber(4),
    dropdownNumber(4),

    checkbox1Name("Water"),
    checkbox2Name("Earth"),
    checkbox3Name("Wind"),
    checkbox4Name("Fire"),

    radio1value("Gold"),
    radio2value("Silver"),
    radio3value("Bronze"),
    radio4value("Selen"),

    dropdown1value("Red"),
    dropdown2value("Green"),
    dropdown3value("Blue"),
    dropdown4value("Yellow");

    public String strValue;
    public Integer intValue;

    DifferentElementsConstants(String str){
        strValue = str;
    }

    DifferentElementsConstants(Integer i){
        intValue = i;
    }
}