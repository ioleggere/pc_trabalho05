package tela;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import threads.Tremdois;
import threads.Tremum;
import static threads.Tremum.velocidadetremum;
import static threads.Tremdois.velocidadetremdois;;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 05 de abril de 2021
Alteracao: 09 de maio de 2021
Nome.....: Bandeira.java
Funcao...: Classe Bandeira, onde todos as acoes de interface do protocolo das bandeiras serao administradas.
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Bandeira{
  public static JFrame janela = new JFrame("Protocolo das bandeiras"); //JFrame, onde tudo sera desenhado.

  public static JLabel trem = new JLabel(); //JLabel representando o primeiro trem.

  public static JLabel trem2 = new JLabel(); //JLabel representando o segundo trem.

  public static Tremum tremum = new Tremum(); //Iniciando o objeto representando o primeiro trem.

  public static Tremdois tremdois = new Tremdois(); //Iniciando o objeto representando o segundo trem.

  public static JLabel greenflag = new JLabel(); //Iniciando o objeto representando a primeira bandeira verde.

  public static JLabel redflag = new JLabel(); //Iniciando o objeto representando a primeira bandeira vermelha.

  public static JLabel greenflag2 = new JLabel(); //Iniciando o objeto representando a segunda bandeira verde.

  public static JLabel redflag2 = new JLabel(); //Iniciando o objeto representando a segunda bandeira vermelha.

  public static JLabel greenflag3 = new JLabel(); //Iniciando o objeto representando a terceira bandeira verde.

  public static JLabel redflag3 = new JLabel(); //Iniciando o objeto representando a terceira bandeira vermelha.

  public static JLabel greenflag4 = new JLabel(); //Iniciando o objeto representando a quarta bandeira verde.

  public static JLabel redflag4 = new JLabel(); //Iniciando o objeto representando a quarta bandeira vermelha.

  public Bandeira(){
    //JLabel painelopcoes = new JLabel(); //JMenuBar, uma barra de menus onde ficara as opcoes de controle do programa.

    JButton iniciar = new JButton("Iniciar"); //JButton, uma opcao para o menu.

    JButton reiniciar = new JButton("Reiniciar"); //JButton, uma opcao para o menu.

    JButton aumentartremum = new JButton("Aumentar velocidade do trem 1"); //JButton, uma opcao para o menu.

    JButton diminuirtremum = new JButton("Diminir velocidade do trem 1"); //JButton, uma opcao para o menu.

    JButton aumentartremdois = new JButton("Aumentar velocidade do trem 2"); //JButton, uma opcao para o menu.

    JButton diminuirtremdois = new JButton("Diminuir velocidade do trem 2"); //JButton, uma opcao para o menu.

    JLabel trilhos = new JLabel(new ImageIcon(getClass().getResource("/img/trilhos.png"))); //JLabel, representando os trilhos.
    
    //Fonte usada nos botoes.
    String family = "Impact";
    int style = Font.PLAIN;
    int size = 18;
    Font f = new Font(family, style, size);

    //Inserindo as imagens nas respectivas JLabel's.
    trem = new JLabel(new ImageIcon(getClass().getResource("/img/trem.png"))); 

    trem2 = new JLabel(new ImageIcon(getClass().getResource("/img/trem2.png")));
    
    greenflag = new JLabel(new ImageIcon(getClass().getResource("/img/greenflag.png")));

    redflag = new JLabel(new ImageIcon(getClass().getResource("/img/redflag.png")));

    greenflag2 = new JLabel(new ImageIcon(getClass().getResource("/img/greenflag.png")));

    redflag2 = new JLabel(new ImageIcon(getClass().getResource("/img/redflag.png")));

    greenflag3 = new JLabel(new ImageIcon(getClass().getResource("/img/greenflag.png")));

    redflag3 = new JLabel(new ImageIcon(getClass().getResource("/img/redflag.png")));

    greenflag4 = new JLabel(new ImageIcon(getClass().getResource("/img/greenflag.png")));

    redflag4 = new JLabel(new ImageIcon(getClass().getResource("/img/redflag.png")));

    //Configuracoes da janela, e insercoes dos elementos na mesma.


    janela.setResizable(false);

    janela.setSize(750, 750);

    janela.setVisible(true); 

    janela.setLocationRelativeTo(null); 

    trilhos.setSize(259,719);

    //Configuracoes dos botoes.

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

    //Adicionando os botoes.

    janela.add(iniciar);

    janela.add(reiniciar);

    janela.add(aumentartremum);

    janela.add(diminuirtremum);

    janela.add(aumentartremdois);

    janela.add(diminuirtremdois);
    
    janela.getContentPane().setBackground(Color.GRAY);

    //Configurando os trens e bandeiras.
    
    trem.setBounds(40, 0, 50 ,100);  

    trilhos.add(trem);

    trem2.setBounds(140, 610, 50 ,100);  

    trilhos.add(trem2);
    
    greenflag.setBounds(30, 150, 40,40);

    trilhos.add(greenflag);
    
    greenflag2.setBounds(160, 150, 40, 40);

    trilhos.add(greenflag2);

    greenflag3.setBounds(30, 480, 40, 40);

    trilhos.add(greenflag3);

    greenflag4.setBounds(160, 480, 40, 40);

    trilhos.add(greenflag4);

    redflag.setBounds(30, 150, 40,40);
    
    redflag.setVisible(false);

    trilhos.add(redflag);

    redflag2.setBounds(160, 150, 40, 40);

    redflag2.setVisible(false);

    trilhos.add(redflag2);

    redflag3.setBounds(30, 480, 40, 40);

    redflag3.setVisible(false);

    trilhos.add(redflag3);

    redflag4.setBounds(160, 480, 40, 40);

    redflag4.setVisible(false);

    trilhos.add(redflag4);   

    trilhos.setHorizontalAlignment(2);
    
    janela.add(trilhos);      

    janela.repaint();
    
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

  } //Fim do contrutor Bandeira().    
} //Fim da classe Bandeira.