package homework05.ch09.exam09;

public class Window {	//2개의 button 객체를 가지고 있는 윈도우 창을 만드는 클래스
	Button button1 = new Button();
	Button button2 = new Button();
	
	
	//필드에 구현 객체를 대입
	Button.OnClickListener listener = new Button.OnClickListener() {
		
		@Override
		public void onClick() {
			System.out.println("전화를 겁니다.");
			
		}
	};
	
	


	Window(){			
		button1.setOnClickListener(listener);		//매개값으로 필드대입
		button2.setOnClickListener(new Button.OnClickListener(){	//매개값으로 익명 객체 대입
			@Override	
			public void onClick() {
				System.out.println("메세지를 보냅니다.");				
			}
		});
	
		
	}
}
