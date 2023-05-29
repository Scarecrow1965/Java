//  Exercise 8.4
/*(Rectangle Class)
 * Create a class Rectangle with attributes length and width, each of which defaults to 1.
 * Provide methods that calculate the rectangle’s perimeter and area.
 * It has set and get methods for both length and width.
 * The set methods should verify that length and width are each floating-point numbers larger
 * than 0.0 and less than 20.0.
 * Write a program to test class Rectangle. */

public class Rectangle
{
	// initializing variables
	public static double length = 1.0;
	public static double width = 1.0;
	public static double perimeter;
	public static double area;

	public Rectangle(double length, double width, double perimeter, double area)
	{
		this.length = length;
		this.width = width;
		this.perimeter = perimeter;
		this.area = area;
	} // end constructor Rectangle
	
	// method SetLength
	public void SetLength(double length)
	{
		if(length < 0.0)
		{
			this.length = 0.0;
		}
		if(length > 20.0)
		{
			this.length = 20.0;
		}
		if(length > 0.0 && length < 20.0) 
		{
			this.length = length;
		}
	} //end method SetLength
	
	// method GetLength
	public double GetLength()
	{
		return length;
	} // end method GetLength

	// method SetWidth
	public void SetWidth(double width)
	{
		if(width < 0.0)
		{
			this.width = 0.0;
		}
		if(width > 20.0)
		{
			this.width = 20.0;
		}
		if(width > 0.0 && width < 20.0) 
		{
			this.width = width;
		}
	} //end method SetWidth
	
	// method GetWidth
	public double GetWidth()
	{
		return width;
	} // end method GetWidth

public double Perimeter(double length, double width)
{
	perimeter = 2 *(length + width);
	return perimeter;
}

public double Area(double length, double width)
{
	area = length * width;
	return area;
}

	
} // end class Rectangle
