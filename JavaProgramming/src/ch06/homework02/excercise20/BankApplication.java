package ch06.homework02.excercise20;

import java.util.Scanner;

public class BankApplication {

	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		boolean run = true;
		while(run){
			System.out.println("----------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("----------------------------------------");
			System.out.print("����> ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1){
				createAccount();				
			}
			else if(selectNo == 2){
				accountList();
			}
			else if(selectNo == 3){
				deposit();
			}
			else if(selectNo == 4){
				withdraw();
			}
			else if(selectNo == 5){
				run = false;
			}
		}
		System.out.println("���α׷� ����");
	}
	
	private static void createAccount(){			
		System.out.println("---------");
		System.out.println("���»���");
		System.out.println("---------");
		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("������: ");
		String owner = scanner.next();
		System.out.print("�ʱ��Աݾ�: ");
		int balance = scanner.nextInt();
		Account newAccount = new Account(ano,owner,balance);
		for(int i=0; i<accountArray.length; i++){
			if(accountArray[i]==null){
				accountArray[i]=newAccount;
				System.out.println("��� : ���°� �����Ǿ����ϴ�.");				
				break;
			}
		}
	}
	private static void accountList(){
		System.out.println("---------");
		System.out.println("���¸��");
		System.out.println("---------");
		for(int i=0;accountArray[i]!=null;i++){
			System.out.println(accountArray[i].getAno() +"   "+accountArray[i].getOwner()+"   "+accountArray[i].getBalance());
		}
	}
	private static void deposit(){
		System.out.println("---------");
		System.out.println("����");
		System.out.println("---------");
		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		for(int i=0;i<accountArray.length;i++){
			if(accountArray[i].getAno().equals(ano)){
				System.out.print("���ݾ�: ");
				int plusBalance = scanner.nextInt();
				String owner=accountArray[i].getOwner();
				int balance=accountArray[i].getBalance()+plusBalance;
				Account newAccount = new Account(ano, owner, balance);
				accountArray[i]=newAccount;
				System.out.println("���: ������ �����Ǿ����ϴ�");
				break;
			}else if(i==accountArray.length){
				System.out.println("���°� �����ϴ�");
			}
		}
		
	}
	private static void withdraw(){
		System.out.println("---------");
		System.out.println("���");
		System.out.println("---------");
		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		for(int i=0;i<accountArray.length;i++){
			if(accountArray[i].getAno().equals(ano)){
				System.out.print("��ݾ�: ");
				int minusBalance = scanner.nextInt();
				if(minusBalance > accountArray[i].getBalance()){
					System.out.println("�ܾ��� �����մϴ�");
				}else{
					String owner=accountArray[i].getOwner();
					int balance=accountArray[i].getBalance()-minusBalance;
					Account newAccount = new Account(ano, owner, balance);
					accountArray[i]=newAccount;
					System.out.println("���: ����� �����Ǿ����ϴ�");
					break;
				}
			
			}else if(i==accountArray.length){
				System.out.println("���°� �����ϴ�");
			}
		}
	}

}
