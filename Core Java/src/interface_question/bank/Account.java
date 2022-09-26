package interface_question.bank;

public interface Account {
    public static final String SAVING_ACCOUNT = "Savings";
    public static final String FIXED_ACCOUNT = "Fixed";
    public static final String PERSONAL_LOAN_ACCOUNT = "PersonalLoan";
    public static final String HOUSING_LOAN_ACCOUNT = " HousingLoan";

    public void createAcc(int acctNo);

}
