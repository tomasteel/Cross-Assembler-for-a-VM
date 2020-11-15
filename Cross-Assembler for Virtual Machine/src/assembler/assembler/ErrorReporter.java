package assembler;

public class ErrorReporter {
	private ErrorMessage[] messageArray;
	private static final int defaultSize = 100;
	private int currSize;
	private int maxSize;
	
	
	public ErrorReporter(int max) {
		messageArray = new ErrorMessage[max];
		maxSize = max;
		currSize = 0;
	}
	
	public ErrorReporter() {
		this(defaultSize);
	}
	
	public boolean reportError(ErrorMessage m) {
		if(currSize < maxSize) {
			messageArray[currSize++] = m;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean reportError(String m, Position p) {
		if(currSize < maxSize) {
			messageArray[currSize++] = new ErrorMessage(m, p);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean reportError(String m, int l, int c) {
		if(currSize < maxSize) {
			messageArray[currSize++] = new ErrorMessage(m, new Position(l, c));
			return true;
		} else {
			return false;
		}
	}
	
	public void printErrors() {
		for(int i = 0; i < currSize; i++) {
			messageArray[i].printMessage();
		}
	}
}
