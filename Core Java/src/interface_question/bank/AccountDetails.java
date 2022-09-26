package interface_question.bank;

public class AccountDetails {
    private String name;
    private String accountType;
    private String address;
    private int phoneNo;
    private int accountNo;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountDetails(String name, String accountType, String address, int phoneNo,  double balance,int accountNo) {
        this.name = name;
        this.accountType = accountType;
        this.address = address;
        this.phoneNo = phoneNo;
        this.balance = balance;
        this.accountNo = accountNo;

    }

    public AccountDetails() {
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo=" + phoneNo +
                ", accountNo=" + accountNo +
                ", balance=" + balance +
                '}';
    }
}
