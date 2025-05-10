# Java Banking Application

This is a simple **Banking System** application written in Java that allows you to create accounts, deposit money, withdraw money, and check account balances. The application supports persistent data storage by reading from and writing to a file (`accounts.txt`).

---

## Features:
- **Create Account**: Users can create an account by specifying an account number, holder name, and an initial deposit.
- **Deposit**: Users can deposit money into their account.
- **Withdraw**: Users can withdraw money from their account.
- **Check Balance**: Users can check the balance of their account.

--- 

The application loads account data from a file on startup and saves data after any changes are made (such as creating an account, making a deposit, or a withdrawal).

## How to Use:
- **Create an Account**: Choose option 1 and enter the account details (account number, holder name, initial deposit).
- **Deposit**: Choose option 2 and enter the account number and deposit amount.
- **Withdraw**: Choose option 3 and enter the account number and withdrawal amount.
- **Check Balance**: Choose option 4 to check the current balance of an account.
- **Exit**: Choose option 5 to exit the application.
 
----

## BankingSystem:
-  **Account.java**: Contains the Account class (for account details, deposit/withdraw methods)
-  **BankingApplication.java**: Main application logic (handles user input and operations)
-  **accounts.txt**: File to store account data (persisted between application runs)
-  **README.md**: Project description and instructions

