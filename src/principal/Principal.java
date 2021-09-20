/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import classes.Janela; //Necessario para importar a classe Janela.
import javax.swing.JFrame; //Necessario para JFrame.Exit_On_Close, para que a expressao funcione e seja permite fechar a Janela.

/**
 *
 * @author Nuno Pontes e Fabio Teixeira
 */
public class Principal {
    public static void main(String[] args) {
        Janela janela = new Janela(); //Criou-se e instanciou-se o objecto da Janela.
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Este metodo basicamente o que faz e que no momento em que carreguemos em X na janela, a sua execucao termina.
    }
}
