package ATM_Machine;

public class Atm {
	private double balance;
	private double deposite_Amount;
	private double withdraw_Amount;
	public Atm() {
		super();
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getDeposite_Amount() {
		return deposite_Amount;
	}
	public void setDeposite_Amount(double deposite_Amount) {
		this.deposite_Amount = deposite_Amount;
	}
	public double getWithdraw_Amount() {
		return withdraw_Amount;
	}
	public void setWithdraw_Amount(double withdraw_Amount) {
		this.withdraw_Amount = withdraw_Amount;
	}
	@Override
	public String toString() {
		return "Atm [balance=" + balance + ", deposite_Amount=" + deposite_Amount + ", withdraw_Amount="
				+ withdraw_Amount + "]";
	}
	
	

	
}
