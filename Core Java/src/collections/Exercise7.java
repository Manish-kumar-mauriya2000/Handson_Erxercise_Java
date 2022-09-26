package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise7 {
    static Logger logger = Logger.getLogger(Exercise7.class.getName());
    public static void main(String[] args){
        ArrayList<Integer> employeeIdList= new ArrayList<>(Arrays.asList(1,2,6,3,4,5,6,7,9,4));
        logger.info("outstanding for 2 consecutive years");
        Set<Integer> consecutiveYearList= new HashSet<>();
        for(Integer employeeId : employeeIdList){
            if(!consecutiveYearList.add(employeeId)){
                logger.log(Level.INFO,"Employee id : {0}",employeeId);
            }
        }
    }
}
