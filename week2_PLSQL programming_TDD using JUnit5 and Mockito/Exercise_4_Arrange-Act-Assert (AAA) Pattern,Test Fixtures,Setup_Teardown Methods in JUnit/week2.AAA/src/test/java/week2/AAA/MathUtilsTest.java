package week2.AAA;

import org.junit.jupiter.api.*;

import com.cognizant.week2.aaa_pattern.Mathutils;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

	Mathutils mathUtils;

    @BeforeAll
    static void initAll() {
        System.out.println("Starting MathUtils tests...");
    }

    @BeforeEach
    void init() {
        mathUtils = new Mathutils();
    }

    @Test
    void testAdd() {
        int result = mathUtils.add(10, 5);

        assertEquals(15, result, "Addition failed");
    }

    @Test
    void testMultiply() {
        int result = mathUtils.multiply(4, 3);

        assertEquals(12, result, "Multiplication failed");
    }

    @Test
    void testDivide() {
        int result = mathUtils.divide(20, 4);

        assertEquals(5, result, "Division failed");
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(10, 0),
                "Division by zero should throw exception");
    }

    @Test
    void testIsPositive() {
        boolean result = mathUtils.isPositive(7);

        assertTrue(result, "Number should be positive");
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Test completed.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("All tests done.");
    }
}