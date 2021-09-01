package threads;
import static tela.Estrita.trem2;
import static tela.Estrita.vez1;
import static tela.Estrita.vez2;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 07 de maio de 2021
Alteracao: 09 de maio de 2021
Nome.....: Tremumestrita.java
Funcao...: Classe Tremdoisestrita, onde as funcoes da thread do segundo trem da estrita alternancia sao configuradas (Movimentacao, acesso, etc.).
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Tremdoisestrita extends Thread {
public static int velocidadetremdois = 150;
  public void run(){
  while(true){
    try {
      sleep(velocidadetremdois); //Sleep representando a velocidade, onde cada vez que passa, a posicao do trem muda.
      //Verificacoes das posicoes do trem, para animacao.
      if(trem2.getY() < 570 && trem2.getY() > 440){
        if(trem2.getY() == 569 && vez2 == 0){ //Verificamos se a vez de passagem do tunel e do outro trem. 
          while(vez2 == 0){ //Entao, enquanto a vez for do outro trem o processo dorme.
            sleep(10);
          } //Fim do while.
        }else{
          if(trem2.getX() > 100){
            trem2.setBounds(trem2.getX() - 1, trem2.getY() - 1, 50 ,100);
          } //Fim do if.
          trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
        } //Fim do else.
      }else if(trem2.getY() < 430 && trem2.getY() > 250){
        vez2 = 0; //Depois de sair, a vez sera do outro trem.
        if(trem2.getX() < 140){
          trem2.setBounds(trem2.getX() + 1, trem2.getY() - 1, 50 ,100);
        } //Fim do if.
        trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
      }else if(trem2.getY() < 260 && trem2.getY() > 100){
        if(trem2.getY() == 250 && vez1 == 0){ //Verificamos se a vez de passagem do tunel e do outro trem. 
          while(vez2 == 0){ //Entao, enquanto a vez for do outro trem o processo dorme.
            sleep(10);
          } //Fim do while.
        }else{ //Fim do if.
        if(trem2.getX() > 90){
          trem2.setBounds(trem2.getX() - 1, trem2.getY() - 1, 50 ,100);
        } //Fim do if.
          trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);  
        }        
        }else if(trem2.getY() < 110 && trem2.getY() > 20){  
          vez2 = 0;  
          if(trem2.getX() < 140){
            trem2.setBounds(trem2.getX() + 2, trem2.getY() - 1, 50 ,100);
          } //Fim do if.
          trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
        }else{
          trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
        } //Fim do else.       
      } catch (Exception e) {
      } //Fim do catch. 
    } //Fim do while.      
  } //Fim do metodo run.
} //Fim da classe Tremdoisestrita.
