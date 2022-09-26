package streams;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;


class StringUtils{
    static Logger logger=Logger.getLogger(StringUtils.class.getName());

    public  void listTransformed(List<String> word){
        word.forEach(logger::info);
    }
}

public class BasicStream {
    static Logger logger=Logger.getLogger(BasicStream.class.getName());
    public static void main(String[] args){
        List<String> words= Arrays.asList("hi","hel","manish","exercise","bottom","eye","ant");
        //1
        words.forEach(w -> logger.log(Level.INFO,"{0} ",w));
        //2
        StringUtils stringUtils= new StringUtils();
        stringUtils.listTransformed(words);
        //3
        words.stream().map(w->w+"!").forEach(logger::info);
        words.stream().map(w->w.replace("i","eye")).forEach(logger::info);
        words.stream().map(String::toUpperCase).forEach(logger::info);
        //4
        words.stream().filter(w->w.length()<4).forEach(logger::info);
        words.stream().filter(w->w.contains("b")).forEach(logger::info);
        words.stream().filter(w->w.length()%2==0).forEach(logger::info);

        //5
        words.stream().map(String::toUpperCase).filter(w-> w.length()<4 && w.contains("E")).forEach(logger::info);
        words.stream().map(String::toUpperCase).forEach(w->{
            if(w.length()<4 && w.contains("Q")){
                logger.log(Level.INFO,"{0}",w);
            }
        });

        //6
        Stream<String> newStream=words.stream().map(String::toUpperCase).filter(w-> w.length()<4 && w.contains("E"));
        newStream.forEach(word->logger.log(Level.INFO, "lazy start evaluate when terminal reached - {0}",word));


        //7
        String[] arr = {"hi","hel","manish","exercise","bottom"};
        Arrays.stream(arr).map(w->w.replace("i","eye")).forEach(logger::info);
    }
}
