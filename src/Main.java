import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to open SBI account/Enter 2 to open HDFC account");
        int choice = sc.nextInt();
        System.out.println("Enter your name ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter your balance ");
        double balance = sc.nextInt();
        System.out.println("Enter your password ");
        sc.nextLine();
        String password = sc.nextLine();
        if (choice == 1) {
            System.out.println("Welcome to SBI Bank");
            SBI_Users s1 = new SBI_Users(name, balance, password);
            System.out.println("Account No. of your new account is " + s1.getAccountNo());
            s1.setBalance(balance);
            while(true) {
                System.out.println("1.Deposit amount 2.Withdraw amount 3.Check Interest for 10 years 4.If you want to exit");
                int select = sc.nextInt();
                if (select == 1) {
                    //Add amount
                    System.out.println("Enter deposit amount ");
                    System.out.println(s1.addMoney(sc.nextInt()));
                } else if (select == 2) {
                    //Withdraw money
                    System.out.println("Enter withdraw amount ");
                    int amount = sc.nextInt();
                    System.out.println("Enter Password");
                    sc.nextLine();
                    String Enterpassword = sc.nextLine();
                    System.out.println(s1.withdrawMoney(amount, Enterpassword));
                } else if (select == 3) {
                    //Interest
                    System.out.println("Interest for 10 years on "+s1.getBalance()+" is "+ s1.calculateInterest(10));
                } else if (select == 4) {
                    break;
                }
                else{
                    System.out.println("Wrong selection");
                }
            }
        }
        else if (choice == 2) {
            System.out.println("Welcome to HDFC Bank");
            HDFC_Users s1 = new HDFC_Users(name, balance, password);
            System.out.println("Account No. of your new account is " + s1.getAccountNo());
            s1.setBalance(balance);
            while(true) {
                System.out.println("1.Deposit amount 2.Withdraw amount 3.Check Interest for 10 years 4.If you want to exit");
                int select = sc.nextInt();
                if (select == 1) {
                    //Add amount
                    System.out.println("Enter deposit amount ");
                    System.out.println(s1.addMoney(sc.nextInt()));
                } else if (select == 2) {
                    //Withdraw money
                    System.out.println("Enter withdraw amount ");
                    int amount = sc.nextInt();
                    System.out.println("Enter Password");
                    sc.nextLine();
                    String Enterpassword = sc.nextLine();
                    System.out.println(s1.withdrawMoney(amount, Enterpassword));
                } else if (select == 3) {
                    //Interest
                    System.out.println("Interest for 10 years on "+s1.getBalance()+" is "+ s1.calculateInterest(10));
                } else if (select == 4) {
                    break;
                }
                else{
                    System.out.println("Please check selection list");
                }
            }
        }
        else{
            System.out.println("You entered wrong choice");
        }
        System.out.println("Thank you!");
    }
}