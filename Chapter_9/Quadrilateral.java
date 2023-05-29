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

public class Quadrilateral
{
	// information below taken from https://www.mathsisfun.com/quadrilaterals.html
	// A quadrilateral has:
	// four sides (edges)
	//four vertices (corners)
	//interior angles that add to 360 degrees.

	// since Quadrilateral is the superclass then the point location must be referred here
	// must use file Point.class to state the four x-y coordinate endpoints
	private Point point1; // 1st x-y coordinate endpoints
	private Point point2; // 2nd x-y coordinate endpoints
	private Point point3; // 3rd x-y coordinate endpoints
	private Point point4; // 4th x-y coordinate endpoints

	//need a constructor for Quadrilateral and must refer to the Point points above
	// point layout should be as follows:
	// top left = point1, top right = point2, bottom right = point3 and bottom left = point4 (it's all clockwise)
	public Quadrilateral(double point1x, double point1y, double point2x, double point2y,
			double point3x, double point3y, double point4x, double point4y)
	{
		point1 = new Point(point1x, point1y); // 1st x-y coordinate endpoints
		point2 = new Point(point2x, point2y); // 2nd x-y coordinate endpoints
		point3 = new Point(point3x, point3y); // 3rd x-y coordinate endpoints
		point4 = new Point(point4x, point4y); // 4th x-y coordinate endpoints
	}

	//since Quadrilateral is the superclass, we need to ensure other subclasses can access the x-y coordinate endpoints
	// must use get methods for each points
	public Point getP1()
	{
		return point1;
	}

	public Point getP2()
	{
		return point2;
	}

	public Point getP3()
	{
		return point3;
	}

	public Point getP4()
	{
		return point4;
	}

	// why don't these work in this class?
//	// point layout should be as follows:
//	// top left = point1, top right = point2, bottom right = point3 and bottom left = point4 (it's all clockwise)
//	public double top = getTopDist(); // top side distance version 4
//	// public double top = point1.getDistance2(point2); // top side distance version 3 (doesn't work)
//	// public double top = getPoint1().getDistance2(getPoint2() ); // top side distance version 2 (doesn't work)
//	// public double top = DistanceMeasure(getPoint1(), getPoint2() ); // top side distance version 1 (doesn't work)
//	public double rtside = getRTSideDist(); // right side distance version 4
//	// public double rtside = point2.getDistance2(point3); // right side distance version 3 (doesn't work)
//	// public double rtside = getPoint2().getDistance2(getPoint3() ); // right side distance version 2 (doesn't work)
//	// public double rtside = DistanceMeasure(getPoint2(), getPoint3() ); // right side distance version 1 (doesn't work)
//	public double bottom = getBottomDist(); // bottom side distance version 4
//	// public double bottom = point3.getDistance2(point4); // bottom side distance version 3 (doesn't work)
//	// public double bottom = getPoint3().getDistance2(getPoint4() ); // bottom side distance version 2 (doesn't work)
//	// public double bottom = DistanceMeasure(getPoint3(), getPoint4() ); // bottom side distance version 1 (doesn't work)
//	public double lfside = getLFSideDist(); // left side distance version 4
//	// public double lfside = point4.getDistance2(point1); // left side distance version 3 (doesn't work)
//	// public double lfside = getPoint4().getDistance2(getPoint1() ); // left side distance version 2 (doesn't work)
//	// public double lfside = DistanceMeasure(getPoint4(), getPoint1() ); // left side distance version 1 (doesn't work)
//	public double diag13 = getDiag13Dist(); // diagonal between point 1 and 3 distance version 4
//	// public double diag13 = point1.getDistance2(point3); // diagonal between point 1 and 3 distance version 3 (doesn't work)
//	// public double diag13 = getPoint1().getDistance2(getPoint3() ); // diagonal between point 1 and 3 distance version 2 (doesn't work)
//	// public double diag13 = DistanceMeasure(getPoint1(), getPoint3() ); // diagonal between point 1 and 3 distance version 1 (doesn't work)
//	public double diag24 = getDiag24Dist(); // diagonal between point 2 and 4 distance version 4
//	// public double diag24 = point2.getDistance2(point4); // diagonal between point 2 and 4 distance version 3 (doesn't work)
//	// public double diag24 = getPoint2().getDistance2(getPoint4() ); // diagonal between point 2 and 4 distance version 2 (doesn't work)
//	// public double diag24 = DistanceMeasure(getPoint2(), getPoint4() ); // diagonal between point 2 and 4 distance version 1 (doesn't work)

	public double getTopDist()
	{
		return Math.sqrt( (getP1().getX() - getP2().getX() ) * (getP1().getX() - getP2().getX() )
				+ (getP1().getY() - getP2().getY() ) * (getP1().getY() - getP2().getY() ) );
	}

	public double getRTSideDist()
	{
		return Math.sqrt( (getP2().getX() - getP3().getX() ) * (getP2().getX() - getP3().getX() )
				+ (getP2().getY() - getP3().getY() ) * (getP2().getY() - getP3().getY()));
	}

	public double getBottomDist()
	{
		return Math.sqrt( (getP3().getX() - getP4().getX() ) * (getP3().getX() - getP4().getX() )
				+ (getP3().getY() - getP4().getY() ) * (getP3().getY() - getP4().getY()));
	}

	public double getLFSideDist()
	{
		return Math.sqrt( (getP4().getX() - getP1().getX() ) * (getP4().getX() - getP1().getX() )
				+ (getP4().getY() - getP1().getY() ) * (getP4().getY() - getP1().getY()));
	}

	public double getDiag13Dist()
	{
		return Math.sqrt( (getP1().getX() - getP3().getX() ) * (getP1().getX() - getP3().getX() )
				+ (getP1().getY() - getP3().getY() ) * (getP1().getY() - getP3().getY()));
	}

	public double getDiag24Dist()
	{
		return Math.sqrt( (getP2().getX() - getP4().getX() ) * (getP2().getX() - getP4().getX() )
				+ (getP2().getY() - getP4().getY() ) * (getP2().getY() - getP4().getY()));
	}

	public String toString()
	{
		return String.format("Quadrilateral Coordinates are: %s%n", coordtoString() );
	}
	
	public String coordtoString()
	{
		return String.format("%s , %s , %s , %s", point1, point2, point3, point4 );
	}

	// ****************************************
	// Additional info and references

	// From https://www.interviewsansar.com/distance-between-two-points-in-java/
//	// this one works across classes
//	public double getDistance2(Point p)
//	{
//		return Math.sqrt((this.getX() - p.getX()) * (this.getX() - p.getX())
//				+ (this.getY() - p.getY()) * (this.getY() - p.getY()));
//	}
	
	//from https://www.geeksforgeeks.org/number-of-quadrilaterals-possible-from-the-given-points/
//	// Java implementation of above approach
//	class GFG
//	{
//	static class Point // points
//	{
//	    int x;
//	    int y;
//	}
//	 
//	// determines the orientation of points
//	static int orientation(Point p, Point q,
//	                                Point r)
//	{
//	    int val = (q.y - p.y) * (r.x - q.x) -
//	              (q.x - p.x) * (r.y - q.y);
//	 
//	    if (val == 0)
//	        return 0;
//	    return (val > 0) ? 1 : 2;
//	}
//	 
//	// check whether the distinct
//	// line segments intersect
//	static boolean doIntersect(Point p1, Point q1,
//	                           Point p2, Point q2)
//	{
//	    int o1 = orientation(p1, q1, p2);
//	    int o2 = orientation(p1, q1, q2);
//	    int o3 = orientation(p2, q2, p1);
//	    int o4 = orientation(p2, q2, q1);
//	 
//	    if (o1 != o2 && o3 != o4)
//	        return true;
//	 
//	    return false;
//	}
//	 
//	// check if points overlap(similar)
//	static boolean similar(Point p1, Point p2)
//	{
//	 
//	    // it is same, we are returning
//	    // false because quadrilateral is
//	    // not possible in this case
//	    if (p1.x == p2.x && p1.y == p2.y)
//	        return false;
//	 
//	    // it is not same, So there is a
//	    // possibility of a quadrilateral
//	    return true;
//	}
//	 
//	// check for collinearity
//	static boolean collinear(Point p1, Point p2,
//	                         Point p3)
//	{
//	    int x1 = p1.x, y1 = p1.y;
//	    int x2 = p2.x, y2 = p2.y;
//	    int x3 = p3.x, y3 = p3.y;
//	 
//	    // it is collinear, we are returning
//	    // false because quadrilateral is not
//	    // possible in this case
//	    if ((y3 - y2) *
//	        (x2 - x1) == (y2 - y1) *
//	                     (x3 - x2))
//	        return false;
//	 
//	    // it is not collinear, So there
//	    // is a possibility of a quadrilateral
//	    else
//	        return true;
//	}
//	 
//	static int no_of_quads(Point p1, Point p2,
//	                       Point p3, Point p4)
//	{
//	    // Checking for cases where
//	    // no quadrilateral = 0
//	 
//	    // check if any of the
//	    // points are same
//	    boolean same = true;
//	    same = same & similar(p1, p2);
//	    same = same & similar(p1, p3);
//	    same = same & similar(p1, p4);
//	    same = same & similar(p2, p3);
//	    same = same & similar(p2, p4);
//	    same = same & similar(p3, p4);
//	 
//	    // similar points exist
//	    if (same == false)
//	        return 0;
//	 
//	    // check for collinearity
//	    boolean coll = true;
//	    coll = coll & collinear(p1, p2, p3);
//	    coll = coll & collinear(p1, p2, p4);
//	    coll = coll & collinear(p1, p3, p4);
//	    coll = coll & collinear(p2, p3, p4);
//	 
//	    // points are collinear
//	    if (coll == false)
//	        return 0;
//	 
//	    // Checking for cases where
//	    // no of quadrilaterals= 1 or 3
//	 
//	    int check = 0;
//	 
//	    if (doIntersect(p1, p2, p3, p4))
//	        check = 1;
//	    if (doIntersect(p1, p3, p2, p4))
//	        check = 1;
//	    if (doIntersect(p1, p2, p4, p3))
//	        check = 1;
//	 
//	    if (check == 0)
//	        return 3;
//	    return 1;
//	}

} // end class Quadrilateral
