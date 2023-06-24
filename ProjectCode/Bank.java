import java.util.*;


public class Bank {
 private String bankName;
 private List<Account> accounts;

 public Bank(String bankName) {
     this.bankName = bankName;
     this.accounts = new ArrayList<>();
 }

 public String getBankName() {
     return bankName;
 }

 public void setBankName(String bankName) {
     this.bankName = bankName;
 }

 public List<Account> getAccounts() {
     return accounts;
 }

 public void setAccounts(List<Account> accounts) {
     this.accounts = accounts;
 }

 public void addAccount(Account account) {
     this.accounts.add(account);
 }
}
