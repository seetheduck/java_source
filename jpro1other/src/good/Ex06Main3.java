package good;

import pack1.Ex06Bank;

public class Ex06Main3 {

	public static void main(String[] args) {
		// 프로젝트가 다른 곳에서  Ex06Bank를 사용하려면
		Ex06Bank kildong = new Ex06Bank();
		
		kildong.dePosit(5000);
		kildong.withDraw(2000);
		System.out.println("kildong 예금액 : " + kildong.getMoney());
		
	}

}
