import java.util.Scanner;

public class Account {

    //Class variables
    int balance = 0;
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
                B) Make a Deposit
                C) Make a Withdrawal
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
                    System.out.println("Balance = $" + balance);
                    System.out.println("====================================");
                    System.out.println();
                    break;

                //Case B allows the user to make a deposit
                case "B":
                    System.out.println("Enter the amount you'd like to deposit: ");
                    int amountAdd = scanner.nextInt();
                    deposit(amountAdd);
                    System.out.println("Deposit successful, your current balance is $" + balance);
                    break;

                //Case C allows the user to make a withdrawal
                case "C":
                    System.out.println("Enter the amount you'd like to withdraw: ");
                    int amountSubtract = scanner.nextInt();
                    if (balance - amountSubtract >= 0){
                        withdraw(amountSubtract);
                        System.out.println("Your new balance is: $" + balance);
                    }else {
                        System.out.println("There are insufficient funds in the account");
                    }
                    break;

                //Case M reprints the Menu for the user
                case "M":
                    System.out.println("""
                            Please enter a character to select a transaction:
                            A) Balance Inquiry
                            B) Make a Deposit
                            C) Make a Withdrawal
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

    //Function for depositing funds
    public void deposit(int amount){
        balance += amount;
    }

    //Functions for withdrawing funds
    public void withdraw(int amount){

        balance -= amount;
    }
}
