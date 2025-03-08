package Lesson_4;

import static java.lang.String.format;

public class ExceptionsHW {
    public static void main(String[] args) {
        try {
            arrException(new String[][]{{"4", "4", "k", "4"}, {"4", "4", "4", "4"}, {"4", "4", "4", "4"},
                    {"4", "4", "4", "4"}});
        } catch (MyArraySizeException s) {
            s.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
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
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(format("Ошибка парсинга: i = %d, j = %d",i,j));
                }
                sum += toInt;
            }
        }
        System.out.println(sum);
    }
}