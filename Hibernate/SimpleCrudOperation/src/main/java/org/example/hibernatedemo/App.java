package org.example.hibernatedemo;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class App 
{
    static Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
       Scanner sc=new Scanner(System.in);
        StudentDaoImp studentDaoImp=new StudentDaoImp();
        Student student = new Student();
       logger.info("1 Add Student.\n2 Get Student by ID.\n3 Get all Student.\n4 Update Student by Id.\n5 Delete Student by Id\n6 Exist.");
       while(true){
           logger.info("Enter your choice : ");
           int choice=sc.nextInt();
           if(choice==6){
               logger.info("Thank yoy!!!!");
               System.exit(0);
               break;
           }else{
               switch(choice){
                   case 1:
                       logger.info("Enter student name : ");
                       String name=sc.next();
                       logger.info("Enter student city name : ");
                       String city=sc.next();
                       student.setName(name);
                       student.setCity(city);
                       studentDaoImp.saveStudent(student);
                       break;
                   case 2:
                       logger.info("Enter student id : ");
                       long id=sc.nextLong();
                       studentDaoImp.getStudentId(id);
                       break;
                   case 3:
                       logger.info("Student list.....");
                       List<Student> studentList=studentDaoImp.getAllStudents();
                       studentList.forEach(student1-> logger.log(Level.INFO,"{0}",student1));
                       break;
                   case 4:
                       logger.info("Enter student id : ");
                       long studentId=sc.nextLong();
                       studentDaoImp.getStudentId(studentId);
                       logger.info("Enter the name to update : ");
                       String studentName=sc.next();
                       logger.info("Enter the updated city name :");
                       String studentCity=sc.next();
                       studentDaoImp.updateStudent(studentId,studentName,studentCity);
                       break;
                   case 5:
                       logger.info("Enter the student id to be deleted : ");
                       long delId=sc.nextLong();
                       studentDaoImp.deleteStudent(delId);
                       break;
                   default:
                       logger.info("Your entered a wrong option.....try again..");

               }
           }

       }
    }
}
