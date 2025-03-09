package Lesson_4;

import static java.lang.String.format;

public class MyExceptions {
    public static void main(String[] args) {
        try {
            arrException(new String[][]{{"4", "4", "k", "4"}, {"4", "4", "4", "4"}, {"4", "4", "4", "4"},
                    {"4", "4", "4", "4"}});
        } catch (MyArraySizeException | MyArrayDataException s) {
            s.printStackTrace();
        }
    }

    static void arrException(String[][] arr) throws NumberFormatException, MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int toInt = 0;
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("На вход подан массив недопустимой длины");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    toInt = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(format("Ошибка парсинга на элементе массива: строка = %d," +
                            " столбец = %d", i, j));
                }
                sum += toInt;
            }
        }
        System.out.println(format("Сумма элементов массива - %d",sum));
    }
}