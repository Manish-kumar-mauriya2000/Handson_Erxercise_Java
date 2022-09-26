package classes_methods;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise9 {
    static Logger logger=Logger.getLogger(Exercise9.class.getName());
    public static void generatePassword(String uniChar){
        StringBuilder sb = new StringBuilder();
        sb.append(uniChar);
        String revUniChar=sb.reverse().toString();
        logger.log(Level.INFO, "Reversing all unicode : {0}",revUniChar);
        Long intConvetChar=Long.valueOf(revUniChar);
        Integer lenIntConvertChar=(String.valueOf(intConvetChar).length());
        while(lenIntConvertChar>5){
            intConvetChar=intConvetChar/5;
            lenIntConvertChar=(String.valueOf(intConvetChar).length());
        }
        logger.log(Level.INFO,"After divided by 5 until length is five : {0}",intConvetChar);

        logger.log(Level.INFO,"Octal notation : {0}",Long.toOctalString(intConvetChar));
        logger.log(Level.INFO,"Hexa notation : {0}",Long.toHexString(intConvetChar));

    }
    public static void main(String[] args){

        String name="Manish";
        String uniChar="";
        char[] ch=name.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int cha=ch[i];
            uniChar+=(cha);
        }
        logger.log(Level.INFO,"Unicode for {0} is : {1}",new String[] {name,uniChar});
        Exercise9.generatePassword(uniChar);

    }
}
