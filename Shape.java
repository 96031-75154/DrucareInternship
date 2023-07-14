package tasks_abstraction;

public class Shape {

	int length;
	int breadth;
	
	public Shape(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	double square(double side) {
		return side*side;
	}
	double rectangle(int len, int bd) {
		return len*bd;
	}
	public static void main(String[] args) {
		Shape shape = new Shape(5, 8);
		System.out.println("Area of rectangle : "+shape.rectangle(shape.length, shape.breadth));
		System.out.println("Area of square : "+shape.square(shape.length));
	}
}