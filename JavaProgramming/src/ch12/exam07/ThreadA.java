package ch12.exam07;
public class ThreadA extends Thread{
	//Field
	public boolean stop = false;
	public boolean work = true;
	
	//Constructor
	
	//Method
	
	public void run(){
		while(!stop){
			if(work){
			System.out.println("ThreadA �۾� ��....");
			} else {
				Thread.yield();
			}
		}
		System.out.println("ThreadA �۾� ����");
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setWork(boolean work) {
		this.work = work;
	}
	
	
	
}
