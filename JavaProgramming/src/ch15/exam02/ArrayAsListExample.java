package ch15.exam02;

import java.util.Arrays;
import java.util.List;

public class ArrayAsListExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("ȫ�浿", "�ſ��", "�ڹ�");		//Arrays.asList() �� �迭�� ������ ���ϴ�
		for(String name : list){
			System.out.println(name);
		}
		//list.add("�迵��");

		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for(int value : list2){
			System.out.println(value);
		}
	}

}
