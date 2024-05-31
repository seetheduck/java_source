package pack;

//한개 상품이 이름과 가격으로 구성됨. 이를 하나의 객체로 만들기 위한 dto(vo) 클래스
public class goods {
	private String name;
	private int price;
	
	public goods(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
}
