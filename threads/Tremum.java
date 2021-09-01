package threads;
import static tela.Bandeira.trem;
import static tela.Bandeira.tremdois;
import static tela.Bandeira.greenflag2;
import static tela.Bandeira.redflag2;
import static tela.Bandeira.greenflag4;
import static tela.Bandeira.redflag4;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 06 de abril de 2021
Alteracao: 09 de maio de 2021
Nome.....: Tremum.java
Funcao...: Classe Tremum, onde as funcoes da thread do primeiro trem da solucao das bandeiras sao configuradas (Movimentacao, acesso, etc.).
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Tremum extends Thread{
  public static int velocidadetremum = 100; //Variavel que contem o valor da velocidade do trem, controlada pelo sleep.
    public void run(){ 
      while(true){
        this.ocupadoTrem1();
        this.ocupadoTrem2();
        try {
          sleep(velocidadetremum); //Sleep representando a velocidade, onde cada vez que passa, a posicao do trem muda.
          //Verificacoes das posicoes do trem, para animacao.
          if(trem.getY() > 16 && trem.getY() < 64){            
            if(tremdois.ocupadoTrem1()){ //Verificamos se o tremdois esta no tunel com o metodo ocupado, que retorna true quando ha um trem.              
              while(tremdois.ocupadoTrem1()){ //Entao, enquanto estiver ocupado, o processo ira adormecer.
              sleep(10);
              } //Fim do while.                                     
            } //Fim do if.
            trem.setBounds(trem.getX() + 1, trem.getY() + 1, 50, 100);
          }else if(trem.getY() > 130 && trem.getY() < 340 ){
            if(trem.getX() > 40){
              trem.setBounds(trem.getX() - 1, trem.getY() + 1, 50, 100);
            }else{
              trem.setBounds(trem.getX(), trem.getY() + 1, 50, 100);
            } //Fim do else.      
          }else if(trem.getY() > 360 && trem.getY() < 440){
            if(tremdois.ocupadoTrem2()){ //Verificamos se o tremdois esta no tunel com o metodo ocupado, que retorna true quando ha um trem.
              while(tremdois.ocupadoTrem2()){ //Entao, enquanto estiver ocupado, o processo ira adormecer.
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
/********************************************************************* 
* Metodo: ocupadoTrem1.
* Funcao: Verifica se o trem esta ocupando a posicao de tunel nos trilhos, retorna true quando esta ocupado.
* Parametros: Nenhum.
* Retorno: boolean.
********************************************************************* */
  public boolean ocupadoTrem1(){
    if((trem.getY() > 65 && trem.getY() < 190)){
      redflag2.setVisible(true);
      greenflag2.setVisible(false);      
      return true;      
    } //Fim do if.
    redflag2.setVisible(false);
    greenflag2.setVisible(true);
    
    return false;
  } //Fim do metodo ocupadoTrem1.
/********************************************************************* 
* Metodo: ocupadoTrem2.
* Funcao: Verifica se o trem esta ocupando a posicao de tunel nos trilhos, retorna true quando esta ocupado.
* Parametros: Nenhum.
* Retorno: boolean.
********************************************************************* */
  public boolean ocupadoTrem2(){
    if((trem.getY() > 410 && trem.getY() < 500)){
      redflag4.setVisible(true);
      greenflag4.setVisible(false);
      
      return true;
    } //Fim do if.
    redflag4.setVisible(false);
    greenflag4.setVisible(true);
    
    return false;
  } //Fim do metodo ocupadoTrem2.
} //Fim da classe Tremum.