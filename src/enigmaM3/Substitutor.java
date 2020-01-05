package enigmaM3;


public abstract class Substitutor {
	
	public Substitutor(){}
	
	public int letterToIndex(char letter, char[] perm){
		letter = Character.toUpperCase(letter);
		
		for(int i=0;i<perm.length;i++){
			if(perm[i] == letter)
				return i+1;
		}
		return -1; //return error!
	}
	
	public int letterToIndex(char letter, StringBuffer perm){
		letter = Character.toUpperCase(letter);
		
		for(int i=0;i<perm.length();i++){
			if(perm.charAt(i) == letter)
				return i+1;
		}
		return -1; //return error!
	}
	
	
	public char indexToLetter(int index, char[] perm){
		for(int i=0;i<perm.length;i++){
			if(i+1==index)
				return perm[i];
		}
		return '*'; //return error!
		
	}
	
	public abstract char letterTranslation(char letter);
	
	public int reverseTrans(String letter){
		
		return 0;
	}


	
}
