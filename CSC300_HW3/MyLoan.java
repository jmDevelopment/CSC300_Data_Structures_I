package CSC300_HW3;

import java.util.Scanner;

public class MyLoan {
	
	public static void main(String[] args) {
		
		int YEAR15 = 15;
		int YEAR30 = 30;
		double RATE15 = 5.75;
		double RATE30 = 6.25;
		String continueSimulation = "";
		
		do{
			Scanner in = new Scanner(System.in);
			System.out.print("Enter the principle amount to borrow: ");
			double pa = in.nextDouble();
		
			MyLoan loan1 = new MyLoan(pa, RATE15, YEAR15);
			MyLoan loan2 = new MyLoan(pa, RATE30, YEAR30);
		
			System.out.println("============ ANALYSES ============");
			System.out.println(loan1.toString());
			System.out.println("");
			System.out.println(loan2.toString());
			System.out.println("================================== \n");
		
			System.out.print("**Do you want to continue (y/n): ");
			continueSimulation = in.next();
		}while(continueSimulation.equals("y"));
		if(continueSimulation.equals("n")){
			System.out.println("Thank you. Have a nice day.");
		}
		
	}	// END MAIN
		
	
	// Private instance variables
	private double amountBorrowed;	// The principle amount of the loan.
	private double yearlyRate;	// The annual interest rate of the loan. A rate of 7.25% for example must be stored as 7.25. 
	private int years;	// The number of years on the loan.

	// Constructors
	// Sets all instances to 0.
	public MyLoan(){
		amountBorrowed = 0;
		yearlyRate = 0;
		years = 0;
	}
	
	// Initializes all instance variables to parameters.
	public MyLoan(double ab, double yrate, int yrs){
		
		amountBorrowed = ab;
		yearlyRate = yrate;
		years = yrs;
		
	}
	
	public double getAmountBorrowed(){
		return amountBorrowed;
	}
	
	public double getYearlyRate(){
		return yearlyRate;
	}
	
	public int getYears(){
		return years;
	}
	
	public double getMonthlyPayment(){
		
		// Formula: P * (i * ((1 + i) ** n) / (((1 + i) ** n) - 1)
		
		double monthlyRate = ((yearlyRate/12)/100);	// Also known as i
		int numberOfPayments = years * 12;	// Also known as n
		
		double monthlyPayment = amountBorrowed * (monthlyRate * (Math.pow(1 + monthlyRate, numberOfPayments)) /  
																(Math.pow(1 + monthlyRate, numberOfPayments) - 1));
		
		return monthlyPayment;
		
	}
	
	public double getTotalPayment(){
		
		return getMonthlyPayment() * (years * 12);
	}
	
	public String toString(){
		
		String strPrincipalAmount = String.format("$%.2f", amountBorrowed);
		String strYearlyRate = String.format("%.2f", yearlyRate);
		String strMonthlyPayment = String.format("$%.2f", getMonthlyPayment());
		String strTotalPayment = String.format("$%.2f", getTotalPayment());
		
		String topLine = "Loan: " + strPrincipalAmount + " at " + strYearlyRate + " for " + years + " years.\n";
		String middleLine = "Monthly Payment: " + strMonthlyPayment + "\n";
		String bottomLine = "Total Payment: " + strTotalPayment;
		
		String fullBuild = topLine + middleLine + bottomLine;
		
		return fullBuild;
		
		
	}
	
	
	
	
	
	
}
