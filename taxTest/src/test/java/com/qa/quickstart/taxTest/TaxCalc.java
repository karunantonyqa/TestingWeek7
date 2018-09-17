package com.qa.quickstart.taxTest;

public class TaxCalc {
	int salaryBTax = 0;
	int tax = 0;
	int salATax;
	
	public int percTax(int salary) {
		salaryBTax = salary;
		
		if(salaryBTax <= 14999) {
			tax = 0;
			return tax;
		} else if(salaryBTax >=15000 && salaryBTax<=19999) {
			tax = 10;
			return tax;
		} else if(salaryBTax >=20000 && salaryBTax<=29999) {
			tax = 15;
			return tax;
		} else if(salaryBTax >=30000 && salaryBTax<=44999) {
			tax = 20;
			return tax;
		} else if(salaryBTax >=45000) {
			tax = 25;
			return tax;
		}
		return tax;
	}
	
	public int calcTax(int salBTax) {
		
		salaryBTax = salBTax;
		
		tax = percTax(salaryBTax);
		
		salATax = salaryBTax - ((salaryBTax*tax)/100);
		
		return salATax;
	}

}
