import java.util.Scanner;

public class Account {

    //Class variables
    double checkingBalance;
    double savingsBalance;
    String customerName;
    String customerID;

    //Constructor for the Class
    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }
    Scanner scanner = new Scanner(System.in);
    void printMenu(){
        System.out.println("Thank you " + customerName + ", for choosing Simple Bank");
        System.out.println("Your ID is " + customerID);
        System.out.println("""
                Please enter a character to select a transaction:
                A) Balance Inquiry
                B) Checking
                C) Savings
                D) Exit
                
                Note: You can bring up this Menu at any time
                by entering M""");


        //The menu options sits inside a while-loop. Exit condition is setting 'quitloop' to 'true'
        boolean quitLoop = false;

        while (!quitLoop) {
            System.out.println();
            String menuOption = scanner.nextLine().toUpperCase();

            switch (menuOption){
                //Case A allows the user to check their balance
                case "A":
                    System.out.println("====================================");
                    System.out.println("Total account balance: $" + checkingBalance + savingsBalance);
                    System.out.println("Checking balance: $" + checkingBalance);
                    System.out.println("Savings balance: $" + savingsBalance);
                    System.out.println("====================================");
                    System.out.println();
                    break;

                //Case B allows the user to access their Checking Account
                case "B":
                    System.out.println("""
                            How would you like to access your Checking Account?
                            G) Deposit
                            H) Withdrawal""");
                    Scanner checkingOption = new Scanner(System.in);
                    if (checkingOption.hasNext("G") || (checkingOption.hasNext("g"))){
                        checkingDeposit();
                    } else if (checkingOption.hasNext("H") || (checkingOption.hasNext("h"))) {
                        checkingWithdrawal();
                    }else {
                        System.out.println("Please enter a valid choice");
                    }
                    break;

                //Case C allows the user to access their Savings Account
                case "C":
                    System.out.println("""
                            How would you like to access your Savings Account?
                            G) Deposit
                            H) Withdrawal""");
                    Scanner savingsOption = new Scanner(System.in);
                    if (savingsOption.hasNext("G") || (savingsOption.hasNext("g"))){
                        savingsDeposit();
                    } else if (savingsOption.hasNext("H") || (savingsOption.hasNext("h"))) {
                        savingsWithdrawal();
                    }else {
                        System.out.println("Please enter a valid choice");
                    }

                    break;

                //Case M reprints the Menu for the user
                case "M":
                    System.out.println("""
                            Please enter a character to select a transaction:
                            A) Balance Inquiry
                            B) Checking
                            C) Savings
                            D) Exit""");
                    break;

                //Case D allows the user to exit the menu, switching the 'quitloop' value to 'true'
                case "D":
                    System.out.println("Thank you " + customerName + " for using Simple Bank");
                    System.out.println("Have a wonderful day!");
                    quitLoop = true;
                    break;
            }
        }
    }

    //Functions for making Deposits in Checking/Savings
    public void checkingDeposit(){
        System.out.println("Please enter the deposit amount for Checking");
        double addChecking = scanner.nextDouble();
        checkingBalance += addChecking;
        System.out.println("You're new Checking Account balance is $" + checkingBalance);
    }

    public void savingsDeposit(){
        System.out.println("Please enter the deposit amount for Savings");
        double addSavings = scanner.nextDouble();
        savingsBalance += addSavings;
        System.out.println("You're new Savings Account balance is $" + savingsBalance);
    }

    //Functions for making Withdrawals from Checking/Savings
    public void checkingWithdrawal(){
        System.out.println("Enter the amount you'd like to withdraw from your Checking Account: ");
        double amountSubtract = scanner.nextDouble();
        if (checkingBalance - amountSubtract >= 0){
            checkingBalance -= amountSubtract;
            System.out.println("Your new Checking balance is: $" + checkingBalance);
        }else {
            System.out.println("There are insufficient funds in the account");
            //if this else statement is reached then it bugs out the loop
        }
    }

    public void savingsWithdrawal(){
        System.out.println("Enter the amount you'd like to withdraw from your Savings Account: ");
        double amountSubtract = scanner.nextDouble();
        if (savingsBalance - amountSubtract >= 0){
            savingsBalance -= amountSubtract;
            System.out.println("Your new Savings balance is: $" + savingsBalance);
        }else {
            System.out.println("There are insufficient funds in the account");
        }
    }
}
