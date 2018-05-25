package testing.Lab3.constants;

public enum DatesConstants {
    firstTest(new Integer[] {0, 100}),
    secondTest(new Integer[] {0, 0}),
    thirdTest(new Integer[] {100, 100}),
    fourthTest(new Integer[] {30, 70});

    public Integer[] testArray;

    DatesConstants(Integer[] i){
        testArray = i;
    }
}