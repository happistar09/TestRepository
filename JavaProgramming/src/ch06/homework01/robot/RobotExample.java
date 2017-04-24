package ch06.homework01.robot;


public class RobotExample {
    
	public static void main(String[] args) throws Exception{
		Robot myRobot = new Robot("2017-03-28", "Blue");
		boolean machineRun = false;
		
		myRobot.power();
		
		int powerCode = 0;
		powerCode = System.in.read();
		if(powerCode == 49){
			myRobot.powerOn();
			machineRun = true;
		} else if(powerCode == 50){
			myRobot.info();					
		} else if(powerCode == 51){
			myRobot.powerOff();			
		} else {
			System.out.println("Error !!");			
		}
		while(machineRun){
			myRobot.motionChoice();
			int motionCode = 0;
			for(int i=0;i<3;i++){
				motionCode = System.in.read();
			}
			
			if(motionCode == 49){
				myRobot.hello();
			} else if(motionCode == 50){
				myRobot.sitDown();					
			} else if(motionCode == 51){
				myRobot.chickenBattle();
			} else if(motionCode == 52){
				myRobot.dance();			
			} else if(motionCode == 53){
				myRobot.powerOff();
				machineRun = false;
			} else {
				System.out.println("Error !!");			
			}
		}
		
	}

}
