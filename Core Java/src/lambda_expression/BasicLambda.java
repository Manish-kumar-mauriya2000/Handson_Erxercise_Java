package lambda_expression;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class Utils{
    public static int compareByLength(String s1, String s2){
        return s1.length()-s2.length();
    }
    public static int helper(String s1,String s2) {
        if (s1.contains("e") && s2.contains("e"))
            return 0;
        else if (s1.contains("e"))
            return -1;
        else
            return 1;
    }

    private Utils() {
    }
}

public class BasicLambda {
    static Logger logger=Logger.getLogger(BasicLambda.class.getName());
    public static void main(String[] args){
        String[] names={"manish","kavin","karthik","eswar","elangovan","hi","hello","apple"};
        logger.info("Sort by length in ascending order");
        Arrays.sort(names,(s1,s2)->s1.length()-s2.length());
        logger.log(Level.INFO,"{0}",Arrays.asList(names));

        logger.info("Sort by length in descending order");
        Arrays.sort(names,(s1,s2)->s2.length()-s1.length());
        logger.log(Level.INFO,"{0}",Arrays.asList(names));

        logger.info("alphabetically by the first character only");
        Arrays.sort(names,(s1,s2)->s1.charAt(0)-s2.charAt(0));
        logger.log(Level.INFO,"{0}",Arrays.asList(names));

        logger.info("Words contain e first");
        Arrays.sort(names, (s1,s2)-> {
            if(s1.contains("e") && s2.contains("e")) {
                return 0;
            }
            return s1.contains("e")?-1:1;

        });
        logger.log(Level.INFO,"{0}",Arrays.asList(names));

        logger.info("Using helper methods:");
        Arrays.sort(names, Utils::compareByLength);
        logger.log(Level.INFO,"{0}",Arrays.asList(names));

        Arrays.sort(names,(s2,s1)->Utils.compareByLength(s1,s2));
        logger.log(Level.INFO,"{0}",Arrays.asList(names));

        Arrays.sort(names, Utils::helper);
        logger.log(Level.INFO,"{0}",Arrays.asList(names));
    }
}
