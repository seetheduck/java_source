package quiz;

public class EmployeeMain {

	public static void main(String[] args) {
		
		Temporary tem = new Temporary("홍길동", 23, 20, 150000);
		tem.print();
		
		Regular reg = new Regular("신기해", 25, 2345000);
		reg.print();
		
		Salesman sal = new Salesman("손오공", 27, 2890000, 30000, 0.25);
		sal.print();
		
		Manager man = new Manager("사오정", 33, 4578000);
		man.print();
		
	}

}
