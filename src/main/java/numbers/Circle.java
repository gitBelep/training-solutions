package numbers;

public class Circle {
    private int diameter;
    private final double PI = 3.14;

    public Circle(int d){
        this.diameter = d;
    }

    public double perimeter(){
        return diameter*PI;
    }
    public double area(){
        double r = diameter /2.0;
        return r*r*PI;
    }
}
