import java.util.*;

class Employee {
	public int partTimeSwitchCase(int attendanceValue) {
		int empWage=0,empWorkingHours=0;
		switch(attendanceValue%3) {
			case 1: 
				empWorkingHours=8;
			break;
			case 2: 
				empWorkingHours=16;
			break;
			default:
				empWorkingHours=0;
		}
		empWage=empWorkingHours*20;
		return empWage;
	}
	public int partTimeEmployee(int attendanceValue) {
		int empWage=0,empWorkingHours=0;
		if(attendanceValue%3==1) {
			empWorkingHours=8;
		}
		else if(attendanceValue%3==2) {
			empWorkingHours=16;
		}
		empWage=empWorkingHours*20;
		return empWage;
	}
	public int wageCalculate(int attendanceValue) {
		int empWage=0,empWorkingHours=0;
		if(attendanceValue==1) {
			empWorkingHours=8;
		}
		empWage=empWorkingHours*20;
		return empWage;
	}
	public int attendance() {
		int randomValue=(int)(Math.random()*10);
		int checkAttendance=randomValue%2;
		if(checkAttendance==1) {
			System.out.println("Employee is Present");
		}
		else {
			System.out.println("Employee is Absent");
		}
		return randomValue;
	}
	public static void main(String[] args) {
		System.out.println("========Welcome to Employee Wage Computation Program========");
		Employee ob=new Employee();
		int attendanceValue=ob.attendance();
		int wage=ob.wageCalculate(attendanceValue%2);
		System.out.printf("Wage of the Employee: %d\n",wage);
		int partTimeWage=ob.partTimeEmployee(attendanceValue);
		if(attendanceValue%3==1) {
			System.out.printf("Wage of the Employee as part-time: %d\n",partTimeWage);
		}
		else if(attendanceValue%3==2) {
			System.out.printf("Wage of the Employee as full-time: %d\n",partTimeWage);
		}
		else {
			System.out.printf("Wage of the Employee as absent: %d\n",partTimeWage);
		}
		int partTimeSC=ob.partTimeSwitchCase(attendanceValue);
		if(attendanceValue%3==1) {
                        System.out.printf("Wage of the Employee as part-time: %d\n",partTimeWage);
                }
                else if(attendanceValue%3==2) {
                        System.out.printf("Wage of the Employee as full-time: %d\n",partTimeWage);
                }
                else {
                        System.out.printf("Wage of the Employee as absent: %d\n",partTimeWage);
                }
	}
}
