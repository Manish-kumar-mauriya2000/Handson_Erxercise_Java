package collections;

import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise11 {
    static Logger logger = Logger.getLogger(Exercise11.class.getName());
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double totalRetailPrice=0;
        logger.info("Exist the application by choosing invalid product except A/B/C..");
        while(true) {
            logger.info("Enter product code A/B/C : ");
            char product = sc.next().charAt(0);
            if (Objects.equals(product, 'D')) {
                logger.info("Thank you! Visit again......");
                break;
            }
            logger.info("Enter the quantity : ");
            int quantity = sc.nextInt();
            switch (product) {
                case 'A':
                    totalRetailPrice += quantity * 22.50;
                    logger.info("Product Code : A");
                    logger.log(Level.INFO,"Product Price : ₹ {0} ",22.50);
                    logger.log(Level.INFO,"Product quantity : {0} ",quantity);
                    logger.log(Level.INFO,"Total retail price : {0} ",totalRetailPrice);
                    break;
                case 'B':
                    totalRetailPrice += quantity * 44.50;
                    logger.info("Product Code : B");
                    logger.log(Level.INFO,"Product Price : ₹ {0}",44.50);
                    logger.log(Level.INFO,"Product quantity : {0}",quantity);
                    logger.log(Level.INFO,"Total retail price : {0}",totalRetailPrice);
                    break;
                case 'C':
                    totalRetailPrice += quantity * 9.98;
                    logger.info("Product Code : C");
                    logger.log(Level.INFO,"Product Price : ₹ {0}",9.98);
                    logger.log(Level.INFO,"Product quantity : {0}",quantity);
                    logger.log(Level.INFO,"Total retail price : {0}",totalRetailPrice);
                    break;
                default:
                    logger.info("Invalid option!!!!!");
            }
            logger.log(Level.INFO,"Total of all retail price is ₹ {0}", totalRetailPrice);
        }

    }
}
