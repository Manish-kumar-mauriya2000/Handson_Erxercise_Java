package interface_question.bankimpl;

import interface_question.bank.AccountDetails;
import interface_question.bank.DebitInterest;
import interface_question.bank.LoanAcc;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalLoanAcc extends AccountDetails implements LoanAcc, DebitInterest {
    static Logger logger= Logger.getLogger(PersonalLoanAcc.class.getName());
    public PersonalLoanAcc() {
    }
    public PersonalLoanAcc(String name, String address, String accountType, int phoneNo, double balance,int accountNo) {
        super(name, address, accountType, phoneNo, (int)balance,accountNo);
    }


    @Override
    public void createAcc(int acctNo) {
        logger.log(Level.INFO, "Personal Loan Account created : {0}",acctNo);
    }

    @Override
    public double deductMonthlyInt(double money) {
        return money-(money*2.2*((double)1/12));

    }

    @Override
    public double deductHalfYrlyInt(double money) {
        return money-(money*2.2*((double)6/12));
    }

    @Override
    public double deductAnnualInt(double money) {
        return money-(money*2.2*(1));
    }

    @Override
    public double calcInt(double dt) {
        return (dt*2.2*1)/100;
    }

    @Override
    public void repayPrincipal() {
        logger.info("Repay principal..");
    }

    @Override
    public void payInterest() {
        logger.info("Pay Interest paid....");
    }

    @Override
    public void payPartialPrincipal() {
        logger.info("Pay partial principal paid....");
    }
}
