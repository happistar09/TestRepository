package ch12.exam10;

public class InterruptExample {
	public static void main(String[] args) {
		
		
		
		//how2
		PrintThread2 thread2 = new PrintThread2();
		thread2.start();
		try{ Thread.sleep(2000);}catch(Exception e){}
		thread2.interrupt();
	
	}
}
