/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlo;

import classes.Tabuleiro; //Necessario para que se possa importar certos atributos dao objecto Bola e Tabuleiro.
                          //Como o fundo e, para que se possa executar o metodo run, uma vez que diz respeito a velocidade
                           //a que a bola se move.
import classes.Bola;    //Necessario uma vez que diz respeito a bola, e para que o metodo run
                        //possa ser executado e necessario que a classe Bola seja importada.

/**
 *
 * @author Nuno Pontes e Fabio Teixeira
 */

/*Esta classe e responsavel por actualizar constantemente o movimento da Plataforma e da Bola.*/

public class EngineGraphics extends Thread { //Criou-se esta classe para podermos dar varias tarefas. E nesta caso criamos a classe porque temos
                                            //objectos em movimento, e o Thread torna-se mais util.

    private final Tabuleiro canvas;

    public EngineGraphics(Tabuleiro canvas) { //Criou-se o construtor, em que o parametro e um Objecto da classe Janela. E depois e instanciado.
        this.canvas = canvas;
    }

    @Override
    public void run() { //Este metodo foi criado porque o jogo esta em constante movimento e por isso criamos o metodo para que o jogo se actualize.
                        //E para, posteriormente, regularmos a velocidade do movimento do Objecto Bola.
                        //Por outras palavras, permite que se execute de forma simultanea o movimento da Bola, como o movimento da Plataforma.
        while (!Bola.fimDoJogo) {
            canvas.repaint();
            try {
                
                Thread.sleep(15); /*Criou-se este metodo para que a velocidade da bola possa ser controlada. 
                                    Fez-se tambem um import try catch para fazer funcionar este metodo.
                                    Basicamente para o programa a cada X milisegundos, dependendo do valor que se por.*/
            } catch (Exception ex) {
                System.out.println("error in graphics engine: " + ex.getMessage());
            }
        }
    }
}
