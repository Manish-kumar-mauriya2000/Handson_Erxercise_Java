package interface_question;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


class Athlete{
    private String name;
    private String grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Athlete(String name, String grade) {
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

public class Exercise2 {
    static Logger logger=Logger.getLogger(Exercise2.class.getName());
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Athlete[] athlete =new Athlete[10];
        athlete[0]=new Athlete("Manish","");
        athlete[1]=new Athlete("Ram","");
        athlete[2]=new Athlete("kavin","");
        athlete[3]=new Athlete("siva","");
        athlete[4]=new Athlete("Eswar","");
        athlete[5]=new Athlete("prabhu","");
        athlete[6]=new Athlete("harish","");
        athlete[7]=new Athlete("prakash","");
        athlete[8]=new Athlete("Ajay","");
        athlete[9]=new Athlete("kishore","");
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

        Comparator<Athlete> athleteComparator=Comparator.comparing(Athlete::getName);
        List<Athlete> atheleteList=Arrays.asList(athlete);
        atheleteList.sort(athleteComparator);
        logger.info("After sorting....");
        for (Athlete atheleteListResult:atheleteList) {
            logger.log(Level.INFO,"{0}", atheleteListResult);
        }

    }
}
