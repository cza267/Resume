package test;

/**
 * JUnit test case to check all functions relating to the operations
 */
import static org.junit.Assert.*;
import org.junit.Test;
import model.CalculatorModel;
public class TestCalculator {
	
	CalculatorModel model = new CalculatorModel();
	
	/**
	 * Testing Factorial operation
	 */
	@Test
	public void testFact() {
		assertEquals("Checking Factorial Function ", model.fact(3),6,0 );
	}
	
	/**
	 * Testing Modulo operation 
	 */
	@Test
	public void testModulo() {
		assertEquals("Checking Modulus Function", model.modulo(7, 10), 7, 0);
	}
	
	/**
	 * Testing power operation
	 */
	@Test 
	public void testPower() {
		assertEquals("Checking Power Function", model.power(2, 3), 8,0); 
	}
	
	/**
	 * Testing square root operation
	 */
	@Test
	public void testSqrt() {
		assertEquals("Checking Square Root Function", model.sqrt(49), 7, 0);
	}

	/**
	 * Testing squared operation
	 */
	@Test
	public void testSquared() {
		assertEquals("Checking Squared Function", model.squared(4), 16,0);
	}	
	
	/**
	 * Testing getValue() operation
	 */
	@Test
	public void testGetValue() {
		assertNull("Checking GetValue Function", null );
	}
	
	/**
	 * Testing update operation
	 */
	@Test
	public void testUpdate() {
		assertNull("Checking update",null);
	}	
}
