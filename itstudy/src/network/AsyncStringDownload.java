package network;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncStringDownload {

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				
				try {
					//URL을 생성
					URL url = new URL(
							"http://www.kakao.com");
					//연결객체 생성
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					//연결옵션 설정
					con.setConnectTimeout(10000);
					con.setUseCaches(false);
					con.setRequestMethod("GET");
					
					//읽기 위한 스트림 생성
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					
					//파싱을 하기 위한 스트링 빌더
					StringBuilder sb = new StringBuilder();
					while(true) {
						String line = br.readLine();
						if(line == null) {
							break;
						}
						sb.append(line + "\n");
					}
					String html = sb.toString();
					System.out.println(html);
					br.close();
					con.disconnect();
				} catch (Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
		}.start();
	}

}
