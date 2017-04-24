package homework05.ch09.exam09;

public class Button { 
	//인터페이스 타입 필드
	OnClickListener listener;
	
	//매개 변수의 다형성
	void setOnClickListener(OnClickListener listener){
		this.listener = listener;
	}	
	
	void touch(){					//  구현 객체의 onClick()메소드를 호출한다
		listener.onClick();
	}
	interface OnClickListener{		//중첩 인터페이스 
		void onClick();
	}
}
