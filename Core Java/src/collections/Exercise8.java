package collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise8 {
    static Logger logger = Logger.getLogger(Exercise8.class.getName());
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<Integer> employeeIds = new HashSet<>();
        logger.info("10 Employees is compulsory..");
        logger.info("Enter the no of employees to Showcase of New Product : ");
        int n=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            logger.info("Enter the employee id : ");
            employeeIds.add(Integer.parseInt(sc.nextLine()));
        }
        logger.info("volunteer employees to Showcase of New Product");
        logger.log(Level.INFO,"{0}",employeeIds);
    }
}
