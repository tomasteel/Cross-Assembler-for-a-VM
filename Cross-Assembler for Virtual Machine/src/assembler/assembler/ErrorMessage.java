package assembler;

public class ErrorMessage {
	private String message;
	private Position pos; 
	
	public ErrorMessage(String m, Position p) {
		message = m;
		pos = p;
	}
	
	public void printMessage() {
		System.out.println(message);
		System.out.println("at line" + pos.getLine() + ", character " + pos.getCharacter());
	}
}
