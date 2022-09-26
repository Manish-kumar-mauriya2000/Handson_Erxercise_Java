package inheritance;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Connections {
    static final Logger logger = Logger.getLogger(Connections.class.getName());

    private String username;
    private String password;
    private String url;
    private static int count = 1;
    public static final int MAX_CONNECTION=5;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Connections(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
        count++;
    }

    public Connections() {

    }

    @Override
    public String toString() {
        return "Object{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public Connections getConnetion(String username, String password, String url) throws InvalidObjectException {

        if(count<MAX_CONNECTION) logger.log(Level.INFO,"Object added: {0}",count);
        else throw new InvalidObjectException("Not able to create more than 5 connection");
        return new Connections(username, password, url);
    }
}

public class Exercise10 {
    static Logger logger= Logger.getLogger(Exercise10.class.getName());
    public static void main(String[] args){
        ArrayList<Connections> connectionObj=new ArrayList<>();
        try{
            connectionObj.add(new Connections().getConnetion("manish","123","oracle/ad/db"));
            connectionObj.add(new Connections().getConnetion("kumar","1234","oracle/ad/db1"));
            connectionObj.add(new Connections().getConnetion("prabhu","12348","oracle/ad/db2"));
            connectionObj.add(new Connections());
            connectionObj.add(new Connections().getConnetion("siva","12345","oracle/ad/db3"));
            connectionObj.add(new Connections().getConnetion("saran","12349","oracle/ad/db4"));
            connectionObj.add(new Connections().getConnetion("saranT","12349","oracle/ad/db4"));
        } catch (Exception e){
            logger.log(Level.INFO,"{0}",e.getMessage());
        }finally{
            for(Connections conn : connectionObj){
                logger.log(Level.INFO,"{0}",conn);
            }

        }
    }
}
