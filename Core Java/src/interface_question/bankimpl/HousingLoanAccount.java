package interface_question.bankimpl;


import interface_question.bank.AccountDetails;
import interface_question.bank.DebitInterest;
import interface_question.bank.LoanAcc;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HousingLoanAccount extends AccountDetails implements LoanAcc, DebitInterest {
    static Logger logger= Logger.getLogger(HousingLoanAccount.class.getName());
    public HousingLoanAccount(String name, String accountType, String address, int phoneNo,double money, int accountNo ) {
        super(name, accountType, address, phoneNo, (int) money,accountNo);
    }

    public HousingLoanAccount() {
    }

    @Override
    public void createAcc(int acctNo) {
        logger.log(Level.INFO, "Housing Loan Account created : {0}",acctNo);
    }

    @Override
    public double deductMonthlyInt(double money) {
        return money-(money*4.0*((double)1/12));
    }

    @Override
    public double deductHalfYrlyInt(double money) {
        return money-(money*4.0*((double)6/12));
    }

    @Override
    public double deductAnnualInt(double money) {
        return money-(money*4.0*(1));
    }

    @Override
    public double calcInt(double dt) {
        return (dt*4.0*1)/100;
    }

    @Override
    public void repayPrincipal() {
        logger.info("Housing Repay principal..");
    }

    @Override
    public void payInterest() {
        logger.info("Housing Pay Interest paid....");
    }

    @Override
    public void payPartialPrincipal() {
        logger.info(" Housing Pay partial principal paid....");
    }
}
