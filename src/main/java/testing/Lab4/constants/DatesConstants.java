package testing.Lab4.constants;

public enum DatesConstants {
    FIRST_TEST(new Integer[]{0, 100}),
    SECOND_TEST(new Integer[]{0, 0}),
    THIRD_TEST(new Integer[]{100, 100}),
    FOURTH_TEST(new Integer[]{30, 70});

    public Integer[] values;

    DatesConstants(Integer[] i) {
        values = i;
    }
}