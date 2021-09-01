package threads;
import static tela.Travamento.trem;
import static tela.Travamento.trem2;
import static tela.Travamento.travareagiaoum;
import static tela.Travamento.travareagiaodois;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 05 de maio de 2021
Alteracao: 09 de maio de 2021
Nome.....: Tremdoistravamento.java
Funcao...: Classe Tremdoistravamento, onde as funcoes da thread do segundo trem da variavel de travamento sao configuradas (Movimentacao, acesso, etc.).
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Tremdoistravamento extends Thread{
public static int velocidadetremdois = 150;
  public void run(){
    while(true){
      try {
        sleep(velocidadetremdois);  //Sleep representando a velocidade, onde cada vez que passa, a posicao do trem muda.
        //Verificacoes das posicoes do trem, para animacao.
        if(trem2.getY() < 570 && trem2.getY() > 440){
          if(trem2.getY() == 569 && travareagiaodois == 1){ //Verificamos se o segundo tunel esta travado.
            while(travareagiaodois == 1){ //Entao, enquanto estiver travado, o processo ira adormecer.
              sleep(10);
            } //Fim do while.
          }else{
            travareagiaodois = 1; //Travamos o tunel quando entramos nele.
            if(trem2.getX() > 100){
              trem2.setBounds(trem2.getX() - 1, trem2.getY() - 1, 50 ,100);
            } //Fim do if.
            trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
          } //Fim do else.
        }else if(trem2.getY() < 430 && trem2.getY() > 250){
          if(!(trem.getY() > 362 && trem.getY() < 440)){
            travareagiaodois = 0; //Destrava o tunel depois de sair.
          }
          if(trem2.getX() < 140){
            trem2.setBounds(trem2.getX() + 1, trem2.getY() - 1, 50 ,100);
          } //Fim do if.
          trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
        }else if(trem2.getY() < 260 && trem2.getY() > 100){
          if(trem2.getY() == 250 && travareagiaoum == 1){ //Verificamos se o primeiro tunel esta travado.
            while(travareagiaoum == 1){ //Entao, enquanto estiver travado, o processo ira adormecer.
              sleep(10);
            } //Fim do while.
          }else{ //Fim do if.
          travareagiaoum = 1; //Travamos o tunel quando entramos nele.
          if(trem2.getX() > 90){
            trem2.setBounds(trem2.getX() - 1, trem2.getY() - 1, 50 ,100);
          } //Fim do if.
          trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);  
          }        
          }else if(trem2.getY() < 110 && trem2.getY() > 20){
            if(!(trem.getY() > 18 && trem.getY() < 64)){  
              travareagiaoum = 0; //Destrava o tunel depois de sair.
            }
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
} //Fim da classe Tremdoistravamento.
