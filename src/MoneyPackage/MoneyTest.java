package MoneyPackage;

import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyTest {
	@Test
	public void testMixedAddition() {
		Expression fiveBucks= Money.dollar(5);
		Expression tenFrancs= Money.franc(10);
		Bank bank= new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result= bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.dollar(10), result);
		}
	
	public void testIdentityRate() {
		assertEquals(1, new Bank().rate("USD", "USD"));
		}
	public void testArrayEquals() {
		assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
		}
	public void testReduceMoneyDifferentCurrency() {
		Bank bank= new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result= bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
		}
	
	public void testReduceSum() {
		Bank bank= new Bank();
		Money result= bank.reduce(Money.dollar(1), "USD");
		assertEquals(Money.dollar(1), result);
		}
	
	public void testPlusReturnsSum() {
		Money five= Money.dollar(5);
		Expression result= five.plus(five);
		Sum sum= (Sum) result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
		
	}
	public void testSimpleAddition() {
		Money sum= Money.dollar(5).plus(Money.dollar(5));
		assertEquals(Money.dollar(10), sum);
		}
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
		}
	
	public void testDifferentClassEquality() {
		assertTrue(new Franc(10, "CHF").equals(new Franc(10, "CHF")));
		}
	public void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
		} 
	
	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
		}
	
	

}
