package interface_question.bank;

public interface CreditInterest extends Interest {
    public double addMonthlyInt(double money);

    public double addHalfYrlyInt(double money);

    public double addAnnualInt(double money);
}
