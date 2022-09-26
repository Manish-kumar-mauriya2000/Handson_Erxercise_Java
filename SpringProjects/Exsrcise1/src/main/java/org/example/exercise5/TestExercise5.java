package org.example.exercise5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestExercise5 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("AnnotationConfig.xml");
        StudentProfile studentProfile= (StudentProfile) context.getBean("profile");
        studentProfile.printProfile();
    }
}
