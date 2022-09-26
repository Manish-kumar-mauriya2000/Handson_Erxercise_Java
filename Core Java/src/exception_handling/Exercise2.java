package exception_handling;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//A comma separated list containing pairs of topic name, time in hours ( Java 14, JEE 10, JME 12)
//        will be entered in the command line arguments. If a day consists of 8 hours, list out the topics
//        that will be covered day-wise. Catch all the possible exceptions.

public class Exercise2 {
    static final Logger logger= Logger.getLogger(Exercise2.class.getName());
    public static void main(String[] args) throws IndexOutOfBoundsException {
        Scanner sc=new Scanner(System.in);
        logger.info("Enter subject and time : ");
        String str=sc.nextLine();
        String[] strSplit= str.split(",");
        ArrayList<String> topics = new ArrayList<>();
        ArrayList<Integer> hours = new ArrayList<>();

        for(String finalStr:strSplit){
            String[] res=finalStr.split(" ");
            topics.add(res[0]);
            int val=Integer.parseInt(res[1]);
            hours.add(val);
        }
        int day = 0;
        logger.info("List of topics consist of 8 hours...");
        try{
            for(int i=0;i<hours.size();i++){
                if(hours.get(i)>8){
                    throw new IndexOutOfBoundsException("Day can only cover 8 hours........");
                }
                else{
                    ++day;
                    logger.log(Level.INFO,"Day : {0}",day);
                    logger.log(Level.INFO,"{0}",topics.get(i));
                }
            }
        }catch(Exception ex){
            logger.log(Level.INFO,"Day : {0}",ex.getMessage());
        }

    }

}
