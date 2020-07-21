package empWage;
import java.util.ArrayList;
class CompanyEmpWage {
	  public final String company;
	  public final int empRatePerHr;
	  public final int numberOfWorkingDays;
	  public final int maxHrPerMonth;
	  public int totalEmpWage;
	  ArrayList<Integer> dailyWage = new ArrayList<Integer>();

	  public CompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
	    this.company = company;
	    this.empRatePerHr = empRatePerHr;
	    this.numberOfWorkingDays = numberOfWorkingDays;
	    this.maxHrPerMonth = maxHrPerMonth;
	   
	  }// constructor
	
	 
	  public void setTotalEmpWage(int totalEmpWage) {
	    this.totalEmpWage = totalEmpWage;
	  }

	  public String toString() {
	    return "Total employee wage for: " + company + " is " + totalEmpWage;
	  }
	}// ComanyEmpWage class

