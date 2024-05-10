package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestServer {

	public static void main(String[] args) {
		// 단순 서버
		ServerSocket ss = null;
		
		// 내 컴퓨터가 사용중인 port number 확인
//		for(int i=0; i<65536; i++) {
//			try {
//				ss = new ServerSocket(i);
//				ss.close();
//			} catch (Exception e) {
//				System.out.println(i + "번 포트는 사용중");
//			}
//		}
//		System.out.println("확인 종료");
		
		Socket socket = null;	// TCP 기반의 통신용 클래스(파일)
		try {
			ss = new ServerSocket(9999);
			System.out.println("서버 서비스 시작...");
			socket = ss.accept();	// 서버 소켓으로부터 클라이언트 컴과 통신하기위한 개별 소켓 생성
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
			String data = reader.readLine();
			System.out.println("수신자료 : " + data);
			
			reader.close();
			socket.close();
			ss.close();
			
		} catch (Exception e) {
			System.out.println("서버 에러 : " + e);
		}
		
	}

}
