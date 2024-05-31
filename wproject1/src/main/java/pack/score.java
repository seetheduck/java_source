package pack;

public class score {
	private int num, kor, eng;
	private String name;
	
	public score(int num, String name, int kor, int eng) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	public int getNum() {
		return num;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public String getName() {
		return name;
	}
	
	
	
}
