package inheritance;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Currency{
    public static final Logger loggerCurrency=Logger.getLogger(Currency.class.getName());
    private final int currencyOneCount;
    private final int currencyTwoCount;

    public int getCurrencyOneCount() {
        return currencyOneCount;
    }

    public int getCurrencyTwoCount() {
        return currencyTwoCount;
    }

    public Currency(int currencyOneCount, int currencyTwoCount) {
        this.currencyOneCount = currencyOneCount;
        this.currencyTwoCount = currencyTwoCount;
    }
    public double compute() {
       return Double.parseDouble(null);
    }
    public void print() {
        loggerCurrency.info("Currency");
    }
}

class Dollar extends Currency{

    public Dollar(int oneDollarCount, int oneCentCount) {
        super( oneDollarCount,oneCentCount);
    }

    @Override
    public double compute() {
        return (getCurrencyOneCount()*50+ getCurrencyTwoCount()*0.5);
    }

    @Override
    public void print(){
        loggerCurrency.log(Level.INFO," Rupees as dollar ₹: {0}",compute());
    }
}
class Pound extends Currency{

    public Pound(int onePoundCount, int onePenceCount) {
        super(onePoundCount, onePenceCount);
    }

    @Override
    public double compute() {
        return (getCurrencyOneCount()*81.15+ getCurrencyTwoCount()*0.8115);
    }

    @Override
    public void print(){
        loggerCurrency.log(Level.INFO,"Total Ruppee as pound ₹: {0}",compute());
    }

}
class Rupees extends Currency{

    public Rupees(int oneRuppeeCount, int onePaiseCount) {
        super(oneRuppeeCount, onePaiseCount);
    }

    @Override
    public double compute() {
        return (getCurrencyOneCount()+ getCurrencyTwoCount()*0.01);
    }

    @Override
    public void print(){
        loggerCurrency.log(Level.INFO,"Total Rupees as rupees ₹:{0}",compute());
    }
}

public class CollectionBox {
    static Logger logger = Logger.getLogger(CollectionBox.class.getName());
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        logger.info("Enter no of one Dollar coin:");
        int oneDollar=scan.nextInt();
        logger.info("Enter no of five Dollar coin:");
        int fiveDollar=scan.nextInt();
        logger.info("Enter no of fifty Dollar note:");
        int fiftyDollar=scan.nextInt();
        logger.info("Enter no of hundred Dollar note:");
        int hundredDollar=scan.nextInt();
        logger.info("Enter no of one Cent coin:");
        int oneCent=scan.nextInt();
        logger.info("Enter no of ten Dollar coin:");
        int tenCent=scan.nextInt();
        logger.info("Enter no of  twenty five coin:");
        int twentyFiveCent=scan.nextInt();
        logger.info("Enter no of one Pound coin:");
        int onePound=scan.nextInt();
        logger.info("Enter no of two Pound coin:");
        int twoPound=scan.nextInt();
        logger.info("Enter no of five Pound coin:");
        int fivePound=scan.nextInt();
        logger.info("Enter no of fifty Pound coin:");
        int fiftypound=scan.nextInt();
        logger.info("Enter no of one Pence coin:");
        int onePence=scan.nextInt();
        logger.info("Enter no of two Pence coin:");
        int twoPence=scan.nextInt();
        logger.info("Enter no of ten Pence coin:");
        int tenPence=scan.nextInt();
        logger.info("Enter no of one Rupee coin:");
        int oneRupee=scan.nextInt();
        logger.info("Enter no of two Rupee coin:");
        int twoRupee=scan.nextInt();
        logger.info("Enter no of fiveRupee note:");
        int fiveRupee=scan.nextInt();
        logger.info("Enter no of fifty Rupee coin:");
        int fiftyrupee=scan.nextInt();
        logger.info("Enter no of hundred Rupee note:");
        int hundredRupee=scan.nextInt();
        logger.info("Enter no of fifty Paise coin:");
        int fiftyPaise=scan.nextInt();
        logger.info("Enter no of twentyfive Paise coin:");
        int twentyfivePaise=scan.nextInt();

        int oneDollarCount=oneDollar+(fiveDollar*5)+(fiftyDollar*50)+(hundredDollar*100);
        int oneCentCount=oneCent+(tenCent*10)+(twentyFiveCent*25);
        int onePoundCount=onePound+(twoPound*2)+(fivePound*5)+(fiftypound*50);
        int onePenceCount=onePence+(twoPence*2)+(tenPence*10);
        int oneRuppeeCount=oneRupee+(twoRupee*2)+(fiveRupee*5)+(fiftyrupee*50)+(hundredRupee*100);
        int onePaiseCount=(fiftyPaise*50)+(twentyfivePaise*25);

        display(oneDollarCount,oneCentCount,onePoundCount,onePenceCount,oneRuppeeCount,onePaiseCount);
    }

    public static void display(int oneDollarCount, int oneCentCount, int onePoundCount, int onePenceCount, int oneRuppeeCount, int onePaiseCount) {
        Currency dollar=new Dollar(oneDollarCount,oneCentCount);
        dollar.print();

        Currency pound=new Pound(onePoundCount,onePenceCount);
        pound.print();

        Currency rupees=new Rupees(oneRuppeeCount,onePaiseCount);
        rupees.print();
    }

}