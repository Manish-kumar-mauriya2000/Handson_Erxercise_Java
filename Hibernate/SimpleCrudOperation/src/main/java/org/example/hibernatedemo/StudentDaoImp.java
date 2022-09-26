package org.example.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDaoImp implements StudentDao{
    static Logger logger = Logger.getLogger(StudentDaoImp.class.getName());
    @Override
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(student);
            logger.info("Student inserted successfully!!!!");
            transaction.commit();

        }catch(Exception e){
            logger.log(Level.INFO,"{0}",Arrays.toString(e.getStackTrace()));
        }
   }

    @Override
    public void updateStudent(long id,String name,String city) {
        Transaction transaction = null;
        Student student = null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            student=session.get(Student.class,id);
            student.setName(name);
            student.setCity(city);
            session.update(student);
            transaction.commit();
            logger.info("Employee Updated!!!");

        }catch(Exception e){
            logger.log(Level.INFO,"{0}",Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void getStudentId(long id) {
        Transaction transaction = null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Student student= session.get(Student.class,id);
            logger.log(Level.INFO,"{0}",student);
            transaction.commit();
        }catch(Exception e){
            logger.log(Level.INFO,"{0}",e.getStackTrace());
        }

    }

    @Override
    public List<Student> getAllStudents() {
        Transaction transaction;
        List<Student> studentList=null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            studentList =session.createQuery("from Student").list();
            transaction.commit();
        }catch(Exception e){
            logger.log(Level.INFO,"{0}",Arrays.toString(e.getStackTrace()));
        }
        return studentList;
    }

    @Override
    public void deleteStudent(long id) {
        Transaction transaction = null;
        Student student=null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            student = session.get(Student.class, id);
            session.delete(student);
            transaction.commit();
            logger.info("Deleted successfully!!!");
            logger.log(Level.INFO,"deleted employee: {0}",student.getName());

        }catch(Exception e){
            logger.log(Level.INFO,"{0}",Arrays.toString(e.getStackTrace()));
        }
    }
}
