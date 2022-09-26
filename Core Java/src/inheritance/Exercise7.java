package inheritance;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Database1{
    public static final Logger logger= Logger.getLogger(Database1.class.getName());
    private String username;
    private String password;
    private String url;
    static int count = 0;
    public static final int MAX_CONNECTION=5;

    protected Database1(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
        count++;
    }

    protected Database1() {
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getUrl() {
        return url;
    }

    public abstract String display();

}
class Oracle1 extends Database1{

    public Oracle1(String username, String password, String url) {
        super(username, password, url);
    }

    public Oracle1() {
        count=count+1;
    }

    public Oracle1 getInstance(String username, String password, String url) throws InvalidObjectException {
        if(count<=MAX_CONNECTION){
            logger.log(Level.INFO,"Oracle Object added :{0} ",count);
        }
        else throw new InvalidObjectException("Not able to create more than five object");
        return new Oracle1(username, password, url);
    }
    @Override
    public String display() {
        return "{" +
                "Oracle username='" + getUsername() + '\'' +
                ",Oracle password='" + getPassword() + '\'' +
                ",Oracle url='" + getUrl() + '\'' +
                '}';
    }

}

class MySQL1 extends Database1{

    public MySQL1(String username, String password, String url) {
        super(username, password, url);
    }

    public MySQL1() {
        count=count+1;
    }

    @Override
    public String display() {
        return "{" +
                "MYSQL username='" + getUsername() + '\'' +
                ",MYSQL password='" + getPassword() + '\'' +
                ",MYSQL url='" + getUrl() + '\'' +
                '}';
    }

    public MySQL1 getInstance(String username, String password, String url) throws InvalidObjectException {
        if(count<=MAX_CONNECTION){
            logger.log(Level.INFO,"MYSQL Object added :{0} ",count);
        }
        else throw new InvalidObjectException("Not able to create more than 5 objects");
        return new MySQL1(username, password, url);
    }
}

class SQLServer1 extends Database1{

    public SQLServer1(String username, String password, String url) {
        super(username, password, url);

    }
    public SQLServer1() {
        count=count+1;
    }

    @Override
    public String display() {
        return "{" +
                "SQLServer username='" + getUsername() + '\'' +
                ",SQLServer password='" + getPassword() + '\'' +
                ",SQLServer url='" + getUrl() + '\'' +
                '}';
    }
    public SQLServer1 getInstance(String username, String password, String url) throws InvalidObjectException {
        if(count<=MAX_CONNECTION){
            logger.log(Level.INFO,"SQLServer Object added :{0} ",count);
        }
        else throw new InvalidObjectException("Not able to create more than 5 object");
        return new SQLServer1(username, password,url);
    }

}

public class Exercise7 {
    static Logger logger=Logger.getLogger(Exercise7.class.getName());
    public static void main(String[] args) throws Exception {
        ArrayList<Database1> databaseObj=new ArrayList<>();
        databaseObj.add(new Oracle1().getInstance("manish","123","oracle/ad/db"));
        databaseObj.add(new Oracle1().getInstance("kumar","1234","oracle/ad/db1"));
        databaseObj.add(new MySQL1().getInstance("ram","123456","mysql/ad/db2"));
        databaseObj.add(new MySQL1().getInstance("prabhu","123098","mysql/ad/db5"));
        databaseObj.add(new SQLServer1().getInstance("prakash","root","sqlserver/ad/db4"));
        databaseObj.add(new SQLServer1().getInstance("praka","root1","sqlserver/ad/db6"));

        for(Database1 db :databaseObj){
            logger.log(Level.INFO,"{0}",db.display());
        }



    }
}
