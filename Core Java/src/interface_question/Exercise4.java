package interface_question;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

interface Spatial{

}

abstract class  Shape{
    public static final Logger loggerShape = Logger.getLogger(Shape.class.getName());
    public static final double PI=3.14;
    public abstract void area();
    public abstract float volume();

    public abstract String display();
}

class Cube extends Shape implements Spatial{
    private double length;
    private double width;
    private double height;
    private double area;
    private double volume;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cube(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }


    @Override
    public void area(){
        area=(2*length*width) + (2*length*height) + (2*width*height);
    }

    @Override
    public float volume() {
        volume=length*width*height;
        loggerShape.info("Volume = ");
        return (float) volume;
    }

    public String display() {
        area();
        volume();
        loggerShape.log(Level.INFO,"The area of the Cube is : {0}",area);
        loggerShape.log(Level.INFO,"The volume of the Cube is : {0} ",volume);

        return "Cube completed!!!";
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;
    private double area;
    private double volume;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
    }

    @Override
    public void area() {
        area=length*width;
    }

    @Override
    public float volume() {
        volume=-1;
        return (float) volume;
    }
    public String display() {
        area();
        volume();
        loggerShape.log(Level.INFO,"The area of the Rectangle is :{0} ",area);
        loggerShape.log(Level.INFO,"The volume of the Rectangle is : {0}",Math.round(volume));
        return "Rectangle completed!!!";
    }
}

class Triangle extends Shape{
    private double base;
    private double height;
    private double area;
    private double volume;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void area() {
        area=(base*height)/2;
    }

    @Override
    public float volume() {
        volume=-1;
        return (float) volume;
    }
    public String display() {
        area();
        volume();
        loggerShape.log(Level.INFO,"The area of the Triangle is : {0}",area);
        loggerShape.log(Level.INFO,"The volume of the Triangle is :{0} ",Math.round(volume));
        return "Triangle completed";
    }
}

class Sphere extends Shape implements Spatial{
    private double area;
    private double volume;
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Sphere(int radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        area=4*PI*radius*radius;
    }

    @Override
    public float volume() {
        volume=(4*PI*radius*radius*radius)/3;
        loggerShape.info("Volume = ");
        return (float) volume;
    }

    public String display() {
        area();
        volume();
        loggerShape.log(Level.INFO,"The area of the Sphere is :{0} ",area);
        loggerShape.log(Level.INFO,"The volume of the Sphere is :{0} ",volume);
        return "Sphere completed!!!!";
    }
}

public class Exercise4 {
   static Logger logger = Logger.getLogger(Exercise4.class.getName());
   public static void main(String[] args){
        Shape cube = new Cube(12,6,8);
        Shape rectangle = new Rectangle(5,10);
        Shape triangle = new Triangle(8,12);
        Shape sphere = new Sphere(4);
        Shape cube2=new Cube(10,5,9);
        ArrayList<Shape> shapeArrayList= new ArrayList<>();
        shapeArrayList.add(cube);
        shapeArrayList.add(rectangle);
        shapeArrayList.add(triangle);
        shapeArrayList.add(sphere);
        shapeArrayList.add(cube2);
        for (Shape res:shapeArrayList) {
            if(res instanceof Spatial){
                logger.log(Level.INFO,"{0}",res.volume());
            }else {
                logger.log(Level.INFO,"{0}",res.display());
            }
        }

    }


}
