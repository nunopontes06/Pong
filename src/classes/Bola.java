/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.geom.Rectangle2D; //Necessario para que o metodo getShape seja executado.

/**
 *
 * @author Nuno Pontes e Fabio Teixeira
 */
public class Bola {

    private static final int TAMX = 15; //Esta expressao corresponde ao metodo getBola, diz respeito as dimensoes da Bola, por isso e uma variavel final, o valor nunca muda.
    private static final int TAMY = 15; //Sao constantes por isso foi usado final.
    private double x = 0; //O objecto Bola tem esta posicao em X.
    private static double y = 0; //O objecto Bola tem esta posicao em Y.
    private double dx = 1; //Este valor vai ser somado, as variaveis X e Y, que representam a posicao do Objecto Bola.
    private double dy = 1; //Estes valor vai ser somado, as variaveis X e Y, que representam a posicao do Objecto Bola.
   
    private Integer score1 = 0, score2 = 0; //Corresponde a contagem dos pontos do utilizador 1 e utilizador 2.
    public static boolean fimDoJogo = false; //Para que o jogo possa terminar 
                                            //assim que qualquer dos dois utilizadores obtenha 5 pontos.
    

    public Rectangle2D getShape() { //Criou-se este metodo para retornar um valor da Bola.
                                    //Rectangle2D implementa a interface Shape.
        return new Rectangle2D.Double(x, y, TAMX, TAMY); //O que vai fazer e retornar o valor da Bola.  
                                                         //As primeiras duas variaveis sao responsaveis pela posicao da Bola.
                                                         //As variaveis TAMX e TAMY sao responsaveis pelo tamanho da Bola.
    }

    public void moverBola(Rectangle2D limites, boolean colisionR1, boolean colisionR2) {
        /*Criou-se este metodo para fazer mexer a Bola. 
        A variavel limites vai dar o tamanho maximo em X e Y. 
        E para tambem permitir que as duas plataformas 
        possam colidir com a bola.*/
        x += dx;
        y += dy;

        if (colisionR1) { //Criou-se esta condicao para que a Plataforma do utilizador 1
                          //possa colidir com o Objecto Bola.
            dx = -dx;
            x = 20; //Esta expressao permite que a colisao seja mais fluente
                    //caso contrario as Plataformas e a Bola nao colidem em tempo real.    
        }
        if (colisionR2) { //Criou-se esta condicao para que a Plataforma do utilizador 2
                          //possa colidir com o Objecto Bola.
            dx = -dx;
            x = 755; //Esta expressao permite que a colisao seja mais fluente
                    //caso contrario as Plataformas e a Bola nao colidem em tempo real.    
        }

        if (x < limites.getMinX()) {
            score2++; //E incrementado 1 a pontuacao do jogador 2.
           
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {
            score1++; //E incrementado 1 a pontuacao do jogador 1.
            
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
           
        }

        if (y < limites.getMinY()) {
        /*Nesta condicao if, se a variavel Y for menor que o minimo Y 
        o seu movimento muda, Ou seja
        se se estava a mover da esquerda para a direita, 
        move-se da direita para a esquerda.*/

            y = limites.getMinY();

            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) { 
        /*Nesta condicao if, se a variavel Y for maior que a variavel X 
        o seu movimento muda, Ou seja
        se se estava a mover da esquerda para a direita, 
        move-se da direita para a esquerda.*/
            y = limites.getMaxY() - TAMY;
       
            dy = -dy;
        }

    }

    public int getScore1() { //Criou-se este metodo para que a pontuacao 
                             //seja implementada, ao utilizador 1.
        return score1;
    }

    public int getScore2() { //Criou-se este metodo para que a pontuacao 
                             //seja implementada, ao utilizador 2.     
        return score2;
    }

    
    
}
