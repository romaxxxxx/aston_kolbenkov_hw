package Lesson_6;

import static java.lang.String.format;

public class ForUnitTests {
    public static void main(String[] args) {
        System.out.println("dd" + sum(Integer.MAX_VALUE,Integer.MAX_VALUE));
        //System.out.println("df" + multiplication(Integer.MAX_VALUE,Integer.MAX_VALUE));
    }
    public static int factorial(int f) throws MySubZeroException {
        if (f < 0) {
            throw new MySubZeroException("Число должно быть больше или равно нулю");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public static double triangleArea(double a, double h) throws MySubZeroException {
        if (a < 0) {
            throw new MySubZeroException("Основание треугольника меньше ноля");
        }
        if (h < 0) {
            throw new MySubZeroException("Высота треугольника меньше ноля");
        }
        return 0.5 * a * h;
    }

    public static int sum(int a, int b) {
        return Math.addExact(a, b);
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static double division(int a, int b) throws MyArithmeticException {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw new MyArithmeticException("На ноль делить нельзя");
        }
    }

    public static boolean isEquals(Integer a, int b) {
        return a.equals(b);
    }
}