package pack1;

public class Ex07Production {
	private String name;
	private int price;
	private double weight;
	
	public Ex07Production() {
		
	}
	public Ex07Production(String name, int price, double weight) { // 생성자 오버로딩
		this.name = name;
		this.price = price;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void show() {
		System.out.println("제품명 : " + name + ", 가격 : " + price + "원, 무게 : " + weight + "kg");
	}
	
	public void show(int price) { // 메소드 오버로딩
		this.price = price;
		System.out.println("제품명 : " + name + ", 가격 : " + price + "원, 무게 : " + weight + "kg");
	}
	
	public void show(String name) { // 메소드 오버로딩
		this.name = name;
		System.out.println("제품명 : " + name + ", 가격 : " + price + "원, 무게 : " + weight + "kg");
	}
	
}
