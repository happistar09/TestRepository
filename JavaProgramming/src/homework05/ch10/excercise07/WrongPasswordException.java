package homework05.ch10.excercise07;

public class WrongPasswordException extends Exception{
	public WrongPasswordException(){}
	public WrongPasswordException(String message){
		super(message);
	}
}
