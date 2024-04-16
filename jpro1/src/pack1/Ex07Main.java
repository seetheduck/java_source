package pack1;

public class Ex07Main {

	public static void main(String[] args) {
		Ex07Production bottle = new Ex07Production("물병", 12000, 3.5);
		
		bottle.show();
		
		bottle.setName("술병");
		
		bottle.show(10500);
		
		bottle.setWeight(2.7);
		
		bottle.show("물통");
		
		Ex07Production goggle = new Ex07Production("고글", 32800, 1.4);
		
		goggle.show();
		
		if(goggle.equals(bottle)) {
			System.out.println("같다");
		} else System.out.println("다르다");
		
		
	}

}
