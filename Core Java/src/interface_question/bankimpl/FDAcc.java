package interface_question.bankimpl;

import interface_question.bank.AccountDetails;
import interface_question.bank.CreditInterest;
import interface_question.bank.DepositAcc;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FDAcc extends AccountDetails implements DepositAcc, CreditInterest {
    static Logger logger= Logger.getLogger(FDAcc.class.getName());

    public FDAcc(String name, String address, String accountType, int phoneNo, double balance,int accountNo) {
        super(name,address, accountType, phoneNo, (int)balance,accountNo);
    }

    public FDAcc() {
    }

    @Override
    public void createAcc(int acctNo) {
        logger.log(Level.INFO,"Fixed Account created : {0}",acctNo);
    }

    @Override
    public double withdraw(double balance, int withdrawAmt) {
        if(balance<withdrawAmt){
            logger.info("Insufficient balance!!!");

        }
        else {
            logger.info("Withdraw successful...");
            logger.log(Level.INFO,"After withdraw your balance is : {0}", (balance - withdrawAmt));
        }

        return balance;
    }

    @Override
    public double deposit(double balance, int depositAmt) {
        if(depositAmt==0){
            logger.info("Amount 0 is not allowed to deposit!!!!");
        }
        else{
            balance=balance+depositAmt;
            logger.log(Level.INFO,"After deposit total balance : {0}",balance);
        }
        return balance;
    }

    @Override
    public double getBalance(double balance) {
        logger.log(Level.INFO,"Balance : {0}",balance);
        return balance;
    }

    @Override
    public double addMonthlyInt(double money) {
        return money+((money*7.5*((double)1/12))/100);
    }

    @Override
    public double addHalfYrlyInt(double money) {
        return money+((money*7.5*((double)6/12))/100);
    }

    @Override
    public double addAnnualInt(double money) {
        return money+((money*7.5*((double)1/12))/100);
    }

    @Override
    public double calcInt(double dt) {
        logger.log(Level.INFO,"{0}",(dt*7.5*1)/100);
        return dt;
    }
}
