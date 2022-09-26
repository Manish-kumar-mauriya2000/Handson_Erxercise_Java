package org.example.exercise5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentProfile {
    static Logger logger=Logger.getLogger(StudentProfile.class.getName());
    @Autowired
    @Qualifier("student2")
    private Student student;

    public StudentProfile() {
        logger.info("Inside profile constructor");
    }

    public void printProfile(){
        logger.log(Level.INFO,"\nId : {0}\nName : {1}\nCity : {2}\n",new Object[]{student.getId(),student.getName(),student.getCity()});
    }

}
