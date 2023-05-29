// Exercise 9.3
/* (Recommended: Using Composition Rather Than Inheritance)
 Many programs written with inheritance could be written with composition instead, and vice versa.
 Rewrite class BasePlusCommissionEmployee (Fig.9.11 ) of the CommissionEmployee–BasePlusCommissionEmployee
 hierarchy so that it contains a reference to a CommissionEmployee object,
 rather than inheriting from class CommissionEmployee.
 Retest BasePlusCommissionEmployee to demonstrate that it still provides the same functionality.
 
// Fig. 9.11: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class inherits from CommissionEmployee 
// and accesses the superclass�s private data via inherited 
// public methods.

public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary; // base salary per week

	// six-argument constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, 
			String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary)
	{
		super(firstName, lastName, socialSecurityNumber, 
				grossSales, commissionRate);

		// if baseSalary is invalid throw exception
		if (baseSalary < 0.0)
		{
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	// set base salary
	public void setBaseSalary(double baseSalary)
	{
		if (baseSalary < 0.0)
		{
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	// return base salary
	public double getBaseSalary()
	{
		return baseSalary;
	}

	// calculate earnings
	@Override 
	public double earnings()
	{
		return getBaseSalary() + super.earnings();
	}

	// return String representation of BasePlusCommissionEmployee
	@Override
	public String toString()
	{
		return String.format("%s %s%n%s: %.2f", "base-salaried",
				super.toString(), "base salary", getBaseSalary());
	}
}
 */

public class BasePlusCommissionEmployee
{
	// composition IAW chap 9.7
	private CommissionEmployee commissionemployee;
	
	// initializing variables
	private double baseSalary; // base salary per week

	// six-argument constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, 
			String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary)
	{
//		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		// Commented above line and replacing it with:
		// instantiate CommissionEmployee object
		commissionemployee = new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		// CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate)
		
		this.baseSalary = baseSalary;

		// if baseSalary is invalid throw exception
		if (baseSalary < 0.0)
		{
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	} // end constructor

	// have to mirror setting for CommissionEmployee
	// return first name
	public String getFirstName()
	{
		return commissionemployee.getFirstName();
	}

	// return last name
	public String getLastName()
	{
		return commissionemployee.getLastName();
	}

	// return social security number 
	public String getSocialSecurityNumber()
	{
		return commissionemployee.getSocialSecurityNumber();
	}
	
	// return gross sales amount
	public double getGrossSales()
	{
		return commissionemployee.getGrossSales();
	}
	
	// return commission rate
	public double getCommissionRate()
	{
		return commissionemployee.getCommissionRate();
	}

	public void SetGrossSales( double grossSales)
	{
		commissionemployee.setGrossSales(grossSales);
	}

//	// set gross sales amount
//	public void setGrossSales(double grossSales)
//	{
//		if (grossSales < 0.0)
//		{
//			throw new IllegalArgumentException("Gross sales must be >= 0.0");
//		}
//
//		this.grossSales = grossSales;
//	}

	public void SetCommissionRate( double commissionRate)
	{
		commissionemployee.setCommissionRate(commissionRate);
	}
	
//	// set commission rate
//	public void setCommissionRate(double commissionRate)
//	{
//		if (commissionRate <= 0.0 || commissionRate >= 1.0)
//		{
//			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
//		}
//
//		this.commissionRate = commissionRate;
//	}
	// end of mirroring CommissionEmployee


	
	
	// set base salary
	public void setBaseSalary(double baseSalary)
	{
		if (baseSalary < 0.0)
		{
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	// return base salary, doesn't change from the original file
	public double getBaseSalary()
	{
		return baseSalary;
	}
	

	// calculate earnings
	//@Override 
	// commented above line and replacing it with added info to formula
	public double earnings()
	{
		return getBaseSalary() + getCommissionRate() * getGrossSales();
	}
	

	// return String representation of BasePlusCommissionEmployee
	//@Override
	// commented above line and have to replace the super with info
	public String toString()
	{
		return String.format("%s %s%n%s: %.2f", "base-salaried",
				commissionemployee.toString(), "base salary", getBaseSalary());
	}
}
