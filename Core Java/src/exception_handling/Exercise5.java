package exception_handling;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class A{
    public void function(List<Integer> list){
        list.add(null);
    }
}

public class Exercise5 {
    static final Logger logger= Logger.getLogger(Exercise5.class.getName());
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        A nullObject = new A();
        Exercise5 ex5=new Exercise5();
        nullObject.function(ex5.list);
        logger.log(Level.INFO,"{0}",ex5.list.size());
    }
}
