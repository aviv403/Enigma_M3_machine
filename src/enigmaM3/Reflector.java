package enigmaM3;

public class Reflector extends Translator{

	private StringBuffer wheel = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

	public Reflector(StringBuffer p) {
		super(p);
	}

	public StringBuffer getWheel() {
		return wheel;
	}

	public void setWheel(StringBuffer wheel) {
		this.wheel = wheel;
	}

	public char findOutputReflector(char reflectorInput) {
		letterToIndex(reflectorInput, wheel);
		int settingIndex = letterToIndex(reflectorInput, wheel);

		char output = getPermutation().charAt(settingIndex-1);
		return output;
		

	}
	
	
	
	
}
