/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Nuno Pontes e Fabio Teixeira
 */
import javax.swing.*; //Necessario, uma vez que o extends JFrame fica dependente da existencia deste import.
import controlo.EngineGraphics; //Necessario para executar o objecto canvas.

/*Para podermos ter uma janela e assim ser possivel visualizar o jogo.
Criou-se esta classe com o extends Jframe.*/

public class Janela extends JFrame { //Criou-se o Metodo Construtor e por dentro deste metodo iremos ter todas as caracteristicas da janela.
                                     //Como por exemplo o tamanho, ou onde estara a Plataforma.

    Tabuleiro canvas; //Criou-se um objeto do JPanel que vai ser o fundo.
    Bola p = new Bola();  //Criou-se um objecto da classe Bola, para depois ser instanciado dentro do construtor.

    public Janela() {
        setTitle("Projecto LP1 Tenis de Mesa"); //O titulo da janela que ira estar na parte superior esquerda da janela.
        setSize(800, 500); //Usamos o metodo setSize responsavel pelo tamanho da janela. Com esta expressao estamos a dizer a janela que esta ira ter 800 de largura e 500 de altura.
        setLocationRelativeTo(null); //Criou-se mais este metodo para colocarmos a janela no centro do nosso campo de visao no monitor do PC.
        setResizable(false); //Por ultimo criamos este metodo que o faz e impedir que o tamanho da janela de jogo seja modificado, acidentalmente ou nao.
        canvas = new Tabuleiro(); //Atraves desta instancia o fundo passa a fazer parte do JFrame.
        add(canvas);// Como mencionamos em cima o fundo fara parte entao do JFrame.
        addKeyListener(new TecladoEvento()); //Esta expressao permite criar na janela o input do teclado.
        new EngineGraphics(canvas).start(); //E para executar-mos o objecto canvas, usou-se este metodo.
    }

}
