/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Rectangle; //Necessario para fazer funcionar a classe mover R1, mover R2.
import java.awt.geom.Rectangle2D; //Necessario para a criacao da Plataforma.

/**
 *
 * @author Nuno Pontes e Fabio Teixeira
 */
public class Plataforma {

    private int x, y; //Criou-se uma posicao em X e Y, igual ao que se fez no Objecto Bola.
    static final int LARGURA = 10, ALTURA = 40; //A variavel e estatica porque precisamos de importar estes valores para outras classes.

    public Plataforma(int x, int y) { //Criou-se o contructor com as variaveis X e Y.
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getPlataforma() { //Criou-se o metodo que devolve o valor das Plataformas. Tal e qual como se fez no Objecto Bola.
        return new Rectangle2D.Double(x, y, LARGURA, ALTURA);
    }

    public void moverR1(Rectangle limites) { //Criou-se o metodo mover, para a Plataforma 1. Tal como na bola, os limites do fundo sao igualmente colocados aqui.
        if (TecladoEvento.w && y > limites.getMinY()) {
            y--; //Para que a plataforma suba o seu valor tera de diminuir.
        }
        if (TecladoEvento.s && y < limites.getMaxY()-ALTURA) {
            y++; //Para que a Plataforma desca o valor tera de aumentar.
        }
    }

    public void moverR2(Rectangle limites) { //Criou-se o metodo mover, para a Plataforma 2. Tal como na bola, os limites do fundo sao igualmente colocados aqui.
        if (TecladoEvento.up && y > limites.getMinY()) {
            y--; //Para que a plataforma suba o seu valor tera de diminuir.
        }
        if (TecladoEvento.down && y < limites.getMaxY()-ALTURA) {
            y++; //Para que a Plataforma desca o valor tera de aumentar.
        }
    }
}
