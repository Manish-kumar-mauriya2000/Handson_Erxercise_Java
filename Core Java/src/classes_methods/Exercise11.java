package classes_methods;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class AppUser{
    private static String protertyFileName;
    private static String urlUser;
    String username;
    String password;

    static{
        urlUser = "jdbc:mysql://localhost:3306/Test";
        protertyFileName="com.mysql.jdbc.Driver";
    }


    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "URL='" + urlUser + '\'' +
                ", Property File Name='" + protertyFileName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
public class Exercise11 {
   static Logger logger = Logger.getLogger(Exercise11.class.getName());
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        ArrayList<AppUser> user= new ArrayList<>(2);
        ArrayList<String> username= new ArrayList<>(2);
        ArrayList<String> password= new ArrayList<>(2);

        for (int i = 0; i < 2; i++) {
            logger.info("Enter Username : ");
            username.add(sc.nextLine());
            logger.info("Enter Password : ");
            password.add(sc.nextLine());
        }
        for (int i = 0; i < 2; i++) {
            user.add(new AppUser(username.get(i),password.get(i)));
        }
        for (AppUser userDetail:user) {
            logger.log(Level.INFO,"{0}",userDetail);
        }
    }
}
