package interface_question;

import interface_question.bankimpl.FDAcc;
import interface_question.bankimpl.HousingLoanAccount;
import interface_question.bankimpl.PersonalLoanAcc;
import interface_question.bankimpl.SavingsAcc;
import interface_question.bank.Account;
import interface_question.bank.AccountDetails;
import interface_question.bank.DepositAcc;
import interface_question.bank.LoanAcc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyAccount {
    static Logger logger = Logger.getLogger(MyAccount.class.getName());
    static Scanner sc;
    static String msgName="Enter your name : ";
    static String msgAddress="Enter your address : ";
    static String msgPhone="Enter your phone no : ";
    static String msgAccontNo="Enter Account No : ";
    static List<AccountDetails> savingDetails=new ArrayList<>();
    static List<AccountDetails> fdDetails=new ArrayList<>();
    static List<AccountDetails> personalLoanDetails=new ArrayList<>();
    static List<AccountDetails> housingLoanDetails=new ArrayList<>();

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        int accountNo = 1;
        while (true) {
            logger.info("\n=======================================\nEnter your option\n1.create Account\n2.Already have account\n3.Exit\n========================================");
            int option = sc.nextInt();
            if (option == 1) {
                logger.log(Level.INFO, "Your account no is created :{0} ", accountNo);
                logger.info("Enter choice\n1.Saving\n2.Fixed Deposit account:\n3.personal Loan\n4.Housing Loan ");
                int choice = sc.nextInt();
                String name;
                String address;
                int phoneNo;
                double balance;
                Account account;
                switch (choice){
                    case 1:
                        logger.info(msgName);
                        name = sc.next();
                        logger.info(msgAddress);
                        address = sc.next();
                        logger.info(msgPhone);
                        phoneNo = sc.nextInt();
                        logger.info("Enter your initial amount to deposit : ");
                        balance = sc.nextInt();
                        savingDetails.add(new SavingsAcc(name, address, "Savings Account", phoneNo, balance, accountNo) {
                        });
                        account = new SavingsAcc();
                        account.createAcc(accountNo);
                        accountNo = accountNo + 1;
                        break;
                    case 2:
                        logger.info(msgName);
                        name = sc.next();
                        logger.info(msgAddress);
                        address = sc.next();
                        logger.info(msgPhone);
                        phoneNo = sc.nextInt();
                        logger.info("Enter your initial amount to deposit : ");
                        balance = sc.nextInt();
                        fdDetails.add(new FDAcc(name, address, "fixed deposit Account", phoneNo, balance, accountNo));
                        account = new FDAcc();
                        account.createAcc(accountNo);
                        accountNo = accountNo + 1;
                        break;
                    case 3:
                        logger.info(msgName);
                        name = sc.next();
                        logger.info(msgAddress);
                        address = sc.next();
                        logger.info(msgPhone);
                        phoneNo = sc.nextInt();
                        logger.info("Enter principal : ");
                        double principal = sc.nextInt();
                        personalLoanDetails.add(new PersonalLoanAcc(name, address, "Personal loan account", phoneNo, principal, accountNo));
                        account = new PersonalLoanAcc();
                        account.createAcc(accountNo);
                        accountNo = accountNo + 1;
                        break;
                    case 4:
                        logger.info(msgName);
                        name = sc.next();
                        logger.info(msgAddress);
                        address = sc.next();
                        logger.info(msgPhone);
                        phoneNo = sc.nextInt();
                        logger.info("Enter principal : ");
                        principal = sc.nextInt();
                        housingLoanDetails.add(new HousingLoanAccount(name, address, "Housing loan account", phoneNo, principal, accountNo));
                        account = new HousingLoanAccount();
                        account.createAcc(accountNo);
                        accountNo = accountNo + 1;
                        break;
                    default:
                        logger.info("Invalid option!!");
                        break;
                }

            } else if (option == 2) {
                logger.info("\n==========================================\nEnter choice.....\n1.savings account\n2.Fixed Deposit account\n3.personal loan account\n4.housing Loan account \n==========================================\n ");
                int choice = sc.nextInt();
                if (choice == 1) {
                    logger.info("\nSelect your option.....\n1.withdraw\n2.deposit\n3.balance\n4.Back to Home");
                    savingOperation();

                } else if (choice == 2) {
                    logger.info("\nSelect your option\n1.withdraw\n2.deposit\n3.balance\n4.Back to home");
                    fdOperation();

                } else if (choice == 3) {
                    logger.info("\nSelect your option\n1.Repay Interest\n2.Repay partial interest\n3.Repay Principal\n4.Back to Home ");
                    personalLoanOperation();
                } else if (choice == 4) {
                    logger.info("\nSelect your option\n1.Repay Interest\n2.Repay partial interest\n3.Repay Principal\n4.Back to home ");
                    housingLoanOperation();

                }
            } else {
                logger.info("Thank you!!! visit again............");
                break;
            }
        }
    }

    //=================housing loan==============================
    public static void housingLoanOperation() {
            int val = sc.nextInt();
            if (val == 1) {
                logger.info(msgAccontNo);
                int accNo = sc.nextInt();
                for (AccountDetails list : housingLoanDetails) {
                    if (accNo == list.getAccountNo()) {
                        LoanAcc account = new HousingLoanAccount();
                        account.payInterest();
                    }
                }
            } else if (val == 2) {
                logger.info(msgAccontNo);
                int accNo = sc.nextInt();
                for (AccountDetails list : housingLoanDetails) {
                    if (accNo == list.getAccountNo()) {
                        LoanAcc account = new HousingLoanAccount();
                        account.payPartialPrincipal();
                    }
                }
            } else if (val == 3) {
                logger.info(msgAccontNo);
                int accNo = sc.nextInt();
                housingLoanRepayPrincipal(accNo);

            } else if (val == 4) {
                logger.info("Home screen!!!!");
            }
    }
    private static void housingLoanRepayPrincipal(int accNo) {
        for (AccountDetails list : housingLoanDetails) {
            if (accNo == list.getAccountNo()) {
                LoanAcc account = new HousingLoanAccount();
                account.repayPrincipal();

            }
        }
    }

    //=================personal loan==============================
    private static void personalLoanOperation() {
        int val = sc.nextInt();
        if (val == 1) {
            logger.info(msgAccontNo);
            int accNo = sc.nextInt();
            for (AccountDetails list : personalLoanDetails) {
                if (accNo == list.getAccountNo()) {
                    LoanAcc account = new PersonalLoanAcc();
                    account.payInterest();
                }
            }
        } else if (val == 2) {
            logger.info(msgAccontNo);
            int accNo = sc.nextInt();
            for (AccountDetails list : personalLoanDetails) {
                if (accNo == list.getAccountNo()) {
                    LoanAcc account = new PersonalLoanAcc();
                    account.payPartialPrincipal();
                }
            }
        } else if (val == 3) {
            logger.info(msgAccontNo);
            int accNo = sc.nextInt();
            personalLoanRepayPrincipal(accNo);

        } else if (val == 4) {
            logger.info("Home screen!!!");
        }
    }

    private static void personalLoanRepayPrincipal(int accNo) {
        for (AccountDetails list : personalLoanDetails) {
            if (accNo == list.getAccountNo()) {
                LoanAcc account = new PersonalLoanAcc();
                account.repayPrincipal();
            }
        }
    }

    //=================Fixed account loan==============================
    private static void fdOperation() {
        int val = sc.nextInt();
        if (val == 1) {
            logger.info(msgAccontNo);
            int accNo = sc.nextInt();
            logger.info("Enter withdraw Amount : ");
            int withdrawAmount = sc.nextInt();
            getFdWithdraw(accNo,withdrawAmount);

        } else if (val == 2) {
            logger.info(msgAccontNo);
            int accNo = sc.nextInt();
            logger.info("Enter deposit Amount : ");
            int depositAmount = sc.nextInt();
            setFdDeposit(accNo, depositAmount);

        } else if (val == 3) {
            logger.info(msgAccontNo);
            int accNo = sc.nextInt();
            getFdBalance(accNo);

        } else if (val == 4) {
            logger.info("Home screen!!!");
        }
    }
    private static void setFdDeposit(int  accNo,int depositAmount) {
        for (AccountDetails list : fdDetails) {
            if (accNo == list.getAccountNo()) {
                DepositAcc account = new FDAcc();
                list.setBalance(account.deposit(list.getBalance(), depositAmount));
            }
        }
    }

    private static void getFdBalance(int  accNo){
        for (AccountDetails list : fdDetails) {
            if (accNo == list.getAccountNo()) {
                DepositAcc account = new FDAcc();
                account.getBalance(list.getBalance());
            }
        }
    }

    private static void getFdWithdraw(int  accNo,int withdrawAmount){
        for (AccountDetails list : fdDetails) {
            if (accNo == list.getAccountNo()) {
                DepositAcc account = new FDAcc();
                list.setBalance(account.withdraw(list.getBalance(), withdrawAmount));

            }
        }
    }

    //=================saving account==============================
    private static void savingOperation() {
        int val = sc.nextInt();
        if (val == 1) {
            logger.info(msgAccontNo);
            int acctno = sc.nextInt();
            logger.info("Enter withdraw Amount : ");
            int withdrawAmount = sc.nextInt();
            for (AccountDetails list : savingDetails) {
                if (acctno == list.getAccountNo()) {
                    DepositAcc account = new SavingsAcc();
                    list.setBalance(account.withdraw(list.getBalance(), withdrawAmount));
                }
            }

        } else if (val == 2) {
            logger.info(msgAccontNo);
            int accNo = sc.nextInt();
            logger.info("Enter deposit Amount : ");
            int depositAmount = sc.nextInt();
            savingDeposit(accNo, depositAmount);

        } else if (val == 3) {
            logger.info(msgAccontNo);
            int accNo = sc.nextInt();
            for (AccountDetails list : savingDetails) {
                if (accNo == list.getAccountNo()) {
                    DepositAcc account = new SavingsAcc();
                    account.getBalance(list.getBalance());
                }
            }
        } else if (val == 4) {
            logger.info("Home screen!!!!");
        }
    }
    private static void savingDeposit(int  accNo,int depositAmount){
        for (AccountDetails list : savingDetails) {
            if (accNo == list.getAccountNo()) {
                DepositAcc account = new SavingsAcc();
                list.setBalance(account.deposit(list.getBalance(), depositAmount));
            }
        }
    }


}
