package aima;
import aima.*;
public class Teste {
    public static void main(String args[]) {
        Encoding enc = new Encoding();
		//String test = "10110011110";
		String test = "teste";

		Integer[] encoded;
		encoded = enc.encodificar(test);
		for (Integer bit: encoded){
			System.out.print(bit.toString());
		}
		System.out.println();    
	}
}
