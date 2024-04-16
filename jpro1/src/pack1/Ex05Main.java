package pack1;

public class Ex05Main {

	public static void main(String[] args) {
		// 메소드 오버로딩 연습
		Ex05AnimalOverload tiger = new Ex05AnimalOverload();
		tiger.display();
		tiger.display(5);	// 인수(인자, argument)
		tiger.display("호랑이");
		tiger.display("호랭이", 2);
		tiger.display(3, "호돌이");
		
		System.out.println("\n생성자 오버로딩 ---");
		
		Ex05AnimalOverload dog = new Ex05AnimalOverload();
		dog.display();
		
		Ex05AnimalOverload hen = new Ex05AnimalOverload(2);
		hen.display();
		
		Ex05AnimalOverload wolf = new Ex05AnimalOverload("늑대", 3, 4);
		wolf.display();
		
		
	}

}
