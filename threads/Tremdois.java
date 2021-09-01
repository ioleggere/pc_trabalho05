package threads;
import static tela.Bandeira.trem2;
import static tela.Bandeira.tremum;
import static tela.Bandeira.greenflag;
import static tela.Bandeira.redflag;
import static tela.Bandeira.greenflag3;
import static tela.Bandeira.redflag3;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 06 de abril de 2021
Alteracao: 09 de maio de 2021
Nome.....: Tremdois.java
Funcao...: Classe Tremdois, onde as funcoes da thread do primeiro trem da solucao das bandeiras sao configuradas (Movimentacao, acesso, etc.).
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Tremdois extends Thread{
  public static int velocidadetremdois = 150; //Variavel que contem o valor da velocidade do trem, controlada pelo sleep.
    public void run(){
      while(true){
        this.ocupadoTrem1();
        this.ocupadoTrem2();  
        try {
          sleep(velocidadetremdois); //Sleep representando a velocidade, onde cada vez que passa, a posicao do trem muda. 
          //Verificacoes das posicoes do trem, para animacao.
          if(trem2.getY() < 570 && trem2.getY() > 440){
            if(tremum.ocupadoTrem2()){ //Verificamos se o tremum esta no tunel com o metodo ocupado, que retorna true quando ha um trem.
              while(tremum.ocupadoTrem2()){ //Entao, enquanto estiver ocupado, o processo ira adormecer.
                sleep(10);
              } //Fim do while.
            }else{
              if(trem2.getX() > 100){
                trem2.setBounds(trem2.getX() - 1, trem2.getY() - 1, 50 ,100);
              } //Fim do if.
              trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
            } //Fim do else.
          }else if(trem2.getY() < 430 && trem2.getY() > 250){
            if(trem2.getX() < 140){
              trem2.setBounds(trem2.getX() + 1, trem2.getY() - 1, 50 ,100);
            } //Fim do if.
            trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
          }else if(trem2.getY() < 260 && trem2.getY() > 100){
            if(tremum.ocupadoTrem1()){ //Verificamos se o tremum esta no tunel com o metodo ocupado, que retorna true quando ha um trem.
              while(tremum.ocupadoTrem1()){ //Entao, enquanto estiver ocupado, o processo ira adormecer.
                sleep(10);
              } //Fim do while.
            } //Fim do if.
            if(trem2.getX() > 90){
              trem2.setBounds(trem2.getX() - 1, trem2.getY() - 1, 50 ,100);
            } //Fim do if.
            trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);          
            }else if(trem2.getY() < 110 && trem2.getY() > 20){    
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
/********************************************************************* 
* Metodo: ocupadoTrem1.
* Funcao: Verifica se o trem esta ocupando a posicao de tunel nos trilhos, retorna true quando esta ocupado.
* Parametros: Nenhum.
* Retorno: boolean.
********************************************************************* */
  public boolean ocupadoTrem1(){
    if((trem2.getY() < 190 && trem2.getY() > 65)){
      redflag.setVisible(true);
      greenflag.setVisible(false);
      return true;
    }
    redflag.setVisible(false);
    greenflag.setVisible(true);
    return false;
  } //Fim do metodo ocupadoTrem1.
/********************************************************************* 
* Metodo: ocupadoTrem2.
* Funcao: Verifica se o trem esta ocupando a posicao de tunel nos trilhos, retorna true quando esta ocupado.
* Parametros: Nenhum.
* Retorno: boolean.
********************************************************************* */
  public boolean ocupadoTrem2(){
    if((trem2.getY() < 500 && trem2.getY() > 410)){
      redflag3.setVisible(true);
      greenflag3.setVisible(false);
      
      return true;
    } //Fim do if.
    redflag3.setVisible(false);
    greenflag3.setVisible(true);
    
    return false;
  } //Fim do metodo ocupadoTrem2.
} //Fim da classe Tremdois.