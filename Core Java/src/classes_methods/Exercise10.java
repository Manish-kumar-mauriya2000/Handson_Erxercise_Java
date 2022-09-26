package classes_methods;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Calculator{
    public static final Logger loggerCalc= Logger.getLogger(Calculator.class.getName());

    public void add(int a,int b){
        loggerCalc.log(Level.INFO,"Integer addition of two number is :{0} ",(a+b));
    }
    public void add(double a,double b){
        loggerCalc.log(Level.INFO,"Double addition of two number is :{0} ",(a+b));
    }
    public void add(int a,double b){
        loggerCalc.log(Level.INFO,"Addition of two number is :{0} ",(a+b));
    }
    public void add(double a,int b){
        loggerCalc.log(Level.INFO,"Addition of two number is :{0} ",(a+b));
    }
    //================================================================================
    public void sub(int a,int b){
        loggerCalc.log(Level.INFO,"Integer Subtraction of two number is :{0} ",(a-b));
    }
    public void sub(double a,double b){
        loggerCalc.log(Level.INFO,"Double  Subtraction of two number is :{0} ",(a-b));
    }
    public void sub(int a,double b){
        loggerCalc.log(Level.INFO,"Subtraction of two number is :{0} ",(a-b));
    }
    public void sub(double a,int b){
        loggerCalc.log(Level.INFO,"Subtraction of two number is :{0} ",(a-b));
    }
    //================================================================================
    public void mul(int a,int b){
        loggerCalc.log(Level.INFO,"Integer Multiplication of two number is :{0} ",(a*b));
    }
    public void mul(double a,double b){
        loggerCalc.log(Level.INFO,"Double Multiplication of two number is :{0} ",(a*b));
    }
    public void mul(int a,double b){
        loggerCalc.log(Level.INFO,"Multiplication of two number is :{0} ",(a*b));
    }
    public void mul(double a,int b){
        loggerCalc.log(Level.INFO,"Multiplication of two number is :{0} ",(a*b));
    }
    //================================================================================
    public void div(int a,int b){
        loggerCalc.log(Level.INFO,"Integer Division of two number is :{0} ",(a/b));
    }
    public void div(double a,double b){
        loggerCalc.log(Level.INFO,"Double Division of two number is :{0} ",(a/b));
    }
    public void div(int a,double b){
        loggerCalc.log(Level.INFO,"Division of two number is :{0} ",(a/b));
    }
    public void div(double a,int b){
        loggerCalc.log(Level.INFO,"Division of two number is :{0} ",(a/b));
    }
}

public class Exercise10 {
    static Logger logger = Logger.getLogger(Exercise10.class.getName());

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Calculator c=new Calculator();
        logger.info("\n=============================================\nSelect 1 for addition.\nSelect 2 for subtraction.\nSelect 3 for multiplication.\nSelect 4 for division.\nSelect 5 for Exist.\n==============================================");

        logger.info("Enter your choice : ");
        int choice=sc.nextInt();
        if(choice==5){
            System.exit(0);

        }
        logger.info("Enter the number1 : ");
        double x=sc.nextDouble();
        logger.info("Enter the number2 : ");
        double y=sc.nextDouble();
        switch(choice){
            case 1:
                if(Math.round(x+y)==x+y){
                    c.add((int)x,(int)y);
                }
                else{
                    c.add(x,y);
                }
                break;
            case 2:
                if(Math.round(x+y)==x+y){
                    c.sub((int)x,(int)y);
                }
                else{
                    c.sub(x,y);
                }
                break;
            case 3:
                if(Math.round(x+y)==x+y){
                    c.mul((int)x,(int)y);
                }
                else{
                    c.mul(x,y);
                }
                break;
            case 4:
                if(Math.round(x+y)==x+y){
                    c.div((int)x,(int)y);
                }
                else{
                    c.div(x,y);
                }
                break;
            default:
                logger.info("Invalid choice!!!!!");

    }

    }
}
