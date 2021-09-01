package threads;
import static tela.Estrita.trem;
import static tela.Estrita.vez1;
import static tela.Estrita.vez2;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 07 de maio de 2021
Alteracao: 09 de maio de 2021
Nome.....: Tremumestrita.java
Funcao...: Classe Tremumestrita, onde as funcoes da thread do primeiro trem da estrita alternancia sao configuradas (Movimentacao, acesso, etc.).
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Tremumestrita extends Thread{
public static int velocidadetremum = 100;
  public void run(){   
      while(true){
        try {
          sleep(velocidadetremum); //Sleep representando a velocidade, onde cada vez que passa, a posicao do trem muda.
          //Verificacoes das posicoes do trem, para animacao.
          if(trem.getY() > 16 && trem.getY() < 64){            
            if(trem.getY() == 17 && vez1 == 1){ //Verificamos se a vez de passagem do tunel eh do outro trem.            
              while(vez1 == 1){ //Entao, enquanto a vez for do outro trem o processo dorme.
                sleep(10);
              } //Fim do while.                                     
            }else{ //Fim do if.
                trem.setBounds(trem.getX() + 1, trem.getY() + 1, 50, 100);
              }
            }else if(trem.getY() > 130 && trem.getY() < 340 ){
              vez1 = 1;  //Depois de sair, a vez sera do outro trem.
            if(trem.getX() > 40){
              trem.setBounds(trem.getX() - 1, trem.getY() + 1, 50, 100);
            }else{
              trem.setBounds(trem.getX(), trem.getY() + 1, 50, 100);
            } //Fim do else.      
          }else if(trem.getY() > 360 && trem.getY() < 440){
            if(trem.getY() == 361 && vez2 == 1){ //Verificamos se a vez de passagem do tunel eh do outro trem.
              while(vez2 == 1){ //Entao, enquanto a vez for do outro trem o processo dorme.
                sleep(10);
              } //Fim do while.                    
            }else{
              if(trem.getX() < 87){
                trem.setBounds(trem.getX() + 1, trem.getY() + 1, 50, 100);
              }else{
                trem.setBounds(trem.getX(), trem.getY() + 1, 50, 100);
              } //Fim do else.
            } //Fim do else.
          }else if(trem.getY() > 460){
            vez2 = 1; //Depois de sair, a vez sera do outro trem.
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
} //Fim da classe Tremumestrita.
