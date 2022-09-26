package java_basic;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise1{
    public static void main(String[] args){
//      1a) Use print and println statements.
        Logger logger = Logger.getLogger(Exercise1.class.getName());
        logger.info("\n  * * *\n   * * \n    *");

//      b) The class file of this program should be automatically placed inside “Design” folder while  compiling.

//      c) Display the version used for compiling.
        logger.log(Level.INFO,"Java version :{0} ",System.getProperty("java.specification.version"));
    }
}