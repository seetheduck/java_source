package quiz;

abstract public class Employee {
	private String irum;
	private int nai;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String irum, int nai) {
		this.irum = irum;
		this.nai = nai;
	}

	public String getIrum() {
		return irum;
	}

	public int getNai() {
		return nai;
	}

	abstract double pay();

	abstract void print();

	public void display() {
		System.out.print("이름 : " + irum + ", 나이 : " + nai);
	}

}
