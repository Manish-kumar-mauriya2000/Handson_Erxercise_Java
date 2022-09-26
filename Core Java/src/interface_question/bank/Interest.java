package interface_question.bank;

public interface Interest {
    double SAVING_INTREST=5.6;
    double FIXED_INTREST=  3.5;
    double PERSONAL_LOAN_INTREST = 2.8;
    double HOUSING_LOAN_INTREST = 4.5;

    public double calcInt(double dt);

}
