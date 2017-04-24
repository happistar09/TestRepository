package homework05.ch09.exam06;

public class Button {
	OnClickListener listener;
	
	void SetOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	void touch(){
		listener.onClick();
	}
	
	interface OnClickListener{
		void onClick();
	}
}
