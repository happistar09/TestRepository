package ch09.exam07;

public class Example2 {
	public static void main(String[] args) {
		//���� Ŭ������ �����ϰ� ��ü ����
		/*
		class Cimpl implements A.C{
			@Override
			public void cMethod() {
				System.out.println("Cimpl-cMethod()");
				
			}			
		}	
		A.C c = new Cimpl();
		c.cMethod();
		*/
		
		A.C c = new A.C(){	
			public void cMethod() {
				System.out.println("Cimpl-cMethod()");				
			}
		};
		c.cMethod();
	}
}
