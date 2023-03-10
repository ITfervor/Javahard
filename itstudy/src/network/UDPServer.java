package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
		try(DatagramSocket dsoc = new DatagramSocket(7777)) {
				byte [] data = new byte[65536];
				DatagramPacket dp = new DatagramPacket(data, data.length);
				while(true) {
					//데이터 받기
					dsoc.receive(dp);
					//클라이언트 정보 확인
					System.out.println(dp.getAddress());
					//받은 메시지 출력
					System.out.println(new String(dp.getData()));
				}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
