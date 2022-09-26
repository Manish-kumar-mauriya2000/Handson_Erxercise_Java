package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class School{
    private String name;
    private String role;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public School(String name, String role) {
        super();
        this.name = name;
        this.role = role;
    }
    @Override
    public String toString() {
        return "School {name = " + name + ", role = " + role + "}";
    }

}

class Students extends School{
    public Students(String name, String role) {
        super(name, role);

    }

    @Override
    public String toString() {
        return "Student {Name = " + getName() + ", Role= " + getRole() + "object Type = " + getClass() + "}";
    }

}

class Teacher extends School{
    public Teacher(String name, String role) {
        super(name, role);
    }

    @Override
    public String toString() {
        return "Teacher {Name = " + getName() + ", Role = " + getRole() +" object Type = " + getClass() + "}";
    }
}

class HOD extends School{
    public HOD(String name, String role) {
        super(name, role);
    }


    @Override
    public String toString() {
        return "HOD {Name = " + getName() + ", Role = " + getRole() + ", object Type = " + getClass() + "}";
    }
}
public class Exercise2 {
    static Logger logger=Logger.getLogger(Exercise2.class.getName());
    public static void main(String[] args) {
        List<Object> arrayObj=new ArrayList<>();
        arrayObj.add(new Students("manish kumar","Student"));
        arrayObj.add(new Teacher("Ram","Teacher"));
        arrayObj.add(new HOD("Kavin","HOD"));
        for(Object data:arrayObj) {
            logger.log(Level.INFO,"{0} ",data);
        }
    }
}
