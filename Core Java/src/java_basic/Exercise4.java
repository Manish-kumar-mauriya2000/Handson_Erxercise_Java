package java_basic;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise4 {
    public static void main(String[] args){
        Logger logger = Logger.getLogger(Exercise4.class.getName());
        Scanner sc = new Scanner(System.in);
        double totalRetailPrice=0;
        logger.info("Exist the application by choosing invalid product except A/B/C..");
        while(true){
            logger.info("Enter product code A/B/C : ");
            char product=sc.next().charAt(0);
            if(Objects.equals(product, 'D')){
                logger.info("Thank you! Visit again......");
                break;
            }
            logger.info("Enter the quantity : ");
            int quantity=sc.nextInt();
            switch(product){
                case 'A':
                    totalRetailPrice+=quantity*22.50;
                    break;
                case 'B':
                    totalRetailPrice+=quantity*44.50;
                    break;
                case 'C':
                    totalRetailPrice+=quantity*9.98;
                    break;
                default:
                    logger.info("Invalid option!!!!!");
            }
            logger.log(Level.INFO,"Total retail price is ₹ {0} ",totalRetailPrice);
        }
    }
}
