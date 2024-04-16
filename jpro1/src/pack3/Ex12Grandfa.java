package pack3;

// 상속 : 하나의 클래스가 다른 클래스를 포함하는 상위 개념일 때 두 클래스 사이에 
// 일반화 관계가 있다. 이런 일반화 관계를 상속관계(is a kind of 관계)라고 한다
// 클래스 간 부모 자식의 구조를 갖는다.
// 부모 클래스는 자식 클래스의 멤버를 제공하는 틀 역할을 한다.

//final public class Ex12Grandfa { // 클래스에 final은 상속 불가
public class Ex12Grandfa {
	private int nai = 80;
	public String gabo = "상감청자";
	protected String gahun = "자바 모르면 인간도 아니다";
	
	public Ex12Grandfa() {
		System.out.println("할아버지 생성자");
	}
	
	public Ex12Grandfa(int nai) {
		this();
		this.nai = nai;
	}
	
	public String say() {
		return "할아버지 말씀 : 자기주도 학습";
	}
	
	public void eat() {
		System.out.println("밥은 맛있게...");
	}
	
	public int getNai() {
		return nai;
	}
	
	
	
}
