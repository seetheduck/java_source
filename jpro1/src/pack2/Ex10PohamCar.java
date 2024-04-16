package pack2;

public class Ex10PohamCar {
	// 여러 개의 부품이 모인 완성차 설계도
	int speed = 0;
	String ownerName, turnMessageShow;
	Ex10PohamHandle handle;	// 부품 클래스를 자신의 멤버처럼 사용

	public Ex10PohamCar() {
		// TODO Auto-generated constructor stub
		// this("하하"); // 다른 생성자 호출할 때 사용
	}

	public Ex10PohamCar(String name) {
		ownerName = name;
		handle = new Ex10PohamHandle(); // 클래스의 포함관계(has a 관계)
	}

	public void playCarTurnHandle(int q) { // q : 핸들 회전량
		if (q < 0)
			turnMessageShow = handle.rightTurn(q);

		if (q > 0)
			turnMessageShow = handle.leftTurn(q);

		if (q == 0)
			turnMessageShow = handle.straight(q);
	}

}
