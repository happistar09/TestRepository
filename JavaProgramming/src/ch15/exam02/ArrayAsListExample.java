package ch15.exam02;

import java.util.Arrays;
import java.util.List;

public class ArrayAsListExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "신용권", "자바");		//Arrays.asList() 는 배열의 성질이 강하다
		for(String name : list){
			System.out.println(name);
		}
		//list.add("김영민");

		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for(int value : list2){
			System.out.println(value);
		}
	}

}
