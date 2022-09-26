package java_basic;

import java.util.Scanner;
import java.util.logging.Logger;



public class Exercise2 {
    static Logger logger = Logger.getLogger(Exercise2.class.getName());
    public static void main(String[] args){
        logger.info("a) Get two numbers as input from the user through console and swap the values of two numbers without using a temporary variable and display the same.");
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        logger.info("Enter the number1 : ");
        a=sc.nextInt();
        logger.info("Enter the number2 : ");
        b=sc.nextInt();
        String beforeSwapping="Before swapping a is : "+a+" and b is : "+b;
        logger.info(beforeSwapping);
        a=a+b;
        b=a-b;
        a=a-b;
        String afterSwapping="After swapping a is : "+a+" and b is : "+b;
        logger.info(afterSwapping);

        logger.info("============================================================================================================");

        logger.info("b) Determine whether the given year is leap year or not (Read the input through console");
        logger.info("Enter the Year : ");
        int year = sc.nextInt();
        if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
            logger.info("The given year is leap year...");
        }
        else
            logger.info("The given year is not a leap year....");
    }
}
