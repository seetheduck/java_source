package pack7gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ex46Menu extends JFrame implements ActionListener{
	JButton btnR, btnG, btnB;
	JMenuBar mBar;
	JTextArea txtArea = new JTextArea("", 10, 5); // 키보드로 여러 행 입력 가능
	JMenuItem mnuMes, mnuOk, mnuInput;
	
	public Ex46Menu() {
		setTitle("연습");
		
		addLayout();		// 버튼 관련
		addMenuLayout();	// 메뉴 관련
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		//addWindowListener(....);	윈도우 종료를 아래와 같이 적을 수 있다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void addLayout() {
		btnR = new JButton("빨강");
		btnG = new JButton("초록");
		btnB = new JButton("파랑");
		btnR.addActionListener(this);
		btnG.addActionListener(this);
		btnB.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(btnR);
		panel.add(btnG);
		panel.add(btnB);
		
		add("South", panel);	// Frame은 BorderLayout 이므로
		add("Center", txtArea);
	}
	
	private void addMenuLayout() {
		mBar = new JMenuBar();
		
		JMenu menu = new JMenu("대화상자");
		mnuMes = new JMenuItem("메세지창");
		mnuOk = new JMenuItem("확인창");
		mnuInput = new JMenuItem("입력창");
		menu.add(mnuMes);	// 메뉴에 메뉴 아이템 등록
		menu.add(mnuOk);
		menu.add(mnuInput);
		
		mBar.add(menu);		// 메뉴바에 메뉴 등록
		
		JMenu menu2 = new JMenu("난 메뉴");
		mBar.add(menu2);
		
		setJMenuBar(mBar);
		
		// 메뉴에 리스너 장착
		mnuMes.addActionListener(this);
		mnuOk.addActionListener(this);
		mnuInput.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getActionCommand());
		if(e.getSource() == btnR) {
			txtArea.setBackground(Color.RED);
		}else if(e.getSource() == btnG) {
			txtArea.setBackground(new Color(0, 255, 0));
		}else if(e.getSource() == btnB) {
			txtArea.setBackground(new Color(0, 0, 255));
		}else if(e.getSource() == mnuMes) {	// 메뉴
			// 내장 다이얼로그 박스 호출
			JOptionPane.showMessageDialog(this, "메세지", "알림", JOptionPane.INFORMATION_MESSAGE);
			// Modal dialogbox는 실행을 멈추고 창을 보여준다. 창을 닫으면 처리 진행.
			System.out.println("계속");	// 메세지(showMessageDialog)를 유저가 다 보기 전까지 실행을 멈춤
		}else if(e.getSource() == mnuOk) {
			int result = JOptionPane.showConfirmDialog(this, "버튼을 고르시오", "골라", JOptionPane.YES_NO_CANCEL_OPTION);
			System.out.println(result);
			// if(result == 0) ...
			switch(result) {
			// case 0: ...
			case JOptionPane.YES_OPTION:
				txtArea.append("예 선택\n");
				break;
			case JOptionPane.NO_OPTION:
				txtArea.append("아니오 선택\n");
				break;
			case JOptionPane.CANCEL_OPTION:
				txtArea.append("취소 선택\n");
				break;
			}
		}else if(e.getSource() == mnuInput) {
			String str = JOptionPane.showInputDialog(this, "자료 입력");
			txtArea.append(str + "\n");
		}
		
	}
	
	public static void main(String[] args) {
		// 메뉴 작성, 메세지 박스 ...
		new Ex46Menu();

	}

}
