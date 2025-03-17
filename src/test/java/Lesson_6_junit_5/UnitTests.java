package Lesson_6_junit_5;

import Lesson_6.ForUnitTests;
import Lesson_6.MyArithmeticException;
import jdk.jfr.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class UnitTests {
    @ParameterizedTest
    @MethodSource("sumTestData")
    @Tag("SumTests")
    @DisplayName("Проверка метода суммирования целых чисел")
    void sumTestMethod(int a, int b, int sum) {
        Assertions.assertEquals(ForUnitTests.sum(a, b), sum);
    }

    @Test
    @DisplayName("Проверка на исключение MyArithmeticException при делении на ноль")
    @Tag("DivisionTests")
    void MyArithmeticExceptionDivisionTest() {
        MyArithmeticException thrown = Assertions.assertThrows(MyArithmeticException.class,
                () -> ForUnitTests.division(4, 0), "Ожидается MyArithmeticException");
        Assertions.assertEquals(thrown.getMessage(), "На ноль делить нельзя");
    }

    @DisplayName("Проверка метода умножения")
    @Tag("MultiplicationTests")
    @ParameterizedTest
    @CsvSource({"2, 4, 8", "-2, -6, 12", "-10, 2, -20"})
    void MultiplicationTest(int a, int b, int c) {
        Assertions.assertEquals(ForUnitTests.multiplication(a, b), c);
    }

    @DisplayName("Проверка метода деления")
    @Tag("DivisionTests")
    @ParameterizedTest
    @CsvSource({"8, 4, 2", "-12, -6, 2", "-10, 2, -5"})
    void DivisionTest(int a, int b, int c) throws MyArithmeticException {
        Assertions.assertEquals(ForUnitTests.division(a, b), c);
    }

    @DisplayName("Проверка метода вычитания")
    @Tag("SubtractionTests")
    @ParameterizedTest
    @CsvFileSource(resources = "/subtractingData.csv")
    void subtractionTest(int a, int b, int c) {
        Assertions.assertEquals(ForUnitTests.subtraction(a, b), c);
    }

    @DisplayName("Проверка метода сравнения равных чисел")
    @Tag("IsEqualsTests")
    @ParameterizedTest
    @CsvSource({"2,2", "-3,-3", "0,0"})
    void isEqualsTest(int a, int b) {
        Assertions.assertTrue(ForUnitTests.isEquals(a, b));
    }

    @DisplayName("Проверка метода сравнения неравных чисел")
    @Tag("IsEqualsTests")
    @ParameterizedTest
    @CsvSource({"2,3", "-3,3"})
    void isUnEqualsTest(int a, int b) {
        Assertions.assertFalse(ForUnitTests.isEquals(a, b));
    }

    @DisplayName("Проверка метода нахождения площади треугольника")
    @Tag("TriangleAreaTests")
    @ParameterizedTest
    @CsvSource({"2, 4, 4", "5, 2, 5"})
    void triangleAreaTest(int a, int h, int result) {
        Assertions.assertEquals(ForUnitTests.triangleArea(a, h), result);
    }

    @DisplayName("Проверка метода нахождения факториала")
    @Tag("factorialTests")
    @ParameterizedTest
    @CsvSource({"0,1", "5, 120"})
    void factorialTest(int f, int result) {
        Assertions.assertEquals(ForUnitTests.factorial(f), result);
    }

    public static Object[][] sumTestData() {
        return new Object[][]{
                {2, 2, 4},
                {10, 1, 11},
                {1000000, -1000000, 0}
        };
    }
}