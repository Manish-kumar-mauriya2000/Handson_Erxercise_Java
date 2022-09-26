package interface_question;

public interface PhysicalConstants {
     double SPEED_OF_LIGHT=299792458;
     double GRAVITATIONAL=6.67428e-11;
     double STANDARD_GRAVITATIONAL_ACCELERATION=9.80665;

   double energy(double mass);
   double force(double m1,double m2,double r);

   double gravitationalAcc(double t);


}
