package quiz;

public class Salesman extends Regular {
	private int sales;
	private double commission;
	
	public Salesman() {
		// TODO Auto-generated constructor stub
	}
	 
	public Salesman(String irum, int nai, int salary, int sales, double commission) {
		super(irum, nai, salary);
		this.sales = sales;
		this.commission = commission;
	}
	
	@Override
	void print() {
		display();
		System.out.println(", 수령액(실적 * 수수료율) : " + (pay() + sales * commission));
	}
	
}
