package Lesson_6_testng;

import Lesson_6.ForUnitTests;
import Lesson_6.MyArithmeticException;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;


public class UnitTests {
    @Test(dataProvider="sumTestData")
    @Tag(name = "SumTests")
    void sumTestMethod(int a, int b, int sum) {
        Assert.assertEquals(ForUnitTests.sum(a, b), sum);
    }

    @Test(expectedExceptions = MyArithmeticException.class,
            expectedExceptionsMessageRegExp = "На ноль делить нельзя")
    @Tag(name = "DivisionTests")
    void MyArithmeticExceptionDivisionTest() throws MyArithmeticException {
        ForUnitTests.division(4, 0);
    }
    @Test
    @Tag(name = "MultiplicationTests")
    //@CsvSource({"2, 4, 8", "-2, -6, 12", "-10, 2, -20"})
    void MultiplicationTest(int a, int b, int c) {
        Assert.assertEquals(ForUnitTests.multiplication(a, b), c);
    }
    @Test
    @Tag(name = "DivisionTests")
    //@CsvSource({"8, 4, 2", "-12, -6, 2", "-10, 2, -5"})
    void DivisionTest(int a, int b, int c) throws MyArithmeticException {
        Assert.assertEquals(ForUnitTests.division(a, b), c);
    }
    @Test
    @Tag(name = "SubtractionTests")
    //@CsvFileSource(resources = "/subtractingData.csv")
    void subtractionTest(int a, int b, int c) {
        Assert.assertEquals(ForUnitTests.subtraction(a, b), c);
    }
    @Test
    @Tag(name = "IsEqualsTests")
    //@CsvSource({"2,2", "-3,-3", "0,0"})
    void isEqualsTest(int a, int b) {
        Assert.assertTrue(ForUnitTests.isEquals(a, b));
    }
    @Test
    @Tag(name = "IsEqualsTests")
    //@CsvSource({"2,3", "-3,3"})
    void isUnEqualsTest(int a, int b) {
        Assert.assertFalse(ForUnitTests.isEquals(a, b));
    }

    @Test
    @Tag(name = "TriangleAreaTests")
    //@CsvSource({"2, 4, 4", "5, 2, 5"})
    void triangleAreaTest(int a, int h, int result) {
        Assert.assertEquals(ForUnitTests.triangleArea(a, h), result);
    }

    @Test
    @Tag(name = "factorialTests")
    //@CsvSource({"0,1", "5, 120"})
    void factorialTest(int f, int result) {
        Assert.assertEquals(ForUnitTests.factorial(f), result);
    }
    @DataProvider
    public static Object[][] sumTestData() {
        return new Object[][]{
                {2, 2, 4},
                {10, 1, 11},
                {1000000, -1000000, 0}
        };
    }
}
