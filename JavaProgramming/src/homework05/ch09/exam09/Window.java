package homework05.ch09.exam09;

public class Window {	//2���� button ��ü�� ������ �ִ� ������ â�� ����� Ŭ����
	Button button1 = new Button();
	Button button2 = new Button();
	
	
	//�ʵ忡 ���� ��ü�� ����
	Button.OnClickListener listener = new Button.OnClickListener() {
		
		@Override
		public void onClick() {
			System.out.println("��ȭ�� �̴ϴ�.");
			
		}
	};
	
	


	Window(){			
		button1.setOnClickListener(listener);		//�Ű������� �ʵ����
		button2.setOnClickListener(new Button.OnClickListener(){	//�Ű������� �͸� ��ü ����
			@Override	
			public void onClick() {
				System.out.println("�޼����� �����ϴ�.");				
			}
		});
	
		
	}
}
