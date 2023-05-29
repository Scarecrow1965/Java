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

public class Point
{
	private double x;
	private double y;

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getX()
	{
		return x;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public double getY()
	{
		return y;
	}

	public String toString()
	{
		return String.format("(%.1f, %.1f)", getX(), getY() );
	}

	
	// *************************************
	// calculating distance between two points
	//	 x1=1;y1=1;x2=4;y2=4;
//	    dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	
	// taken from https://www.geeksforgeeks.org/check-given-four-points-form-square/
//	// from point 'p' to point 'q'
//	static int distSq(Point p, Point q)
//	{
//	    return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
//	}
	
} // end class Point
