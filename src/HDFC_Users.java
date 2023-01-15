import java.util.Objects;
import java.util.UUID;

public class HDFC_Users implements Bank_Interface{
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public HDFC_Users(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.rateOfInterest = 7.5;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

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
        HDFC_Users.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return getBalance();
    }

    @Override
    public String addMoney(int enteredAmount) {
        setBalance(balance+enteredAmount);
        return "Money credited, Your new balance is "+getBalance();
    }

    @Override
    public String withdrawMoney(int enteredAmount, String enteredPassword) {
        if(Objects.equals(password, enteredPassword)){
            if(enteredAmount<balance){
                setBalance(balance-enteredAmount);
                return "Money debited, Your new balance is "+getBalance();
            }
            else{
                return "Insufficient balance";
            }
        }
        else{
            return "Wrong password";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*rateOfInterest*years)/100;
    }
}
