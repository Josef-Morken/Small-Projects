import java.util.Scanner;

public class AccountV2_1 {

    //Class variables
    double checkingBalance;
    double savingsBalance;
    String customerName;
    String customerID;

    //Constructor for the Class
    public AccountV2_1(String customerName, String customerID) {
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
                D) Savings Interest Calculator
                E) Exit
                
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
                    System.out.println("Total account balance: $" + (checkingBalance + savingsBalance)); //without the balances in () there's weird math with the doubles. would read 0.00.0 instead of 0.0
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
                    //An alternative choice here is force all user input to all caps or lower with toUpper/toLower
                    if (checkingOption.hasNext("G") || (checkingOption.hasNext("g"))){
                        checkingDeposit();
                    } else if (checkingOption.hasNext("H") || (checkingOption.hasNext("h"))) {
                        checkingWithdrawal();
                    }else {
                        System.out.println("Not a recognized option, returning to the Main Menu");
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
                        System.out.println("Not a recognized option, returning to the Main Menu");
                    }
                    break;

                //Case M reprints the Menu for the user
                case "M":
                    System.out.println("""
                            Please enter a character to select a transaction:
                            A) Balance Inquiry
                            B) Checking
                            C) Savings
                            D) Savings Interest Calculator
                            E) Exit""");
                    break;

                //Case D Asks the user for time in Years to calculate interest for the balance currently in their Savings
                case "D":
                    System.out.println("How many years would you like to calculate interest for?");
                    int years = scanner.nextInt();
                    interestCalculator(years);
                    break;

                //Case D allows the user to exit the menu, switching the 'quitloop' value to 'true'
                case "E":
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
        while (scanner.hasNextLine()){
            double amountSubtract = scanner.nextDouble();
            if (checkingBalance - amountSubtract >= 0){
                checkingBalance -= amountSubtract;
                System.out.println("Your new Checking balance is: $" + checkingBalance);
            }if (checkingBalance - amountSubtract < 0){
                System.out.println("There are insufficient funds in the account. Please enter a different amount.");
            }
        }
    }

    public void savingsWithdrawal(){
        System.out.println("Enter the amount you'd like to withdraw from your Savings Account: ");
        double amountSubtract = scanner.nextDouble();
        if (savingsBalance - amountSubtract >= 0){
            savingsBalance -= amountSubtract;
            System.out.println("Your new Savings balance is: $" + savingsBalance);
        }if (savingsBalance - amountSubtract < 0){
            System.out.println("There are insufficient funds in the account. Please enter a different amount.");
        }
    }

    //Function to check interest generated over Years provided by user. Interest rates based on account balance
    public void interestCalculator(int years){
        double interestRateOne = .00;
        double interestRateTwo = .0095;
        double interestRateThree = .0105;
        double interestRateFour = .0109;
        double interestRateFive = .0149;
        //This tier/rate system is based on the NFCU system in use as of 3/21/2023

        //Simple interest formula: P * R * T
        //P = principal amount
        //R = interest rate per year expressed as a decimal
        //T = number of time periods in years

        //Interest rates to display to the user are multiplied by 100 to show easily understandable numbers
        if ((savingsBalance > 0) && (savingsBalance < 2499)){
            System.out.println("The current interest rates for your savings account are " + (interestRateOne * 100)+ "%");
            System.out.println("In " + years + " years your Savings Account balance will be $" + ((interestRateOne * savingsBalance * years) + savingsBalance));
        } else if((savingsBalance >= 2500 ) && (savingsBalance < 9999)){
            System.out.println("The current interest rates for your savings account are " + (interestRateTwo * 100)+ "%");
            System.out.println("In " + years + " years your Savings Account balance will be $" + ((interestRateTwo * savingsBalance * years) + savingsBalance));
        }else if((savingsBalance >= 10000 ) && (savingsBalance < 24999)){
            System.out.println("The current interest rates for your savings account are " + (interestRateThree * 100)+ "%");
            System.out.println("In " + years + " years your Savings Account balance will be $" + ((interestRateThree * savingsBalance * years) + savingsBalance));
        }else if((savingsBalance >= 25000 ) && (savingsBalance < 49999)){
            System.out.println("The current interest rates for your savings account are " + (interestRateFour * 100)+ "%");
            System.out.println("In " + years + " years your Savings Account balance will be $" + ((interestRateFour * savingsBalance * years) + savingsBalance));
        }else if(savingsBalance >= 50000){
            System.out.println("The current interest rates for your savings account are " + (interestRateFive * 100)+ "%");
            System.out.println("In " + years + " years your Savings Account balance will be $" + ((interestRateFive * savingsBalance * years) + savingsBalance));
        }
    }
}
