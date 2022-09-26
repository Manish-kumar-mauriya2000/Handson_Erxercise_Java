package multi_threading;

import java.util.logging.Level;
import java.util.logging.Logger;

class Eggs{
    static Logger logger = Logger.getLogger(Eggs.class.getName());
    static int days=1;
    static final int MAX_DAYS=50;
    public void henLaidEggs() {
        synchronized(this){
            while (days<MAX_DAYS){
                while(days%2!=0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        logger.log(Level.INFO,"{0}",e.getClass());
                        Thread.currentThread().interrupt();
                    }
                }

                logger.log(Level.INFO,"Hen Laid the Egg - {0}",days);
                logger.log(Level.INFO,"Owner gained Rs {0}", days*2);
                days++;
                notifyAll();
            }
       }
    }
    public void ownerGained(){
        synchronized(this){
            while(days<MAX_DAYS) {
                while(days%2==0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        logger.log(Level.INFO,"{0}",e.getClass());
                        Thread.currentThread().interrupt();
                    }
                }
                logger.log(Level.INFO,"Hen Laid the Egg - {0}",days);
                logger.log(Level.INFO,"Owner gained Rs {0}", days*2);
                days++;
                notifyAll();
            }

        }
    }
}
public class Exercise7 {
    public static void main(String[] args){
        Eggs egg=new Eggs();
        Thread t1=new Thread(egg::henLaidEggs);

        Thread t2=new Thread(egg::ownerGained);

        t1.start();
        t2.start();
    }
}
