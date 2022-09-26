package lambda_expression;

import java.util.logging.Level;
import java.util.logging.Logger;

interface TwoElementPredict<T>{
    boolean func(T t1, T t2);
}
class Employee{
    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public void setNane(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class Exercise3 {
    static Logger logger=Logger.getLogger(Exercise3.class.getName());
    static <T> T betterEntry(T t1, T t2,TwoElementPredict<T> tp){
        if(tp.func(t1,t2))
            return t1;
        else
            return t2;

    }
    public static void main(String[] args){
        TwoElementPredict<String> lambdaStr=(s1,s2)->s1.length()>s2.length();
        String longer=betterEntry("manish","kumar",lambdaStr);
        logger.log(Level.INFO,"{0}",longer);
        Employee emp1=new Employee("suresh",20000);
        Employee emp2 = new Employee("manish",70000);
        TwoElementPredict<Employee> emp=(e1, e2)->e1.getSalary() > e2.getSalary();
        Employee res=  betterEntry(emp1,emp2,emp);
        logger.log(Level.INFO,"{0}",res.getSalary());

    }
}
