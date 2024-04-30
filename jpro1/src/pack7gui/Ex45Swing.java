package pack7gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
Swing
AWT 기술을 기반으로 순수 자바 언어로 만들어진 라이브러리
모든 AWT 기능 + 추가된 풍부하고 화려한 고급 컴포넌트
AWT 컴포넌트에 J자가 덧붙여진 이름의 클래스
그 외 J 자로 시작하는 클래스
javax.swing 패키지
Swing 컴포넌트는 경량 컴포넌트(Light weight components)
native(peer) 운영체제에 의존하지 않음
*/


public class Ex45Swing extends JFrame implements ActionListener{
	JLabel lblShow;
	int count = 0;
	
	public Ex45Swing() {
		setTitle("스윙 연습");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));	// top, left, bottom, right 여백 주기
		
		JButton button = new JButton("클릭");
		button.setMnemonic(KeyEvent.VK_C);	// Mnemonic key : alt + C
		button.addActionListener(this);
		
		panel.add(button);
		
		lblShow = new JLabel("버튼 클릭 수 : 0");
		panel.add(lblShow);
		
		add(panel, BorderLayout.CENTER);
		//add("Center", panel);	// 위의 결과와 동일
		
		setBounds(200, 200, 300, 300);
		setVisible(true);
		
		//addWindowListener(....);	윈도우 종료를 아래와 같이 적을 수 있다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		lblShow.setText("버튼 클릭 수 : " + count);
		
	}
	
	public static void main(String[] args) {
		new Ex45Swing();
		
	}

}
