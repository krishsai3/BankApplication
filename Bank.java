import java.util.*;

public class TestApp {
	public static void main(String[] args) {
		
		Bank bank = new Bank("HDFC");
		ATM atm = new ATM(bank);
		
		// adding accounts to bank
		AccountHolder ah1 = new AccountHolder("sai","hyderabad","9090909090","sai@gmail.com");
		Account ac1 = new Account("HDFC001",ah1,10000,"hdfcSai","1100");
		
		AccountHolder ah2 = new AccountHolder("vam","bangalore","9090909091","vam@gmail.com");
		Account ac2 = new Account("HDFC002",ah2,20000,"hdfcVam","1101");
		
		AccountHolder ah3 = new AccountHolder("varma","kolkata","9090909092","varma@gmail.com");
		Account ac3 = new Account("HDFC003",ah3,30000,"hdfcVarma","1102");
		
		AccountHolder ah4 = new AccountHolder("charan","chennai","9090909093","charan@gmail.com");
		Account ac4 = new Account("HDFC004",ah4,40000,"hdfcCharan","1103");
		
		List<Account> acList = new ArrayList<Account>();
		acList.add(ac1);
		acList.add(ac2);
		acList.add(ac3);
		acList.add(ac4);
		
		bank.setAccounts(acList);
		
		atm.run();
	}
}
