package pack;

import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DbTest03Gogek extends JFrame implements ActionListener {
	JButton btnA = new JButton("전체");
	JButton btnM = new JButton("남자");
	JButton btnF = new JButton("여자");
	JTextArea txtResult = new JTextArea();

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public DbTest03Gogek() {
		setTitle("고객 자료");

		layInit();
		accDb();

		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void layInit() {
		JPanel jpanel = new JPanel();
		jpanel.add(btnA);
		jpanel.add(btnM);
		jpanel.add(btnF);

		txtResult.setEditable(false); // read only
		JScrollPane pane = new JScrollPane(txtResult);

		add("Center", pane);
		add("North", jpanel);

		btnA.addActionListener(this);
		btnM.addActionListener(this);
		btnF.addActionListener(this);

	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
			
			stmt = conn.createStatement();
			
			String sql = "select gogek_no,gogek_name,gogek_jumin from gogek";
			
			if(e.getSource() == btnA) {
				
			} else if(e.getSource() == btnM) {
				sql += " where gogek_jumin like '%-1%'";
				// sql += " where substr(gogek_jumin,8,1) = 1";
			} else if(e.getSource() == btnF) {
				sql += " where gogek_jumin like '%-2%'";
			}
			
			txtResult.setText("");
			rs = stmt.executeQuery(sql);
			int count = 0;
			txtResult.setText("고객번호\t고객명\t주민번호\n");
			
			while(rs.next()) {
				String imsi = rs.getString("gogek_no") + "\t" +
				rs.getString("gogek_name") + "\t" +
				rs.getString("gogek_jumin") + "\n";
				
				txtResult.append(imsi);
				count++;
			
			}
			txtResult.append("인원수 : " + count);
			
		} catch (Exception e2) {
			System.out.println("actionPerfomed err : " + e);
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			}catch (Exception e2) {
				
			}
		}
	}

	@Override
	public Font getFont() {
		// TODO Auto-generated method stub
		return super.getFont();
	}

	@Override
	public boolean postEvent(Event e) {
		// TODO Auto-generated method stub
		return super.postEvent(e);
	}

	public static void main(String[] args) {
		new DbTest03Gogek();

	}

}
