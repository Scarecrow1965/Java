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

public class Rectangle extends Parallelogram
{
	// initializing variables
	private double length;
	private double width;
	private double top = getTopDist(); // top side distance version 4
	private double rtside = getRTSideDist(); // right side distance version 4
	private double bottom = getBottomDist(); // bottom side distance version 4
	private double lfside = getLFSideDist(); // left side distance version 4

	// Rectangle is second lowest in hierarchy

	// information below taken from https://www.mathsisfun.com/geometry/rectangle.html
	// Opposite sides are parallel and of equal length (so it is a Parallelogram).
	// Each internal angle is 90°
	// Area = a × b
	// a = length, b = width; a > b (a is always greater than b)
	// Perimeter = 2*(a+b)
	// Diagonal "d" = √(a2 + b2)

	// point layout should be as follows:
	// top left = point1, top right = point2, bottom right = point3 and bottom left = point4 (it's all clockwise)
	public Rectangle(double point1x, double point1y, double point2x, double point2y,
			double point3x, double point3y, double point4x, double point4y)
	{
		// copy the super from Quadrilateral since we are using the same references
		super(point1x, point1y, point2x, point2y,
				point3x, point3y, point4x, point4y);
	}

	public void setWidth(double top, double lfside, double bottom, double rtside )
	{
		if( width < 0)
		{
			throw new IllegalArgumentException("integer must be between 0 and 9!!");
		}
		if( isRectangle(top, lfside, bottom, rtside) && top > lfside )
		{
			this.width = lfside;
		}
		else
		{
			this.width = top;
		}
	}

	public void setLength(double top, double lfside, double bottom, double rtside )
	{
		if( length < 0)
		{
			throw new IllegalArgumentException("integer must be between 0 and 9!!");
		}
		if( isRectangle(top, lfside, bottom, rtside) && top > lfside )
		{
			this.length = top;
		}
		else
		{
			this.length = lfside;
		}
	}

	public double getWidth()
	{
		return width;
	}

	public double getLength()
	{
		return length;
	}

	public boolean isRectangle(double top, double lfside, double bottom, double rtside )
	{
		// Square is also a rectangle verification
		if (top == rtside && top == bottom && top == lfside && bottom == lfside
				&& rtside == bottom && rtside == lfside)
		{
			return true;
		}
		//Rectangle verification
		if (top == bottom && lfside == rtside)
		{
			if(top > lfside)
			{
				return true;
			}
			if(top < lfside)
			{
				return true;
			}
			return true;
		}
		// all else that it's not a rectangle nor square
		else
			return false;
	}

	public double getRectArea (double length, double width)
	{
		if (isRectangle( top, lfside, bottom, rtside))
		{
			setWidth( top, lfside, bottom, rtside);
			setLength( top, lfside, bottom, rtside);
		}
		return getWidth() * getLength();
	}

	public String toString()
	{
		return String.format("Rectangle Coordinates are: %s%n Width is: %.1f%n Height is: %.1f%n Area of the rectangle is: %.1f%n",
				coordtoString(), getWidth(), getLength(), getRectArea( getLength(), getWidth() ) );
		// need to get coordinates, Width, Height and Area
	}

	// ****************************************
	// Additional Information and references
//	def isRectangle(a1, a2, b1, b2, c1, c2, d1, d2):
//
//	    # A = (a1, a2), B = (b1, b2), C = (c1, c2), D = (d1, d2) -> points
//	    AB = int(math.pow(b1-a1, 2) + math.pow(b2-a2, 2))
//	    BC = int(math.pow(b1-c1, 2) + math.pow(b2-c2, 2))
//	    CD = int(math.pow(c1-d1, 2) + math.pow(c2-d2, 2))
//	    DA = int(math.pow(d1-a1, 2) + math.pow(d2-a2, 2))
//	    AC = int(math.pow(c1-a1, 2) + math.pow(c2-a2, 2))
//	    BD = int(math.pow(b1-d1, 2) + math.pow(b2-d2, 2))
//
//	    if AB^BC^CD^DA^AC^BD == 0:
//	        return True
//	    return False

	// https://www.geeksforgeeks.org/check-given-four-integers-sides-make-rectangle/?ref=rp
//	// Function to check if the given
//    // integers value make a rectangle
//    static boolean isRectangle(int a, int b, int c, int d)
//    {
//        // Square is also a rectangle
//        if (a == b && a == c && a == d && c == d && b == c && b == d)
//            return true;
//     
//        else if (a == b && c == d)
//            return true;
//        else if (a == d && c == b)
//            return true;
//        else if (a == c && d == b)
//            return true;
//        else
//            return false;
//    }

	//https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/391-perfect-rectangle.html
//	 public boolean isRectangleCover(int[][] rectangles) {
//    int blox = Integer.MAX_VALUE, bloy = Integer.MAX_VALUE, trix = Integer.MIN_VALUE, triy = Integer.MIN_VALUE;
//    int area = 0;
//    HashMap<String, Integer> data = new HashMap<String, Integer>();
//    for (int i = 0; i < rectangles.length; i ++) {
//        int[] rect = rectangles[i];
//        blox = Math.min(blox, rect[0]);
//        bloy = Math.min(bloy, rect[1]);
//        trix = Math.max(trix, rect[2]);
//        triy = Math.max(triy, rect[3]);
//        area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
//        if (!isValid(data, rect[0] + "," + rect[1], 1)) {
//            return false;    
//        }
//        if (!isValid(data, rect[0] + "," + rect[3], 2)) {
//            return false;    
//        }
//        if (!isValid(data, rect[2] + "," + rect[1], 4)) {
//            return false;    
//        }
//        if (!isValid(data, rect[2] + "," + rect[3], 8)) {
//            return false;    
//        }
//    }
//    int count = 0;
//    for (String s:data.keySet()) {
//        int val = data.get(s);
//        if (val == 1 || val == 2 || val == 4 || val == 8) {
//            count ++;
//        }
//    }
//    return count == 4 && (trix - blox) * (triy - bloy) == area;
//}
//private boolean isValid(HashMap<String, Integer> data, String key, int mask) {
//    if (data.containsKey(key) && (data.get(key)&mask) != 0) {
//        return false;
//    }
//    int val = 0;
//    if (data.containsKey(key)) {
//        val = data.get(key);
//    }
//    val = val | mask;
//    data.put(key, val);
//    return true;
//}

	//https://www.codingcargo.com/problems/hard/perfect-rectangle/
//	 public boolean isRectangleCover(int[][] rectangles) {
//	        /**
//	             Input rectangles array should satisfy below three criteria
//	             1. the large rectangle area should be equal to the sum of all small input rectangles
//	             2. count of all the points should be even
//	             3. count of of all the four corner points should be one
//	         */
//	        HashSet<String> points = new HashSet<>();
//	        int x1 = Integer.MAX_VALUE;
//	        int y1 = Integer.MAX_VALUE;
//	        int x2 = Integer.MIN_VALUE;
//	        int y2 = Integer.MIN_VALUE;
//
//	        int area = 0;
//	        for(int[] rectangle: rectangles) {
//	            x1 = Math.min(x1, rectangle[0]);
//	            y1 = Math.min(y1, rectangle[1]);
//	            x2 = Math.max(x2, rectangle[2]);
//	            y2 = Math.max(y2, rectangle[3]);
//
//	            String point1 = rectangle[0] +" "+ rectangle[1];
//	            String point2 = rectangle[2] +" "+ rectangle[3];
//	            String point3 = rectangle[0] +" "+ rectangle[3];
//	            String point4 = rectangle[2] +" "+ rectangle[1];
//
//	            if(!points.add(point1)) points.remove(point1);
//	            if(!points.add(point2)) points.remove(point2);
//	            if(!points.add(point3)) points.remove(point3);
//	            if(!points.add(point4)) points.remove(point4);
//
//	            area += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
//	        }
//
//	        String point1 = x1 +" "+ y1;
//	        String point2 = x2 +" "+ y2;
//	        String point3 = x1 +" "+ y2;
//	        String point4 = x2 +" "+ y1;
//
//	        if(!points.contains(point1) || !points.contains(point2) || !points.contains(point3) || !points.contains(point4) || points.size() != 4) return false;
//
//	        return area == (x2 - x1) * (y2 - y1);
//	    }

} // end class Rectangle
