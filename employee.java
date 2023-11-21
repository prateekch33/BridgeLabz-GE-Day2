import java.util.*;

class Employee {
	public int wageCalculate(int attendanceValue) {
		int empWage=0,empWorkingHours=0;
		if(attendanceValue==1) {
			empWorkingHours=8;
		}
		empWage=empWorkingHours*20;
		return empWage;
	}
	public int attendance() {
		int checkAttendance=((int)(Math.random()*10))%2;
		if(checkAttendance==1) {
			System.out.println("Employee is Present");
		}
		else {
			System.out.println("Employee is Absent");
		}
		return checkAttendance;
	}
	public static void main(String[] args) {
		System.out.println("========Welcome to Employee Wage Computation Program========");
		Employee ob=new Employee();
		int attendanceValue=ob.attendance();
		int wage=ob.wageCalculate(attendanceValue);
		System.out.printf("Wage of the Employee: %d",wage);
	}
}
