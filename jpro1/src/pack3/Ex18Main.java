package pack3;

public class Ex18Main {

	public static void main(String[] args) {
		Ex18Cow cow = new Ex18Cow();
		System.out.println(cow.action());
		System.out.println(cow.eat());
		System.out.println(cow.name());
		cow.animalPrint();
		
		System.out.println();
		
		Ex18Lion lion = new Ex18Lion();
		System.out.println(lion.action());
		System.out.println(lion.eat());
		System.out.println(lion.name());
		lion.animalPrint();
		lion.eatOther(); // 사자 고유 메소드
		
		System.out.println();
		Ex18Animal animal;
		
		animal = cow;
		System.out.println(animal.name());
		animal = lion;
		System.out.println(animal.name());
		
		System.out.println("\n별도의 클래스 사용해보기");
		Ex18FindUtil.find(cow);
		
		
	}

}
