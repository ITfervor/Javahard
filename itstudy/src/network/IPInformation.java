package network;
import java.net.InetAddress;
import java.util.Arrays;

public class IPInformation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//자신의 컴퓨터 IP정보 확인
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost);		
			//도메인을 가지고 IP정보 확인
			InetAddress [] naver = InetAddress.getAllByName("www.naver.com");
			System.out.println(Arrays.toString(naver));
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
			//오늘 날짜로 텍스트 파일을 생성해서 예외를 기록
			
		}
	}

}
