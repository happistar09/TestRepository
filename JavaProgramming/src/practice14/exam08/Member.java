package practice14.exam08;

public class Member {
	private String name;
	private String id;
	
	public Member(){
		System.out.println("Member() ����");
	}
	public Member(String id){
		System.out.println("Member(String id) ����");
		this.id = id;
	}
	public Member(String id, String name){
		System.out.println("Member(String id, String name)");
		this.id = id;
		this.name = name;
	}
	public String getId() {return id;}
	
}
