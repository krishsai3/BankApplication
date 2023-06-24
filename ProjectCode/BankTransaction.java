import java.time.LocalDateTime;


public class BankTransaction {
	
 private LocalDateTime transactionDate;
 private String transactionType;
 private double amount;


 public BankTransaction(String transactionType,
                        double amount) {

     this.transactionDate = LocalDateTime.now();
     this.transactionType = transactionType;
     this.amount = amount;
     
 }

 public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	
 public String getTransactionType() {
     return transactionType;
 }

 public void setTransactionType(String transactionType) {
     this.transactionType = transactionType;
 }

 public double getAmount() {
     return amount;
 }

 public void setAmount(double amount) {
     this.amount = amount;
 }


}
