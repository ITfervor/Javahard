package network;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		try {
			//접속할 컴퓨터의 IP정보를 가져오기
			InetAddress addr = InetAddress.getByName("192.168.0.10");
			//9999번 포트롱 연결
			Socket socket = new Socket(addr, 9999);
			//문자열 전송하기 위한 스트림
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("");
			pw.flush();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
