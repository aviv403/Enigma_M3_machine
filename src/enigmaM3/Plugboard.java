package enigmaM3;

import java.util.StringTokenizer;

public class Plugboard extends Translator{
	

	private char[] plugboard = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	//private StringBuffer perm = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	
	public Plugboard(StringBuffer p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public boolean setPlugs(String plgs) {
		if(plgs == "" || plgs == null) //if we d'ont have any plags, every letter goes to her self!
			return true;
		
	    String s;
	    StringTokenizer tokenCheck = new StringTokenizer(plgs, " ");
	    while(tokenCheck.hasMoreTokens()){
	      s = tokenCheck.nextToken();
	      if (s.length() != 2)
	        return false;
	      if(s.charAt(0)>90 || s.charAt(0)<65 || s.charAt(1)>90 || s.charAt(1)<65)
	        return false;
	    }

	    StringTokenizer token = new StringTokenizer(plgs, " ");
	    while(token.hasMoreTokens()){
	      s = token.nextToken();
	      if(s.length()==2)
	        setWireToPlgs(s.charAt(0), s.charAt(1));
	      else
	        return false;
	    }
	    return true;
		
	}


	public void setWireToPlgs(char letter1, char letter2) {
	    for(int i=0; i<plugboard.length; i++){
	        if(plugboard[i] == letter1)
	        	plugboard[i] = letter2;
	        else if(plugboard[i] == letter2)
	        	plugboard[i] = letter1;
	    }		
	}
	
	public char[] getPlugboard() {
		return plugboard;
	}

	

	
}
