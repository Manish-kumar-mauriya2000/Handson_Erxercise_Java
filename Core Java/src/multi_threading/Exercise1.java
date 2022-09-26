package multi_threading;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;



public class Exercise1 {
    static Logger logger = Logger.getLogger(Exercise1.class.getName());
    static int[][] splittedArray;
    static double avgOfAllArrays;
    class FindAverage{

        public FindAverage(int[] arr) {
            synchronized(this) {
                int sum=0;
                for(int i=0;i<arr.length;i++) {
                    sum+=arr[i];
                }
                double findAvg=(double)sum/arr.length;
                avgOfAllArrays+=findAvg;
            }
        }


    }
    public static int[][] splitArray(int[] inputArray, int chunkSize) {
        return IntStream.iterate(0, i -> i + chunkSize).limit((int) Math.ceil((double) inputArray.length / chunkSize))
                .mapToObj(j -> Arrays.copyOfRange(inputArray, j, Math.min(inputArray.length, j + chunkSize)))
                .toArray(int[][]::new);
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc=new Scanner(System.in);
        logger.info("Enter the number of arrays : ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        logger.info("Enter the array values : ");
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        int chunkSize = arr.length/5;
        splittedArray = splitArray(arr, chunkSize);
        logger.info("Arrays splitted into small chunks...");
        for (int i=0;i<splittedArray.length;i++){
            logger.log(Level.INFO,"{0}",Arrays.toString(splittedArray[i]));
        }

        Exercise1 avg=new Exercise1();

        Thread t1=(new Thread() {
            @Override
            public void run() {
                avg.new FindAverage(splittedArray[0]);
            }
        });
        Thread t2=(new Thread() {
            @Override
            public void run() {
               avg.new FindAverage(splittedArray[1]);
            }
        });
        Thread t3=(new Thread() {
            @Override
            public void run() {
               avg.new FindAverage(splittedArray[2]);
            }
        });
        Thread t4=(new Thread() {
            @Override
            public void run() {
               avg.new FindAverage(splittedArray[3]);
            }
        });
        Thread t5=(new Thread() {
            @Override
            public void run() {
              avg.new FindAverage(splittedArray[4]);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        Thread.sleep(500);
        logger.log(Level.INFO,"Final Average : {0}",avgOfAllArrays/5);
    }
}
