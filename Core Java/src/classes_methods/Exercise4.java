package classes_methods;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise4 {
    static Logger logger=Logger.getLogger(Exercise4.class.getName());
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        logger.info("Enter the n value : ");
        int n = sc.nextInt();
        int[][] arr=new int[n][n];
        int[][] arr2=new int[n][n];
        int[][] res=new int[n][n];
        logger.info("Enter the First matrix :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                logger.log(Level.INFO, "arr1[{0}][{1}] : ",new int[] {i,j});
                arr[i][j] = sc.nextInt();
            }
        }
        logger.info("Enter the second Matrix : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                logger.log(Level.INFO, "arr2[{0}][{1}] : ",new int[] {i,j});
                arr2[i][j] = sc.nextInt();
            }
        }
        logger.info("Sum of the two matrix : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = arr[i][j]+arr2[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                logger.log(Level.INFO,"{0}",res[i][j]);
            }
            logger.info("");
        }




    }
}
