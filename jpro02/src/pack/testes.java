package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class testes extends JFrame implements ActionListener {
	JTextField buName = new JTextField("", 10);
	JTextArea result = new JTextArea();
	JButton bt = new JButton("실행");

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public testes() {
		super("test");

		layoutInit();
		accDb();

		setBounds(200, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void layoutInit() {
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("부서명 : "));
		panel1.add(buName);
		panel1.add(bt);
		add("North", panel1);

		result.setEditable(false);
		JScrollPane pane = new JScrollPane(result);

		add("Center", pane);

		bt.addActionListener(this);

	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}
	}

	private void connectDB() {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("connectDB err : " + e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			connectDB();

			String sql = "select * from jikwon";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			result.setText("사번\t이름\t직급\t성별");
			boolean b = rs.getString("buser_name").equals(buName.getText());
			if (b) {

				String p = "";
				System.out.println("부서 전화번호는 " + rs.getString("buser_tel"));
				p = "부서 전화번호는 " + rs.getString("buser_tel");
				result.append(p);
				String sql2 = "select * from jikwon inner join buser on buser_num=buser_no group by buser_num having avg(jikwon_pay)";
				pstmt = conn.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				String temp = "";
				while (rs.next()) {
					temp = rs.getString("jikwon_no") + "\t" + rs.getString("jikwon_name") + "\t"
							+ rs.getString("jikwon_jik") + "\t" + rs.getString("jikwon_gender");
					result.append(temp);
				}

				temp = "";
				sql = "select jikwon_gender, count(jikwon_no) from jikwon group by jikwon_gender";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					temp = "인원수는  " + rs.getString("jikwon_gender") + " : " + rs.getString("count(jikwon_no)") + "\t";
					result.append(temp);
				}

				temp = "";
				sql = "select jikwon_gender, round(avg(jikwon_pay)) from jikwon group by jikwon_gender";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					temp = "연봉 평균은 " + rs.getString("jikwon_gender") + " : " + rs.getString("round(avg(jikwon_pay))")
							+ "\t";
					result.append(temp);
				}

			} else {
				result.setText(null);
				JOptionPane.showMessageDialog(this, "정보 이상");
			}

		} catch (Exception e2) {
			System.out.println("error : " + e);
		}
	}

	public static void main(String[] args) {
		new testes();

	}

}
