import java.util.*;

public class Account {
 private String accountNumber;
 private AccountHolder accountHolder;
 private double balance;
 
 // atm detials
 private String userid;
 private String pin;
 
 private ArrayList<BankTransaction> transactionHistory;
 
 public Account(String accountNumber, AccountHolder accountHolder, double balance,
		 String userid,String pin) {
     this.accountNumber = accountNumber;
     this.accountHolder = accountHolder;
     this.balance = balance;
     this.userid = userid;
     this.pin = pin;
     this.transactionHistory = new ArrayList<>();
 }
 
 public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getPin() {
	return pin;
}

public void setPin(String pin) {
	this.pin = pin;
}

 public String getAccountNumber() {
     return accountNumber;
 }

 public void setAccountNumber(String accountNumber) {
     this.accountNumber = accountNumber;
 }

 public AccountHolder getAccountHolder() {
     return accountHolder;
 }

 public void setAccountHolder(AccountHolder accountHolder) {
     this.accountHolder = accountHolder;
 }

 public double getBalance() {
     return balance;
 }

 public void setBalance(double balance) {
     this.balance = balance;
 }

public ArrayList<BankTransaction> getTransactionHistory() {
	return transactionHistory;
}

public void setTransactionHistory(ArrayList<BankTransaction> transactionHistory) {
	this.transactionHistory = transactionHistory;
}


public void deposit(double amount)
{
	BankTransaction transaction = new BankTransaction("deposit", amount);
	balance+=amount;
	transactionHistory.add(transaction);
}

public void withdraw(double amount)
{
	BankTransaction transaction = new BankTransaction("withdraw", amount);
	balance-=amount;
	transactionHistory.add(transaction);
}

public void transfer(Account recipientAccount, double amount)
{
	BankTransaction transaction = new BankTransaction("transfer",amount);
	balance-=amount;
	transactionHistory.add(transaction);
}


}
