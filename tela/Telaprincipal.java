package tela;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 05 de maio de 2021
Alteracao: 09 de maio de 2021
Nome.....: Bandeira.java
Funcao...: Classe Tela principal, onde todos as acoes da tela inicial serao administradas.
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Telaprincipal {

  //Iniciando os botoes, a tela e a imagem de fundo.
  private JFrame telaprincipal = new JFrame("Problema do trem");
  private JLabel imagemfundo = new JLabel(new ImageIcon(getClass().getResource("/img/telaprincipal.png")));
  private JButton bandeira = new JButton("Protocolo das bandeiras");
  private JButton trava = new JButton("Variavel de travamento");
  private JButton estrita = new JButton("Estrita alternancia");
  private JButton peterson = new JButton("Solucao de peterson");

  //Fonte usada nos botoes.
  String family = "Impact";
  int style = Font.PLAIN;
  int size = 18;
  Font f = new Font(family, style, size);

  public Telaprincipal(){
    
    //Configurando os botoes.
    bandeira.setVisible(true);
    bandeira.setBounds(90,80, 300, 40);
    bandeira.setFont(f);
    bandeira.setForeground(Color.WHITE);
    bandeira.setBackground(Color.DARK_GRAY);

    trava.setVisible(true);
    trava.setBounds(90, 150, 300, 40);
    trava.setFont(f);
    trava.setForeground(Color.WHITE);
    trava.setBackground(Color.DARK_GRAY);

    estrita.setVisible(true);
    estrita.setBounds(90, 220, 300, 40);
    estrita.setFont(f);
    estrita.setForeground(Color.WHITE);
    estrita.setBackground(Color.DARK_GRAY);

    peterson.setVisible(true);
    peterson.setBounds(90, 290, 300, 40);
    peterson.setFont(f);
    peterson.setForeground(Color.WHITE);
    peterson.setBackground(Color.DARK_GRAY);

    //Configurando a tela.
    telaprincipal.setDefaultCloseOperation(telaprincipal.EXIT_ON_CLOSE);
    telaprincipal.setResizable(false);
    telaprincipal.setSize(500,550);
    telaprincipal.setVisible(true);
    telaprincipal.setLocationRelativeTo(null);
    

    //Adicionando os botoes.
    imagemfundo.add(bandeira);
    imagemfundo.add(trava);
    imagemfundo.add(estrita);
    imagemfundo.add(peterson);

    //Adicionando a tela na JFrame.
    telaprincipal.add(imagemfundo);
    telaprincipal.repaint();
    //Acao do botao para iniciar o protocolo das bandeiras.
    bandeira.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        new Bandeira(); //Abre a janela do protocolo das bandeiras.
      } //Fim do actionPerformed.
    }); //Fim do ActionListener.

    //Acao do botao para iniciar a variavel de travamento.
    trava.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        new Travamento(); //Abre a janela da variavel de travamento.
      } //Fim do actionPerformed.
    }); //Fim do ActionListener.

    //Acao do botao para iniciar a estrita alternancia.
    estrita.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        new Estrita(); //Abre a janela da estrita alternancia.
      } //Fim do actionPerformed.
    }); //Fim do ActionListener.

    //Acao do botao para iniciar a solucao de peterson.
    peterson.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        new Peterson(); //Abre a janela da solucao de peterson.
      } //Fim do actionPerformed.   
    }); //Fim do ActionListener.
  } //Fim do contrutor Telaprincipal().
} //Fim da classe Telaprincipal.
