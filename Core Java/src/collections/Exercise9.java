package collections;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Treasures{
    static Logger logger = Logger.getLogger(Treasures.class.getName());
    Map<String, List<String>> synonyms =new HashMap<>();

    public Treasures() {
        synonyms.put("viewer", Arrays.asList("observer","onlooker","watcher","looker-on"));
        synonyms.put("power", Arrays.asList("capability","capacity","function","skill"));
        synonyms.put("deployment", Arrays.asList("distribution","formation","classification"));

    }

    public Object synonymWord(String word) throws NoSuchAlgorithmException {

        Random random = SecureRandom.getInstanceStrong();
        int index =random.nextInt(synonyms.values().toArray().length);
        if(synonyms.containsKey(word))
            return synonyms.get(word).get(index);
        return "Word not found...";
    }
    public void dictionary(){
        logger.log(Level.INFO,"{0}",synonyms.keySet());
    }

}
public class Exercise9 {
    static Logger logger = Logger.getLogger(Exercise9.class.getName());
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc=new Scanner(System.in);
        logger.info("List of the words in the dictionary");
        Treasures treasures=new Treasures();
        treasures.dictionary();
        logger.info("Enter the word to find the related meaning : ");
        String findSynonym = sc.nextLine();
        logger.log(Level.INFO,"{0} - {1}",new Object[]{findSynonym,treasures.synonymWord(findSynonym)});

    }
}
