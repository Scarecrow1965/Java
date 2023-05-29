// Exercise 9.8
/*(Quadrilateral Inheritance Hierarchy)
 Write an inheritance hierarchy for classes Quadrilateral, Trapezoid, Parallelogram, Rectangle and Square.
 Use Quadrilateral as the superclass of the hierarchy.
 Create and use a Point class to represent the points in each shape.
 Make the hierarchy as deep (i.e., as many levels) as possible.
 Specify the instance variables and methods for each class.
 The private instance variables of Quadrilateral should be the x-y coordinate pairs for the four endpoints
 of the Quadrilateral.
 Write a program that instantiates objects of your classes and outputs each object’s area (except Quadrilateral).
*/

public class QuadrilateralTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		Quadrilateral quadrilateral = new Quadrilateral(1.1, 1.2, 6.6, 2.8, 6.2, 9.9, 2.2, 7.4);
		Trapezoid trapezoid = new Trapezoid(0.0, 0.0, 10.0, 0.0, 8.0, 5.0, 3.3, 5.0);
		Parallelogram parallelogram = new Parallelogram(5.0, 5.0, 11.0, 5.0, 12.0, 20.0, 6.0, 20.0);
		Rectangle rectangle = new Rectangle(17.0, 14.0, 30.0, 14.0, 30.0, 28.0, 17.0, 28.0);
		Square square = new Square(4.0, 0.0, 8.0, 0.0, 8.0, 4.0, 4.0, 4.0);

		// why don't these work?
		quadrilateral.toString();
		trapezoid.toString();
		parallelogram.toString();
		rectangle.toString();
		square.toString();

		// but this one does
		System.out.printf("%s%n%s%n%s%n%s%n%s%n", quadrilateral, trapezoid, parallelogram, rectangle, square);

	} // end method main

} // end class QuadrilateralTest
