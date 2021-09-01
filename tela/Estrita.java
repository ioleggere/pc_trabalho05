package tela;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import threads.Tremdoisestrita;
import threads.Tremumestrita;
import static threads.Tremumestrita.velocidadetremum;
import static threads.Tremdoisestrita.velocidadetremdois;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 07 de maio de 2021
Alteracao: 09 de maio de 2021
Nome.....: Bandeira.java
Funcao...: Classe Estrita, onde todos as acoes de interface da estrita alternancia serao administradas.
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Estrita {
  public static JFrame janela = new JFrame("Estrita alternancia"); //JFrame, onde tudo sera desenhado.
  
  public static int vez1 = 0; //Variavel do tunel 1, vez 0 refere a vez do primeiro trem.

  public static int vez2 = 1; //Variavel do tunel 2, vez 1 refere a vez do segundo trem.

  public static Tremumestrita tremum = new Tremumestrita();

  public static Tremdoisestrita tremdois = new Tremdoisestrita();

  JButton iniciar = new JButton("Iniciar"); //JButton, uma opcao para o menu.    
    
  JButton reiniciar = new JButton("Reiniciar"); //JButton, uma opcao para o menu.

  JButton aumentartremum = new JButton("Aumentar velocidade do trem 1"); //JButton, uma opcao para o menu.

  JButton diminuirtremum = new JButton("Diminir velocidade do trem 1"); //JButton, uma opcao para o menu.

  JButton aumentartremdois = new JButton("Aumentar velocidade do trem 2"); //JButton, uma opcao para o menu.

  JButton diminuirtremdois = new JButton("Diminuir velocidade do trem 2"); //JButton, uma opcao para o menu.

  JLabel trilhos = new JLabel(new ImageIcon(getClass().getResource("/img/trilhos.png"))); //JLabel, representando os trilhos.
    
  public static JLabel trem = new JLabel(); //JLabel representando o primeiro trem.

  public static JLabel trem2 = new JLabel(); //JLabel representando o segundo trem.

  //Fonte usada nos botoes.
  String family = "Impact";
  int style = Font.PLAIN;
  int size = 18;
  Font f = new Font(family, style, size);

  public Estrita(){
    //Colocando as imagens dos trens.
    trem = new JLabel(new ImageIcon(getClass().getResource("/img/trem.png"))); 

    trem2 = new JLabel(new ImageIcon(getClass().getResource("/img/trem2.png")));
    
    //Configurando a janela.
    janela.setResizable(false);
  
    janela.setSize(750, 750);
  
    janela.setVisible(true); 
  
    janela.setLocationRelativeTo(null); 
  
    trilhos.setSize(259,719);
    
    //Configurando os botoes.
    iniciar.setVisible(true);
  
    iniciar.setBounds(350,40, 300, 40);
  
    iniciar.setFont(f);
  
    iniciar.setForeground(Color.BLUE);
  
    iniciar.setBackground(Color.YELLOW);
  
    reiniciar.setVisible(true);
  
    reiniciar.setBounds(350,140, 300, 40);
  
    reiniciar.setFont(f);
  
    reiniciar.setForeground(Color.BLUE);
  
    reiniciar.setBackground(Color.YELLOW);
      
    aumentartremum.setVisible(true);
  
    aumentartremum.setBounds(350,240, 300, 40);
  
    aumentartremum.setFont(f);
  
    aumentartremum.setForeground(Color.BLUE);
  
    aumentartremum.setBackground(Color.YELLOW);
      
    diminuirtremum.setVisible(true);
  
    diminuirtremum.setBounds(350,340, 300, 40);
  
    diminuirtremum.setFont(f);
  
    diminuirtremum.setForeground(Color.BLUE);
  
    diminuirtremum.setBackground(Color.YELLOW);
  
    aumentartremdois.setVisible(true);
  
    aumentartremdois.setBounds(350,440, 300, 40);
  
    aumentartremdois.setFont(f);
  
    aumentartremdois.setForeground(Color.BLUE);
  
    aumentartremdois.setBackground(Color.YELLOW);
  
    diminuirtremdois.setVisible(true);
  
    diminuirtremdois.setBounds(350,540, 300, 40);
  
    diminuirtremdois.setFont(f);
  
    diminuirtremdois.setForeground(Color.BLUE);
  
    diminuirtremdois.setBackground(Color.YELLOW);
    

    //Adicionando botoes na janela e o trilho.
    janela.add(iniciar);
  
    janela.add(reiniciar);
  
    janela.add(aumentartremum);
  
    janela.add(diminuirtremum);
  
    janela.add(aumentartremdois);
  
    janela.add(diminuirtremdois);
      
    janela.getContentPane().setBackground(Color.GRAY);
  
    trem.setBounds(40, 0, 50 ,100); 
  
    trem2.setBounds(140, 610, 50 ,100); 
  
    trilhos.add(trem);
  
    trilhos.add(trem2);
  
    trilhos.setHorizontalAlignment(2);
  
    janela.add(trilhos);
    //Definindo a acao da opcao iniciar.
    iniciar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar a opcao.
        tremum.start(); //Iniciando a thread do primeiro trem.
        tremdois.start(); //Iniciando a thread do segundo trem.
      } //Fim do actionPerfomed.
    });
    
    //Definindo a acao da opcao reiniciar.
    reiniciar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar a opcao.
        trem.setBounds(40, 0, 50 ,100); //Volta o primeiro trem para a posicao inicial.
        trem2.setBounds(140, 610, 50 ,100); //Volta o segundo trem para a posicao inicial.       
      } //Fim do actionPerfomed.
    });
    
    //Definindo a acao da opcao aumentartremum.
    aumentartremum.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar a opcao.
        if(velocidadetremum > 50){ //Verificamos se a velocidadetremum nao esta no limite (no caso, 50).
          velocidadetremum -= 50; //Entao decrementamos 50.
        } //Fim do if.
      } //Fim do actionPerfomed.
    });
    
    //Definindo a acao da opcao diminuirtremum.
    diminuirtremum.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar a opcao.
        if(velocidadetremum < 200){ //Verificamos se a velocidadetremum nao esta no limite (no caso, 200);
          velocidadetremum += 50; //Entao incrementamos 50;
        } //Fim do if.       
      } //Fim do actionPerfomed.
    });
        
    //Definindo a acao da opcao aumentartremdois.
    aumentartremdois.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar o botao.
        if(velocidadetremdois > 50){ //Verificamos se a velocidadetremdois nao esta no limite (no caso 50);
          velocidadetremdois -=50; //Entao descrementamos 50.
        } //Fim do if.
      } //Fim do actionPerfomed.
    });
    
    //Definindo a acao da opcao diminuirtremdois.
    diminuirtremdois.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar o botao.
        if(velocidadetremdois < 200){ //Verificamos se a velocidadetremdois nao esta no limite (no caso 200);
          velocidadetremdois +=50; //Entao incrementamos 50.
        } //Fim do if.
      } //Fim do actionPerformed.
    });
  } //Fim do construtor Estrita().
} //Fim da classe Estrita.
