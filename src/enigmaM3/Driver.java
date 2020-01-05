package enigmaM3;

import java.util.Scanner;



public class Driver {

	public static void main(String[] args) {
		
	try{
		
		char[] abc = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

		
		System.out.println("---> Wellcome to Enigma M3 <---\n");
		
		int check=0;
		String leftRotor;
		Scanner scanner = new Scanner(System.in);
		
		do
		{
			if(check>0)
				System.out.println("INPUT ERROR !!!   (try again..)");
			System.out.println("Please enter the left Rotor: (e.g. : RotorI)");
			leftRotor = scanner.nextLine();
			StringBuffer s = new StringBuffer(leftRotor);
			StringBuffer temp = new StringBuffer();
			for(int i=0;i<leftRotor.length();i++)
			{
				char c = Character.toLowerCase(s.charAt(i));
				temp.append(c);
			}
			leftRotor = temp.toString();
			check++;
		}
		while(!leftRotor.equals("rotori") && !leftRotor.equals("rotorii")
				&& !leftRotor.equals("rotoriii") && !leftRotor.equals("rotoriv")
				&& !leftRotor.equals("rotorv"));
		
		
//-------------------------------
		
		check=0;
		String middleRotor;
		Scanner scanner1 = new Scanner(System.in);
		
		do
		{
			if(check>0)
				System.out.println("INPUT ERROR !!!   (try again..)");
			System.out.println("Please enter the middle Rotor: (e.g. : RotorI)");
			middleRotor = scanner1.nextLine();
			StringBuffer s = new StringBuffer(middleRotor);
			StringBuffer temp = new StringBuffer();
			for(int i=0;i<middleRotor.length();i++)
			{
				char c = Character.toLowerCase(s.charAt(i));
				temp.append(c);
			}
			middleRotor = temp.toString();
			check++;
		}
		while((!middleRotor.equals("rotori") && !middleRotor.equals("rotorii")
				&& !middleRotor.equals("rotoriii") && !middleRotor.equals("rotoriv")
				&& !middleRotor.equals("rotorv")) || middleRotor.equals(leftRotor));
		
		
//-------------------------------
		
		
		check=0;
		String rightRotor;
		Scanner scanner2 = new Scanner(System.in);
		
		do
		{
			if(check>0)
				System.out.println("INPUT ERROR !!!   (try again..)");
			System.out.println("Please enter the right Rotor: (e.g. : RotorI)");
			rightRotor = scanner2.nextLine();
			StringBuffer s = new StringBuffer(rightRotor);
			StringBuffer temp = new StringBuffer();
			for(int i=0;i<rightRotor.length();i++)
			{
				char c = Character.toLowerCase(s.charAt(i));
				temp.append(c);
			}
			rightRotor = temp.toString();
			check++;
		}
		while((!rightRotor.equals("rotori") && !rightRotor.equals("rotorii")
				&& !rightRotor.equals("rotoriii") && !rightRotor.equals("rotoriv")
				&& !rightRotor.equals("rotorv") && !rightRotor.equals(leftRotor)
				&& !rightRotor.equals(middleRotor)) || rightRotor.equals(leftRotor)
				|| rightRotor.equals(middleRotor));

				
		//-------------------------------

		Scanner scanner3 = new Scanner(System.in);
		check=0;
		int leftOffset=0;
		
		do
		{
			if(check>0)
				System.out.println("INPUT ERROR !!!   (try again..)");
			
			System.out.println("Please enter Integer number(1-26) the OFFSET of left rotor  (e.g. : 21)");
			String s  = scanner3.nextLine();
			try{
				leftOffset = Integer.valueOf(s);
			}catch(Exception e){}
			check++;
		}
		while(leftOffset<1 || leftOffset>26);

		
		//-------------------------------

		Scanner scanner4 = new Scanner(System.in);
		check=0;
		int middleOffset=0;
		
		do
		{
			if(check>0)
				System.out.println("INPUT ERROR !!!   (try again..)");
			
			System.out.println("Please enter Integer number(1-26) the OFFSET of middle rotor  (e.g. : 21)");
			String s  = scanner4.nextLine();
			try{
				middleOffset = Integer.valueOf(s);
			}catch(Exception e){}
			check++;
		}
		while(middleOffset<1 || middleOffset>26);

		
		//-------------------------------

		Scanner scanner5 = new Scanner(System.in);
		check=0;
		int rightOffset=0;
		
		do
		{
			if(check>0)
				System.out.println("INPUT ERROR !!!   (try again..)");
			
			System.out.println("Please enter Integer number(1-26) the OFFSET of right rotor  (e.g. : 21)");
			String s  = scanner5.nextLine();
			try{
				rightOffset = Integer.valueOf(s);
			}catch(Exception e){}
			check++;
		}
		while(rightOffset<1 || rightOffset>26);

		//-------------------------------

		Scanner scanner6 = new Scanner(System.in);
		check=0;
		int leftSetting=0;
		
		do
		{
			if(check>0)
				System.out.println("INPUT ERROR !!!   (try again..)");
			
			System.out.println("Please enter Integer number(1-26) the SETTING of left rotor  (e.g. : 21)");
			String s  = scanner6.nextLine();
			try{
				leftSetting = Integer.valueOf(s);
			}catch(Exception e){}
			check++;
		}
		while(leftSetting<1 || leftSetting>26);

		//-------------------------------

		Scanner scanner7 = new Scanner(System.in);
		check=0;
		int middleSetting=0;
		
		do
		{
			if(check>0)
				System.out.println("INPUT ERROR !!!   (try again..)");
			
			System.out.println("Please enter Integer number(1-26) the SETTING of middle rotor  (e.g. : 21)");
			String s  = scanner7.nextLine();
			try{
				middleSetting = Integer.valueOf(s);
			}catch(Exception e){}
			check++;
		}
		while(middleSetting<1 || middleSetting>26);


		//-------------------------------

		Scanner scanner8 = new Scanner(System.in);
		check=0;
		int rightSetting=0;
		
		do
		{
			if(check>0)
				System.out.println("INPUT ERROR !!!   (try again..)");
			
			System.out.println("Please enter Integer number(1-26) the SETTING of right rotor  (e.g. : 21)");
			String s  = scanner8.nextLine();
			try{
				rightSetting = Integer.valueOf(s);
			}catch(Exception e){}
			check++;
		}
		while(rightSetting<1 || rightSetting>26);

		
		///====================
		Enigma enigma;
		String p;
		Scanner scanner9 = new Scanner(System.in);
		check=0;
		boolean b;
		do
		{
			if(check>0)
			{
				System.out.println("INPUT ERROR !!!   (try again..)");
				enigma=null;
			}
			enigma = new Enigma(leftRotor, middleRotor, rightRotor, "ReflectorB", "");
			System.out.println("Please enter the plugs (e.g. :  ZU HL CQ WM OA PY EB TR DN VI)");
			p = scanner9.nextLine();
			b = enigma.getPlugBoard().setPlugs(p);
			check++;
		}
		while(b==false);
		
//-------------------
		
		enigma.getFirstRotor().setRingSetting(enigma.indexToLetter(leftSetting, abc));
		enigma.getSecondRotor().setRingSetting(enigma.indexToLetter(middleSetting, abc));
		enigma.getThirdRotor().setRingSetting(enigma.indexToLetter(rightSetting, abc));
		
		enigma.getFirstRotor().setRingOffset(enigma.indexToLetter(leftOffset, abc));
		enigma.getSecondRotor().setRingOffset(enigma.indexToLetter(middleOffset, abc));
		enigma.getThirdRotor().setRingOffset(enigma.indexToLetter(rightOffset, abc));

		//----------------------
		
		check=0;
		String stringInput;
		Scanner scanner10 = new Scanner(System.in);
		StringBuffer output = new StringBuffer();
		boolean checkChar=true;
		do
		{
			checkChar=true;
			stringInput=null;
			output= new StringBuffer();
			if(check>0)
				System.out.println("INPUT ERROR - can't write non-alphabetic!!!   (try again..)");
			
			System.out.println("Please write your text: ");
			stringInput = scanner10.nextLine();
			
			for(int i=0;i<stringInput.length();i++)
				output.append(enigma.letterTranslation(stringInput.charAt(i)));		
			check++;
		}
		while(checkChar == false);
			
			
		System.out.println("\n\nOUTPUT: "+output);

		

		scanner.close();
		scanner1.close();
		scanner2.close();
		scanner3.close();
		scanner4.close();
		scanner5.close();
		scanner6.close();
		scanner7.close();
		scanner8.close();
		scanner9.close();
		scanner10.close();
	
		
		
		
}catch(Exception c){System.out.println("ERROR INPUT!  RUN AGAIN!");}
		


	
	}
	


}
