package homework05.ch09.excercise05;

public class Anonymous {
	Vehicle field = new Vehicle(){
		public void run(){
			System.out.println("�����Ű� �޸��ϴ�");
		}
	};
	
	void method1(){
		Vehicle localVar = new Vehicle(){
			public void run(){
				System.out.println("�¿����� �޸��ϴ�");
			}
		};
		localVar.run();
	}
	
	void method2(Vehicle v){
		v.run();
	}
	
}


