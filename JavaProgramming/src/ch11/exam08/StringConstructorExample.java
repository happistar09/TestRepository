package ch11.exam08;

public class StringConstructorExample {
	public static void main(String[] args) throws Exception{

		String s1 = "abc";
		String s2 = new String("abc");
		
		char[] charArray = {'a', 'b', 'c'};
		String s3 = new String(charArray);
		System.out.println(s3);
		byte[] byteArray = {49,50,51};
		String s4 = new String(byteArray);
		//String s4 = new String(byteArray,2,1);
		System.out.println(s4);
		
		
		byte[] inputData = new byte[100];
		int readByteNo = System.in.read(inputData);
		String strData = new String(inputData, 0, readByteNo-2);
		System.out.println(strData);
		
	
		byte[] byteArray2 = {49, 50, 51, 52, 53, 54, 55};
		String s5 = new String(byteArray2, 3, 3);
		System.out.println(s5);
		
	}
}
