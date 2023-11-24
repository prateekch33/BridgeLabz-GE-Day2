import java.util.ArrayList;
import java.util.Scanner;

interface EmployeeInterface {
	int monthlyWage();

	int partTimeSwitchCase(int attendanceValue);

	int partTimeEmployee(int attendanceValue);

	int wageCalculate(int attendanceValue);

	int attendance();

	String getCompanyName();

	int getTotalWage();

	int getDailyWage();
}

class EmployeeDetails implements EmployeeInterface {
	private int empWagePerHour = 0, fullTimeHour = 0, partTimeHour = 0;
	private String companyName;
	private int totalWage = 0;
	private int dailyWage = 0; // New field to store the daily wage
	Scanner input = new Scanner(System.in);

	public int getTotalWageByCompany(String companyName) {
		if (this.companyName.equals(companyName)) {
			return totalWage;
		} else {
			return 0;
		}
	}

	public int monthlyWage() {
		int monthlyWageValue = 0;
		int totalWorkingHours = 0;
		for (int i = 0; i < 20; i++) {
			if (totalWorkingHours > 100)
				break;
			int attendanceValue = attendance();
			int empWage = partTimeSwitchCase(attendanceValue);
			totalWorkingHours += empWage / 20;
			monthlyWageValue += empWage;
		}
		totalWage += monthlyWageValue;
		return monthlyWageValue;
	}

	public int partTimeSwitchCase(int attendanceValue) {
		int empWage = 0, empWorkingHours = 0;
		switch (attendanceValue % 3) {
			case 1:
				empWorkingHours = partTimeHour;
				break;
			case 2:
				empWorkingHours = fullTimeHour;
				break;
			default:
				empWorkingHours = 0;
		}
		empWage = empWorkingHours * 20;
		dailyWage = empWage / 20;
		return empWage;
	}

	public int partTimeEmployee(int attendanceValue) {
		int empWage = 0, empWorkingHours = 0;
		if (attendanceValue % 3 == 1) {
			empWorkingHours = partTimeHour;
		} else if (attendanceValue % 3 == 2) {
			empWorkingHours = fullTimeHour;
		}
		empWage = empWorkingHours * empWagePerHour;
		dailyWage = empWage;
		return empWage;
	}

	public int wageCalculate(int attendanceValue) {
		int empWage = 0, empWorkingHours = 0;
		if (attendanceValue == 1) {
			empWorkingHours = 8;
		}
		empWage = empWorkingHours * 20;
		dailyWage = empWage / 20;
		return empWage;
	}

	public int attendance() {
		int randomValue = (int) (Math.random() * 10);
		int checkAttendance = randomValue % 2;
		if (checkAttendance == 1) {
			System.out.println("Employee is Present");
		} else {
			System.out.println("Employee is Absent");
		}
		return randomValue;
	}

	public EmployeeDetails(String companyName) {
		this.companyName = companyName;
		System.out.println("Enter the Employee Wage Per Hour for " + companyName + ": ");
		empWagePerHour = input.nextInt();
		System.out.println("Enter the Full Time Hour for " + companyName + ": ");
		fullTimeHour = input.nextInt();
		System.out.println("Enter the Part Time Hour for " + companyName + ": ");
		partTimeHour = input.nextInt();
	}

	public String getCompanyName() {
		return companyName;
	}

	public int getTotalWage() {
		return totalWage;
	}

	public int getDailyWage() {
		return dailyWage;
	}
}

public class employee {
	public static void main(String[] args) {
		ArrayList<EmployeeDetails> companyList = new ArrayList<EmployeeDetails>();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.println("Enter the number of Companies: ");
		int numberOfCompanies = input.nextInt();
		for (int i = 0; i < numberOfCompanies; i++) {
			System.out.println("Enter the Company Name: ");

			String companyName = input.next();
			companyList.add(new EmployeeDetails(companyName));
		}
		for (int i = 0; i < companyList.size(); i++) {
			System.out.println("Total Wage for " + companyList.get(i).getCompanyName() + " is: "
					+ companyList.get(i).monthlyWage());
		}
		System.out.println("Enter the Company Name to get the Total Wage: ");
		// Scanner input = new Scanner(System.in);
		String companyName = input.next();
		for (int i = 0; i < 10; i++) {
			int totalWage = companyList.get(i).getTotalWageByCompany(companyName);
			if (totalWage != 0) {
				System.out.println("Total Wage for " + companyList.get(i).getCompanyName() + " is: " + totalWage);
			}
		}
		input.close();
	}
}