package lambda_expression;

import java.util.logging.Level;
import java.util.logging.Logger;

interface TwoStringPredicate{
    public static boolean betterString(String s1,String s2){
        return (s1.length()>s2.length());
    }
}

public class Exercise2 implements TwoStringPredicate {
    static Logger logger=Logger.getLogger(Exercise2.class.getName());
    public static void main(String[] args){
        String s1="Manishkumar";
        String s2="ram";
        logger.log(Level.INFO,"{0}",TwoStringPredicate.betterString(s1,s2)?s1:s2);
    }
}
