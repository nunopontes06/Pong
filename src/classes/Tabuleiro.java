/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.*;
import java.awt.geom.Line2D; //Necessario para que as colisoes criadas no metodo desenhar possam ser executadas.
import java.awt.geom.Rectangle2D; //Necessario para executar o objecto Graphics2D.
import javax.swing.JPanel; //Necessario para executar a classe JPanel.

/**
 *
 * @author Nuno Pontes e Fabio Teixeira
 */

/*Nesta classe criou-se as plataformas e a bola, assim como O JFrame e JPanel.
De momento o que possuimos e um JFrame com as dimensoes  de 800 por 500
Para desenharmos os nossos objetos tivemos o auxilio do JPanel.*/
public class Tabuleiro extends JPanel {

    Plataforma r1 = new Plataforma(10, 200); //Criou-se um Objecto da classe Plataforma. O R1 representa a Plataforma 1. Os valores referem-se ao tamanho.
    Plataforma r2 = new Plataforma(794 - 10 - Plataforma.LARGURA, 200); //Criou-se um Objecto da classe Plataforma. O R2 representa a Plataforma 2. Os valores referem-se ao calculo do tamanho.
    Bola p = new Bola(); //Criou-se neste constructor um objeto da Classe Bola.

    public Tabuleiro() { //Criou-se o constructor com uma cor designada por nos, neste caso o preto.
        this.setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) { /*Criou-se este metodo do tipo Grafico, e e neste mesmo metodo onde nos foi possivel desenhar
                                              os sliders(plataformas) e a bola, como parametro o objecto do tipo Grafico, sendo 'g' a variavel para identificar o objecto.*/
        super.paintComponent(g); //Esta expressao permite executar o paintComponent da classe JPanel.
        Graphics2D g2 = (Graphics2D) g; /*Criou-se um Objecto do tipo Graphics 2D. O objetivo desta expressao e simplesmente 
                                        para que possamos trabalhar com a class Graphics 2D
                                        que e uma classe proveniente da classe Graphics g, e possui mais funcionalidades.*/
        g2.setPaint(Color.WHITE); //Criou-se este metodo para se dar cor ao Objecto Bola.
        desenharContagem(g2); //E desenhado na janela a pontuacao dos utilizadores, obtidos pelo metodo desenharContagem.
        desenhar(g2);  

    }

    private void desenhar(Graphics2D g) { //Criou-se este metodo para que a Bola e os Sliders(Plataforma) possam ser criadas.
        Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());

        g.draw(linea);

        g.fill(r1.getPlataforma());
        update();

        g.fill(r2.getPlataforma());
        update();

        g.fill(p.getShape());
        update();
    }


    private void update() { //Criou-se este metodo para que o estado da Plataforma e da Bola possam ser actualizados.
                            //Ou seja as suas posicoes em X e Y. Tendo em conta que a Bola e os Sliders irao estar em constante movimento.

        p.moverBola(getBounds(), colision(r1.getPlataforma()), colision(r2.getPlataforma()));

        r1.moverR1(getBounds());
        r2.moverR2(getBounds());
    }

    
    private boolean colision(Rectangle2D r) { //Criou-se este metodo para que possa existir colisao entre a Bola e a Plataforma.
        return p.getShape().intersects(r); //A variavel r refere-se a Plataforma. Ou seja a Bola colide com a Plataforma.
    }

    private void desenharContagem(Graphics2D g) { //Criou-se este metodo para que se possa ter pontuacao, entre os dois utilizadores.
        Graphics2D g1 = g, g2 = g;
        Font score = new Font("Arial", Font.BOLD, 30); //Criou-se a respectiva fonte a apresentar na Janela.
        g.setFont(score); //Score diz respeito a pontuacao.

        g1.drawString(Integer.toString(p.getScore1()), (float) getBounds().getCenterX() - 50, 30);
        g2.drawString(Integer.toString(p.getScore2()), (float) getBounds().getCenterX() + 25, 30);
        if (p.getScore1() == 5) { //Criou-se a condicao, em que se um dos jogadores alcancar a pontuacao maxima de 5, esse mesmo utilizador vence o jogo.
                                  //Em contrapartida o segundo utilizador perde, tendo obtido menos de 5.
            g.drawString("Ganhou o Jogador 1!", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Bola.fimDoJogo = true;
        }
        if (p.getScore2() == 5) { //Criou-se a condicao, em que se um dos jogadores alcancar a pontuacao maxima de 5, esse mesmo utilizador vence o jogo.
                                  //Em contrapartida o segundo utilizador perde, tendo obtido menos de 5.
            g.drawString("Ganhou o Jogador 2!", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Bola.fimDoJogo = true;
        }
    }

}
