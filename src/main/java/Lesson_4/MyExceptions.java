package Lesson_4;

import static java.lang.String.format;

public class MyExceptions {
    public static void main(String[] args) {
        int countStrings = 4;
        int[] stringLengths = {4, 4, 4, 4};
        try {
            arrException(countStrings, stringLengths,
                    new String[][]{{"4", "4", "4", "4"}, {"4", "4", "4", "4"}, {"4", "4", "4", "4"},
                            {"4", "4", "4", "4"}});
        } catch (MyArraySizeException | MyArrayDataException s) {
            s.printStackTrace();
        }
    }

    static void arrException(int countStrings, int[] stringLengths, String[][] arr) throws NumberFormatException, MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int toInt = 0;
        if (arr.length != countStrings) {
            throw new MyArraySizeException("На вход подан массив недопустимого размера");
        }
        for (int i = 0; i < countStrings; i++) {
            if (arr[i].length != stringLengths[i]) {
                throw new MyArraySizeException("На вход подан массив недопустимого размера");
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    toInt = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(format("Ошибка парсинга на элементе массива: строка = %d," +
                            " столбец = %d", i, j));
                }
                sum += toInt;
            }
        }
        System.out.println(format("Сумма элементов массива - %d", sum));
    }
}