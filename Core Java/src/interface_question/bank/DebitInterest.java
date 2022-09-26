package interface_question.bank;

public interface DebitInterest extends Interest {
    public double deductMonthlyInt(double money);

    public double deductHalfYrlyInt(double money);

    public double deductAnnualInt(double money);
}
