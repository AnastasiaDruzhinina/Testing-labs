package testing.Lab3.constants;

public enum DifferentElementsConstants {

    CHECKBOX_NUMBER(4),
    DROPDOWN_NUMBER(4),

    CHECKBOX_1_NAME("Water"),
    CHECKBOX_2_NAME("Earth"),
    CHECKBOX_3_NAME("Wind"),
    CHECKBOX_4_NAME("Fire"),

    RADIO_1_VALUE("Gold"),
    RADIO_2_VALUE("Silver"),
    RADIO_3_VALUE("Bronze"),
    RADIO_4_VALUE("Selen"),

    DROPDOWN_1_VALUE("Red"),
    DROPDOWN_2_VALUE("Green"),
    DROPDOWN_3_VALUE("Blue"),
    DROPDOWN_4_VALUE("Yellow");

    public String strValue;
    public Integer intValue;

    DifferentElementsConstants(String str) {
        strValue = str;
    }

    DifferentElementsConstants(Integer i) {
        intValue = i;
    }
}