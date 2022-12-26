package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {//데이터를 보낼때 상대방 주소가 있어야해서 괄호 안에서 못 만듦

	public static void main(String[] args) {
		try {
			Scanner sc =new Scanner(System.in);
			while(true) {
				System.out.print("보낼 메시지");
				String msg = sc.nextLine();
				//보낼 곳의 IP생성
				InetAddress addr = InetAddress.getByName("192.168.0.10");
				//소켓 생성
				DatagramSocket ds = new DatagramSocket();
				//보낼 패킷생성
				DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, 7777);
				ds.send(dp);
				ds.close();
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
