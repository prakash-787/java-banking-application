import java.io.*;
import java.util.*;

public class BankingApplication {
    private static HashMap<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "accounts.txt";

    public static void main(String[] args) {
        loadAccountsFromFile();

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    saveAccountsToFile();
                    System.out.println("Thank you for using our banking system!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();
        if (accounts.containsKey(accNumber)) {
            System.out.println("Account already exists!");
            return;
        }
        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.nextLine();
        System.out.print("Enter Initial Deposit Amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        accounts.put(accNumber, new Account(accNumber, holderName, initialDeposit));
        System.out.println("Account created successfully!");
    }

    private static void performDeposit() {
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();
        Account account = accounts.get(accNumber);
        if (account != null) {
            System.out.print("Enter Deposit Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void performWithdrawal() {
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();
        Account account = accounts.get(accNumber);
        if (account != null) {
            System.out.print("Enter Withdrawal Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            account.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();
        Account account = accounts.get(accNumber);
        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void loadAccountsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    String accNumber = parts[0];
                    String holder = parts[1];
                    double balance = Double.parseDouble(parts[2]);
                    accounts.put(accNumber, new Account(accNumber, holder, balance));
                }
            }
            System.out.println("Accounts loaded from file.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing account file found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error reading account file: " + e.getMessage());
        }
    }

    private static void saveAccountsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account account : accounts.values()) {
                writer.write(account.toString());
                writer.newLine();
            }
            System.out.println("Accounts saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to account file: " + e.getMessage());
        }
    }
}
