package network;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorLambda {

	public static void main(String[] args) {
		// 데이터 정렬을 위해서 문자열 배열 생성
		String [] ar = {"야구", "축구", "배구", "풋살", "족구"};
		/*
		Arrays.sort(ar, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1);
			}
			*/
			Arrays.sort(ar, (o1, o2) -> 
				o2.compareTo(o1)
			
		);
		
		System.out.println(Arrays.toString(ar));

	}

}
