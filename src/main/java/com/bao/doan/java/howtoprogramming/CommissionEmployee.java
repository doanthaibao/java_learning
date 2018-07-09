package com.bao.doan.java.howtoprogramming;

public class CommissionEmployee {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	protected double grossSales;
	protected double commissionRate;

	public CommissionEmployee(String first, String last, String ssn, double sales, double rate) {
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
		setGrossSales(sales);
		setCommissionRate(rate);
	}

	public void setFirstName(String first) {
		firstName = first;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String last) {
		lastName = last;
	}

	public String getLastName() {
		return lastName;
	}

	public void setSocialSecurityNumber(String ssn) {
		socialSecurityNumber = ssn;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setGrossSales(double sales) {
		if (sales >= 0.0) {
			grossSales = sales;
		} else
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setCommissionRate(double rate) {
		if (rate > 0.0 && rate < 1.0) {
			commissionRate = rate;
		} else
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public double earnings() {
		return commissionRate * grossSales;
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f", "commission employee", firstName, lastName,
				"social security number", socialSecurityNumber, "gross sales", grossSales, "commission rate",
				commissionRate);
	}

	public static void main(String[] args) {

		// instantiate CommissionEmployee object
		CommissionEmployee employee = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);

		// get commission employee data
		System.out.println("Employee information obtained by get methods: \n");
		System.out.printf("%s %s\n", "First name is", employee.getFirstName());
		System.out.printf("%s %s\n", "Last name is", employee.getLastName());
		System.out.printf("%s %s\n", "Social security number is", employee.getSocialSecurityNumber());
		System.out.printf("%s %.2f\n", "Gross sales is", employee.getGrossSales());
		System.out.printf("%s %.2f\n", "Commission rate is", employee.getCommissionRate());
	}
}
