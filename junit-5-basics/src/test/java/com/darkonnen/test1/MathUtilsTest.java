package com.darkonnen.test1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) // -> @BeforeAll no necesita ser static
@DisplayName("When runing MathUtils")
class MathUtilsTest {

//	int cachedValue = 0; // -> Bad code pattern

	MathUtils mathUtils;
	
	@BeforeAll
	static void beforeAllinit() { // HAS TO BE A STATIC METHOD
		System.out.println("This needs to run before all");
	}

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up");
	}

//	@Test
//	@DisplayName("Testing a method")
//	void testAdd() {
////		MathUtils mathUtils = new MathUtils();
////		int expected = 1;
//		int expected = 2;
//		int actual = mathUtils.add(1, 1);
//		assertEquals(expected, actual, "The add method should add two numbers");
//	}
	
	@Nested
	@DisplayName("add methods")
	@Tag("Math")
	class AddTest{
		@Test
		@DisplayName("add positive method")
		void testAddPositive() {
			assertEquals(2, mathUtils.add(1, 1), "The add method should add two positive numbers");
		}
		
		@Test
		@DisplayName("add negative method")
		void testAddNegative() {
			int expected = -2;
			int actual = mathUtils.add(-1, -1);
			
			assertEquals(expected, actual, () -> "The add method should return sum " + expected + " but returned " + actual);
		}

	}
	

	

	@Test
	@EnabledOnOs(OS.WINDOWS)
	@Tag("Math")
	void testDivide() {
//		MathUtils mathUtils = new MathUtils();
//		mathUtils.divide(1, 0); // asserting exceptions
//		assertThrows(NullPointerException.class, () -> mathUtils.divide(1, 0), "Divide by zero throws error");
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero throws error");
	}
	
	@Test
	@Tag("Math")
	@DisplayName("multiply method")
	void testMultiply() {
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2) , "should return 4"),
				() -> assertEquals(0, mathUtils.multiply(2, 0) , "should return 0"),
				() -> assertEquals(-2, mathUtils.multiply(2, -1) , "should return -2")
				);
	}

//	@Test
	@RepeatedTest(3)
	@Tag("Circle")
//	void testComputeCircleRadius(RepetitionInfo repetitionInfo) {
	void testComputeCircleRadius() {
	
		boolean isServerUp = false;
		assumeTrue(isServerUp); // When run, assume that is true|false
//		MathUtils mathUtils = new MathUtils();
//		repetitionInfo.getTotalRepetitions();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
	}
	
	@Test
	@Disabled
	void disabledTest() {
		fail("disabled test");
	}

}
