package practice14.exam05;

public class UsingLocalVariable {

	void method(int arg) {	//arg�� final Ư���� ����
		int localVar = 40;		//localVar�� final Ư���� ����
		
		//arg = 31; 	// final Ư�� ������ ���� �Ұ�
		//localVar = 41; 	//localVar�� final Ư�� ������ ���� �Ұ�
		
		//���ٽ�
		MyFunctionalInterface fi = () -> {
			//���ú��� �б�
			System.out.println("arg: " + arg);
			System.out.println("localVar: " + localVar + "\n");			
		};
		fi.method();
	}
}
