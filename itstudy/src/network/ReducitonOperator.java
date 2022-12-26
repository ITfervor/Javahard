package network;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReducitonOperator {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍범도", "유관순", "안창호","안중근", "이순신");
		
		Stream <String> stream = list.stream();
		//stream.forEach((temp) -> System.out.println(temp + "\t"));
		
		//2개빼고 출력
		//stream.skip(2).forEach((temp) -> System.out.println(temp + "\t"));
		
		//증복 제거
		//stream.distinct().forEach((temp) -> System.out.println(temp + "\t"));

		//필터링
		//매개변수가 1개이고 Boolean을 리턴하는 함수를 대입
		//stream.filter(name -> name.charAt(0) == '안').forEach((temp) -> System.out.println(temp + "\t"));
		
		//ㅇ으로 시작하는 
		stream.filter(name -> name.charAt(0) >= '아' && name.charAt(0) < '자').forEach((temp) -> System.out.println(temp + "\t"));
	}

}
