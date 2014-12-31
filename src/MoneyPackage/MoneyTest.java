package MoneyPackage;

import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyTest {
	@Test
	public void testMultiplication() {
		Dollar five= new Dollar(5);
		five.times(2);
		assertEquals(10, five.amount);
	}

}
