package interface_question;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise1 implements PhysicalConstants {
    static Logger logger=Logger.getLogger(Exercise1.class.getName());
    public double energy(double mass){
        return (mass*0.001)*SPEED_OF_LIGHT*SPEED_OF_LIGHT;
    }
    public double force(double m1,double m2,double r){
        return (GRAVITATIONAL*(m1*m2))/(r*r);
    }
    public double gravitationalAcc(double t){
        return 0.5*STANDARD_GRAVITATIONAL_ACCELERATION*t;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Exercise1 e1=new Exercise1();
        logger.info("========================================\n1 for calculate E=MC2 \n2 for calculate F=G (m1 m2)/r2 \n3 for calculate d=0.5 gt \n ========================================");
        while(true){
            logger.info("Enter your choice : ");
            int choice=Integer.parseInt(sc.nextLine());
            if(choice==4){
                System.exit(0);
                break;
            } else{
            switch(choice) {
                 case 1:
                     logger.info("Enter the value for Mass(M) : ");
                        double mass=Double.parseDouble(sc.nextLine());
                       logger.log(Level.INFO,"E={0}",e1.energy(mass));
                        break;
                    case 2:
                        logger.info("Enter the value for m1 : ");
                        double m1=Double.parseDouble(sc.nextLine());
                        logger.info("Enter the value for m2 : ");
                        double m2=Double.parseDouble(sc.nextLine());
                        logger.info("Enter the value for r : ");
                        double r=Double.parseDouble(sc.nextLine());
                        logger.log(Level.INFO,"F={0}",e1.force(m1,m2,r));
                        break;
                    case 3:
                        logger.info("Enter the value for t : ");
                        double t=Double.parseDouble(sc.nextLine());
                        logger.log(Level.INFO,"d={0}",e1.gravitationalAcc(t));
                        break;
                    default:
                        logger.info("Invalid choice!!!");
                }
            }
        }

    }

}
