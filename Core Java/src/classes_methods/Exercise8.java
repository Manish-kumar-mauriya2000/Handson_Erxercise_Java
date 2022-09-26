package classes_methods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Student{
    static Logger logger=Logger.getLogger(Student.class.getName());
    int regNo;
    String name;
    int eng;
    int maths;
    int science;

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public Student(int regNo, String name, int eng, int maths, int science) {
        this.regNo = regNo;
        this.name = name;
        this.eng = eng;
        this.maths = maths;
        this.science = science;
    }

    public Student() {
    }

    public void sort(List<Student> slist) {
        StudentComparator scomp=new StudentComparator();
        slist.sort(scomp);
        for (Student lst:slist) {
            logger.log(Level.INFO,"{0}",lst);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNo=" + regNo +
                ", name='" + name + '\'' +
                ", eng=" + eng +
                ", maths=" + maths +
                ", science=" + science +
                '}';
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getRegNo() - s2.getRegNo();
    }
}

public class Exercise8 {
    public static void main(String[] args){
        Student stu = new Student();
        ArrayList<Student> st=new ArrayList<>();
        st.add(new Student(5,"Manish",98,95,96));
        st.add(new Student(2,"kishore",90,85,76));
        st.add(new Student(1,"kavin",88,91,90));
        st.add(new Student(4,"prabhu",78,75,86));
        stu.sort(st);

    }
}
