package aima;

import java.util.ArrayList;

public class Encoding {

	Integer[] sequencia;
	boolean nextReverse = false;
	int bit;
	
	public Encoding(){
	}
        
        public String encoderBin(String s){
            StringBuilder string = new StringBuilder();
            char c;
            for(int i = 0; i < s.length(); i++){
                c = s.charAt(i);
                switch(c){
                    case '0': string.append("00110000"); break;
                    case '1': string.append("00110001"); break;
                    case '2': string.append("00110010"); break;
                    case '3': string.append("00110011"); break;
                    case '4': string.append("00110100"); break;
                    case '5': string.append("00110101"); break;
                    case '6': string.append("00110110"); break;
                    case '7': string.append("00110111"); break;
                    case '8': string.append("00111000"); break;
                    case '9': string.append("00111001"); break;                    
                    case 'A': string.append("01000001"); break;
                    case 'B': string.append("01000010"); break;
                    case 'C': string.append("01000011"); break;
                    case 'D': string.append("01000100"); break;
                    case 'E': string.append("01000101"); break;
                    case 'F': string.append("01000110"); break;
                    case 'G': string.append("01000111"); break;
                    case 'H': string.append("01001000"); break;
                    case 'I': string.append("01001001"); break;
                    case 'J': string.append("01001010"); break;
                    case 'K': string.append("01001011"); break;
                    case 'L': string.append("01001100"); break;
                    case 'M': string.append("01001101"); break;
                    case 'N': string.append("01001110"); break;
                    case 'O': string.append("01001111"); break;
                    case 'P': string.append("01010000"); break;
                    case 'Q': string.append("01010001"); break;
                    case 'R': string.append("01010010"); break;
                    case 'S': string.append("01010011"); break;
                    case 'T': string.append("01010100"); break;
                    case 'U': string.append("01010101"); break;
                    case 'V': string.append("01010110"); break;
                    case 'W': string.append("01010111"); break;
                    case 'X': string.append("01011000"); break;
                    case 'Y': string.append("01011001"); break;
                    case 'Z': string.append("01011010"); break;                    
                    case 'a': string.append("01100001"); break;
                    case 'b': string.append("01100010"); break;
                    case 'c': string.append("01100011"); break;
                    case 'd': string.append("01100100"); break;
                    case 'e': string.append("01100101"); break;
                    case 'f': string.append("01100110"); break;
                    case 'g': string.append("01100111"); break;
                    case 'h': string.append("01101000"); break;
                    case 'i': string.append("01101001"); break;
                    case 'j': string.append("01101010"); break;
                    case 'k': string.append("01101011"); break;
                    case 'l': string.append("01101100"); break;
                    case 'm': string.append("01101101"); break;
                    case 'n': string.append("01101110"); break;
                    case 'o': string.append("01101111"); break;
                    case 'p': string.append("01110000"); break;
                    case 'q': string.append("01110001"); break;
                    case 'r': string.append("01110010"); break;
                    case 's': string.append("01110011"); break;
                    case 't': string.append("01110100"); break;
                    case 'u': string.append("01110101"); break;
                    case 'v': string.append("01110110"); break;
                    case 'w': string.append("01110111"); break;
                    case 'x': string.append("01111000"); break;
                    case 'y': string.append("01111001"); break;
                    case 'z': string.append("01111010"); break;  
                }
            }
            
            return s;
        }
        
        public void decodificar(String){
            StringBuilder string = new StringBuilder();
            String s;
                switch(s){
                    case "00110000": string.append("0"); break;
                    case "00110001": string.append("1"); break;
                    case "00110010": string.append("2"); break;
                    case "00110011": string.append("3"); break;
                    case "00110100": string.append("4"); break;
                    case "00110101": string.append("5"); break;
                    case "00110110": string.append("6"); break;
                    case "00110111": string.append("7"); break;
                    case "00111000": string.append("8"); break;
                    case "00111001": string.append("9"); break;                    
                    case "01000001": string.append("A"); break;
                    case "01000010": string.append("B"); break;
                    case "01000011": string.append("C"); break;
                    case "01000100": string.append("D"); break;
                    case "01000101": string.append("E"); break;
                    case "01000110": string.append("F"); break;
                    case "01000111": string.append("G"); break;
                    case "01001000": string.append("H"); break;
                    case "01001001": string.append("I"); break;
                    case "01001010": string.append("J"); break;
                    case "01001011": string.append("K"); break;
                    case "01001100": string.append("L"); break;
                    case "01001101": string.append("M"); break;
                    case "01001110": string.append("N"); break;
                    case "01001111": string.append("O"); break;
                    case "01010000": string.append("P"); break;
                    case "01010001": string.append("Q"); break;
                    case "01010010": string.append("R"); break;
                    case "01010011": string.append("S"); break;
                    case "01010100": string.append("T"); break;
                    case "01010101": string.append("U"); break;
                    case "01010110": string.append("V"); break;
                    case "01010111": string.append("W"); break;
                    case "01011000": string.append("X"); break;
                    case "01011001": string.append("Y"); break;
                    case "01011010": string.append("Z"); break;                    
                    case "01100001": string.append("a"); break;
                    case "01100010": string.append("b"); break;
                    case "01100011": string.append("c"); break;
                    case "01100100": string.append("d"); break;
                    case "01100101": string.append("e"); break;
                    case "01100110": string.append("f"); break;
                    case "01100111": string.append("g"); break;
                    case "01101000": string.append("h"); break;
                    case "01101001": string.append("i"); break;
                    case 'j': string.append("01101010"); break;
                    case 'k': string.append("01101011"); break;
                    case 'l': string.append("01101100"); break;
                    case 'm': string.append("01101101"); break;
                    case 'n': string.append("01101110"); break;
                    case 'o': string.append("01101111"); break;
                    case 'p': string.append("01110000"); break;
                    case 'q': string.append("01110001"); break;
                    case 'r': string.append("01110010"); break;
                    case 's': string.append("01110011"); break;
                    case 't': string.append("01110100"); break;
                    case 'u': string.append("01110101"); break;
                    case 'v': string.append("01110110"); break;
                    case 'w': string.append("01110111"); break;
                    case 'x': string.append("01111000"); break;
                    case 'y': string.append("01111001"); break;
                    case 'z': string.append("01111010"); break;  
                }
            
        }

	public Integer[] encodificar (String seq) {

		sequencia = new Integer[seq.length()];

		for (int i = 0 ; i < seq.length(); i++) {

			bit = Character.getNumericValue(seq.charAt(i));
			
			if (bit == 0)
				sequencia[i] = 0;		
			else if (bit==1 && nextReverse) {
				sequencia[i] = -1;
				nextReverse = false;
			} else {
				sequencia[i]=1;
				nextReverse= true;
			}						
		}
		return sequencia;
	}
}
