package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import pack7gui.Ex44Event.EventTest;

public class Ex48Mini extends JFrame implements ActionListener {
	JTextField num1, num2;
	ButtonGroup buttonGroup = new ButtonGroup();
	ButtonGroup buttonGroup2 = new ButtonGroup();
	JRadioButton plus, minus, gop, na;
	JLabel lblResult;
	JButton button, button1, button2;

	public Ex48Mini() {
		super("미니 계산기");

		layoutInit();

		setBounds(200, 200, 400, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 종료 버튼에 종료 기능 추가
			}
		});

	}

	private void layoutInit() {

		// 1행 : 숫자 1 입력 필드
		setLayout(new GridLayout(5, 1));
		JLabel lbl1 = new JLabel("숫자1 : ");
		num1 = new JTextField("", 20);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(num1);
		add(panel1);

		// 2행 : 숫자 2 입력 필드
		JLabel lbl2 = new JLabel("숫자2 : ");
		num2 = new JTextField("", 20);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(num2);
		add(panel2);

		// 3행 : +,-,*,/ 들 라디오 버튼으로 나열, 기본 값은 +
		plus = new JRadioButton("+", true);
		minus = new JRadioButton("-", false);
		gop = new JRadioButton("*", false);
		na = new JRadioButton("/", false);
		buttonGroup.add(plus); // JRadioButton을 그룹화
		buttonGroup.add(minus);
		buttonGroup.add(gop);
		buttonGroup.add(na);
		JPanel panel3 = new JPanel();
		panel3.add(plus);
		panel3.add(minus);
		panel3.add(gop);
		panel3.add(na);
		add(panel3);

		// 4행 : 결과값 보여주는 곳.
		lblResult = new JLabel("결과 : ", JLabel.CENTER);
		add(lblResult);

		// 5행 : 계산, 초기화, 종료 버튼
		button = new JButton("계산");
		button1 = new JButton("초기화");
		button2 = new JButton("종료");
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		buttonGroup2.add(button);
		buttonGroup2.add(button1);
		buttonGroup2.add(button2);
		JPanel panel4 = new JPanel();
		panel4.add(button);
		panel4.add(button1);
		panel4.add(button2);

		add(panel4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) { // 계산 버튼이 눌렸을 때
			if (num1.getText().equals("")) { // 아무것도 입력되지 않았을 때 입력하게끔 유도
				lblResult.setText("숫자1 입력!");
				num1.requestFocus();
				return;
			} else if (num2.getText().equals("")) {
				lblResult.setText("숫자2 입력!");
				num2.requestFocus();
				return;
			}

			int number = 0;
			try { // 입력된 숫자를 number 변수에 대입하고, 정수가 아닌 값이 입력됐을때는 숫자를 입력하게끔 유도
				number = Integer.parseInt(num1.getText());
			} catch (Exception e2) {
				lblResult.setText("숫자만 가능");
				num1.requestFocus();
				return;
			}

			int nai2 = 0;
			try {
				nai2 = Integer.parseInt(num2.getText());
			} catch (Exception e2) {
				lblResult.setText("숫자만 가능");
				num2.requestFocus();
				return;
			}

			int res = 0; // isSelected() 메소드를 사용하여 체크된 라디오 버튼이 무엇인지 판단 후 연산
			if (plus.isSelected()) {
				res = number + nai2;
			} else if (minus.isSelected()) {
				res = number - nai2;
			} else if (gop.isSelected()) {
				res = number * nai2;
			} else if (na.isSelected()) {
				if(number == 0) {
					lblResult.setText("0으로 나누기 불가");
					num1.requestFocus();
					return;
				}
				else if(nai2 == 0){
					lblResult.setText("0으로 나누기 불가");
					num2.requestFocus();
					return;
				}
				res = number / nai2;
			}

			String mes = "결과는 : " + res;
			lblResult.setText(mes);
		} else if (e.getSource() == button1) { // 초기화 버튼이 눌렸을 때 값들 초기화
			num1.setText("");
			num2.setText("");
			plus.setSelected(true);
			lblResult.setText("결과 : ");
		} else if (e.getSource() == button2) { // 종료 버튼이 눌렸을 때
			int result = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "알림", JOptionPane.YES_NO_OPTION);
			switch (result) {
			case JOptionPane.YES_OPTION:
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				return;
			}
		}

	}

	public static void main(String[] args) {
		new Ex48Mini();

	}

}
