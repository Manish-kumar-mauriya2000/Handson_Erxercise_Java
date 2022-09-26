package multi_threading;

import java.util.logging.Level;
import java.util.logging.Logger;


class Vehicle{
    private int vehicleNumber;
    private boolean flag = false;
    static Logger logger = Logger.getLogger(Vehicle.class.getName());
    public int getVehicleNumber() {
        return vehicleNumber;
    }


    public boolean isFlag() {
        return flag;
    }


    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public synchronized void crossBridge(int vehicleNumber) throws InterruptedException {

        while (flag){
            logger.log(Level.INFO, "waiting to cross the bridge");
            wait();
        }

        this.vehicleNumber = vehicleNumber;
        logger.log(Level.INFO, "Vechicle {0} crosses the bridge",this.vehicleNumber);
        flag = true;
        notifyAll();
    }

    public synchronized void payToll(int vehicleNumber) throws InterruptedException {
        while (!flag){
            logger.log(Level.INFO, "waiting to pay toll");
            wait();
        }

        this.vehicleNumber = vehicleNumber;
        logger.log(Level.INFO, "Vechicle {0} pays the toll",this.vehicleNumber);
        flag = false;
        notifyAll();
    }
}

class Bridge extends Thread{
    private Vehicle vehicle;
    static Logger logger = Logger.getLogger(Bridge.class.getName());
    public Vehicle getVehicle() {
        return vehicle;
    }



    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }



    public Bridge(Vehicle vehicle) {
        super();
        this.vehicle = vehicle;
    }


    @Override
    public void run() {
        for(int i=1;i<=6;i++) {
            try {
                this.vehicle.crossBridge(i);
                Thread.sleep(2000);
            }catch(InterruptedException e) {
                logger.log(Level.WARNING, "Interrupted!", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}

class TollBooth extends Thread{
    private Vehicle vehicle;
    static Logger logger = Logger.getLogger(TollBooth.class.getName());


    public Vehicle getVehicle() {
        return vehicle;
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public TollBooth(Vehicle vehicle) {
        super();
        this.vehicle = vehicle;
    }


    @Override
    public void run() {
        for(int i=1;i<=5;i++) {
            try {
                this.vehicle.payToll(i);
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                logger.log(Level.WARNING, "Interrupted!", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Bridge bridge = new Bridge(vehicle);
        TollBooth toll = new TollBooth(vehicle);
        bridge.start();
        toll.start();
    }
}
