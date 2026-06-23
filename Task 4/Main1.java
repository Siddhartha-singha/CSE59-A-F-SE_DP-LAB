
public class Main{
    public static void main(String[] args){
        Shape[] myShapes = new Shape[]{
            new Rectangle(5,4),
            new Circle(3),
            new Triangle(3,4)
        };
        AreaCalculator calculator = new AreaCalculator();
        double total = calculator.calculateTotalArea(myShapes);
        System.out.println("The total area is:" + total);
    }
} 

public interface Shape{
    double calculateArea();
}

class Rectangle implements Shape{
    public double length;
    public double width;
    
    public Rectangle (double length, double w) 
    {
        this.length = length;
        this.width = w;
    }
    public double calculateArea(){
        return length * width;
    }
}
class Circle implements  Shape{
    public double radius;
    public Circle(double r) {this.radius=r;}
    public double calculateArea(){
        return Math.PI* (radius * radius);
    }
} 
class Triangle implements Shape {
    public double base;
    public double height;
    public Triangle(double b, double h) { this.base = b; this.height = h; }
    public double calculateArea() { return 0.5 * base * height; }
}
class AreaCalculator {
    public double calculateTotalArea(Shape[] shapes){
        double totalArea =0;
        for(Shape shape : shapes){
            totalArea +=shape.calculateArea();
        }
        return totalArea;
    }
}
