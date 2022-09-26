package multi_threading;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise3 {
    static Logger logger = Logger.getLogger(Exercise3.class.getName());
    private String word;

    public String getWord() {
        return word;
    }


    public void setWord(String word) {
        this.word = word;
    }

    class ThreadWait implements Runnable {
        private Exercise3 word;

        public ThreadWait(Exercise3 word) {
            this.word = word;
        }

        @Override
        public void run() {
            synchronized (word) {
                while(true){
                    try {
                        logger.info("waiting to notify.....");
                        word.wait();
                        Random random = SecureRandom.getInstanceStrong();
                        int x = random.nextInt(5000);
                        logger.log(Level.INFO, "{0}", word.getWord() + x);
                        break;
                    } catch (InterruptedException | NoSuchAlgorithmException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }
    }


    class ThreadNotify implements Runnable {
        private Exercise3 word;

        public ThreadNotify(Exercise3 word) {
            this.word = word;
        }

        @Override
        public void run() {
            synchronized (word) {
                Scanner scan = new Scanner(System.in);
                logger.info("Enter Word: ");
                word.setWord(scan.nextLine());
                word.notifyAll();
            }
        }
    }


    public static void main(String[] args){
        Exercise3 word=new Exercise3();
        Runnable threadwait= new Exercise3().new ThreadWait(word);
        Runnable threadnotify= new Exercise3().new ThreadNotify(word);
        Thread t1=new Thread(threadwait);
        Thread t2=new Thread(threadnotify);
        t1.start();
        t2.start();
    }
}
