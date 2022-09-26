package interface_question.bank;

public interface DepositAcc extends Account {
    public double withdraw(double balance, int withdrawAmt);

    public double deposit(double balance, int depositAmt);

    public double getBalance(double balance);
}
