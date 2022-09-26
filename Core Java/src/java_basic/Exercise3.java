package java_basic;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise3 {
    static Logger logger= Logger.getLogger(Exercise3.class.getName());
    static void generalType(int amount){
        float tax=0;
        if(amount>=0 && amount<=180000){
            logger.info("No tax");
        }
        else if(amount>=180001&&amount <=500000){
            tax = (float) (amount + (amount * 0.10));

            logger.log(Level.INFO, "10% of your tax is :{0} and total amount is : {1}",new Object[]{amount*0.10,tax});
        }
        else if(amount >= 500001&&amount <= 800000){
            tax = (float) (amount + (amount * 0.20));
            logger.log(Level.INFO,"20% of your tax is :{0} and total amount is :{1} ",new Object[]{amount*0.20,tax});
        }
        else{
            tax = (float) (amount + (amount * 0.30));
            logger.log(Level.INFO,"30% of your tax is :{0} and total amount is :{1} ",new Object[]{amount*0.30,tax});
        }
    }

    static void womenType(int amount){
        float tax=0;
        if(amount>=0 && amount<=190000){
            logger.info("No tax");
        }
        else if(amount>=190001&&amount <=500000){
            tax = (float) (amount + (amount * 0.10));
            logger.log(Level.INFO, "10% of your tax is :{0} and total amount is : {1}",new Object[]{amount*0.10,tax});
        }
        else if(amount>=500001&&amount <=800000){
            tax = (float) (amount + (amount * 0.20));
            logger.log(Level.INFO,"20% of your tax is :{0} and total amount is :{1} ",new Object[]{amount*0.20,tax});
        }
        else{
            tax = (float) (amount + (amount * 0.30));
            logger.log(Level.INFO,"30% of your tax is :{0} and total amount is :{1} ",new Object[]{amount*0.30,tax});
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        logger.info("Enter your salary : ");
        int amt = sc.nextInt();
        logger.info("Enter type of tax general/women : ");
        String taxType = sc.next();
        if(taxType.equals("general")){
            generalType(amt);
        }
        else{
            womenType(amt);
        }
    }
}
