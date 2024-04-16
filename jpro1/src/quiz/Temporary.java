package quiz;

public class Temporary extends Employee {
	private int ilsu, ildang;

	public Temporary() {
		// TODO Auto-generated constructor stub
	}

	public Temporary(String irum, int nai, int ilsu, int ildang) {
		super(irum, nai);
		this.ilsu = ilsu;
		this.ildang = ildang;

	}

	public int getIlsu() {
		return ilsu;
	}

	public int getIldang() {
		return ildang;
	}

	@Override
	double pay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void print() {
		display();
		System.out.println(", 월급 : " + ilsu * ildang);

	}

}
