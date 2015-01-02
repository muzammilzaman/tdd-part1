package MoneyPackage;

public  class Money implements Expression{
	protected int amount;
	protected String currency;
	 
	Money times(int multiplier){
		return new Money(amount * multiplier, currency);
	}
	//abstract String currency();
	public Money reduce(String to) {
		return this;
		}
	static Money dollar(int amount) {
		return new Dollar(amount, "USD");
		}
	static Money franc(int amount) {
		return new Franc(amount, "CHF");
		}
	Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
		}
	/*Money plus(Money addend) {
		return new Money(amount + addend.amount, currency);
		}*/
	
	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount
		&& currency().equals(money.currency());
		}
	Expression plus(Money addend) {
		return new Sum(this, addend);
		}
	String currency() {
		return currency;
	}
}
