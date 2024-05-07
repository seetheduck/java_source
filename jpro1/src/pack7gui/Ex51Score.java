package pack7gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex51Score extends JFrame implements ActionListener {
	JTextField name, guk, eng, math;
	JButton check, re;
	JLabel result, avg, pg;
	ButtonGroup buttonGroup = new ButtonGroup();
	Image img;
	int selim;

	public Ex51Score() {

		super("성적 출력");

		scoreLayout();

		setBounds(200, 200, 500, 400);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void scoreLayout() {
		setLayout(new GridLayout(5, 1));

		// 1행
		JLabel space = new JLabel("이름 : ");
		name = new JTextField("", 20);
		JPanel pan1 = new JPanel();
		pan1.add(space);
		pan1.add(name);
		add(pan1);

		// 2행
		JLabel ko = new JLabel("국어 : ");
		JLabel en = new JLabel("영어 : ");
		JLabel su = new JLabel("수학 : ");
		guk = new JTextField("", 5);
		eng = new JTextField("", 5);
		math = new JTextField("", 5);
		JPanel pan2 = new JPanel();
		pan2.add(ko);
		pan2.add(guk);
		pan2.add(en);
		pan2.add(eng);
		pan2.add(su);
		pan2.add(math);
		add(pan2);

		// 3행
		result = new JLabel("총점 : ");
		avg = new JLabel("평균 : ");
		pg = new JLabel("평가 : ");
		JPanel pan3 = new JPanel();
		pan3.add(result);
		pan3.add(avg);
		pan3.add(pg);
		add(pan3);

		// 4행
		check = new JButton("확인");
		re = new JButton("초기화");
		check.addActionListener(this);
		re.addActionListener(this);
		buttonGroup.add(check);
		buttonGroup.add(re);
		JPanel pan4 = new JPanel();
		pan4.add(check);
		pan4.add(re);
		add(pan4);

		// 5행
		JLabel imgimg = new JLabel(new ImageIcon("C:\\work\\jsou\\jpro1\\src\\pack7gui\\ddabom.jpg"));
		imgimg.setSize(50, 50);
		add(imgimg);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == check) {
			if (name.getText().equals("")) { // 아무것도 입력되지 않았을 때 입력하게끔 유도
				JOptionPane.showMessageDialog(this, "이름을 입력해주세요");
				name.requestFocus();
				return;
			} else if (guk.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "국어 점수를 입력해주세요");
				guk.requestFocus();
				return;
			} else if (eng.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "영어 점수를 입력해주세요");
				eng.requestFocus();
				return;
			} else if (math.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "수학 점수를 입력해주세요");
				math.requestFocus();
				return;
			}

			int num1, num2, num3;

			try { // 입력된 숫자를 number 변수에 대입하고, 정수가 아닌 값이 입력됐을때는 숫자를 입력하게끔 유도
				num1 = Integer.parseInt(guk.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "숫자를 입력해주세요");
				guk.requestFocus();
				return;
			}
			try {
				num2 = Integer.parseInt(eng.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "숫자를 입력해주세요");
				eng.requestFocus();
				return;
			}
			try {
				num3 = Integer.parseInt(math.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "숫자를 입력해주세요");
				math.requestFocus();
				return;
			}

			int res, ag;
			res = num1 + num2 + num3;
			ag = (num1 + num2 + num3) / 3;
			String mes = "합계 :" + res;
			String mes2 = "평균 : " + ag;

			if(ag > 100) {
				JOptionPane.showMessageDialog(this, "평균 100점 초과");
			}
			result.setText(mes);
			avg.setText(mes2);
			switch (ag) {
			case 90:
				pg.setText("평가 : A");
				break;
			case 80:
				pg.setText("평가 : B");
				break;
			case 70:
				pg.setText("평가 : C");
				break;
			case 60:
				pg.setText("평가 : D");
				break;
			default:
				pg.setText("평가 : E");
				break;
			}

		} else if (e.getSource() == re) {
			name.setText("");
			guk.setText("");
			eng.setText("");
			math.setText("");
			result.setText("총점 : ");
			avg.setText("평균 : ");
			pg.setText("평가 : ");
		}

	}

	public static void main(String[] args) {
		new Ex51Score();

	}

}
