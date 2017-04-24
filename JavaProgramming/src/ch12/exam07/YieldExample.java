package ch12.exam07;

public class YieldExample {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		threadA.start();
		threadB.start();
		
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){			
		}
		threadA.work = false;
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){			
		}
		threadA.work = true;
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){			
		}
		threadA.work = true;
		threadB.work = true;
		
		threadA.setStop(true);
		threadB.setStop(true);
	}

}
