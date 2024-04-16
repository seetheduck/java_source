package pack3;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame5Inner extends Frame{
//	private Wevent wevent;
	int x, y; // mouseClicked 에서 발생한 x, y 좌표를 기억
	private String[] names = {"정재형", "이원재", "지명기", "김성하", "김서현"};

	public MyFrame5Inner() {
		setTitle("내부 클래스");
		setSize(300, 250);
		setLocation(200, 200);
		setVisible(true);

//		wevent  = new Wevent();
//		addWindowListener(wevent);
		addWindowListener(new Wevent());
		addMouseListener(new Mevent());
	}

	class Wevent extends WindowAdapter { // 내부 클래스
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	class Mevent extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			// setTitle("클릭");
			// int x = e.getX(); // 지역변수에 값을 치환
			// int y = e.getY();
			x = e.getX(); // 전역변수에 값을 치환
			y = e.getY();
			setTitle("x : " + x + ", y : " + y);
			
			paint(getGraphics()); // 자동 호출되는 paint()를 명시적으로 호출
			repaint();	// graphics 객체를 가진 paint()를 호출. refresh함
		}
	}

	@Override
	public void paint(Graphics g) { // 자동 호출이 기본
		// frame이 제공하는 그림 그리기 객체
		// g.drawString("홍길동", 100, 100);
		g.setFont(new Font("굴림체", Font.BOLD, (int)(Math.random() * 50 + 8)));
		
		int n = (int)(Math.random() * 5);
		// g.drawString("홍길동", x, y);
		g.drawString(names[n], x, y);
	}

	public static void main(String[] args) {
		new MyFrame5Inner();
	}

}
