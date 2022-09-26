package java_basic;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Logger logger= Logger.getLogger(Exercise5.class.getName());
        logger.info("Enter the number of eggs : ");
        int eggs = sc.nextInt();
        int gross;
        int dozen;
        int remaining;
        gross=(eggs/144);
        dozen=(eggs%144)/12;
        remaining=(eggs%144)%12;
        logger.log(Level.INFO,"Gross :{0} ",gross);
        logger.log(Level.INFO,"Dozens :{0} ",dozen);
        logger.log(Level.INFO,"Extra :{0} ",remaining);
    }
}
