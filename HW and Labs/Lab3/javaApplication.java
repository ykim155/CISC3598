package Lab3;

public class javaApplication {
    public static void main(String[] args){
        vehicle v = new vehicle();
        suv s = new suv();
        tank t = new tank();
        trolley tr = new trolley();

        System.out.println("Vehicle Class");
        v.setSpeed(10);
        System.out.println("Speed: " + v.speed);
        v.turnLeft();
        v.turnRight();
        System.out.println("");

        System.out.println("SUV Class");
        s.setSpeed(15);
        System.out.println("Speed: " + s.speed);
        s.turnLeft();
        s.turnRight();
        System.out.println("");

        System.out.println("Tank Class");
        t.setSpeed(20);
        System.out.println("Speed: " + t.speed);
        t.turnLeft();
        t.turnRight();
        System.out.println("");

        System.out.println("Trolley Class");
        tr.setSpeed(25);
        System.out.println("Speed: " + tr.speed);
        tr.turnLeft();
        tr.turnRight();
        System.out.println("");
    }
}
