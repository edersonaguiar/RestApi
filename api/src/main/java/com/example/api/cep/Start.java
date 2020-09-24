/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api.cep;


import java.util.logging.Level;


public class Start {
    
    
    public static void main(String[] args){
        
        String cep = "06410340";
        String bairro = null;
         String rua = null;
        try{
        ViaCEP viacep = new ViaCEP();
        
        viacep.buscar(cep);
        bairro = viacep.getBairro();
        rua = viacep.getLogradouro();
        
        
        System.out.println(cep);
        System.out.println(bairro);
        System.out.println(rua);
        
        } catch (ViaCEPException ex) {
                
                }
    }
    
}
