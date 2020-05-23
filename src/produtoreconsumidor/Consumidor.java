/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoreconsumidor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carol Fonz
 */
public class Consumidor implements Runnable {

    //instanciando a fila
    private Fila minhaFila;
    private int controle;

    //construtor
    public Consumidor(Fila minhaFila, int controle) {
        this.minhaFila = minhaFila;
        this.controle = controle;
    }

    public void run() {

        //Seção Crítica com controle
        if (controle == 1) {

            for (int i = 0; i < 10; i++) {

                // consumidor consumindo os itens
                minhaFila.getComControle();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            //Seção crítica sem controle
            for (int j = 0; j < 10; j++) {

                minhaFila.getSemControle();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }

}
