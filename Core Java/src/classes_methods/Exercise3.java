package classes_methods;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class ArrLst{
    static final Logger logger=Logger.getLogger(ArrLst.class.getName());
   public int insert(int[] arr,int n,int x){
        arr[n]=x;
        return n+1;
   }

   public int find(int[] arr,int n,int x){
       for (int i = 0; i < n; i++) {
           if(arr[i]==x) return i;

       }
       return -1;
   }

   public int delete(int[] arr,int n,int x){
       int pos=find(arr,n,x);
       if(pos==-1)
           logger.info("Element not found");
       for (int i = pos; i < n-1 ; i++) {
            arr[i]=arr[i+1];
       }
       return n-1;
   }

    public void display(int[] arr,int n){
        for (int i = 0; i <n ; i++) {
            logger.log(Level.INFO,"{0}",arr[i]);
        }
    }
}

public class Exercise3 {
    static Logger logger=Logger.getLogger(Exercise3.class.getName());
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrLst lst = new ArrLst();
        logger.info("Enter n value : ");
        int n=sc.nextInt();
        int[] arr=new int[20];
        logger.info("Enter the array values : ");
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        logger.info("Enter insert value : ");
        int insertEle=sc.nextInt();
        n=lst.insert(arr,n,insertEle);
        logger.info("After insert");
        lst.display(arr,n);
        logger.info("Enter delete value : ");
        int delEle=sc.nextInt();
        n=lst.delete(arr,n,delEle);
        logger.info("After delete");
        lst.display(arr,n);
        logger.info("Enter find value : ");
        int findEle=sc.nextInt();
        n=lst.find(arr,n,findEle);
       logger.log(Level.INFO,"Element found in the list at the position : {0}",n);
    }
}
