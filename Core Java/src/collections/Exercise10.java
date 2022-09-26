package collections;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class PhoneDirectory{
    private String name;
    private long phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneDirectory(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneDirectory{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }


}

public class Exercise10 {
    static Logger logger = Logger.getLogger(Exercise10.class.getName());
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<PhoneDirectory> phoneDirectories=new ArrayList<>();
        ArrayList<String> names=new ArrayList<>();
        ArrayList<Long> phoneNumber=new ArrayList<>();
        int n;
        logger.info("\n==================================================\n1 for add phone directory\n2 for search phone directory information\n3 for delete information\n==================================================\n");

        while(true){
            logger.info("Enter your choice to proceed : ");
            int choice=sc.nextInt();
            if(choice==4){
                System.exit(0);
                break;
            }
            switch(choice){
                case 1:
                    logger.info("Enter the number of phone directories data do you add : ");
                    n=sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        logger.info("Enter name : ");
                        names.add(sc.next());
                        logger.info("Enter phone Number : ");
                        phoneNumber.add(sc.nextLong());
                    }
                    for (int i = 0; i < n;i++){
                        phoneDirectories.add(new PhoneDirectory(names.get(i),phoneNumber.get(i)));
                    }
                    logger.log(Level.INFO,"{0}",phoneDirectories);
                    break;
                case 2:
                    logger.info("Enter the name to search : ");
                    String searchName=sc.next();
                    for (int i = 0; i < phoneDirectories.size(); i++) {
                        if(phoneDirectories.get(i).getName().equals(searchName)){
                            logger.log(Level.INFO,"{0}",phoneDirectories.get(i));
                            break;
                        }
                        else{
                            logger.info("Data not found....");
                        }
                    }
                    break;
                case 3:
                    logger.info("Enter the name to delete : ");
                    String deleteName=sc.next();
                    if(phoneDirectories.removeIf(s->s.getName().equals(deleteName))){
                        logger.info("Data deleted successfully..");
                    }
                    else logger.info("Data not found...");
                    logger.info("After deleting......");
                    logger.log(Level.INFO,"{0}",phoneDirectories);
                    break;
                default :
                    logger.info("Invalid option!!");

            }
        }
    }

}
