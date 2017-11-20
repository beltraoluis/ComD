/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beltraoluis.conexao;

import beltraoluis.Bit;
import beltraoluis.DadoBinario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author beltraoluis
 */
public class AMI implements Serializable{
    
    protected ArrayList<Integer> sinal;
    protected boolean flag;
    
    public AMI(){
        sinal = new ArrayList<>();
        flag = true;
    }
    
    public void codificar(String s){
        DadoBinario dado = new DadoBinario();
        dado.set(s);
        System.out.println("binário:");
        dado.println();
        sinal.clear();
        for(int i = 0; i < dado.size(); i++){
            int k = dado.get(i);
            switch(k){
                case 1:
                    if(flag){
                        sinal.add(1);
                    }else{
                        sinal.add(-1);
                    }
                    flag = !flag;
                    break;
                case 0:
                    sinal.add(0);
                    break;
                default: break;
            }
        }
        System.out.println("Sinal codificado:");
        this.println();
    }
    
    public String decodificar(){
        System.out.println("Sinal");
        this.println();
        String s = "";
        DadoBinario dado = new DadoBinario();
        for(int i = 0; i < sinal.size(); i++){
            int k = sinal.get(i);
            try{
                switch(k){
                    case 1:
                        dado.set(new Bit(1));
                        break;
                    case 0:
                        dado.set(new Bit(0));
                        break;
                    case -1:
                        dado.set(new Bit(1));
                        break;
                }
            }catch(NullPointerException e){}
        }
        System.out.println("Binario decodificado:");
        dado.println();
        s = dado.toString();
        return s;
    }
    
    public void print(){
        for(int i = 0; i < sinal.size()-1; i++){
            System.out.print(sinal.get(i).intValue() + ",");
        }
        System.out.print(sinal.get(sinal.size()-1).intValue());
    }
    
    public void println(){
        for(int i = 0; i < sinal.size()-1; i++){
            System.out.print(sinal.get(i).intValue() + ",");
        }
        System.out.println(sinal.get(sinal.size()-1).intValue());
    }
    
    
    
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < sinal.size()-1; i++){
            sb.append(sinal.get(i).intValue());
            sb.append(",");
        }
        sb.append(sinal.get(sinal.size()-1).intValue());
        return sb.toString();
    }
}
