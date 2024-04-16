package pack1;

public class Ex03Main {

	public static void main(String[] args) {
		// 클래스 기본 연습 중
		Ex03Programmer programmer = new Ex03Programmer();
		programmer.displayData();
		System.out.println();
		
		programmer.setAge(33);
		System.out.println("나이는 " + programmer.getAge());
		programmer.displayData();
		
		System.out.println("-------");
		
		Ex03Programmer tom = new Ex03Programmer();
		tom.nickName = "톰 아저씨";
		tom.displayData();
		
		System.out.println("-------");
		
		Ex03Programmer james = new Ex03Programmer();
		tom.nickName = "제임스 형";
		tom.displayData();
		
		System.out.println();
		System.out.println("너의 모토는 " + james.motto);
		// static 멤버는 클래스이름.멤버 하고 사용한다(권장)
		System.out.println("너의 모토는 " + Ex03Programmer.motto);
		Ex03Programmer.goodMethod();
		
	}

}
