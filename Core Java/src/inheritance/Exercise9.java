package inheritance;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

class Student{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public boolean isPrime(int id){
        if(id==0 || id==1)
            return false;
        else{
            for (int i = 2; i <= id / 2; i++)
            {
                if (id%i == 0)
                   return false;
            }
            return true;
        }
    }
    
    public boolean isEven(int id){
       return id%2==0;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        if(isPrime(id) && isEven(id)){
            return 1;
        }
        else if(isPrime(id) && !isEven(id)){
            return 2;
        }
        return 0;
    }
}
public class Exercise9 {
    static Logger logger=Logger.getLogger(Exercise9.class.getName());
    public static void main(String[] args){
        Student student1 = new Student(1,"manish");
        Student student2 = new Student(2,"kumar");
        Student student3 = new Student(3,"ram");
        Student student4 = new Student(4,"karthik");

        Set<Student> set = new HashSet<>();
        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);

        for(Student st:set){
            logger.log(Level.INFO,"{0} {1}",new Object[] {st.getId(),st.hashCode()});
        }
    }
}
