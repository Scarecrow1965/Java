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

public class Square extends Parallelogram
{
	// initializing variables
	private double side;
	private double top = getTopDist(); // top side distance version 4
	private double rtside = getRTSideDist(); // right side distance version 4
	private double bottom = getBottomDist(); // bottom side distance version 4
	private double lfside = getLFSideDist(); // left side distance version 4
	// the following lines are commented as I am not verifying a true square
	//	private double diag13 = getDiag13Dist(); // diagonal between point 1 and 3 distance version 4
	//	private double diag24 = getDiag24Dist(); // diagonal between point 2 and 4 distance version 4

	// Square is the base of the hierarchy

	// information below taken from https://www.mathsisfun.com/geometry/square.html
	// All sides are equal in length
	// Each internal angle is 90°
	// Opposite sides are parallel (so it is a Parallelogram).
	// Area = a2 = a × a
	// Area = d2 / 2 (d squared divided by 2)
	// Perimeter = 4a
	// Diagonal "d" = a × √2

	// point layout should be as follows:
	// top left = point1, top right = point2, bottom right = point3 and bottom left = point4 (it's all clockwise)
	public Square(double point1x, double point1y, double point2x, double point2y,
			double point3x, double point3y, double point4x, double point4y)
	{
		// copy the super from Quadrilateral since we are using the same references
		super(point1x, point1y, point2x, point2y,
			point3x, point3y, point4x, point4y);
	}

	//need to figure out if this is a square
	// point layout should be as follows:
	// top left = point1, top right = point2, bottom right = point3 and bottom left = point4 (it's all clockwise)
	public boolean isSquare(double top, double lfside, double bottom, double rtside )
	{

		if (top == 0 || rtside == 0 )
		{
			return false;
		}

		if( top == lfside && rtside == bottom && top == bottom)
		{
			return true;
		}

		// the following commented lines would work only if true square
//		// If lengths if (p1, p2) and (p1, p4) are same, then
//		// following conditions must met to form a square.
//		// 1) Square of length of (p1, p3) is same as twice
//		// the square of (p1, p2)
//		// 2) Square of length of (p2, p3) is same
//		// as twice the square of (p2, p4)
//
//		if (top == rtside && 2 * top == diag13 && 2 * lfside == diag24 )
//		{
//			return true;
//		}
//		// The below two cases are similar to above case
//		if (lfside == bottom && 2 * bottom == diag13 && 2 * top == diag24 )
//		{
//			return true;
//		}
//		if (top == lfside && 2 * top == diag13 && 2 * bottom == diag24 )
//		{
//			return true;
//		}
		return false; // if nothing else is true
	}

	public double getSide()
	{
		return side;
	}

	public void setSide(double top)
	{
		this.side = top;
	}

	public double getSquareArea()
	{
		if(isSquare(top, lfside, bottom, rtside) )
		{
			setSide(top);
		}
		double sqarea = getSide() * getSide();
		return sqarea;
	}

	public String toString()
	{
		return String.format("Square Coordinates are: %s%n Side Length is: %.1f%n Area of the square is: %.1f%n",
				coordtoString(), getSide(), getSquareArea() );
		// need to get Coordinates, Side and Area
	}

	// ********************************************
	// Additional info and references

	// taken from https://www.geeksforgeeks.org/check-given-four-points-form-square/
//	static class Point
//	{
//	    int x, y;
//	 
//	        public Point(int x, int y)
//	        {
//	            this.x = x;
//	            this.y = y;
//	        }
//	     
//	};
	//	// A utility function to find square of distance
//	// from point 'p' to point 'q'
//	static int distSq(Point p, Point q)
//	{
//	    return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
//	}
//	 
//	// This function returns true if (p1, p2, p3, p4) form a
//	// square, otherwise false
//	static boolean isSquare(Point p1, Point p2, Point p3, Point p4)
//	{
//	    int d2 = distSq(p1, p2); // from p1 to p2
//	    int d3 = distSq(p1, p3); // from p1 to p3
//	    int d4 = distSq(p1, p4); // from p1 to p4
//	 
//	    if (d2 == 0 || d3 == 0 || d4 == 0)   
//	        return false;
//	 
//	    // If lengths if (p1, p2) and (p1, p3) are same, then
//	    // following conditions must met to form a square.
//	    // 1) Square of length of (p1, p4) is same as twice
//	    // the square of (p1, p2)
//	    // 2) Square of length of (p2, p3) is same
//	    // as twice the square of (p2, p4)
//	 
//	    if (d2 == d3 && 2 * d2 == d4 && 2 * distSq(p2, p4) == distSq(p2, p3))
//	    {
//	        return true;
//	    }
//	 
//	    // The below two cases are similar to above case
//	    if (d3 == d4 && 2 * d3 == d2 && 2 * distSq(p3, p2) == distSq(p3, p4))
//	    {
//	        return true;
//	    }
//	    if (d2 == d4 && 2 * d2 == d3 && 2 * distSq(p2, p3) == distSq(p2, p4))
//	    {
//	        return true;
//	    }
//	 
//	    return false;
//	}

} // end class Square
