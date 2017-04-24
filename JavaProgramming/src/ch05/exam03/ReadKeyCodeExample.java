package ch05.exam03;

public class ReadKeyCodeExample {

	public static void main(String[] args) throws Exception {
		System.out.println("--------------------------------");		
		System.out.println("1. 저장 | 2. 읽기 | 3. 종료");
		System.out.println("--------------------------------");
		
		int keycode = 0;
		while(true){			
			if(keycode != 13 && keycode !=10){
				System.out.print("번호선택: ");
			}
			keycode = System.in.read();
			//System.out.println(keycode);
			
			switch(keycode) {
			case 49:
				System.out.println("저장을 선택하셨습니다.");
				break;
			case 50:
				System.out.println("읽기를 선택하셨습니다");
				break;
			case 51:
				System.out.println("종료를 선택하셨습니다.");
				//return;
				System.exit(0);
				//break;
			}
			
		}
		
	}

}
