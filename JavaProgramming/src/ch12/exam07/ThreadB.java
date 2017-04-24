package ch12.exam07;
public class ThreadB extends Thread{
	//Field
	public boolean stop = false;
	public boolean work = true;
	
	//Constructor
	
	//Method
	
	public void run(){
		while(!stop){
			if(work){
			System.out.println("ThreadB 작업 중....");
			} else {
				Thread.yield();
			}
		}
		System.out.println("ThreadB 작업 종료");
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setWork(boolean work) {
		this.work = work;
	}
	
	
	
}
