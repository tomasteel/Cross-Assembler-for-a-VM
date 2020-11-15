package assembler;

public class Instruction{
	private Mnemonic mnemonic;
	private Operand operand;

	public Instruction() {
		mnemonic = new Mnemonic();
		operand = new Operand();
	}
	
	public Mnemonic getMnemonic() {
		return mnemonic;
	}
	public void setMnemonic(Mnemonic mnemonic) {
		this.mnemonic = mnemonic;
	}
	public Operand getOperand() {
		return operand;
	}
	public void setOperand(Operand operand) {
		this.operand = operand;
	}


}
