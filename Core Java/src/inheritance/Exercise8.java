package inheritance;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


class Workers {
    public static final Logger logger= Logger.getLogger(Workers.class.getName());
    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }



    public Workers(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Workers() {
    }

    public void pay() {
        logger.info("Daily worker salary is based on the number of days working....");
        logger.info("Salaried worker salary is based on the number of hours working......");
    }

}
class DailyWorkers extends Workers{
    private String workerType;
    private int days;
    private static final int SALARY_PER_DAY = 2000;

    public String getWorkerType() {
        return workerType;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    private static int calculateSalary(int days) {
        return days*SALARY_PER_DAY;
    }

    public DailyWorkers(String name,int days,String workerType) {
        super(name, calculateSalary(days));
        this.days = days;
        this.workerType = workerType;

    }


}
class SalariedWorkers extends Workers{
    private int hours;
    private String workerType;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getWorkerType() {
        return workerType;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    private static final int SALARY_PER_DAY = 2500;

    public SalariedWorkers(String name, int hours, String workerType) {
        super(name, calculateSalariedWorkers(hours));
        this.hours = hours;
        this.workerType = workerType;
    }

    private static int calculateSalariedWorkers(int hours){
        return hours*SALARY_PER_DAY;
    }


}

public class Exercise8 {
    static Logger logger = Logger.getLogger(Exercise8.class.getName());
    public static void main(String[] args) {

        Workers worker = new Workers();
        worker.pay();

        Workers dailyWorker1 = new DailyWorkers("Manish", 45, "Daily worker");
        Workers dailyWorker2 = new DailyWorkers("Manish", 25, "Daily worker");
        Workers salariedWorker1 = new SalariedWorkers("Ram", 35, "Salaried worker");
        Workers salariedWorker2 = new SalariedWorkers("krishna", 40, "Salaried worker");

        ArrayList<Workers> workerArrayList=new ArrayList<>();
        workerArrayList.add(dailyWorker1);
        workerArrayList.add(dailyWorker2);
        workerArrayList.add(salariedWorker1);
        workerArrayList.add(salariedWorker2);

        logger.info("Before removing duplicate.....");
        for(Workers result:workerArrayList){
            logger.log(Level.INFO,"{0},{1}",new Object[]{result.getName(),result.getSalary()});
        }

        logger.info("After removing duplicate...");
        Set<Workers> removeDuplicate = new TreeSet<>((w1,w2)->w1.getName().equals(w2.getName())?0:1);
        removeDuplicate.addAll(workerArrayList);

       for(Workers results:removeDuplicate){
           logger.log(Level.INFO,"{0},{1}",new Object[]{results.getName(),results.getSalary()});
       }
    }
}
