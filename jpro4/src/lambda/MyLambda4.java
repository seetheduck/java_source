package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyLambda4 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("람다 연습");
		JButton button1 = new JButton("click1"); // 이벤트 처리
		JButton button2 = new JButton("click2"); // 람다로 이벤트 처리
		JButton button3 = new JButton("click3"); // 컬렉션 처리
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 전통적 방법
				System.out.println("전통적 방법으로 이벤트 처리");
			}
		});
		
		button2.addActionListener(e -> System.out.println("람다 사용 이벤트 처리"));
		button3.addActionListener(e -> callMethod());

		frame.add("North", button1);
		frame.add("Center", button2);
		frame.add("South", button3);
		
		frame.setBounds(200, 200, 400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	static void callMethod() {
		// System.out.println("a");
		ArrayList<jikwon> jikwons = new ArrayList<MyLambda4.jikwon>();
		jikwons.add(new jikwon(3, "홍길동"));
		jikwons.add(new jikwon(1, "고길동"));
		jikwons.add(new jikwon(2, "나길동"));
		
		System.out.println("정렬 전 : ");
//		for(jikwon j:jikwons) {
//			System.out.println(j.bunho);
//		}
		
//		accept(jikwon j){
//			System.out.println(j.bunho + " " + j.irum);
//		}
		jikwons.forEach(j -> System.out.println(j.bunho + " " + j.irum));
		
		System.out.println("Collection.sort 사용");
		// 특정 메소드의 매개변수로 람다식 사용
		Collections.sort(jikwons, new Comparator<jikwon>() {
			public int compare(jikwon o1, jikwon o2) {
				return o1.bunho - o2.bunho;
			}
		});
		
		System.out.println("정렬 후 :");
		jikwons.forEach(jik -> System.out.println(jik.bunho + " " + jik.irum));
		
		System.out.println("정렬 후 2 (람다 사용) : ");
		Collections.sort(jikwons, (o1, o2) -> o1.bunho - o2.bunho);
		jikwons.forEach(jik -> System.out.println(jik.bunho + ". " + jik.irum));
	
	}
	
	static class jikwon{
		int bunho;
		String irum;
		
		public jikwon(int bunho, String irum) {
			this.bunho = bunho;
			this.irum = irum;
		}
	}
	
}
