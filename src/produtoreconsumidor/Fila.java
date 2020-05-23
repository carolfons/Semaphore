/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoreconsumidor;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Carol Fonz
 */
public class Fila {

    // um item
    private int item;

    // semaforoConsumidor inicializando com 0 pra que o método
    // put() execute primeiro (produtor)
    
    private Semaphore semaforoConsumidor = new Semaphore(0);
    private Semaphore semaforoProdutor = new Semaphore(1);

    /**************Métodos da Seção Crítica com controle****************/
        
    // função para pegar um item do buffer
    public void getComControle() {
        try {
            /* antes do consumidor pegar um item, 
               precisa conseguir uma permissão do semaforoConsumidor
             */
            semaforoConsumidor.acquire();

        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        // consumidor consumindo um item
            System.out.println("Consumidor consumiu o item: " + item);
      
        /* Depois do consumidor consumir um item, o semaforoProdutor sofre um
                release para notificar o produtor
         */
        semaforoProdutor.release();
    }

    // Colocando um item no buffer
    public void putComControle(int item) {
        try {
            /* antes do produtor produzir algum item, ele precisa conseguir a permissão
                    do semaforoProdutor
             */

            semaforoProdutor.acquire();

        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        // produtor produzindo um item
        this.item = item; //parametro recebido instanciado dentro da variável
        System.out.println("Produtor produziu o item: " + item);

        /* após a produção do item,o semaforoConsumidor é liberado para
                notificar o consumidor
         */
        semaforoConsumidor.release();
    }

 /**************Métodos da Seção Crítica sem controle****************/
    
    //método para consumir um item do buffer
    public void getSemControle() {
        System.out.println("Consumidor consumiu o item: " + item);
    }
    //método para produzir um item e colocar no buffer
    public void putSemControle(int item) {
        this.item = item;
        System.out.println("Produtor produziu o item: " + item);

    }

}
