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

public class Parallelogram extends Trapezoid
{

	// initializing variables
	private double top = getTopDist(); // top side distance version 4
	private double rtside = getRTSideDist(); // right side distance version 4
	private double bottom = getBottomDist(); // bottom side distance version 4
	private double lfside = getLFSideDist(); // left side distance version 4

	// Parallelogram are in the middle of the hierarchy

	// information below taken from https://www.mathsisfun.com/geometry/parallelogram.html
	// Opposite sides are parallel
	// Opposite sides are equal in length
	// Opposite angles are equal (angles A are the same, and angles B are the same)
	// Angle A and angle B add up to 180°, so they are supplementary angles.
	// Area = b × h
	// Perimeter = 2(b+s)

	public Parallelogram(double point1x, double point1y, double point2x, double point2y,
			double point3x, double point3y, double point4x, double point4y)
	{
		// copy the super from Quadrilateral since we are using the same references
		super(point1x, point1y, point2x, point2y,
				point3x, point3y, point4x, point4y);
	}

	public boolean isParallelogram(double top, double lfside, double bottom, double rtside)
	{
		// IAW https://www.onlinemath4all.com/how-to-check-if-the-given-points-form-a-parallelogram.html#content_43691473
		if ( (top == bottom && lfside == rtside) &&
				(getP1().getX() == getP2().getX() && getP3().getX() == getP4().getX() ) ||
				(getP1().getY() == getP2().getY() && getP3().getY() == getP4().getY() ) )
			return true;
		else
			return false;
	}

	public double getParaArea(double top, double lfside, double bottom, double rtside)
	{
		// option 1
		// point layout should be as follows:
		// top left = point1, top right = point2, bottom right = point3 and bottom left = point4 (it's all clockwise)
		// since parallelograms have two equal triangles within it.
		// from https://www.java67.com/2016/10/how-to-calculate-area-of-triangle-in.html
		// formula is ( (Ax * (By - Cy)) + (Bx * (Cy - Ay) ) + (Cx * (Ay - By)) ) / 2
		if(isParallelogram( top, lfside, bottom, rtside) )
		{
		double triArea = ( (getP1().getX() * (getP2().getY() - getP4().getY() ) ) +
				(getP2().getX() * (getP4().getY() - getP1().getY() ) ) +
				(getP4().getX() * (getP1().getY() - getP2().getY() ) ) ) / 2;
		double paraArea = triArea * 2;
		return paraArea;
		}
		else
		{
			return -1;
		}
		
//		// option 2
//		double parx1 = getP1().getX();
//		//double pary1 = getP1().getY();
//		double parx2 = getP2().getX();
//		double pary2 = getP2().getY();
//		//double parx3 = getP3().getX();
//		//double pary3 = getP3().getY();
//		double parx4 = getP4().getX();
//		//double pary4 = getP4().getY();
//		
//		if(isParallelogram( top, lfside, bottom, rtside) )
//		{
//			// try first formula and see. if not, try the second formula
//			double areaPar1 = (Math.abs( (parx2 - parx1) * (pary2 - parx2) - (pary2 - parx2) *(parx4 - parx1) ) );
////			double areaPar2 = 0.5 * (Math.abs( (parx1 * pary2) + (parx2 * pary3) + (parx3 * pary4) + (parx4 * pary1)
////			- (parx2 * pary1) - (parx3 * pary2) - (parx4 * pary3) - (parx1 * pary4) ) );
//			return areaPar1;
//		}
//		return -1;
	}

	public double getHeight()
	{
		if(top > lfside) // then top will be the base
		{
			// formula of height = area / base taken from area = base * height
			double height = getParaArea(top, lfside, bottom, rtside) / top;
			return height;
		}
		else // then lfside will be the base
		{
			// formula of height = area / base taken from area = base * height
			double height = getParaArea(top, lfside, bottom, rtside) / lfside;
			return height;
		}
	}
	
	public double getWidth()
	{
		if(top > lfside) // then top well be the base/width
			return top;
		else // then lfside well be the base/width
			return lfside;
	}
	
public String toString()
{
	return String.format("Parallelogram Coordinates are: %s%n Width is: %.1f%n Height is: %.1f%n Area of the Parallelogram is: %.1f%n",
			coordtoString(), getWidth(), getHeight(), getParaArea(top, lfside, bottom, rtside) );
	// need to get Width, get Height and Area
}

	// ********************************************
	// Additional info and references

	// https://www.geeksforgeeks.org/check-whether-four-points-make-parallelogram/
//	// C++ code to test whether four points make a 
//	// parallelogram or not
//	#include <bits/stdc++.h>
//	using namespace std;
//	  
//	// structure to represent a point
//	struct point {
//	    double x, y;
//	    point() { }
//	    point(double x, double y)
//	        : x(x), y(y) { }
//	  
//	    // defining operator < to compare two points
//	    bool operator<(const point& other) const
//	    {
//	        if (x < other.x) {
//	            return true;
//	        } else if (x == other.x) {
//	            if (y < other.y) {
//	                return true;
//	            }
//	        }
//	        return false;
//	    }
//	};
//	  
//	// Utility method to return mid point of two points
//	point getMidPoint(point points[], int i, int j)
//	{
//	    return point((points[i].x + points[j].x) / 2.0, 
//	                (points[i].y + points[j].y) / 2.0);
//	}
//	  
//	// method returns true if point of points array form 
//	// a parallelogram
//	bool isParallelogram(point points[])
//	{ 
//	    map<point, vector<point> > midPointMap;
//	  
//	    // looping over all pairs of point to store their
//	    // mid points
//	    int P = 4;
//	    for (int i = 0; i < P; i++) {
//	        for (int j = i + 1; j < P; j++) {
//	            point temp = getMidPoint(points, i, j);
//	  
//	            // storing point pair, corresponding to
//	            // the mid point
//	            midPointMap[temp].push_back(point(i, j));
//	        }
//	    }
//	  
//	    int two = 0, one = 0;
//	  
//	    // looping over (midpoint, (corresponding pairs)) 
//	    // map to check the occurence of each midpoint
//	    for (auto x : midPointMap) {
//	          
//	        // updating midpoint count which occurs twice
//	        if (x.second.size() == 2) 
//	            two++;
//	          
//	        // updating midpoing count which occurs once
//	        else if (x.second.size() == 1) 
//	            one++;
//	          
//	        // if midpoint count is more than 2, then 
//	        // parallelogram is not possible
//	        else
//	            return false;     
//	    }
//	  
//	    // for parallelogram, one mid point should come 
//	    // twice and other mid points should come once
//	    if (two == 1 && one == 4) 
//	        return true;
//	      
//	    return false;
//	}

} // end class Parallelogram
