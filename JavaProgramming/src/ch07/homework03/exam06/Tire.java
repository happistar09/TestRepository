package ch07.homework03.exam06;

public class Tire {
	
	//Field
	public int maxRotation;		//최대 회전수 (타이어 수명)
	public int accumulatedRotation;		//누적 회전수
	public String location;			//타이어의 위치
	
	//Constructor
	public Tire(String location, int maxRotation){
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	//Method
	public boolean roll(){
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation){
			System.out.println(location + " Tire 수명: " + (maxRotation-accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		}
	}
}
