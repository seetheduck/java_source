package pack;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest08 extends JFrame implements ActionListener{
	JTextField name = new JTextField("", 10);
	JTextField jum1 = new JTextField("", 10);
	JTextField jum2 = new JTextField("", 10);
	JButton check = new JButton("확인");
	JTextArea result = new JTextArea();
	String sql = "";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest08() {
		super("고객정보문제");
		
		setLayout(new GridLayout(3,1));
		
		accDb();
		layInit();

		setBounds(200, 200, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void layInit() {
		JPanel panel1 = new JPanel();
		panel1.add(new Label("고객명 : "));	// 한글 깨질 때 project property에서 run/debug 세팅 들어가서 arguments에 -Dfile.encoding=MS949 추가
		panel1.add(name);
		add("North",panel1);
		
		JPanel panel2 = new JPanel();
		panel2.add(new Label("주민번호 : "));
		panel2.add(jum1);
		panel2.add(new Label("-"));
		panel2.add(jum2);
		add("North",panel2);
		
		result.setEditable(false);
		JScrollPane pane = new JScrollPane(result);
		add("Center",pane);
		
	}
	
	private void accDb() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new DbTest08();

	}

}
