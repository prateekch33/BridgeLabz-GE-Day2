import java.util.*;

class Employee {
	public void attendance() {
		int checkAttendance=((int)(Math.random()*10))%2;
		if(checkAttendance==1) {
			System.out.println("Employee is Present");
		}
		else {
			System.out.println("Employee is Absent");
		}
	}
	public static void main(String[] args) {
		System.out.println("========Welcome to Employee Wage Computation Program========");
		Employee ob=new Employee();
		ob.attendance();
	}
}
