//java
import java.util.*;
class Create_accnt{
	private String user_name="nafees";
	private String user_pass="naf";
	private int accnt_bal=500;
	private String bank_name="state national bank";
	private String accnt_num="456780";
	public int check_id(String user,String pass){
		if(user_name.equals(user)&&user_pass.equals(pass)){
			return 1;
		}
			return 0;
	}
	public void set_bal(int bal){
		this.accnt_bal=bal;
	}
	public int get_bal(){
		return this.accnt_bal;
	}
	public void display(){
		 System.out.println();
		 System.out.println("USER NAME--->"+" "+user_name);
		 System.out.println("USER PASSWORD--->"+" "+user_pass);
		 System.out.println("ACCOUNT NUMBER--->"+" "+accnt_num);
		System.out.println("TOTAL BALANCE--->"+accnt_bal);
		System.out.println("BANK NAME--->"+bank_name);
	}
	public int withdraw(int amount){
		Create_accnt cr=new Create_accnt();
		if(accnt_bal>=amount){
			int credit=accnt_bal-amount;
			this.set_bal(credit);
			System.out.println("CURRENT BAL IS: "+accnt_bal);
			return amount;
		}else{
			return 0;
		}
	}
	public void password_change(){
		 Scanner sc=new Scanner(System.in);
		System.out.println("	ENTER YOUR OLD PASSWORD:");
                   String oldpass=sc.nextLine();
                       if(oldpass.equals(user_pass)){
                          System.out.println("	ENTER YOUR NEW PASSWORD:");
                               String newpass=sc.nextLine();
                                user_pass=newpass;
                  }else{
                                       System.out.println("Wrong password");
                          }

	}
	public void verify(){
		Scanner sc=new Scanner(System.in);
		Create_accnt cr=new Create_accnt();
		System.out.println("				LOGIN			");
		System.out.println("			please Enter Your UserName");
		String user=sc.nextLine();
		System.out.println("			Please Enter Yout Password");
		String pass=sc.nextLine();
		int ver=cr.check_id(user,pass);
		if(ver!=0){
			System.out.println("  Credentials Accepted ::");
			while(true){
			System.out.println("\n\n	choose the option\n"+"	\n 1.ACCOUNT SUMMARY"+"	\n 2.WITHDRAW AMOUNT"+"	\n 3.CURRENT BALANCE"+"	\n 4.CHANGE PASSWORD"+"	\n 5.LOG OUT");
			int option=sc.nextInt();
				switch(option){
					case 1:
						cr.display();
						break;
					case 2:
						System.out.println("ENTER YOUR AMOUNT");
						int amount=sc.nextInt();
						int available=cr.withdraw(amount);
						if(available!=0){
							System.out.println("YOUR WITHDRAW MONEY:\n"+amount);
						}else{
							System.out.println("ensufficient balance\n");
						}
						break;
					case 3:
						System.out.println("YOUR BALANCE ACCOUNT IS:"+accnt_bal);
						break;
					case 4:
						cr.password_change();
						break;
					case 5:
						System.out.println("		Thanku For Using......");
						System.exit(0);
						break;
				  }
			}

			}else{
				System.out.println("wrong password");
			}
		}
}
class maindemo{
	public static void main(String args[]){
	Create_accnt cr=new Create_accnt();
        cr.verify();
	}
}
