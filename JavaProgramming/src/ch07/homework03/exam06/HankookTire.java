package ch07.homework03.exam06;

public class HankookTire extends Tire{

		public HankookTire(String location, int maxRotation){
			super(location, maxRotation);
		}
		@Override
		public boolean roll(){
			++accumulatedRotation;
			if(accumulatedRotation<maxRotation){
				System.out.println(location + " HanKookTire ����: " + (maxRotation-accumulatedRotation) + "ȸ");
				return true;
			} else {
				System.out.println("*** " + location + " HankookTire ��ũ ***");
				return false;
			}
		}
}
