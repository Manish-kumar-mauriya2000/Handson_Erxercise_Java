package classes_methods;

import java.util.logging.Level;
import java.util.logging.Logger;

class StringOperation {
    static Logger logger=Logger.getLogger(StringOperation.class.getName());

    public void print12thIndex(String str) {
        logger.log(Level.INFO,"The character at {0} index is : {1}", new Object[] {12,str.charAt(12)});
    }

    public void checkStringWord(String str) {
        boolean res = str.contains("is");
        if (res) {
            logger.info("Element found....");
        } else logger.info("Element not found...");
    }

    public void concatenate(String str) {
        logger.log(Level.INFO,"{0}",str.concat(" and killed it "));
    }

    public void stringEndWord(String str) {
        boolean res = str.endsWith("dogs");
        if (res) logger.info("The string end with dogs");
        else logger.info("Not end with dogs!!!!");
    }

    public void stringEqual(String str) {
        if (str.equals("The quick brown Fox jumps over the lazy Dog")) logger.info("String matched");
        else logger.info("False : Not matched");
    }

    public void stringEqual2(String str) {
        if (str.equals("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG")) logger.info("True");
        else logger.info("False");
    }

    public void stringLength(String str) {
        logger.log(Level.INFO,"The length of the string is : {0}",str.length());
    }

    public void stringMatch(String str) {
        boolean res = str.matches("The quick brown Fox jumps over the lazy Dog");
        if (res) logger.info("string matched...");
        else logger.info("String not matched!!!!");
    }

    public void stringReplace(String str) {
        String afterRepalce = str.replace("The", "A");
        logger.log(Level.INFO,"After replacing the string : {0}",afterRepalce);
    }

    public void splitString(String str) {
        String[] st = str.split("jumps");
        for (String res : st) {
            logger.log(Level.INFO,"{0}",res);
        }
    }

    public void printAnimal(String str) {
        String ani1="fox";
        String ani2="dog";
        int a1=str.indexOf(ani1);
        int a2=str.indexOf(ani2);
        if(a1>0 && a2>0){
            logger.log(Level.INFO,"{0}",str.substring(a1,a1+ani1.length()));
            logger.log(Level.INFO,"{0}",str.substring(a2,a2+ani2.length()));
        }
        else logger.info("Animal not found....");
    }

    public void upperLower(String str) {
        logger.log(Level.INFO,"{0}",str.toUpperCase());
        logger.log(Level.INFO,"{0}",str.toLowerCase());

    }
    public void firstLastIndex(String str) {
        logger.log(Level.INFO,"The position of the a is :{0}",str.indexOf("a"));
        logger.log(Level.INFO,"The position of last index of e is : {0}",str.lastIndexOf("e"));
    }
}

public class Exercise5 {
    public static void main(String[] args){
        StringOperation sp = new StringOperation();
        String str="The quick brown fox jumps over the lazy dog";
        sp.print12thIndex(str);
        sp.checkStringWord(str);
        sp.concatenate(str);
        sp.stringEndWord(str);
        sp.stringEqual(str);
        sp.stringEqual2(str);
        sp.stringLength(str);
        sp.stringMatch(str);
        sp.stringReplace(str);
        sp.splitString(str);
        sp.printAnimal(str);
        sp.upperLower(str);
        sp.firstLastIndex(str);


    }
}
