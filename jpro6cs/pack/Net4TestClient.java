package pack;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net4TestClient {

	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName("192.168.0.18");
			//System.out.println(ia);
			//Socket socket = new Socket(ia, 9999);
			
			Socket socket = new Socket("192.168.0.18", 9999);	// 서버와 접속
			
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8), true);
			writer.println("Hi I'm Lee" + "\n");	// 서버로 자료 전송
			
			writer.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("client error : " + e);
		}

		// 특정 컴의 접속 후 메세지 전달음
	}

}
