package inheritance;
import inheritance.material.Accessories;
import inheritance.material.Laptop;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise3 {
    static Logger logger=Logger.getLogger(Exercise3.class.getName());
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Laptop[] lap = new Laptop[5];
        lap[0] = new Laptop(8,1001,"DELL","Black");
        lap[1] = new Laptop(10,1002,"LENOVO","White");
        lap[2] = new Laptop(20,1003,"HP","Blue");
        lap[3] = new Laptop(12,1004,"ACER","Purple");
        lap[4] = new Laptop(6,1005,"ASUS","Red");
        Accessories[] accessories=new Accessories[10];
        accessories[0]=new Accessories(7,2001,"watch");
        accessories[1]=new Accessories(9,2002,"pencil");
        accessories[2]=new Accessories(5,2003,"Note");
        accessories[3]=new Accessories(20,2004,"Scale");
        accessories[4]=new Accessories(15,2005,"Sketch pencil");
        accessories[5]=new Accessories(25,2006,"chart");
        accessories[6]=new Accessories(22,2007,"Colour pencil");
        accessories[7]=new Accessories(18,2008,"Tape");
        accessories[8]=new Accessories(10,2009,"Gum");
        accessories[9]=new Accessories(9,2010,"Pen");
        logger.log(Level.INFO,"{0}",Arrays.toString(lap));
        logger.info("Enter Unique Id : ");
        int uid=Integer.parseInt(sc.nextLine());
        logger.info("Enter the Quantity : ");
        int quantity=Integer.parseInt(sc.nextLine());
        if(uid>1000 && uid<=1005){
            for(int i=0;i<5;i++){
                if((lap[i].getUniqueId()==uid) && (lap[i].getQuantity()>lap[i].getLowOrderLevelQuantity())){
                    logger.log(Level.INFO,"\n========================================================\n uniqe ID: {0} \nBrand name : {1} \nColor : {2}\nQuantity bought : {3}\n========================================================",new Object[]{lap[i].getUniqueId(),lap[i].getBrand(),lap[i].getColour(),quantity});
                    lap[i].setQuantity(lap[i].getQuantity()-quantity);
                    break;
                }
                else if(lap[i].getUniqueId() == uid && lap[i].getQuantity()<=lap[i].getLowOrderLevelQuantity()){
                    logger.info("Request for item needed!!!!!!!!");
                    break;
                }
            }
        }
        else if(uid>2000 && uid <= 2010){
            for (int i = 0; i < 10; i++) {
                if(accessories[i].getUniqueId() == uid && accessories[i].getQuantity()>accessories[i].getLowOrderLevelQuantity()) {
                   logger.log(Level.INFO,"\n========================================================\n uniqe ID:{0}\n Brand name :{1} \n Quantity bought :{2} \n======================================================== ",new Object[] {accessories[i].getUniqueId(),accessories[i].getName(),quantity});
                   accessories[i].setQuantity(accessories[i].getQuantity()-quantity);
                   break;
                }
                else if(accessories[i].getUniqueId() == uid&&accessories[i].getQuantity()<=accessories[i].getLowOrderLevelQuantity()) {
                    logger.info("Request for the item needed!!!!!");
                    break;
                }
            }
        }
        else{
            logger.info("Invalid Id!!!!!!");
        }
    }


}
