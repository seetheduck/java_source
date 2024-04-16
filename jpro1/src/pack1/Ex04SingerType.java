package pack1;

public class Ex04SingerType { // 가수들이 가져야할 기본 멤버를 클래스로 작성
	private String name = "무명가수"; // 이름
	private String title = "아 대한민국"; // 곡 제목
	// ...

	public Ex04SingerType(String name, String title) {
		this.name = name;
		this.title = title;
	}

	public String getName() { // getter
		return name;
	}

	public String getTitle() {
		return title;
	}

	public void sing() {
		System.out.println(name + " is singing " + title + "...");
	}
	
	
	
	public static void main(String[] args) {
		// 응용 프로그램 시작용 메소드
		// Ex04SingerType 멤버는 아님
		Ex04SingerType bts = new Ex04SingerType("bts", "dynamite");
		bts.sing();
		System.out.println("가수 이름 : " + bts.getName());
		System.out.println("곡 제목 : " + bts.getTitle());
		
		System.out.println();
		
		Ex04SingerType blackpink = new Ex04SingerType("blackpink", "how you like that");
		blackpink.sing();
		System.out.println("가수 이름 : " + blackpink.getName());
		System.out.println("곡 제목 : " + blackpink.getTitle());
		
		
	}

}
