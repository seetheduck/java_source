package pack3;

//public class Ex22Radio implements Ex22InterVol, Ex22VolEtc { // 인터페이스는 ,를 찍어서 다중 상속이 가능하다
public class Ex22Radio implements Ex22InterVol {
	private int v = 0;

	@Override
	public void volUp(int v) {
		this.v += v;
	}

	@Override
	public void volDown(int v) {
		this.v -= v;
	}

	@Override
	public void volOn() {
		v = 1;
	}

	@Override
	public void volOff() {
		v = 0;
	}
	
	public void showVol() {
		System.out.println("현재 볼륨은 " + v);
	}
	
	
}
