// Execrise 6.15
/* (Hypotenuse Calculations) Define a method hypotenuse that calculates the hypotenuse
 * of a right triangle when the lengths of the other two sides are given.
 * The method should take two arguments of type double and return the hypotenuse as a double.
 * Incorporate this method into an application that reads values for side1 and side2 and
 *  performs the calculation with the hypotenuse method. Use Math methods pow and sqrt to
 *  determine the length of the hypotenuse for each of the triangles in Fig.6.14 .
 *  [Note:Class Math also provides method hypot to perform this calculation.]
Fig. 6.14
Triangle	Side 1	Side 2
1	3.0	 4.0
2	5.0	12.0
3	8.0	15.0
*/
public class HypCalc {

	public static void main(String[] args) {
		// initializing variables
		double side1;
		double side2;
		double hypotenuse;

		side1 = 3.0;
		side2 = 4.0;
		System.out.printf("If side 1 is %.1f and side 2 is %.1f then it's right angle hypotenuse is: %.1f%n", side1, side2, Hypotenuse(side1, side2));
		side1 = 5.0;
		side2 = 12.0;
		System.out.printf("If side 1 is %.1f and side 2 is %.1f then it's right angle hypotenuse is: %.1f%n", side1, side2, Hypotenuse(side1, side2));
		side1 = 8.0;
		side2 = 15.0;
		System.out.printf("If side 1 is %.1f and side 2 is %.1f then it's right angle hypotenuse is: %.1f%n", side1, side2, Hypotenuse(side1, side2));

	} //end method main

	public static double Hypotenuse(double side1, double side2)
	{
		double hyp = Math.pow(side1, 2) + Math.pow(side2, 2);
		double hypotenuse = Math.sqrt(hyp);
		return hypotenuse;
	}

} // end class HypCalc
