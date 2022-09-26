package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

class Student{
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
public class Exercise6 {
    static Logger logger = Logger.getLogger(Exercise6.class.getName());
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        Queue<Student> students = new LinkedList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> score = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            names.add(sc.next());
            score.add(sc.nextInt());
            students.add(new Student(names.get(i), score.get(i)));
        }
        logger.info("Before sorting...");
        logger.log(Level.INFO,"{0}",students);
        logger.info("List based on high score...");
        logger.log(Level.INFO,"{0}",students.stream().sorted((s1,s2)->s2.getScore()-s1.getScore()).collect(Collectors.toList()));

    }
}
