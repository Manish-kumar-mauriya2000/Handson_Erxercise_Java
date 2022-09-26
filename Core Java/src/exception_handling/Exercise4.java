package exception_handling;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise4 {
    static Logger logger= Logger.getLogger(Exercise4.class.getName());
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        logger.log(Level.INFO,"List : {0}",list);
        List<Integer> clone;
        clone= (LinkedList) list.clone();
        logger.log(Level.INFO,"Clone List : {0}",clone);
    }
}
