package MoneyPackage;

public  class Money implements Expression{
	protected int amount;
	protected String currency;
	 
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
		}
	
	//abstract String currency();
	Expression times(int multiplier) {
		return new Money(amount * multiplier, currency);
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
	
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
		}

	
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
