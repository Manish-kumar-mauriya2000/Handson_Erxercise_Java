package collections;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Exercise1 {
    static Logger logger=Logger.getLogger(Exercise1.class.getName());
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        logger.info("\n====================================================\n1 for add participant.\n2 for delete participant.\n3 for allocated rooms\n4 for exist\n====================================================\n");

        logger.info("Enter no of participant : ");
        int n=Integer.parseInt(sc.nextLine());
        ArrayList<String> participantList=new ArrayList<>(n);
        ArrayList<String> sortedList;
        int index;
        int count = 1;
        while(true){
            logger.info("Enter your choice : ");
            int choice=Integer.parseInt(sc.nextLine());
            if(choice==4){
                System.exit(0);
                break;
            }
            switch(choice){
                case 1:
                    for (int i = 0; i < n; i++) {
                        participantList.add(sc.nextLine());
                    }
                    logger.log(Level.INFO,"{0}",participantList);
                    break;
                case 2:
                    logger.info("Enter the index position to remove participant : ");
                    index=Integer.parseInt(sc.nextLine());
                    participantList.remove(index);
                    logger.log(Level.INFO,"{0}",participantList);
                    break;
                case 3:
                    sortedList= (ArrayList<String>) participantList.stream().sorted().collect(Collectors.toList());
                    for (int i = 0; i < sortedList.size(); i+=5) {
                        logger.log(Level.INFO,"Group No : {0}\n"+"Room No : {1}",new int[]{count,count});
                        try{
                            for(int j=0;j<5;j++){
                                logger.log(Level.INFO,"{0}",sortedList.get(i+j));
                            }
                            count+=1;
                        }catch (Exception e){
                            logger.info("Member no enough!!!");

                        }
                    }
                    break;
                default:
                    logger.info("Invalid option!!!");
            }
        }


    }
}
