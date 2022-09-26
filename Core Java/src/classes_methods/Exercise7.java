package classes_methods;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise7 {
    static Logger logger=Logger.getLogger(Exercise7.class.getName());
    public static void main(String[] args){

        String str1="Eat";
        String str2="ate";

        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

       if(str1.length()==str2.length()){
           char[] char1=str1.toCharArray();
           char[] char2=str2.toCharArray();

           Arrays.sort(char1);
           Arrays.sort(char2);

           boolean result=Arrays.equals(char1,char2);
           if(result){
               logger.log(Level.INFO,"{0} and {1} are anagram.",new String[] {str1,str2});
           }
           else{
               logger.log(Level.INFO,"{0} and {1} are not anagram.",new String[] {str1,str2});
           }
       }
       else{
           logger.log(Level.INFO,"{0} and {1} are not anagram.",new String[] {str1,str2});
       }


    }
}
