import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Withdrawal failed. Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class BankAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter account information
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.next();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        // Create a new bank account
        BankAccount account = new BankAccount(accountNumber, accountHolderName, balance);

        // Display menu options and prompt the user to select an option
        int option;
        do {
            System.out.println("Select an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("0. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }
    /*
    This solution defines a BankAccount class with the required properties and methods, 
    and a BankAccountTest class that uses a Scanner object to prompt the user for input and display a menu of options. 
    The program creates a BankAccount object based on the user's input, and then allows the user to perform deposit, 
    withdrawal, and balance checking operations on the account by selecting options from the menu. 
    The program handles invalid input by displaying an error message and prompting the user to enter a valid input.
    */
}
