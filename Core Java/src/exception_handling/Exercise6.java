package exception_handling;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Employees{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employees(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Exercise6 {
    static Logger logger= Logger.getLogger(Exercise6.class.getName());
    public static void main(String[] args) throws AlreadyBoundException {
        Scanner sc = new Scanner(System.in);
        logger.info("Enter number of employees : ");
        int n=Integer.parseInt(sc.nextLine());
        ArrayList<Employees> arrayList=new ArrayList<>(n);
        ArrayList<String> name=new ArrayList<>(n);
        ArrayList<Integer> age=new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            logger.info("Enter name : ");
            name.add(sc.next());
            logger.info("Enter age : ");
            age.add(sc.nextInt());
            logger.log(Level.INFO,"{0}",arrayList);
            if(!arrayList.isEmpty()){
                for(Employees n1:arrayList){
                    if(n1.getName().equals(name.get(i))){
                      throw new AlreadyBoundException("Name is already entered..");
                    }
                }
                if(age.get(i)<0 || age.get(i)<18 || age.get(i)>60){
                   throw new InternalError("Age is not negative or not less than 18 or not greather than 60..");
                }

                else {
                    arrayList.add(new Employees(name.get(i), age.get(i)));
                }

            }
            else{
                arrayList.add(new Employees(name.get(i), age.get(i)));
            }

        }


    }
}
