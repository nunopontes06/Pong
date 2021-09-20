/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.event.*;

/**
 *
 * @author Nuno Pontes e Fabio Teixeira
 */

/*Esta e a classe responsavel por criar eventos de teclado, ou seja, a funcao dada a certas teclas do teclado
para que possamos controlar as Plataformas esquerda, e direita.*/

public class TecladoEvento extends KeyAdapter { //Criou-se esta classe que nos permite trabalhar com eventos de teclado. E permite-nos
                                                //detectar se uma tecla foi pressionada ou nao.

    static boolean w, s, up, down; //Criou-se quatro variaveis, em que o W e o S, sao as teclas responsaveis para subir, e descer da Plataforma.

    @Override
    public void keyPressed(KeyEvent e) { //Criou-se este metodo, com o Objecto KeyEvent, que e executado sempre que se carrega numa tecla.
                                         //Neste metodo contem-se a informacao de que tecla pressionamos.

        int id = e.getKeyCode(); //Esta variavel, id, vai armazenar o codigo da tecla pressionada.
        if (id == KeyEvent.VK_W) { //Tendo em conta que a variavel e publica e estatica, podemos importa-la simplesmente com o nome da classe.
            w = true;

        }
        if (id == KeyEvent.VK_S) { //Tendo em conta que a variavel e publica e estatica, podemos importa-la simplesmente com o nome da classe.
            s = true;

        }
        if (id == KeyEvent.VK_UP) { //Tendo em conta que a variavel e publica e estatica, podemos importa-la simplesmente com o nome da classe.
            up = true;
        }
        if (id == KeyEvent.VK_DOWN) { //Tendo em conta que a variavel e publica e estatica, podemos importa-la simplesmente com o nome da classe.
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { //Criou-se este metodo, com o Objecto KeyEvent, que e executado sempre que largamos uma tecla.

        int id = e.getKeyCode(); //Esta variavel, id, vai armazenar o codigo da tecla pressionada.
        if (id == KeyEvent.VK_W) { //Sempre que a tecla e largada o seu valor e false.
            w = false;
        }
        if (id == KeyEvent.VK_S) { //Sempre que a tecla e largada o seu valor e false.
            s = false;
        }
        if (id == KeyEvent.VK_UP) { //Sempre que a tecla e largada o seu valor e false.
            up = false;
        }
        if (id == KeyEvent.VK_DOWN) { //Sempre que a tecla e largada o seu valor e false.
            down = false;
        }
    }

}
