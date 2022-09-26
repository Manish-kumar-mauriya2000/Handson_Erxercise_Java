package inheritance;


import java.util.logging.Level;
import java.util.logging.Logger;

class Vehicle{
    static Logger loggerVehicle = Logger.getLogger(Vehicle.class.getName());
    private String colour;
    private int noOfWheels;
    private String model;

    public String getColour() {
        return colour;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public String getModel() {
        return model;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vehicle(String colour, int noOfWheels, String model) {
        this.colour = colour;
        this.noOfWheels = noOfWheels;
        this.model = model;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "colour='" + colour + '\'' +
                ", No_of_wheels=" + noOfWheels
                +
                ", model='" + model + '\'' +
                '}';
    }

    public void display(){
        String msg=toString();
        loggerVehicle.log(Level.INFO,"{0}",msg);
    }
}
class Truck extends Vehicle{
    private final int mileage;

    public Truck(String colour, int noOfWheels, String model, int mileage) {
        super(colour, noOfWheels, model);
        this.mileage = mileage;
    }

    @Override
    public void display(){
        super.display();
        loggerVehicle.info("Truck is invoked.....");
        loggerVehicle.log(Level.INFO,"Vehicle mileage :{0} ",mileage);
    }
}
class Car extends Vehicle{
    public Car(String colour, int noOfWheels, String model) {
        super(colour, noOfWheels, model);
    }

    @Override
    public void display(){
        super.display();
        loggerVehicle.info("Car is invoked.....");

    }
}
class Bus extends Vehicle{
    public Bus(String colour, int noOfWheels, String model) {
        super(colour, noOfWheels, model);
    }

    @Override
    public void display(){
        super.display();
        loggerVehicle.info("Bus is invoked.....");

    }
}
public class Exercise2 {
    public static void main(String[] args){
        Vehicle vr=new Truck("red",10,"Ford 260",300);
        vr.display();
        Vehicle v2 =new Car("blue",4,"RD");
        v2.display();
        Vehicle v3 =new Bus("black",6,"Tata");
        v3.display();


    }
}
