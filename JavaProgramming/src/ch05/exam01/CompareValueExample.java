package ch05.exam01;

public class CompareValueExample {

	public static void main(String[] args) {
			int v1 = 10;
			int v2 = 10;
			System.out.println(v1 == v2);
			
			int[] v3 = {10};			
			int[] v4 = {10};
			//int[] v4 = v3;		//(true가 나오게 된다)
			System.out.println(v3 == v4);	
			
			String v5 = "Java";
			String v6 = "Java";
			System.out.println(v5 == v6);	
			System.out.println(v5.equals(v6));		//객체가 다르더라도 안에 있는 내용이 같은지를 확인
		
	}

}
