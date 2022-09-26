package inheritance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


class Worker{
    public static final Logger logger = Logger.getLogger(Worker.class.getName());
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

    public Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Worker() {
    }

    public void pay(){
        logger.info("Daily worker salary is based on the number of days working....");
        logger.info("Salaried worker salary is based on the number of hours working......");
    }

    public void sortWorkerSalary(List<Worker> workerArrayList){
        SortBySalary sortSalary=new SortBySalary();
        workerArrayList.sort(sortSalary);
        logger.info("After sorting by salary....");
        for(Worker worker : workerArrayList){
            logger.log(Level.INFO,"{0} , {1}",new Object[]{worker.getName(),worker.getSalary()});
        }
    }
}

class SortBySalary implements Comparator<Worker> {
    public int compare(Worker w1, Worker w2) {
        return w1.getSalary() - w2.getSalary();
    }
}

class DailyWorker extends Worker{
    private int days;
    private String workerType;
    private static final int SALARITY_PER_DAY = 2000;

    public int getDays() {
        return days;
    }

    public String getWorkerType() {
        return workerType;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    private static int calculateSalary(int days) {
        return days*SALARITY_PER_DAY;
    }

    public DailyWorker(String name,int days,String workerType) {
        super(name, calculateSalary(days));
        this.days = days;
        this.workerType = workerType;
    }

}
class SalariedWorker extends Worker{
    private int hours;
    private String workerType;
    private static final int SALARY_PER_DAY = 2500;

    public int getHours() {
        return hours;
    }

    public String getWorkerType() {
        return workerType;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    public SalariedWorker(String name, int hours, String workerType) {
        super(name, calculateSalariedWorkers(hours));
        this.hours = hours;
        this.workerType = workerType;
    }

    private static int calculateSalariedWorkers(int hours){
        return hours*SALARY_PER_DAY;
    }

}

public class Exercise4 {
    static Logger logger=Logger.getLogger(Exercise4.class.getName());
    public static void main(String[] args) {

        Worker dailyWorker1 = new DailyWorker("Manish",45,"Daily worker");
        Worker dailyWorker2 = new DailyWorker("kavin",25,"Daily worker");
        Worker salariedWorker1 = new SalariedWorker("Ram",35,"Salaried worker");
        Worker salariedWorker2 = new SalariedWorker("krishna",40,"Salaried worker");

        ArrayList<Worker> workerArrayList=new ArrayList<>();
        workerArrayList.add(dailyWorker1);
        workerArrayList.add(dailyWorker2);
        workerArrayList.add(salariedWorker1);
        workerArrayList.add(salariedWorker2);
        logger.info("Before sorting.....");
        for(Worker result:workerArrayList){
            logger.log(Level.INFO,"{0} , {1}",new Object[]{result.getName(),result.getSalary()});
        }
        Worker worker = new Worker();
        worker.pay();
        worker.sortWorkerSalary(workerArrayList);
    }
}
