package Lesson_6_testng;

import Lesson_6.ForUnitTests;
import Lesson_6.MyArithmeticException;
import Lesson_6.MySubZeroException;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;


public class UnitTests {
    @Test(dataProvider = "sumTestData")
    @Tag(name = "SumTests")
    void sumTest(int a, int b, int sum) {
        Assert.assertEquals(ForUnitTests.sum(a, b), sum);
    }

    @Test(dataProvider = "sumTestOverflowExceptionTestData", expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "integer overflow")
    @Tag(name = "SumTests")
    void sumTestOverflowExceptionTest(int a, int b) {
        ForUnitTests.sum(a, b);
    }

    @Test(groups = "DivisionTests", expectedExceptions = MyArithmeticException.class,
            expectedExceptionsMessageRegExp = "На ноль делить нельзя")
    @Tag(name = "DivisionTests")
    void myArithmeticExceptionDivisionTest() throws MyArithmeticException {
        ForUnitTests.division(4, 0);
    }

    @Test(dataProvider = "multiplicationTestData")
    @Tag(name = "MultiplicationTests")
    void multiplicationTest(int a, int b, int c) {
        Assert.assertEquals(ForUnitTests.multiplication(a, b), c);
    }

    @Test(dataProvider = "multiplicationOverflowExceptionTestData", expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "integer overflow")
    @Tag(name = "MultiplicationTests")
    void multiplicationOverflowExceptionTest(int a, int b) {
        ForUnitTests.multiplication(a, b);
    }

    @Test(groups = "DivisionTests", dataProvider = "divisionTestData")
    @Tag(name = "DivisionTests")
    void divisionTest(int a, int b, int c) throws MyArithmeticException {
        Assert.assertEquals(ForUnitTests.division(a, b), c);
    }

    @Test(dataProvider = "subtractionTestData")
    @Tag(name = "SubtractionTests")
    void subtractionTest(int a, int b, int c) {
        Assert.assertEquals(ForUnitTests.subtraction(a, b), c);
    }

    @Test(dataProvider = "subtractionOverflowExceptionTestData", expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "integer overflow")
    @Tag(name = "SubtractionTests")
    void subtractionOverflowExceptionTest(int a, int b) {
        ForUnitTests.subtraction(a, b);
    }

    @Test(groups = "isEqualsTests", dataProvider = "isEqualsTestData")
    @Tag(name = "IsEqualsTests")
    void isEqualsTest(int a, int b) {
        Assert.assertTrue(ForUnitTests.isEquals(a, b));
    }

    @Test(groups = "isEqualsTests", dataProvider = "isUnEqualsTestData")
    @Tag(name = "IsUnEqualsTests")
    void isUnEqualsTest(int a, int b) {
        Assert.assertFalse(ForUnitTests.isEquals(a, b));
    }

    @Test(dataProvider = "triangleAreaTestData")
    @Tag(name = "TriangleAreaTests")
    void triangleAreaTest(double a, double h, double result) throws MySubZeroException {
        Assert.assertEquals(ForUnitTests.triangleArea(a, h), result);
    }

    @Test(expectedExceptions = MySubZeroException.class,
            expectedExceptionsMessageRegExp = "Основание треугольника меньше ноля")
    @Tag(name = "TriangleAreaTests")
    void triangleAreaWithBaseSubZeroTest() throws MySubZeroException {
        ForUnitTests.triangleArea(-2, 5);
    }

    @Test(expectedExceptions = MySubZeroException.class,
            expectedExceptionsMessageRegExp = "Высота треугольника меньше ноля")
    @Tag(name = "TriangleAreaTests")
    void triangleAreaWithSubZeroHeightTest() throws MySubZeroException {
        ForUnitTests.triangleArea(2, -5);
    }

    @Test(dataProvider = "factorialTestData")
    @Tag(name = "factorialTests")
    void factorialTest(int f, int result) throws MySubZeroException {
        Assert.assertEquals(ForUnitTests.factorial(f), result);
    }

    @Test(expectedExceptions = MySubZeroException.class,
            expectedExceptionsMessageRegExp = "Число должно быть больше или равно нулю")
    @Tag(name = "factorialTests")
    void factorialMySubZeroExceptionTest() throws MySubZeroException {
        ForUnitTests.factorial(-2);
    }

    @DataProvider
    public static Object[][] sumTestData() {
        return new Object[][]{
                {2, 2, 4},
                {10, 1, 11},
                {1000000, -1000000, 0}
        };
    }

    @DataProvider
    public static Object[][] sumTestOverflowExceptionTestData() {
        return new Object[][]{
                {-2147483648, -1},
                {2147483647, 1},
        };
    }

    @DataProvider
    public static Object[][] factorialTestData() {
        return new Object[][]{
                {0, 1},
                {5, 120},
        };
    }

    @DataProvider
    public static Object[][] triangleAreaTestData() {
        return new Object[][]{
                {2, 4, 4},
                {5, 2, 5},
        };
    }

    @DataProvider
    public static Object[][] isUnEqualsTestData() {
        return new Object[][]{
                {2, 3},
                {3, -3},
        };
    }

    @DataProvider
    public static Object[][] isEqualsTestData() {
        return new Object[][]{
                {2, 2},
                {-3, -3},
                {0, 0}
        };
    }

    @DataProvider
    public static Object[][] subtractionTestData() {
        return new Object[][]{
                {5, 2, 3},
                {-10, 2, -12},
                {-5, -4, -1}
        };
    }

    @DataProvider
    public static Object[][] subtractionOverflowExceptionTestData() {
        return new Object[][]{
                {-2147483648, 1},
                {2147483647, -1}
        };
    }

    @DataProvider
    public static Object[][] divisionTestData() {
        return new Object[][]{
                {8, 4, 2},
                {-12, -6, 2},
                {-10, 2, -5}
        };
    }

    @DataProvider
    public static Object[][] multiplicationTestData() {
        return new Object[][]{
                {2, 4, 8},
                {-2, -6, 12},
                {-10, 2, -20}
        };
    }

    @DataProvider
    public static Object[][] multiplicationOverflowExceptionTestData() {
        return new Object[][]{
                {2147483647, 2},
                {-2147483648, 2},
        };
    }
}