package homework05.ch09.exam06;

public class ButtonExample {
	public static void main(String[] args){
		Button btn = new Button();
		
		btn.SetOnClickListener(new CallListener());
		btn.touch();
		
		btn.SetOnClickListener(new MessageListener());
		btn.touch();
		
	}

}
