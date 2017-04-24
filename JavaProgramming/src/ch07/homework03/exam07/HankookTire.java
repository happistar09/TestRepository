package ch07.homework03.exam07;

public class HankookTire extends Tire{

		public HankookTire(String location, int maxRotation){
			super(location, maxRotation);
		}
		@Override
		public boolean roll(){
			++accumulatedRotation;
			if(accumulatedRotation<maxRotation){
				System.out.println(location + " HanKookTire ¼ö¸í: " + (maxRotation-accumulatedRotation) + "È¸");
				return true;
			} else {
				System.out.println("*** " + location + " HankookTire ÆãÅ© ***");
				return false;
			}
		}
}
