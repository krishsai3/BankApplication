import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Account currentAccount;

    public ATM(Bank bank) {
        this.bank = bank;    
    }
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter user PIN: ");
        String userPin = scanner.nextLine();
        if (!authenticate(userId, userPin)) {
            System.out.println("Invalid user ID or PIN.");
            return;
        }

        while (true) {
            System.out.println("Welcome, " + currentAccount.getAccountHolder().getName() + "!");
            System.out.println("Choose an operation:");
            System.out.println("1. Show transactions history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showTransactionsHistory();
                    break;
                case "2":
                    withdraw();
                    break;
                case "3":
                    deposit();
                    break;
                case "4":
                    transfer();
                    break;
                case "5":
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    private boolean authenticate(String userId, String userPin) {
        for (Account account : bank.getAccounts()) {
            if (account.getUserid().equals(userId) && account.getPin().equals(userPin)) {
                currentAccount = account;
                return true;
            }
        }
        return false;
    }

    private void showTransactionsHistory() {
        System.out.println("Transactions history:");
        for (BankTransaction transaction : currentAccount.getTransactionHistory()) {
            System.out.println(transaction.getTransactionDate() + " - " +
                    transaction.getTransactionType() + " - " +
                    transaction.getAmount());
        }
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume the newline character
        if (amount > currentAccount.getBalance()) {
            System.out.println("Insufficient funds.");
            return;
        }
        currentAccount.withdraw(amount);
        System.out.println("Withdrawal successful.");
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume the newline character
        currentAccount.deposit(amount);
        System.out.println("Deposit successful.");
    }

    private void transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter recipient account number: ");
        String recipientAccountNumber = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume the newline character

        Account recipientAccount = null;
        for (Account account : bank.getAccounts()) {
            if (account.getAccountNumber().equals(recipientAccountNumber)) {
                recipientAccount = account;
                break;
            }
        }

        if (recipientAccount == null) {
            System.out.println("Recipient account not found.");
            return;
        }

        if (amount > currentAccount.getBalance()) {
            System.out.println("Insufficient funds.");
            return;
        }

        currentAccount.transfer(recipientAccount, amount);
        System.out.println("Transfer successful."); 
    }
}
