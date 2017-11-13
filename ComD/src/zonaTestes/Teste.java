/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zonaTestes;

import beltraoluis.DadoBinario;
import beltraoluis.conexao.AMI;

/**
 *
 * @author beltraoluis
 */
public class Teste {
    
    public static void main(String args[]) {
        DadoBinario dado = new DadoBinario();
        dado.set("Teste de codificação binária");
        dado.println();
        AMI linha = new AMI();
        linha.codificar("Teste de codificação binária");
        linha.println();
        System.out.println(linha.decodificar());
    }
    
}
