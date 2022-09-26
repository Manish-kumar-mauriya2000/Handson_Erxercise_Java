package multi_threading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Exercise9 {
    static Logger logger = Logger.getLogger(Exercise9.class.getName());
    static int[][] splittedArray;
    class  FindAverageArr implements Callable<Double> {
        int[] arr;

        public FindAverageArr(int[] arr) {
            this.arr = arr;
        }

        @Override
        public Double call() throws Exception {
            synchronized (this){
                int sum=0;
                for(int i=0;i<arr.length;i++) {
                    sum+=arr[i];
                }
              return (double)sum/arr.length;
            }
        }
    }

    public static int[][] splitArray(int[] inputArray, int chunkSize) {
        return IntStream.iterate(0, i -> i + chunkSize).limit((int) Math.ceil((double) inputArray.length / chunkSize))
                .mapToObj(j -> Arrays.copyOfRange(inputArray, j, Math.min(inputArray.length, j + chunkSize)))
                .toArray(int[][]::new);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
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
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        List<Future<Double>> avgList=new ArrayList<>();

        Exercise9 ex9=new Exercise9();
        for(int i=0;i<splittedArray.length;i++){
            Exercise9.FindAverageArr avg=ex9.new FindAverageArr(splittedArray[i]);
            avgList.add(executorService.submit(avg));
        }
        double calculateFinalAvg=0;
        for (int i = 0; i < splittedArray.length; i++) {
            calculateFinalAvg = calculateFinalAvg + avgList.get(i).get();
        }
        logger.log(Level.INFO,"Final average : {0}",(calculateFinalAvg/5));
        System.exit(0);
    }

}
