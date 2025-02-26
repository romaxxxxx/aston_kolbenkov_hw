import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Lesson_1 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkValueBetween10and20(5, 16);
        checkValueUnderSubZeroString(0);
        checkValueUnderSubZeroBool(0);
        printWord(3, "Вася");
        out.println(leapYearCheck(104));
        replacement1and0();
        fillArrayFrom1To100();
        multiplicationOn6();
        fill2dimensionalArrayOnDiagonals();
        out.println(Arrays.toString(fillArray(3, 7)));
    }

    static void printThreeWords() {
        Stream.of("Orange", "Banana", "Apple").forEach(System.out::println);
    }

    static void checkSumSign() {
        int a = -10;
        int b = 10;
        out.println((a + b >= 0) ? "Сумму положительная" : "Сумма отрицательная");
    }

    static void printColor() {
        int value = 101;
        if (value <= 0) {
            out.println("красный");
        } else if (value > 0 & value <= 100) {
            out.println("желтый");
        } else {
            out.println("зеленый");
        }
    }

    static void compareNumbers() {
        int a = 10;
        int b = 11;
        out.println((a >= b ? "a >= b" : "a < b"));
    }

    static void checkValueBetween10and20(int a, int b) {
        out.println(((a + b) >= 10 & (a + b) <= 20) ? true : false);
    }

    static void checkValueUnderSubZeroString(int value) {
        out.println(value < 0 ? "число отрицательное" : "число положительное");
    }

    static void checkValueUnderSubZeroBool(int value) {
        out.println(value < 0 ? true : false);
    }

    static void printWord(int word, String value) {
        for (int i = 1; i <= word; i++) {
            out.println(value);
        }
    }

    static boolean leapYearCheck(int verifiableYear) {
        boolean b = false;
        if (verifiableYear % 400 == 0) {
            b = true;
        } else if (verifiableYear % 100 == 0) {
            b = false;
        } else if (verifiableYear % 4 == 0) {
            b = true;
        }
        return b;
    }

    static void replacement1and0() {
        int[] arr = {0, 1, 0, 1, 0, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        out.println(Arrays.toString(arr));
    }

    static void fillArrayFrom1To100() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        out.println(Arrays.toString(arr));
    }

    static void multiplicationOn6() {
        int[] arr = {4, 1, 8, 5, 11, 20, 3};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        out.println(Arrays.toString(arr));
    }

    static void fill2dimensionalArrayOnDiagonals() {
        int[][] arr = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
        out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
    }

    static int[] fillArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}