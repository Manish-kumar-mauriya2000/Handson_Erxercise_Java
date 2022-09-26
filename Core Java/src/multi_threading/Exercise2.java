package multi_threading;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise2 {
    static Logger logger = Logger.getLogger(Exercise2.class.getName());
    class ThreadClass{
        String name;
        public void notifyMethod() {
            synchronized (this){
                Scanner sc = new Scanner(System.in);
                logger.info("Enter name : ");
                name = sc.next();
                notifyAll();

            }
        }
        public void waitMethod() throws InterruptedException, NoSuchAlgorithmException {
            synchronized(this){
                while(true){
                    wait();
                    Random random= SecureRandom.getInstanceStrong();
                    int password=random.nextInt(4000);
                    logger.log(Level.INFO,"Password : {0}",name+password);
                    break;
                }

            }
        }
    }
    public static void main(String[] args) {
        ThreadClass treadobj=new Exercise2().new ThreadClass();

       Thread t1=new Thread(()-> {
           try {
               treadobj.waitMethod();
           } catch (InterruptedException | NoSuchAlgorithmException e ) {
               e.printStackTrace();
               Thread.currentThread().interrupt();
           }
       });
       Thread t2=new Thread(treadobj::notifyMethod);
       t1.start();
       t2.start();
    }


}
