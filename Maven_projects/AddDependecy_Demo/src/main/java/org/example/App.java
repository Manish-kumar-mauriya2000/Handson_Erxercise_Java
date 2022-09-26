package org.example;
import org.mycalculator.com.CalculaorOptions;

/**
 * Hello world!
 *
 */
public class App{

    public static void main( String[] args )
    {
        CalculaorOptions cal=new CalculaorOptions();
        System.out.println( "Dependency Added!!!" );
        System.out.println("Addition of two num is : "+cal.add(2,4));
    }
}
