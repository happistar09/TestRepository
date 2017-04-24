package ch07.homework03.exam06;

public class Tire {
	
	//Field
	public int maxRotation;		//�ִ� ȸ���� (Ÿ�̾� ����)
	public int accumulatedRotation;		//���� ȸ����
	public String location;			//Ÿ�̾��� ��ġ
	
	//Constructor
	public Tire(String location, int maxRotation){
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	//Method
	public boolean roll(){
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation){
			System.out.println(location + " Tire ����: " + (maxRotation-accumulatedRotation) + "ȸ");
			return true;
		} else {
			System.out.println("*** " + location + " Tire ��ũ ***");
			return false;
		}
	}
}
