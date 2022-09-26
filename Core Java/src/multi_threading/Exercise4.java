package multi_threading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Exercise4 {
    static Logger logger = Logger.getLogger(Exercise4.class.getName());
    static class ThreadClass1{

        String word="";
        TimerTask task = new TimerTask()
        {
            public void run()
            {
                if(word.equals(""))
                {
                    logger.info("Better luck next time. timeout...");
                    System.exit( 0 );
                }
            }
        };
        public void notifyMethod() throws IOException {
            synchronized (this){
                Timer timer = new Timer();
                timer.schedule( task, 10000 );
                logger.info("Enter the word within 10 seconds: ");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                word = in.readLine();
                notifyAll();
            }
        }
        public void waitMethod() throws InterruptedException, NoSuchAlgorithmException {
            synchronized(this){
                while(true){
                    this.wait();
                    Random random= SecureRandom.getInstanceStrong();
                    int password=random.nextInt(4000);
                    logger.info("Congratulation!!!");
                    logger.log(Level.ALL,"Password : {0}",word+password);
                    System.exit(0);
                    break;
                }

            }
        }

    }
    public static void main(String[] args){
        ThreadClass1 treadobj= new ThreadClass1();
        Thread t1=new Thread(() -> {
            try {
                treadobj.waitMethod();
            } catch (InterruptedException | NoSuchAlgorithmException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });

        Thread t2=new Thread(() -> {
            try {
                treadobj.notifyMethod();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }
}
