package ATM_Machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Atm_Operations implements Atm_Interface {

	Atm atm = new Atm();
	Map<Double,String> ministmt=new HashMap<>();
	public void view_Balance() {
		System.out.println("Available Balance:"+atm.getBalance());

	}

	public void withdraw_Amount(double withdraw_Amount) {
		if(withdraw_Amount%500==0) {
			if(withdraw_Amount<=atm.getBalance()) {
				System.out.println("collect the cash"+withdraw_Amount);
				atm.setBalance(atm.getBalance()-withdraw_Amount);
				ministmt.put(withdraw_Amount, "Amount withdrawn");
				view_Balance();
			}
			else {
				System.out.println("insufficient Balance");
			}
		}
		else {
			System.out.println("enter the amount in term of 500");
		}
	}

	@Override
	public void deposite_Amount(double deposite_Amount) {
		System.out.println("deposited Amount is:"+deposite_Amount);
		atm.setBalance(atm.getBalance()+deposite_Amount);
		ministmt.put(deposite_Amount,"Deposited Successfully");
		view_Balance();
	}

	@Override
	public void view_Ministatement() {
		Set<Double> set=ministmt.keySet();
		for(Double d:set) {
			System.out.println(d+"="+ministmt.get(d));
		}

	}

}
