package pack1;

public class Ex02Main {

	public static void main(String[] args) {
		// getter, setter 연습
		System.out.println("프로그램을 실행하다가..");
		
		// Ex02Car 객체를 만들기
		System.out.println();
		Ex02Car tom = new Ex02Car();
		tom.showData();
		System.out.println("이름은 " + tom.irum);
		tom.irum = "미스터 톰"; // private이 아니므로 접근 가능
		System.out.println("이름은 " + tom.irum);
		
		System.out.println("getter, setter 확인");
		// tom.speed = 80; private이므로 접근 불가능
		// tom.setSpeed(80, 123);	// 예를들어 비밀번호에 의해 수정 결정
		tom.setSpeed(80);	// speed에만 집중
		tom.showData();
		System.out.println("속도는 " + tom.getSpeed());
		int result = tom.getSpeed();
		System.out.println("속도는 " + result);
		
		
	}

}
