package empWage;
import java.util.ArrayList;
import java.util.HashMap;

class EmployeeWageOops implements InEmployeeWageOops {
  // constant
  public static final int IS_FULL_TIME = 1;
  public static final int IS_PART_TIME = 2;
  int daySalary;
  ArrayList<Integer> dailyWage = new ArrayList<Integer>();
  private ArrayList<CompanyEmpWage> companyEmpWageArrayList;
  private HashMap<String, CompanyEmpWage> companyEmpWageMap;

  public EmployeeWageOops() {
    companyEmpWageArrayList = new ArrayList<>();
    companyEmpWageMap = new HashMap<>();
  }

  public void dailyWage() {
    dailyWage.add(daySalary);
  }

  public void addCompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
    CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, numberOfWorkingDays, maxHrPerMonth);
    companyEmpWageArrayList.add(companyEmpWage);
    companyEmpWageMap.put(company, companyEmpWage);

    // numOfCompany++;

  }

  public void computeEmpWage() {
    for (int i = 0; i < companyEmpWageArrayList.size(); i++) {
      CompanyEmpWage companyEmpWage = companyEmpWageArrayList.get(i);
      companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
      System.out.println(companyEmpWage);
    }
  }

  private int computeEmpWage(CompanyEmpWage companyEmpWage) {
    // variables
    int empHrs = 0;
    int totalEmpHrs = 0;
    int totalWorkingDays = 0;

    // computation
    while (totalEmpHrs <= companyEmpWage.maxHrPerMonth && totalWorkingDays < companyEmpWage.numberOfWorkingDays) {

      totalWorkingDays++;
      double empCheck = Math.floor(Math.random() * 10) % 3;
      switch ((int) empCheck) {
        case IS_FULL_TIME:
          empHrs = 8;
          break;
        case IS_PART_TIME:
          empHrs = 4;
          break;
        default:
          empHrs = 0;

      }// switch
      int daySalary = empHrs * companyEmpWage.empRatePerHr;
      companyEmpWage.dailyWage.add(daySalary);
      totalEmpHrs += empHrs;
      System.out.println(
          "totalWorkingDays: " + totalWorkingDays + "/ daly empHrs: " + empHrs + "/ totalEmpHrs: " + totalEmpHrs);
    } // while
    System.out.println(companyEmpWage.dailyWage);
    return totalEmpHrs * companyEmpWage.empRatePerHr;

  }

  public int getTotalEmpWage(String company) {
    return companyEmpWageMap.get(company).totalEmpWage;
  }

  public static void main(String[] args) {
    EmployeeWageOops empWageBuilder = new EmployeeWageOops();
    empWageBuilder.addCompanyEmpWage("icici", 50, 2, 100);
    empWageBuilder.addCompanyEmpWage("DMart", 20, 4, 100);
    empWageBuilder.addCompanyEmpWage("accenture", 20, 6, 100);
    empWageBuilder.addCompanyEmpWage("IBM", 100, 8, 100);
    empWageBuilder.addCompanyEmpWage("google", 100, 10, 100);
    empWageBuilder.computeEmpWage();
    System.out.println("Total wage of queried company: " + empWageBuilder.getTotalEmpWage("accenture"));
  }// main()
}// class



  