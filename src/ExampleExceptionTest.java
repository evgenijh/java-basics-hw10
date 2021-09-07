import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleExceptionTest {

    /**
     * Test data for positive test.
     *
     * @return test data array
     */
    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]{
                {2, 2, 4},
                {2, 3, 6},
                {5, 1, 5},
                {10, 2, 20}
        };
    }

    /**
     * Test data for exception test.
     *
     * @return test data array
     */
    @DataProvider(name = "negativeData")
    public static Object[][] negativeData() {
        return new Object[][]{
                {-2, 2},
                {2, -2},
                {-2, -2},
                {0, -1}
        };
    }

    @Test(dataProvider = "data")
    public void testRectangleArea(int a, int b, int c) {
        int actualResult = ExampleException.rectangleArea(a, b);
        assertEquals(actualResult, c, "input value is correct");
        try {
        } catch (ArithmeticException ex) {
            System.out.println("Division by zero");
        }
    }


    @Test(dataProvider = "negativeData")
    public void testRectangleAreaNegative(int a, int b) {
        try {
            ExampleException.rectangleArea(a, b);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ("input value is below zero!"));
        }
    }
}

