package ch05.exam03;

public class ReadKeyCodeExample {

	public static void main(String[] args) throws Exception {
		System.out.println("--------------------------------");		
		System.out.println("1. ���� | 2. �б� | 3. ����");
		System.out.println("--------------------------------");
		
		int keycode = 0;
		while(true){			
			if(keycode != 13 && keycode !=10){
				System.out.print("��ȣ����: ");
			}
			keycode = System.in.read();
			//System.out.println(keycode);
			
			switch(keycode) {
			case 49:
				System.out.println("������ �����ϼ̽��ϴ�.");
				break;
			case 50:
				System.out.println("�б⸦ �����ϼ̽��ϴ�");
				break;
			case 51:
				System.out.println("���Ḧ �����ϼ̽��ϴ�.");
				//return;
				System.exit(0);
				//break;
			}
			
		}
		
	}

}
