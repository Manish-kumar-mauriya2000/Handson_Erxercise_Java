package java_basic;
import java.util.*;
import java.util.logging.Logger;

public class Exercise6 {
    public static void main(String[] args){
        Logger logger= Logger.getLogger(Exercise6.class.getName());
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int tmp;
        int rev=0;
        int tmp1;

        tmp1=num;
        while(num > 0){
            tmp=num%10;
            rev=rev*10+tmp;
            num=num/10;
        }
        int n;
        n=tmp1/2;
        int flag=0;
        if(tmp1==rev){
            logger.info("The given number is palindrome");
            if(tmp1==0 || tmp1==1){
                logger.info("It is not a prime number");
            }
            else {
                for (int i = 2; i <= n; i++) {
                    if (tmp1 % i == 0) {
                        logger.info("It is not a prime number");
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag==0){
                logger.info("The given number is also a prime number");
            }
        }
        else{
            logger.info("Not a palindrome number");
        }


    }
}
