import java.util.Objects;
import java.util.UUID;

public class SBI_Users implements Bank_Interface{
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        SBI_Users.rateOfInterest = rateOfInterest;
    }

    public SBI_Users(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.rateOfInterest = 6.5;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    @Override
    public double checkBalance() {
        return this.balance;
    }

    @Override
    public String addMoney(int amount) {
        balance += amount;
        return "Amount is added your Updated balance is "+balance;
    }

    @Override
    public String withdrawMoney(int enteredAmount, String enteredPassword) {
        if(Objects.equals(password, enteredPassword)){
            if(enteredAmount<balance){
                balance -= enteredAmount;
                return "Withdrawn succesfully, Your updated amount is "+balance;
            }
            else{
                return "Insufficient amount in your account";
            }
        }
        else {
            return "Wrong Password";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*rateOfInterest*years)/100;
    }
}
