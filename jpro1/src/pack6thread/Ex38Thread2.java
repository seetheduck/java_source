package pack6thread;

public class Ex38Thread2 implements Runnable {

	public Ex38Thread2() {

	}

	public Ex38Thread2(String name) {
		Thread tt = new Thread(this, name);
		tt.start();
	}

	public void run() {
		for (int i = 0; i <= 50; i++) {
//			System.out.println(i);
			System.out.println(i + ":" + Thread.currentThread().getName());
			try {
				Thread.sleep(100);	// 스레드를 일정 시간동안 비활성화

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
//		Ex38Thread2 my1 = new Ex38Thread2();
//		Ex38Thread2 my2 = new Ex38Thread2();
//		Thread t1 = new Thread(my1);
//		t1.start();
//		Thread t2 = new Thread(my2);
//		t2.start();

		new Ex38Thread2("하나");
		new Ex38Thread2("둘");

		System.out.println("프로그램 종료");

	}
}
