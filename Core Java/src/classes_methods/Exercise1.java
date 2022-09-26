package classes_methods;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Students  {

    int regNo;
    String name;
    int marksInEng;
    int marksInMaths;
    int marksInScience;
    int total;
    double percent;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public int getMarksInEng() {
        return marksInEng;
    }

    public void setMarksInEng(int marksInEng) {
        this.marksInEng = marksInEng;
    }

    public int getMarksInMaths() {
        return marksInMaths;
    }

    public void setMarksInMaths(int marksInMaths) {
        this.marksInMaths = marksInMaths;
    }

    public int getMarksInScience() {
        return marksInScience;
    }

    public void setMarksInScience(int marksInScience) {
        this.marksInScience = marksInScience;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Students(int regNo, String name, int marksInEng, int marksInMaths, int marksInScience, int total, double percent) {
        this.regNo = regNo;
        this.name = name;
        this.marksInEng = marksInEng;
        this.marksInMaths = marksInMaths;
        this.marksInScience = marksInScience;
        this.total = total;
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Students{" +
                "regNo=" + regNo +
                ", name='" + name + '\'' +
                ", MarksInEng=" + marksInEng +
                ", MarksInMaths=" + marksInMaths +
                ", MarksInScience=" + marksInScience +
                ", total=" + total +
                ", percent=" + percent +
                '}';
    }
}

class Standard{
    static final Logger logger=Logger.getLogger(Standard.class.getName());
    public void sortById(List<Students> lst){
        StudentById stuID = new StudentById();
        lst.sort(stuID);
        for(Students res : lst){
            logger.log(Level.INFO,"{0}",res);
        }
    }

    public void highPercent(List<Students> lst){
        StudentPerct stuPer = new StudentPerct();
        Students maxPer= Collections.max(lst,stuPer);
        logger.log(Level.INFO,"\nHighest percentage = Reg no : {0}  Name : {1} total: {2} Percentage :{3}",new Object[]{maxPer.regNo,maxPer.name,maxPer.total,maxPer.percent});
    }

    public void highMathsmark(List<Students> lst){
        StudentMaths stuMaths = new StudentMaths();
        Students maxMaths = Collections.max(lst,stuMaths);
        logger.log(Level.INFO,"\nHighest Maths mark = Reg no : {0} Name : {1} Maths mark {2} ",new Object[] {maxMaths.regNo,maxMaths.name,maxMaths.marksInMaths});
    }

    public void descendingInRank(List<Students> lst){
        StudentReverse stuPe = new StudentReverse();
        lst.sort(stuPe);
        for(Students result : lst){
            logger.log(Level.INFO,"{0}",result);
        }
    }

}

class StudentById implements Comparator<Students> {
    @Override
    public int compare(Students s1, Students s2) {
        return s1.getRegNo() - s2.getRegNo();
    }
}
class StudentPerct implements Comparator<Students>{
    @Override
    public int compare(Students o1, Students o2) {
        return (int) (o1.getPercent()-o2.getPercent());
    }
}
class StudentMaths implements Comparator<Students> {

    @Override
    public int compare(Students o1, Students o2) {
        return o1.getMarksInMaths()-o2.getMarksInMaths();
    }
}
class StudentReverse implements Comparator<Students> {

    @Override
    public int compare(Students o1, Students o2) {
        return Double.compare(o2.percent, o1.percent);
    }
}


public class Exercise1 {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        ArrayList<Students> markList = new ArrayList<>(n);
        ArrayList<Integer> regNo= new ArrayList<>(n);
        ArrayList<String> name= new ArrayList<>(n);
        ArrayList<Integer> eng= new ArrayList<>(n);
        ArrayList<Integer> maths= new ArrayList<>(n);
        ArrayList<Integer> sci= new ArrayList<>(n);
        ArrayList<Integer> total= new ArrayList<>(n);
        ArrayList<Double> percent= new ArrayList<>(n);

        for(int i=0;i<n;i++){
            regNo.add(Integer.parseInt(sc.nextLine()));
            name.add(sc.nextLine());
            eng.add(Integer.parseInt(sc.nextLine()));
            maths.add(Integer.parseInt(sc.nextLine()));
            sci.add(Integer.parseInt(sc.nextLine()));
        }

        for(int i=0;i<n;i++){
            total.add(eng.get(i)+maths.get(i)+sci.get(i));
            percent.add(Double.valueOf(((eng.get(i)+maths.get(i)+sci.get(i))/3)));
        }

        for(int i=0;i<n;i++){
            markList.add(new Students(regNo.get(i),name.get(i),eng.get(i),maths.get(i),sci.get(i), total.get(i),percent.get(i)));

        }


        Standard std = new Standard();
        std.sortById(markList);
        std.highPercent(markList);
        std.highMathsmark(markList);
        std.descendingInRank(markList);

    }
}
