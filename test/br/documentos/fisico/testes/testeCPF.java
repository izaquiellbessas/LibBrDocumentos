/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.documentos.fisico.testes;

import br.documentos.fisico.CPF;

/**
 *
 * @author Izaquiel Bessas
 */
public class testeCPF {
    
    public static void main(String[] args) {
        if (new CPF().isCPF("01921941600")) {
            System.out.println("CPF válido");
        } else {
            System.out.println("CPF inválido");
        }
    }
    
}
