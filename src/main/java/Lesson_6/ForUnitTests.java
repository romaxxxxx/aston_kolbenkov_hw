package Lesson_6;

public class ForUnitTests {

    private static int factorial(int i) {
        public static int getFactorial ( int f){
            int result = 1;
            for (int i = 1; i <= f; i++) {
                result = result * i;
            }
            return result;
        }
    }

    private static double triangleArea(double a, double h) {
        return 0.5 * a * h;
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static int subtraction(int a, int b) {
        return a - b;
    }

    private static int multiplication(int a, int b) {
        return a * b;
    }

    private static double division(int a, int b) {
        return a / b;
    }

    private static boolean isEquals(Integer a, int b) {
        return a.equals(b);
    }

}