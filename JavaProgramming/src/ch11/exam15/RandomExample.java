package ch11.exam15;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		
		//how1
		double random = Math.random();		
		int maxNum = 6;
		
		int num = (int)(random*maxNum) +1;
		System.out.println(num);
		
		//how2
		Random obj = new Random();
		int num2 = obj.nextInt(maxNum)+1;
		System.out.println(num2);
		int num3 = obj.nextInt();
	
	}

}
