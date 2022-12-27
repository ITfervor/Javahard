package kakao.itstudy.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamMain {

	public static void main(String[] args) {
		// Student 클래스의 List생성
		List <Student> list = new ArrayList<>();
		list.add(new Student(1, "김좌진", "남자", "컴공", 66));
		list.add(new Student(2, "강감찬", "남자", "역사", 61));
		list.add(new Student(3, "안중근", "남자", "약학", 78));
		list.add(new Student(4, "유관순", "여자", "독학", 40));
		list.add(new Student(5, "유유유", "여자", "컴공", 70));
		
		//score의 합계 맵투인투는 정수로 표현하겠다는 메서드
		//Student를 student.getScore메서드의 결과를 이용해서 
		//정수로 변환해서 합계를 구함
		int sum = list.stream().mapToInt(Student::getScore).sum();
		System.out.println("점수의 합계" + sum);
		
		OptionalDouble avg = list.stream().mapToInt(Student::getScore).average();
		
		if(avg.isPresent() == true) {
		System.out.println("평균" + avg.getAsDouble());
		}else {
			System.out.println("평균을 구할수 없음");
		}
		
		//reduce - 집계
		//매개변수가 2개이고 리턴이 있는 메서드를 제공
		//처음 2개의 데이터를 가지고 메서드를 호출해서 결과를 만들고
		//그 다음부터는 결과 다음 데이터를 가지고 메서드를 호출
		sum = list.stream().mapToInt(Student::getScore).reduce(0, (n1, n2) -> n1 + n2);
		
		//남자만 추출해서 List로 변환
		List<Student> manList = list.stream().filter(student -> student.getGender().equals("남자"))
		.collect(Collectors.toList());
		System.out.println(manList);
		
		//gender별로 그룹화해서 score의 평균 구하기
		Map<String, Double> genderMap = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getScore)));
		//
		System.out.println(genderMap.get("남자"));
	}

}
