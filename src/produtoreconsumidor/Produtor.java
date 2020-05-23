/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoreconsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carol Fonz
 */
public class Produtor implements Runnable {

    // instanciando a fila
    private Fila minhaFila;
    private int controle;

    //construtor
    public Produtor(Fila minhaFila, int controle) {
        this.minhaFila = minhaFila;
        this.controle = controle;
    }

    public void run() {

        if (controle == 1) { // seção crítica com controle
           
            for (int i = 0; i < 10; i++) {
                Random random = new Random();
                int data = random.nextInt(100);//gerando um numero aleatório

                // produtor colocando os produtos
                minhaFila.putComControle(data);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {

            for (int j = 0; j < 10; j++) {
                Random random = new Random();
                int data2 = random.nextInt(100); //gerando outro numero aleatório
                minhaFila.putSemControle(data2);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
