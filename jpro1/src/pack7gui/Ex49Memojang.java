package pack7gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Ex49Memojang extends JFrame implements ActionListener {
	private JTextArea txtMemo = new JTextArea("", 10, 30);
	private String copyText; // 복사한 문자열 잠시 보관용

	private JMenuItem mnuNew, mnuSave, mnuOpen, mnuExit;
	private JMenuItem mnuCopy, mnuPaste, mnuCut, mnuDel, mnuFontSize;
	private JMenuItem mnuAbout, mnuEtc1, mnuEtc2;
	
	private JPopupMenu popup; // 팝업 메뉴
	private JMenuItem m_white, m_blue, m_yellow;

	public Ex49Memojang() {
		super("메모장");

		initLayout();
		menuLayout();

		setBounds(200, 200, 400, 350);
		setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Ex49Memojang.this, "종료하시겠습니까?", "알림",
						JOptionPane.YES_NO_OPTION);
				switch (result) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					return;
				}
			}
		});
	}

	private void initLayout() {
		JScrollPane scrollPane = new JScrollPane(txtMemo);
		txtMemo.setFont(new Font("돋움", Font.PLAIN, 16));
		add("Center", scrollPane);
	}

	private void menuLayout() {
		JMenuBar menubar = new JMenuBar(); // 메뉴바

		JMenu mnuFile = new JMenu("파일"); // 주메뉴
		mnuNew = new JMenuItem("새문서"); // 부메뉴
		mnuOpen = new JMenuItem("열기...");
		mnuSave = new JMenuItem("저장...");
		mnuExit = new JMenuItem("종료");
		mnuFile.add(mnuNew);
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.addSeparator(); // 구분선
		mnuFile.add(mnuExit); // 메뉴에 부메뉴 등록

		JMenu mnuEdit = new JMenu("편집"); // 주메뉴
		mnuCopy = new JMenuItem("복사");
		mnuCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); // 단축키
		mnuPaste = new JMenuItem("붙여넣기");
		mnuCut = new JMenuItem("잘라내기");
		mnuDel = new JMenuItem("삭제");
		mnuFontSize = new JMenuItem("글꼴 크기...");
		mnuEdit.add(mnuCopy);
		mnuEdit.add(mnuPaste);
		mnuEdit.add(mnuCut);
		mnuEdit.add(mnuDel);
		mnuEdit.addSeparator(); // 구분선
		mnuEdit.add(mnuFontSize);

		JMenu mnuShow = new JMenu("보기"); // 주메뉴
		mnuAbout = new JMenuItem("메모장이란...");
		mnuEtc1 = new JMenuItem("계산기");
		mnuEtc2 = new JMenuItem("카페");
		mnuShow.add(mnuAbout);
		mnuShow.addSeparator(); // 구분선
		mnuShow.add(mnuEtc1);
		mnuShow.add(mnuEtc2);

		menubar.add(mnuFile); // 메뉴바에 주메뉴 등록
		menubar.add(mnuEdit);
		menubar.add(mnuShow);

		setJMenuBar(menubar); // JFrame에 메뉴바 등록

		// 메뉴에 리스너 달기
		mnuNew.addActionListener(this);
		mnuOpen.addActionListener(this);
		mnuSave.addActionListener(this);
		mnuExit.addActionListener(this);
		mnuCopy.addActionListener(this);
		mnuPaste.addActionListener(this);
		mnuCut.addActionListener(this);
		mnuDel.addActionListener(this);
		mnuFontSize.addActionListener(this);
		mnuAbout.addActionListener(this);
		mnuEtc1.addActionListener(this);
		mnuEtc2.addActionListener(this);
		
		// 팝업 메뉴
		popup = new JPopupMenu();
		JMenu menuColor = new JMenu("색 선택");
		m_white = new JMenuItem("하양");
		m_blue = new JMenuItem("파랑");
		m_yellow = new JMenuItem("노랑");
		menuColor.add(m_white);
		menuColor.add(m_blue);
		menuColor.add(m_yellow);
		m_white.addActionListener(this);
		m_blue.addActionListener(this);
		m_yellow.addActionListener(this);
		popup.add(menuColor);
		txtMemo.add(popup);	// txtMemo에 팝업 메뉴 추가
		
		txtMemo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 마우스 오른쪽 버튼 클릭 시 해당 지점에 팝업 띄우기
//				if(e.getModifiers() == MouseEvent.BUTTON3_MASK) {
//					popup.show(txtMemo, e.getX(), e.getY());
//				}
				
				// getModifiersEx() : 마우스 또는 키보드 이벤트가 발생할 때 해당 이벤트와 함께
				// 어떤 추가 키(예: shift, control)가 눌렸는지를 확인할 때 사용
				if((e.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) == MouseEvent.BUTTON3_DOWN_MASK){
					popup.show(txtMemo, e.getX(), e.getY());
				} // BUTTON3_DOWN_MASK : 마우스 오른쪽 버튼이 눌린 상태를 나타내는 상수
				
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getActionCommand());
		// System.out.println(e.getSource());
		if (e.getSource() == mnuNew) { // 새문서
			txtMemo.setText("");
			setTitle("제목 없음");
		} else if (e.getSource() == mnuOpen) { // 열기
			// 파일 열기를 위한 경로명과 파일명 얻기는 os 지원 창을 사용
			FileDialog dialog = new FileDialog(this, "저장", FileDialog.LOAD);
			dialog.setDirectory("."); // 현재 디렉토리
			dialog.setVisible(true);
			if (dialog.getFile() == null)
				return;
			String dfName = dialog.getDirectory() + dialog.getFile(); // 저장 경로 파일명 얻기

			try {
				BufferedReader reader = new BufferedReader(new FileReader(dfName));

				txtMemo.setText("");
				String line = "";
				while ((line = reader.readLine()) != null) {
					txtMemo.append(line + "\n");
				}
				reader.close();

				setTitle(dialog.getFile() + " - 메모장");
			} catch (Exception e2) {
				System.out.println(e2); // 개발자가 보기 위함
				JOptionPane.showMessageDialog(this, e2.getMessage(), "에러", JOptionPane.WARNING_MESSAGE); // 사용자에게 보여줌
			}

		} else if (e.getSource() == mnuSave) { // 저장
			// 파일 저장을 위한 경로명과 파일명 얻기는 os 지원 창을 사용
			FileDialog dialog = new FileDialog(this, "저장", FileDialog.SAVE);
			dialog.setDirectory("."); // 현재 디렉토리
			dialog.setVisible(true);
			if (dialog.getFile() == null)
				return;
			String dfName = dialog.getDirectory() + dialog.getFile(); // 저장 경로 파일명 얻기
			// System.out.println("dfName : " + dfName);

			try {
//				BufferedWriter writer = new BufferedWriter(new FileWriter("c:/work/a.txt"));

				BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
				writer.write(txtMemo.getText()); // c:\\work\\a.txt <- 윈도우
				writer.close();
				setTitle(dialog.getFile());
			} catch (Exception e2) {
				System.out.println(e2); // 개발자가 보기 위함
				JOptionPane.showMessageDialog(this, e2.getMessage(), "에러", JOptionPane.WARNING_MESSAGE); // 사용자에게 보여줌
			}
		} else if (e.getSource() == mnuExit) { // 종료
			int result = JOptionPane.showConfirmDialog(Ex49Memojang.this, "종료하시겠습니까?", "알림", JOptionPane.YES_NO_OPTION);
			switch (result) {
			case JOptionPane.YES_OPTION:
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				return;
			}
		} else if (e.getSource() == mnuCopy) { // 복사
			// System.out.println(txtMemo.getText());
			copyText = txtMemo.getSelectedText();

		} else if (e.getSource() == mnuPaste) { // 붙여넣기
			// txtMemo.setText(copyText);
			int position = txtMemo.getCaretPosition();
			txtMemo.insert(copyText, position);

		} else if (e.getSource() == mnuCut) { // 잘라내기
			copyText = txtMemo.getSelectedText();

			// copyText에 저장된 부분은 txtMemo에서 지움
			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);

		} else if (e.getSource() == mnuDel) { // 삭제
			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);

		} else if (e.getSource() == mnuFontSize) { // 글꼴 크기
			String fontSize = JOptionPane.showInputDialog(this, "글꼴 크기:", "16");
			if (fontSize != null) {
				try {
					int fSize = Integer.parseInt(fontSize);
					txtMemo.setFont(new Font(txtMemo.getFont().getName(), txtMemo.getFont().getStyle(), fSize));

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "글자 크기를 정확히 입력하세요");
				}
			}

		} else if (e.getSource() == mnuAbout) { // 메모장이란
			new Ex49MemoAbout(this);
			System.out.println("About 호출 후 상황"); // Modal과 Modaless 구분

		} else if (e.getSource() == mnuEtc1) { // 기타1
			// exe (실행파일) 실행하기
			try {
				Runtime runtime = Runtime.getRuntime();
				runtime.exec("calc.exe");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage());
			}

		} else if (e.getSource() == mnuEtc2) { // 기타2
			// 브라우저 실행하기
			try {
//				Desktop 클래스는 Java 응용 프로그램 URI 나 파일을 처리하기 위해 기본 등록된 관련 응용 프로그램을 실행 할 수 있다.
//				- 지원하는 기능
//				1. 기본 브라우저를 통해서 URL 전시
//				2. 메일 클라이언트 실행
//				3. 기본 응용프로그램을 통해서 파일을 열거나 편집
				
				String url = "https://cafe.daum.net/flowlife";
				// Desktop 지원 확인
				if(Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					if(desktop.isSupported(Desktop.Action.BROWSE)) {
						// URI는 문자열 특정 리소스를 가리킴 서버에 위치한 파일
						// 이메일주소, 책, 사람 이름, 인터넷 호스트, 오라클의 현재 주가 등 특별한 구문으로 구성

						desktop.browse(new URI(url));
					}else {
						JOptionPane.showMessageDialog(this, "브라우저 지원 안함");
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage());
			}
		} else if(e.getSource() == m_white) {
			txtMemo.setBackground(Color.WHITE);
		} else if(e.getSource() == m_blue) {
			txtMemo.setBackground(Color.BLUE);
		}else if(e.getSource() == m_yellow) {
			txtMemo.setBackground(Color.YELLOW);
		}

	}

	public static void main(String[] args) {
		// 간단한 메모장 만들기
		new Ex49Memojang();
	}

}
