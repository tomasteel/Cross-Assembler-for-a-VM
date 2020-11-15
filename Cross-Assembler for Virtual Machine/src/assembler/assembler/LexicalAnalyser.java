package assembler;
import java.io.*;

public class LexicalAnalyser {
	private Linestatement[] lineStatements;
	private int numberOfLines;
	private Position currPos;
	private ErrorReporter errep;
	
	public LexicalAnalyser(int num) {
		lineStatements = new Linestatement[num];
		numberOfLines = num;
		currPos = new Position(0, 0);
	}
	
	private boolean isSpace(int c) {
		return (c == ' ' || c == '\t' || c == '\n');
	}
	
	public void Parse(char[] word) {
		String token = new String(word);
		switch(token) {
//---------------------------------------------------------------------- INSTRUCTION FORMAT ---------------------------------------------------------------------------------------//

	//---------------------------------------------------------------------- OPCODES ---------------------------------------------------------------------------------------//
		case "add":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "add";
			break;
		case "addv":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "addv";
			break;
		case "and":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "and";
			break;
		case "br":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "br";
			break;
		case "brf":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "brf";
			break;
		case "call":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "call";
			break;
		case "dec":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "decv";
			break;
		case "div":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "div";
			break;
		case "dup":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "dup";
			break;
		case "enter":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "enter";
			break;
		case "halt":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "halt";
			break;
		case "inc":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "inc";
			break;
		case "incv":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "incv";
			break;
			//---------------------------------------------------------------------- OPCODES 2.0 ---------------------------------------------------------------------------------------//
		case "ldc":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "ldc";
			break;
		case "ldv":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "ldv";
			break;
		case "mul":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "mul";
			break;
		case "neg":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "neg";
			break;
		case "not":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "not";
			break;
		case "or":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "or";
			break;
		case "pop":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "pop";
			break;
		case "rem":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "rem";
			break;
		case "ret":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "ret";
			break;
		case "shl":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "shl";
			break;
		case "shr":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "shr";
			break;
		case "sub":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "sub";
			break;
		case "stv":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "stv";
			break;
		case "teq":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "teq";
			break;
		case "tge":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "tge";
			break;
		case "tgt":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "tgt";
			break;
		case "tle":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "tle";
			break;
		case "tlt":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "tlt";
			break;
		case "tne":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "tne";
			break;
		case "trap":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "trap";
			break;
		case "xor":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "xor";
			break;
	//---------------------------------------------------------------------- OPCODES 2.0 ---------------------------------------------------------------------------------------//
		case "<i>":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "xor";
			break;
		case "<u>":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "xor";
			break;
		case "<v>":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "xor";
			break;
		case "<n>":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "xor";
			break;
		case "<a>":
			lineStatements[currPos.getLine()].getInstruction().getMnemonic().identifier = "xor";
			break;
		default:
			errep.reportError("unrecognized mnemonic", currPos);
			break;
		}
	}
	
	public void readLine(String s) throws IOException {
		char[] wordBuf = new char[32];
		int inWordCnt = 0;
		for(int i = 0; i < s.length(); i++) {
			if(!isSpace(s.charAt(i))) {//for anything that isn't whitespace put it in a word buffer
				wordBuf[inWordCnt++] = s.charAt(i);
			} else if (inWordCnt > 0){
				Parse(wordBuf);//send any sequence of non white-space characters to the Parse function
				inWordCnt = 0;
			}
			currPos.incChar();
		}
		currPos.incLine();
	}
}
