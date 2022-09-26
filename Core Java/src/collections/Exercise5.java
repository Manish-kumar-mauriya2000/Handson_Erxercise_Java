package collections;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Person{
    private String name;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Person(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
public class Exercise5 {
    static Logger logger = Logger.getLogger(Exercise5.class.getName());
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Queue<Person> senior = new LinkedList<>();
        Queue<Person> general = new LinkedList<>();
        logger.info("\n============================================\n1 for senior category\n2 for general category\n3 for exist\n============================================\n");


        while(true){
            logger.info("Enter your choice : ");
            int choice=sc.nextInt();
            if(choice==1){
                logger.info("Enter person name : ");
                String name=sc.next();
                senior.add(new Person(name,"senior"));
            }
            else if(choice==2){
                logger.info("Enter person name : ");
                String name=sc.next();
                general.add(new Person(name,"general"));
            }
            else if(choice==3){
                System.exit(0);
                break;
            }
        }
        while(true){
            if(!senior.isEmpty()){
                logger.log(Level.INFO,"senior citizen : {0}",senior.poll().getName());
            }
            if(!general.isEmpty()){
                logger.log(Level.INFO,"general citizen {0}: ",general.poll().getName());
                logger.log(Level.INFO,"general citizen :{0} ",general.poll().getName());
            }

        }















    }
}
