package homework05.ch09.exam09;

public class Button { 
	//�������̽� Ÿ�� �ʵ�
	OnClickListener listener;
	
	//�Ű� ������ ������
	void setOnClickListener(OnClickListener listener){
		this.listener = listener;
	}	
	
	void touch(){					//  ���� ��ü�� onClick()�޼ҵ带 ȣ���Ѵ�
		listener.onClick();
	}
	interface OnClickListener{		//��ø �������̽� 
		void onClick();
	}
}
