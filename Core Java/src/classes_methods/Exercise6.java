package classes_methods;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise6 {
    static Logger logger=Logger.getLogger(Exercise6.class.getName());
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        logger.info("Enter n value : ");
        int n=sc.nextInt();
        String[] name=new String[n];
        logger.info("Enter the Student name : ");
        for (int i = 0; i < n; i++) {
            name[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            sb.append(name[i]).append("\n");

        }
        String str=sb.toString();
        logger.log(Level.INFO,"{0}",str);

    }
}
