package enigmaM3;


public class Translator extends Substitutor{

	private StringBuffer permutation=null;
	private char[] reversePer={};
	
	public Translator(StringBuffer perm) {
		//super();
		setPermutation(perm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public char letterTranslation(char letter) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void printPerms(){
		System.out.println(this.permutation);
		System.out.println(this.reversePer);
	}

	public void setPermutation(StringBuffer perm) {
		this.permutation = perm;
	}

	public StringBuffer getPermutation() {
		return permutation;
	}

	
	
	
}
