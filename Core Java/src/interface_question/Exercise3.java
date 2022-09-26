package interface_question;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Athletes{
    private String name;
    private String grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Athletes(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}

public class Exercise3 {
    static Logger logger=Logger.getLogger(Exercise3.class.getName());
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Athletes[] athlete=new Athletes[10];
        athlete[0]=new Athletes("Manish","");
        athlete[1]=new Athletes("Ram","");
        athlete[2]=new Athletes("kavin","");
        athlete[3]=new Athletes("siva","");
        athlete[4]=new Athletes("Eswar","");
        athlete[5]=new Athletes("prabhu","");
        athlete[6]=new Athletes("harish","");
        athlete[7]=new Athletes("prakash","");
        athlete[8]=new Athletes("Ajay","");
        athlete[9]=new Athletes("kishore","");
        logger.log(Level.INFO,"{0}",Arrays.toString(athlete));
        for (int i = 0; i < 10; i++) {
            logger.info("Enter the name to be search : ");
            String name = sc.next();
            if(name.equals(athlete[i].getName())){
                logger.log(Level.INFO,"Enter the grade for the {0} : ",name);
                String grade = sc.next();
                athlete[i].setGrade(grade);
            }
            else{
                logger.info("Name not found!!!!!");
                break;
            }
        }

        Comparator<Athletes> athleteComparator=Comparator.comparing(Athletes::getGrade);
        List<Athletes> atheleteList=Arrays.asList(athlete);
        atheleteList.sort(athleteComparator);
        logger.info("After sorting by Grade....");
        for (Athletes atheleteListResult:atheleteList) {
            logger.log(Level.INFO,"{0}", atheleteListResult);
        }

    }
}
