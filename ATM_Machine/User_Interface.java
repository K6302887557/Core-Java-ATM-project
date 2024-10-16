package ATM_Machine;

import java.util.Scanner;

public class User_Interface {
 private static int  status;
	public static void main(String[] args) {
		User_Interface user=new User_Interface();
		Atm_Operations oper =new Atm_Operations();
		Scanner sc = new Scanner(System.in);
		 int atm_number=123456;
		 int atm_pin=1234;
		System.out.println("WELCOME TO ATM MACHINE");
		System.out.print("ENTER THE ATM NUMBER:");
		int atm_number2=sc.nextInt();
		System.out.print("ENTER THE ATM PIN:");
		int atm_pin2=sc.nextInt();
		if(atm_number==atm_number2 && atm_pin==atm_pin2) {
			while(true) {
			System.out.println(" 1.VIEW AVAILABLE BALANCE \n 2.WITHDRAW AMOUNT\n 3.DEPOSIT AMOUNT \n 4.VIEW MINISTATEMENT \n 5.EXIT");
			System.out.println("enter the choice:");
			int ch=sc.nextInt();
			if(ch==1) {
				oper.view_Balance();
			}else if(ch==2){
				System.out.println("enter the withdraw amount:");
				double withdraw_Amount=sc.nextInt();
				oper.withdraw_Amount(withdraw_Amount);
			}else if(ch==3) {
				System.out.println("enter the amount for deposite:");
				double deposite_Amount=sc.nextInt();
				oper.deposite_Amount(deposite_Amount);
			}else if(ch==4) {
				oper.view_Ministatement();
			}else if(ch==5) {
				System.out.println("successfully change your pin");
				System.out.println("Collect your ATM card \n THANK YOU FOR VISIT");
				System.exit(status);
			}
			}
		}else {
			System.out.println("ENTERED ATM PIN OR NUMBER IS INVALID");
		}
		

	}

}
