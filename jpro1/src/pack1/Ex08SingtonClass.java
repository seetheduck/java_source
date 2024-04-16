package pack1;

public class Ex08SingtonClass { // gof 디자인 패턴중 singleton 패턴
	int kor = 90;

	public Ex08SingtonClass() {
		// TODO Auto-generated constructor stub
	}

	// 객체의 인스턴스가 오직 1개만 생성되는 패턴을 만들기
	// 장점 : 메모리 절약, 데이터 공유 편리
	// 단점 : 테스트가 불편, 유연성이 떨어짐
	
	private static Ex08SingtonClass class1 = new Ex08SingtonClass();
	
	public static Ex08SingtonClass getInstance() {
		return class1;
	}
	
}
