package Lesson_6;

public class ForUnitTests {
    public static int factorial(int f) {
            int result = 1;
            for (int i = 1; i <= f; i++) {
                result = result * i;
            }
            return result;
        }

    public static double triangleArea(double a, double h) {
        return 0.5 * a * h;
    }

    public static int sum(int a, int b) {
        return a + b;
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
        } catch(ArithmeticException e){
            throw new MyArithmeticException("На ноль делить нельзя");
        }
    }

    public static boolean isEquals(Integer a, int b) {
        return a.equals(b);
    }
}