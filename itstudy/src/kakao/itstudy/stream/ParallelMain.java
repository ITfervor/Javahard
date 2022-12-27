package kakao.itstudy.stream;

import java.util.Arrays;
import java.util.List;

public class ParallelMain {

	public static void main(String[] args) {
		// 정수 리스트 생성
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		// 일반 스트림으로 1초씩 쉬면서 출력
		long start = System.currentTimeMillis();
		list.stream().forEach(imsi -> {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		long end = System.currentTimeMillis();
		System.out.println("걸린시간 : " + (end - start));

		// 병렬 스트림으로 1초씩 쉬면서 출력 parallel추가
		start = System.currentTimeMillis(); 
		list.stream().parallel().forEach(imsi -> {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		end = System.currentTimeMillis();
		System.out.println("걸린시간 : " + (end - start));

	}

}
