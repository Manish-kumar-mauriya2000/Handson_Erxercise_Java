package inheritance;


import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Database{
    public static final Logger logger = Logger.getLogger(Database.class.getName());
    private String username;
    private String password;
    private String url;
    static int count = 0;
    public static final int MAX_CONNECTION=5;

    public Database(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public Database() {
    }


    public String display(){
        return "{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
class Oracle extends Database{

    public Oracle(String username, String password, String url) {
        super(username, password, url);
    }

    public Oracle() {
        count=count+1;
    }

    public Oracle getInstance(String username, String password, String url) throws InvalidObjectException {
        if(count<=MAX_CONNECTION){
            logger.log(Level.INFO,"Oracle Object added :{0} ",count);
        }
        else throw new InvalidObjectException("Not able to create more than five objects");
        return new Oracle(username, password, url);
    }

}

class MySQL extends Database{

    public MySQL(String username, String password, String url) {
        super(username, password, url);
    }

    public MySQL() {
        count=count+1;
    }
    public MySQL getInstance(String username, String password, String url) throws InvalidObjectException{
        if(count<=MAX_CONNECTION){
            logger.log(Level.INFO," MYSQL Object added :{0} ",count);
        }
        else throw new InvalidObjectException("Not able to create more than 5 object");
        return new MySQL(username, password, url);
    }


}

class SQLServer extends Database{

    public SQLServer(String username, String password, String url) {
        super(username, password, url);

    }
    public SQLServer() {
        count=count+1;
    }
    public SQLServer getInstance(String username, String password, String url) throws InvalidObjectException {
       if(count<=MAX_CONNECTION){
            logger.log(Level.INFO,"SQLServer Object added :{0} ",count);
       }
       else throw new InvalidObjectException("Not able to create more than five object");
       return new SQLServer(username, password,url);
    }

}
public class Exercise6 {
    static Logger logger=Logger.getLogger(Exercise6.class.getName());
    public static void main(String[] args) throws Exception {
        ArrayList<Database> databaseObj=new ArrayList<>();
        databaseObj.add(new Oracle().getInstance("manish","123","oracle/ad/db"));
        databaseObj.add(new Oracle().getInstance("kumar","1234","oracle/ad/db1"));
        databaseObj.add(new MySQL().getInstance("ram","123456","mysql/ad/db2"));
        databaseObj.add(new MySQL().getInstance("prabhu","123098","mysql/ad/db5"));
        databaseObj.add(new SQLServer().getInstance("prakash","root","sqlserver/ad/db4"));
        databaseObj.add(new SQLServer().getInstance("praka","root1","sqlserver/ad/db6"));
        for(Database db :databaseObj){
            logger.log(Level.INFO,"{0}",db.display());
        }

    }
}
