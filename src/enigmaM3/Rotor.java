package enigmaM3;


public class Rotor extends Translator{
	//private static StringBuffer rotorPerm = null; //rotor permotation
	private char ringOffset;
	private char ringSetting;
	private char notch;
	private StringBuffer offsetWheel = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ") ;
	private StringBuffer settingWheel = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	//private char[] permutation={};

	public Rotor(StringBuffer perm,char notch) {
		super(perm);
		//this.rotorPerm = perm;
		this.ringOffset = 'A'; // init to 'A'
		this.ringSetting = 'A'; // init to 'A'
		this.notch = notch;
		
	}
	
	//rotate the offset wheel by n times !!!
	public char rotatingOffset(int n){
		for(int k=0;k<n;k++){
			StringBuffer temp = new StringBuffer();
			for(int i=1;i<26;i++)
				temp.append(this.offsetWheel.charAt(i));
			temp.append(this.offsetWheel.charAt(0));
			this.offsetWheel=temp;
		}
		this.ringOffset = this.offsetWheel.charAt(0); //update ring offset
		return this.ringOffset;
	}

	public char rotatingSetting(int n){	
		for(int k=0;k<n;k++){
			StringBuffer temp = new StringBuffer();
			for(int i=1;i<26;i++)
				temp.append(this.settingWheel.charAt(i));
			temp.append(this.settingWheel.charAt(0));
			this.settingWheel=temp;
		}
		this.ringSetting = this.settingWheel.charAt(0); //update ring setting
		return this.ringSetting;
	}

	
	public void setRingOffset(char ringOffset) {
		int i= letterToIndex(ringOffset, this.offsetWheel);
		i--;
		this.rotatingOffset(i);
		this.ringOffset = ringOffset;
	}

	public void setRingSetting(char ringSetting) {
		int i= letterToIndex(ringSetting, this.settingWheel);
		i--;
		this.rotatingSetting(i);
		this.alphabetRotating(i);
		this.ringSetting = ringSetting;		
	}	
	
	//this method given the output letter in some Rotor/Reflector
	public char findOutputRotor(char inputLetter){
		letterToIndex(inputLetter, settingWheel);
		int settingIndex = letterToIndex(inputLetter, settingWheel);
		char output = getPermutation().charAt(settingIndex-1);
		return output;
	}
	
	//up letter in alphabet by n times !!!!!
	public void alphabetRotating(int n){
		for(int j=0; j<n;j++){
			StringBuffer temp = new StringBuffer();
			for(int i=0;i<this.getPermutation().length();i++)
			{
				char newSb = this.getPermutation().charAt(i);
				newSb = Character.toUpperCase(newSb);
				if(newSb == 'Z')
					newSb = 'A';
				else
					newSb++;
				
				temp.append(newSb);
			}
			
			this.setPermutation(temp);
			ringSetting = this.getPermutation().charAt(0);
		}
	}
	

	public char findOutputRotorReverse(char rotorReverseInput) {
		int indexInput = letterToIndex(rotorReverseInput, getPermutation());
		
		indexInput--;
		
		char output = getSettingWheel().charAt(indexInput);		
		return output;
	}


	public char getRingSetting() {
		return ringSetting;
	}
	
	public StringBuffer getOffsetWheel() {
		return offsetWheel;
	}

	public void setOffsetWheel(StringBuffer setoffWheel) {
		this.offsetWheel = setoffWheel;
	}

	public StringBuffer getSettingWheel() {
		return settingWheel;
	}

	public void setSettingWheel(StringBuffer settingWheel) {
		this.settingWheel = settingWheel;
	}

	public char getRingOffset() {
		return ringOffset;
	}

	public char getNotch() {
		return notch;
	}
	
	
	

	

}
