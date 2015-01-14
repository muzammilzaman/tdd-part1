package MoneyPackage;

public class Franc extends Money {
	
		
		
		Franc(int amount, String currency) {
			super(amount, currency);
		}
		
		
		public Money times(int multiplier) {
			return new Money(amount * multiplier, currency);
			}
		String currency() {
			return "CHF";
			}
		
}
