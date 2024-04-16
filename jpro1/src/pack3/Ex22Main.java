package pack3;

public class Ex22Main {

	public static void main(String[] args) {
		Ex22Radio radio = new Ex22Radio();
		radio.volOn();
		radio.volUp(5);
		radio.volDown(2);
		radio.showVol();
		radio.volOff();
		radio.showVol();
		
	}

}
