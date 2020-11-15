package assembler;

public class AssemblyUnit {
	private EOF eof;
	private int numOfLines = 5;
	public Linestatement [] asmFile; 
	public AssemblyUnit() {
		//While loop
		asmFile = new Linestatement[numOfLines];
	}
}
