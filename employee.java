import java.util.*;

class EmployeeDetails {
	private int empWagePerHour = 0, fullTimeHour = 0, partTimeHour = 0;
	Scanner input = new Scanner(System.in);

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
		return empWage;
	}

	public int wageCalculate(int attendanceValue) {
		int empWage = 0, empWorkingHours = 0;
		if (attendanceValue == 1) {
			empWorkingHours = 8;
		}
		empWage = empWorkingHours * 20;
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

	public EmployeeDetails() {
		System.out.println("Enter the Employee Wage Per Hour: ");

		empWagePerHour = input.nextInt();
		System.out.println("Enter the Full Time Hour: ");
		fullTimeHour = input.nextInt();
		System.out.println("Enter the Part Time Hour: ");
		partTimeHour = input.nextInt();
	}
}

class Employee {

	public static void main(String[] args) {
		System.out.println("========Welcome to Employee Wage Computation Program========");
		ArrayList<EmployeeDetails> emp = new ArrayList<EmployeeDetails>();
		System.out.println("Enter the number of employees: ");
		Scanner input = new Scanner(System.in);
		int numberOfEmployees = input.nextInt();
		for (int i = 0; i < numberOfEmployees; i++) {
			emp.add(new EmployeeDetails());
		}
		for (int i = 0; i < numberOfEmployees; i++) {
			int attendanceValue = emp.get(i).attendance();
			int wage = emp.get(i).wageCalculate(attendanceValue % 2);
			System.out.printf("Wage of the Employee: %d\n", wage);
			int partTimeWage = emp.get(i).partTimeEmployee(attendanceValue);
			if (attendanceValue % 3 == 1) {
				System.out.printf("Wage of the Employee as part-time: %d\n", partTimeWage);
			} else if (attendanceValue % 3 == 2) {
				System.out.printf("Wage of the Employee as full-time: %d\n", partTimeWage);
			} else {
				System.out.printf("Wage of the Employee as absent: %d\n", partTimeWage);
			}
			// int partTimeSC = emp.get(i).partTimeSwitchCase(attendanceValue);
			if (attendanceValue % 3 == 1) {
				System.out.printf("Wage of the Employee as part-time: %d\n", partTimeWage);
			} else if (attendanceValue % 3 == 2) {
				System.out.printf("Wage of the Employee as full-time: %d\n", partTimeWage);
			} else {
				System.out.printf("Wage of the Employee as absent: %d\n", partTimeWage);
			}
			int monthlyWageValue = emp.get(i).monthlyWage();
			System.out.printf("Monthly Wage of the Employee: %d\n", monthlyWageValue);
		}
		input.close();
	}
}
