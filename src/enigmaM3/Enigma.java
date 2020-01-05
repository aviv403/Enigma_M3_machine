package enigmaM3;

public class Enigma extends Substitutor{
	private final static Rotor rotorI   = new Rotor(new StringBuffer("EKMFLGDQVZNTOWYHXUSPAIBRCJ"),'Q');
	private final static Rotor rotorII  = new Rotor(new StringBuffer("AJDKSIRUXBLHWTMCQGZNPYFVOE"),'E');
	private final static Rotor rotorIII = new Rotor(new StringBuffer("BDFHJLCPRTXVZNYEIWGAKMUSQO"),'V');
	private final static Rotor rotorIV  = new Rotor(new StringBuffer("ESOVPZJAYQUIRHXLNFTGKDCMWB"),'J');
	private final static Rotor rotorV   = new Rotor(new StringBuffer("VZBRGITYUPSDNHLXAWMJQOFECK"),'Z');

	private final static Reflector reflectorB  = new Reflector(new StringBuffer("YRUHQSLDPXNGOKMIEBFZCWVJAT"));
	
	private Plugboard plugBoard = new Plugboard(new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ")); 

	
	private Rotor firstRotor;
	private Rotor firstRotorReverse;
	private Rotor secondRotor;
	private Rotor secondRotorReverse;
	private Rotor thirdRotor;
	private Rotor thirdRotorReverse;
	private Reflector reflector;


	public Enigma(String r1, String r2, String r3, String rb, String plgs) {
		
		setPlugboard(plgs);
		setRotors(r1,r2,r3);
		setReflector(rb);
		
	}

	public void setReflector(String rb) {
		if(rb.equals("ReflectorB"))
			this.reflector = reflectorB;
		
	}

	public boolean setPlugboard(String plgs) {
		if(this.plugBoard.setPlugs(plgs)) //return true if plugs setup successes (if the input user are correct).
			return true;
		else
			return false;
		
	}

	public void setRotors(String r1, String r2, String r3) {
		if(r1.equals("rotori"))
			this.firstRotor = rotorI;
		else if(r1.equals("rotorii"))
			this.firstRotor = rotorII;
		else if(r1.equals("rotoriii"))
			this.firstRotor = rotorIII;
		else if(r1.equals("rotoriv"))
			this.firstRotor = rotorIV;
		else if(r1.equals("rotorv"))
			this.firstRotor = rotorV;
		
		if(r2.equals("rotori"))
			this.secondRotor = rotorI;
		else if(r2.equals("rotorii"))
			this.secondRotor = rotorII;		
		else if(r2.equals("rotoriii"))
			this.secondRotor = rotorIII;
		else if(r2.equals("rotoriv"))
			this.secondRotor = rotorIV;
		else if(r2.equals("rotorv"))
			this.secondRotor = rotorV;
		
		if(r3.equals("rotori"))
			this.thirdRotor = rotorI;
		else if(r3.equals("rotorii"))
			this.thirdRotor = rotorII;
		else if(r3.equals("rotoriii"))
			this.thirdRotor = rotorIII;
		else if(r3.equals("rotoriv"))
			this.thirdRotor = rotorIV;
		else if(r3.equals("rotorv"))
			this.thirdRotor = rotorV;
			
		
	}
	//changing the ring offset and ring setting
	public boolean changeRings(Rotor rotor , char offset, char setting){ 
		if(Character.isAlphabetic(offset) && Character.isAlphabetic(setting)){
			rotor.setRingOffset(offset);
			rotor.setRingSetting(setting);
			return true;
		}
		else
			return false;
	}
	
	//rotating the rotors by notches
	public void rotateByNotches(){
		if(thirdRotor.getOffsetWheel().charAt(0) == thirdRotor.getNotch()){
			thirdRotor.rotatingOffset(1);
			if(secondRotor.getOffsetWheel().charAt(0) == secondRotor.getNotch()){
				secondRotor.rotatingOffset(1);
				firstRotor.rotatingOffset(1);
			}
			else{
				secondRotor.rotatingOffset(1);
				if(firstRotor.getOffsetWheel().charAt(0) == firstRotor.getNotch())
					firstRotor.rotatingOffset(1);
			}
		}
		else{
			thirdRotor.rotatingOffset(1);
			if(secondRotor.getOffsetWheel().charAt(0) == secondRotor.getNotch()){
				secondRotor.rotatingOffset(1);
				firstRotor.rotatingOffset(1);
			}
			
		}
	}
	
	@Override
	public char letterTranslation(char letter) {
		if(letter == ' ')
			return ' ';
		//first save the permutations and reflector wheel
		StringBuffer tempPermFirstRotor = firstRotor.getPermutation();
		StringBuffer tempPermSecondRotor = secondRotor.getPermutation();
		StringBuffer tempPermThirdRotor = thirdRotor.getPermutation();
		StringBuffer tempPermReflector = reflector.getPermutation();
		StringBuffer tempReflectorWheel = reflector.getWheel();

		
	//-------forward moves-------//
		
		//change input letter to index
		int k=letterToIndex(letter, plugBoard.getPlugboard());
		
		//rotating the rotors by notches
		rotateByNotches();
				
		//in the third rotor -> find in the offset wheel the letter in the index k (k-1)
		char thirdRotorInput = thirdRotor.getOffsetWheel().charAt(k-1);

		//find the output letter of right rotor
		char thirdRotorOutput = thirdRotor.findOutputRotor(thirdRotorInput); //<<<<<<<<<PROBLEMAAAA

		//save in k ver the index output letter of right rotor
		k=letterToIndex(thirdRotorOutput, thirdRotor.getOffsetWheel());
		
		//find the input letter in middle rotor
		char secondRotorInput = secondRotor.getOffsetWheel().charAt(k-1);
		
		//find the output letter in middle rotor
		char secondRotorOutput = secondRotor.findOutputRotor(secondRotorInput);
		
		//save in k ver the index output letter of middle rotor
		k=letterToIndex(secondRotorOutput, secondRotor.getOffsetWheel());
		
		//find the input letter in left rotor
		char firstRotorInput = firstRotor.getOffsetWheel().charAt(k-1);
		
		//find the output letter in left rotor
		char firstRotorOutput = firstRotor.findOutputRotor(firstRotorInput);
		
		//save in k ver the index output letter of left rotor
		k=letterToIndex(firstRotorOutput, firstRotor.getOffsetWheel());
		
		//find the input letter in reflector
		char reflectorInput = reflector.getWheel().charAt(k-1);
		
		//find the output letter in reflector
		char reflectorOutput = reflector.findOutputReflector(reflectorInput);
		
	//-------reverse moves-------//
		
		k=letterToIndex(reflectorOutput, reflector.getWheel());
		
		char firstRotorReverseInput = firstRotor.getOffsetWheel().charAt(k-1);

		char firstRotorReverseOutput = firstRotor.findOutputRotorReverse(firstRotorReverseInput);
		
		k=letterToIndex(firstRotorReverseOutput, firstRotor.getOffsetWheel());
		
		char secondRotorReverseInput = secondRotor.getOffsetWheel().charAt(k-1);

		char secondRotorReverseOutput = secondRotor.findOutputRotorReverse(secondRotorReverseInput);

		k=letterToIndex(secondRotorReverseOutput, secondRotor.getOffsetWheel());
		
		char thirdRotorReverseInput = thirdRotor.getOffsetWheel().charAt(k-1);

		char thirdRotorReverseOutput = thirdRotor.findOutputRotorReverse(thirdRotorReverseInput);		
		
		k = letterToIndex(thirdRotorReverseOutput, thirdRotor.getOffsetWheel());
		
		char output = indexToLetter(k, plugBoard.getPlugboard());
		
		
		firstRotor.setPermutation(tempPermFirstRotor);
		secondRotor.setPermutation(tempPermSecondRotor);
		thirdRotor.setPermutation(tempPermThirdRotor);
		reflector.setPermutation(tempPermReflector);
		reflector.setWheel(tempReflectorWheel);
		
		return output;
	}

	public Rotor getFirstRotor() {
		return firstRotor;
	}

	public Rotor getSecondRotor() {
		return secondRotor;
	}

	public Rotor getThirdRotor() {
		return thirdRotor;
	}

	public Rotor getFirstRotorReverse() {
		return firstRotorReverse;
	}

	public Rotor getSecondRotorReverse() {
		return secondRotorReverse;
	}

	public Rotor getThirdRotorReverse() {
		return thirdRotorReverse;
	}

	public Plugboard getPlugBoard() {
		return plugBoard;
	}

	

	
	
	
	

}
