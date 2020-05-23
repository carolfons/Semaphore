/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoreconsumidor;

import java.util.Scanner;

/**
 *
 * @author Carol Fonz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Saída de Dados
        System.out.println("Entre com a opção:");
        System.out.println("1 - Com Controle");
        System.out.println("2 - Sem controle");
        
        //Entrada de dados
        Scanner teclado = new Scanner(System.in);
        int controle;
        controle = teclado.nextInt();

        // criando a fila de buffer
        Fila minhaFila = new Fila();

        Produtor p = new Produtor(minhaFila,controle);
        Consumidor c = new Consumidor(minhaFila,controle);

        //criando as threads
        Thread produtorThread = new Thread(p);
        Thread consumidorThread = new Thread(c);

        // start na thread do produtor com a Seção Crítica
        produtorThread.start();

        // start na thread do consumidor com a Seção Crítica
        consumidorThread.start();
        
      
    }
    
    

}
