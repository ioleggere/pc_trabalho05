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
Nome.....: Tremumtravamento.java
Funcao...: Classe Tremumtravamento, onde as funcoes da thread do primeiro trem da variavel de travamento sao configuradas (Movimentacao, acesso, etc.).
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Tremumtravamento extends Thread {
public static int velocidadetremum = 100; //Variavel que contem o valor da velocidade do trem, controlada pelo sleep.
  public void run(){ 
    while(true){
      try {
        sleep(velocidadetremum); //Sleep representando a velocidade, onde cada vez que passa, a posicao do trem muda.
        //Verificacoes das posicoes do trem, para animacao.
        if(trem.getY() > 16 && trem.getY() < 64){            
          if(trem.getY() == 17 && travareagiaoum == 1){ //Verificamos se o primeiro tunel esta travado.            
            while(travareagiaoum == 1){ //Entao, enquanto estiver travado, o processo ira adormecer.
            sleep(10);
            } //Fim do while.                                     
          }else{ //Fim do if.
            travareagiaoum = 1; //Travamos o tunel quando entramos nele.
            trem.setBounds(trem.getX() + 1, trem.getY() + 1, 50, 100);
          }
        }else if(trem.getY() > 130 && trem.getY() < 340 ){
          if(!(trem2.getY() < 249 && trem2.getY() > 100)){
            travareagiaoum = 0; //Destrava o tunel depois de sair.
          }
          if(trem.getX() > 40){
            trem.setBounds(trem.getX() - 1, trem.getY() + 1, 50, 100);
          }else{
            trem.setBounds(trem.getX(), trem.getY() + 1, 50, 100);
          } //Fim do else.      
        }else if(trem.getY() > 360 && trem.getY() < 440){
          if(trem.getY() == 361 && travareagiaodois == 1){ //Verificamos se o segundo tunel esta travado.
            while(travareagiaodois == 1){ //Entao, enquanto estiver travado, o processo ira adormecer.
              sleep(10);
            } //Fim do while.                    
          }else{
            travareagiaodois = 1; //Travamos o tunel quando entramos nele.
            if(trem.getX() < 87){
              trem.setBounds(trem.getX() + 1, trem.getY() + 1, 50, 100);
            }else{
              trem.setBounds(trem.getX(), trem.getY() + 1, 50, 100);
            } //Fim do else.
          } //Fim do else.
        }else if(trem.getY() > 460){
          if(!(trem2.getY() < 568 && trem2.getY() > 440)){
            travareagiaodois = 0; //Destrava o tunel depois de sair.
          }
          if(trem.getX() > 40){
            trem.setBounds(trem.getX() - 1, trem.getY() + 1, 50, 100);
          }else{
            trem.setBounds(trem.getX(), trem.getY() + 1, 50, 100);
          } //Fim do else.
        }else{
          trem.setBounds(trem.getX(), trem.getY() + 1, 50, 100);
        } //Fim do else.
      }catch (Exception e) {      
      } //Fim do catch.
    } //Fim do while.
  } //Fim do metodo run.
} //Fim da classe Tremumtravamento.java
