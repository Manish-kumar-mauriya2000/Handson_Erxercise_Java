package multi_threading;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Exercise8{
    static Logger logger = Logger.getLogger(Exercise8.class.getName());
    static int[][] splittedArray;
    static Queue<Double> avgOfAllArrays=new LinkedList<>();
    class FindAverages extends Thread {

        public FindAverages(int[] arr){
            synchronized(this) {
                int sum=0;
                for(int i=0;i<arr.length;i++) {
                    sum+=arr[i];
                }
                double findAvg=(double)sum/arr.length;
                avgOfAllArrays.add(findAvg);
                if(avgOfAllArrays.size()==5){
                    notifyAll();
                }
            }
        }

        public FindAverages(){
        }

        @Override
        public void run(){
            throw new UnsupportedOperationException();
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
        logger.info("Arrays split into small chunks...");
        for (int i=0;i<splittedArray.length;i++){
            logger.log(Level.INFO,"{0}",Arrays.toString(splittedArray[i]));
        }

        Exercise8 avg=new Exercise8();
        Thread t1=(new Thread() {
            @Override
            public void run() {
              avg.new FindAverages(splittedArray[0]);
           }
        });
        Thread t2=(new Thread() {
            @Override
            public void run() {
               avg.new FindAverages(splittedArray[1]);
            }
        });
        Thread t3=(new Thread() {
            @Override
            public void run() {
                avg.new FindAverages(splittedArray[2]);
            }
        });
        Thread t4=(new Thread() {
            @Override
            public void run() {
                avg.new FindAverages(splittedArray[3]);
            }
        });
        Thread t5=(new Thread() {
            @Override
            public void run() {
               avg.new FindAverages(splittedArray[4]);
           }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        
        Exercise8.FindAverages calculateAverage=avg.new FindAverages();
        calculateAverage.start();
        synchronized(calculateAverage){
            while(true){
                double additionOfAverage=0;
                for(double num:avgOfAllArrays){
                    additionOfAverage+=num;
                }
                logger.log(Level.INFO,"Final average : {0}",(additionOfAverage/5));
                System.exit(0);
                break;
            }
        }
    }
}
