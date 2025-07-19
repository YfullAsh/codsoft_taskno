import java.util.Scanner;

// Class representing the Bank Account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

// Class representing the ATM interface
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n===== Welcome to the ATM =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }

        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f%n", account.getBalance());
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ₹");
        double amount = getValidDouble();
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (account.withdraw(amount)) {
            System.out.printf("Please collect your cash. ₹%.2f withdrawn successfully.%n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ₹");
        double amount = getValidDouble();
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            account.deposit(amount);
            System.out.printf("₹%.2f deposited successfully.%n", amount);
        }
    }

    private double getValidDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid amount: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}

// Main class to run the program
public class Task3 {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00); // Initial balance ₹1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

