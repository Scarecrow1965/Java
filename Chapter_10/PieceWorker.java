// Exercise 10.15
/* (Payroll System Modification)
 Modify the payroll system of Figs. 10.4 – 10.9 to include an additional Employee subclass PieceWorker
 that represents an employee whose pay is based on the number of pieces of merchandise produced.
 Class PieceWorker should contain private instance variables wage (to store the employee’s wage per piece)
 and pieces (to store the number of pieces produced).
 Provide a concrete implementation of method earnings in class PieceWorker that calculates the employee’s
 earnings by multiplying the number of pieces produced by the wage per piece.
 Create an array of Employee variables to store references to objects of each concrete class in the new
 Employee hierarchy.
 For each Employee, display its String representation and earnings.
 */

public class PieceWorker extends Employee
{

	private final double wage;
	private final int piece;
	
	public PieceWorker (String firstName, String lastName, 
			String socialSecurityNumber, double wage, int piece, Date birthDate)
	{
		super(firstName, lastName, socialSecurityNumber, birthDate);
		this.wage = wage;
		this.piece = piece;
	}
	
	public double getWage()
	{
		return wage;
	}
	
	public int getPiece()
	{
		return piece;
	}
	
	// calculate earnings; override method earnings in Employee
	@Override
	public double earnings()
	{
		return (getWage() * getPiece());
	}

	// return String representation of PieceWorker object
	@Override
	public String toString()
	{
		return String.format("%s %s%n%s $%.2f; %s %d",
				"piece worker:", super.toString(), "wage per piece:", getWage(), "pieces produced:", getPiece());
	}

}// end class Pieceworker
