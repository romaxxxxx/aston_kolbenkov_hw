package Lesson_4;

import static java.lang.String.format;

public class ExceptionsHW {
    public static void main(String[] args) throws MyArrayDataException {
        arrException(new String[][]{{"4", "4", "4", "4"}, {"4", "4", "4", "4"}, {"4", "4", "4", "4"},
                {"4", "4", "4", "4"}});
    }

    static void arrException(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        int toInt = 0;
        try {
            if (arr.length != 4 || arr[0].length != 4) {
                throw new MyArraySizeException("На вход подан массив недопустимой длины");
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.exit(5);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    toInt = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println(i);
                    e.printStackTrace();
                    throw new MyArrayDataException(format("%i Парсер не прошел", i));
                }
                sum += toInt;
            }
        }
        System.out.println(sum);
    }
}