package pack6thread;

public class Ex42BreadPlate {
	private int breadCount = 0;	// 스레드간 자원 공유 대상
	
	public Ex42BreadPlate() {
		// TODO Auto-generated constructor stub
	}
	
	// 현재 메소드를 스레드로 호출하면 해당 스레드의 처리가 진행되는 동안 lock이 걸림
	public synchronized void makeBread() {
		if(breadCount >= 10) {
			System.out.println("빵 생산을 목표 초과(10개 기준)");
			try {
				wait();	// 스레드를 not runnable 상태로 만들어줌
			} catch (InterruptedException e) {
				
			}
		}
	
		breadCount++; // 빵을 만듦
		System.out.println("빵 생산 총 개수 : " + breadCount + "개");
		notify(); 	// 스레드를 runnable 상태로 되돌림
	}
	
	public synchronized void eatBread() {
		if(breadCount < 1) {
			System.out.println("빵 부족 새로 만드는 빵 기다림");
			try {
				wait();	// 스레드를 not runnable 상태로 만들어줌
			} catch (InterruptedException e) {
				
			}
			
		}
	
		breadCount--; // 빵을 소비
		System.out.println("빵 소비 후 총 개수 : " + breadCount + "개");
		notify(); 	// 스레드를 runnable 상태로 되돌림
	}
	
}
