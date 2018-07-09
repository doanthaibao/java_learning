package com.bao.doan.java.howtoprogramming;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary; // base salary per week

	public BasePlusCommissionEmployee(String first, String last, String ssn, double sales, double rate, double salary)
	// six-argument constructor
	{
		super(first, last, ssn, sales, rate);
		setBaseSalary(salary); // validate and store base salary
	} // end six-argument BasePlusCommissionEmployee constructor
		// set base salary

	public void setBaseSalary(double salary) {
		if (salary >= 0.0)
			baseSalary = salary;
		else
			throw new IllegalArgumentException("Base salary must be >= 0.0");
	} // end method setB

	public double getBaseSalary() {
		return baseSalary;
	}

	@Override // indicates that this method overrides a superclass method
	public double earnings() {
		return baseSalary + ( commissionRate * grossSales );
	} // end method earnings
}
