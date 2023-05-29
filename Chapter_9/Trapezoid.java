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

public class Trapezoid extends Quadrilateral 
{
	// Trapezoid is 2nd from the top

	// information below taken from https://www.mathsisfun.com/geometry/trapezoid.html
	// has a pair of parallel sides
	// is an isosceles trapezoid when it has equal angles from a parallel side
	// The parallel sides are the "bases"
	// The other two sides are the "legs"
	// The distance (at right angles) from one base to the other is called the "altitude"
	// The Area is the average of the two base lengths times the altitude: Area = ((a + b) / 2) × h 
	// Perimeter = a + b + c + d

	// Initializing variables
	private double top = getTopDist(); // top side distance version 4
	private double rtside = getRTSideDist(); // right side distance version 4
	private double bottom = getBottomDist(); // bottom side distance version 4
	private double lfside = getLFSideDist(); // left side distance version 4

	// point layout should be as follows:
	// top left = point1, top right = point2, bottom right = point3 and bottom left = point4 (it's all clockwise)
	public Trapezoid(double point1x, double point1y, double point2x, double point2y,
			double point3x, double point3y, double point4x, double point4y)
	{
		// copy the super from Quadrilateral since we are using the same references
		super(point1x, point1y, point2x, point2y,
				point3x, point3y, point4x, point4y);
		

	}

	public double getTrapArea(double top, double lfside, double bottom, double rtside)
	{
		double area = 0;
		if (top > bottom)
		{
			double s = (top + bottom + lfside + rtside) / 2; // s is the perimeter of the trap
			double num = (s - top) * (s - bottom) * (s - bottom - lfside) * (s - bottom - rtside);
			double res = Math.sqrt(num);
			// Calculate the area
			area =(top + bottom) / (top - bottom) * res;
			return area;
		}
		else
		{
			double temp = 0;
			temp = bottom;
			bottom = top;
			top = temp;
			double s = (top + bottom + lfside + rtside) / 2; // s is the perimeter of the trap
			double num = (s - top) * (s - bottom) * (s - bottom - lfside) * (s - bottom - rtside);
			double res = Math.sqrt(num);
			// Calculate the area
			area =(top + bottom) / (top - bottom) * res;
			return area;
		}
	}

	public double getHeight()
	{
		//formula for area with know coords and area is 2A/(b1+b2)=h
		// where A is Area, b1 is top, and b2 is bottom
		return (2 * getTrapArea( top, lfside, bottom, rtside) ) / (top + bottom); 
	}

	public String toString()
	{
		return String.format("Trapezoid Coordinates are: %s%n Height is: %.1f%n Area of the Trapezoid is: %.1f%n",
				coordtoString(), getHeight(), getTrapArea(top, lfside, bottom, rtside) );
		// need to get coordinates, Height, and Area
	}

	// ************************************
	// Additional info and references

	// from https://www.geeksforgeeks.org/program-find-area-trapezoid/
	// Java program to calculate
//	// area of a trapezoid
//	import java.io.*;
//	 
//	class GFG
//	{
//	     
//	    // Function for the area
//	    static double Area(int b1,
//	                       int b2,
//	                       int h)
//	    {
//	        return ((b1 + b2) / 2) * h;
//	    }
//	 
//	    // Driver Code
//	    public static void main (String[] args)
//	    {
//	        int base1 = 8, base2 = 10,
//	                       height = 6;
//	        double area = Area(base1, base2,
//	                                  height);
//	        System.out.println("Area is: " + area);
//	    }
//	}

	// from https://math.stackexchange.com/questions/2019434/area-of-a-trapezoid-without-the-height0
	// The trapezoid's bases are 30 and 40, and the legs 14 and 16.
	// a-b = bottom, a-d = lfside, b-c = rtside, c-d = top
	// (a+c) / 4(a-c) * √(a+b-c+d)(a-b-c+d)(a+b-c-d)(-a+b+c+d)
	// Where a>c and 'a' is parallel to 'c'. 'b' and 'd' are the 'diagonals'.
	//Therefore, (40+30) / 4(40-30) * √(40+14-30+16)(40-14-30+16)(40+14-30-16)(-40+14+30+16)
	// 70 / 40 * √(40)(12)(8)(20)
	// 7/4 * 277.128129...
	// 484.974

	// From https://www.studytonight.com/java-programs/java-program-to-find-the-area-of-a-trapezium
	// Scanner sc=new Scanner(System.in);
	//	//a = top, b = bottom, c = lfside, d = rtside
	// System.out.println("Enter the length of the longer side of the trapezium: ");
	// double a=sc.nextDouble();
	// System.out.println("Enter the length of the shorter side of the trapezium: ");
	// double b=sc.nextDouble();
	// System.out.println("Enter the length of the non-parallel side of the trapezium: ");
	// double c = sc.nextDouble();
	// System.out.println("Enter the length of the non-parallel side of the trapezium: ");
	// double d = sc.nextDouble();
	// double s =(a+b+c+d)/2; // s is the perimeter of the trap
	// double num=(s-a)*(s-b)*(s-b-c)*(s-b-d);
	// double res=Math.sqrt(num);
	//	//Calculate the area
	// double Area =(a+b)/(a-b)*res;
	// if (a <= 0 || b<=0 || c<=0 || d<=0)
	// 	System.out.println("Length should be positve");
	// else
	// 	System.out.println("Area of trapezium = "+ Area);

	// from https://sciencing.com/height-triangle-4449599.html
	/* Set up the equation for the area of a trapezoid.
	 * Write A=h(b1+b2)/2, where A represents the trapezoid’s area, b1 represents one
	 * of the base lengths, b2 represents the other base length and h represents the height.
	 * 
	 * Rearrange the equation to get h alone.
	 * Multiply both sides of the equation by 2 to get. 2A=h(b1+b2).
	 * Divide both sides of the equation by the sum of the bases to get 2A/(b1+b2)=h.
	 * This equation gives the representation of h in terms of the other traits of the trapezoid.
 */

	// from https://www.geeksforgeeks.org/program-to-find-height-of-a-trapezoid/
	// where point a = bottom left, b = bottom right, c = top right and d= top left coords
	// p1 = lfside and p2 = rtside
//	// Java program to implement
//	// the above approach
//	import java.util.*;
//	 
//	class GFG
//	{
//	   
//	// Function to calculate height
//	// of the trapezoid
//	static void findHeight(float p1, float p2,
//	                float b, float c)
//	{
//	    float a = Math.max(p1, p2) - Math.min(p1, p2);
//	 
//	    // Apply Heron's formula
//	    float s = (a + b + c) / 2;
//	 
//	    // Calculate the area
//	    float area = (int)Math.sqrt(s * (s - a)
//	                      * (s - b) * (s - c));
//	 
//	    // Calculate height of trapezoid
//	    float height = (area * 2) / a;
//	 
//	    // Print the height
//	    System.out.print("Height is: " + height);
//	}
//	 
//	// Driver Code
//	public static void main(String args[])
//	{
//	   
//	    // Given a, b, p1 and p2
//	    float p1 = 25, p2 = 10;
//	    float a = 14, b = 13;
//	 
//	    findHeight(p1, p2, a, b);
//	}
//	}

} // end class Trapezoid
