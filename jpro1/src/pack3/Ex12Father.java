package pack3;

public class Ex12Father extends Ex12Grandfa {	// 단일 상속만 가능
	//Ex12Grandfa fa = new Ex12Grandfa();	// 포함관계
	
	public String gabo = "꽃병";	// 은닉화
	private int nai = 55;
	private int house = 1;
	
	public Ex12Father() {
		//super(55); // 매개변수가 없는 부모 생성자 호출
		System.out.println("아버지 생성자");
	}
	
	public Ex12Father(int n) {
		System.out.println("아버지 생성자라고 해");
	}
	
//	public int getNai() { // Method overriding(오버라이딩)
//		return nai;
//	}
	
	public String say() {
		return "아버지 말씀 : 에러 잡는 연습을 하거라";
	}
	
	final public String getHouse() { // 메소드에 final하면 자식 클래스에서 오버라이딩 불가
		return "집 : " + house + "채";
	}
	
	public void showData() {
		System.out.println("아버지 나이 " + nai);	// 현재 클래스 안을 찾아보고 없으면 감
		System.out.println("아버지 나이 " + this.nai);	// 처음부터 멤버 변수로 감
		System.out.println("아버지 나이 " + getNai());
		System.out.println("아버지 나이 " + this.getNai());
		
		System.out.println("할아버지 나이 " + super.getNai());	// 바로 부모생성자 찾아감
		//System.out.println("할아버지 나이 " + super.nai); // 에러
		System.out.println();
		
		String gabo = "물병";
		System.out.println("가보 " + gabo); // 현재 클래스 안부터 찾아보고 올라감
		System.out.println("가보 " + this.gabo); // 바로 멤버 변수를 찾아감
		System.out.println("가보 " + super.gabo); // 바로 부모를 찾아감
		
	}
	
}
