package threads;
import static tela.Peterson.trem;
import static tela.Peterson.interesse;
import static tela.Peterson.vez;
import static tela.Peterson.interesse2;
import static tela.Peterson.vezdois;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 07 de maio de 2021
Alteracao: 09 de maio de 2021
Nome.....: Tremumpeterson.java
Funcao...: Classe Tremumpeterson, onde as funcoes da thread do primeiro trem da solucao de peterson sao configuradas (Movimentacao, acesso, etc.).
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Tremumpeterson extends Thread {
private int id = 0; //Id do trem.
public static int velocidadetremum = 100; //Variavel que contem o valor da velocidade do trem, controlada pelo sleep.
  public void run(){   
    while(true){
      try {
        sleep(velocidadetremum); //Sleep representando a velocidade, onde cada vez que passa, a posicao do trem muda.
        //Verificacoes das posicoes do trem, para animacao.
        if(trem.getY() > 16 && trem.getY() < 64){            
            this.entraRC(id); //Antes de entrar na zona critica, usamos o metodo entraRC.
            trem.setBounds(trem.getX() + 1, trem.getY() + 1, 50, 100);            
        }else if(trem.getY() > 130 && trem.getY() < 340 ){
          this.deixaRC(id); //Depois de sair, usamos o metodo deixaRC.
          if(trem.getX() > 40){
            trem.setBounds(trem.getX() - 1, trem.getY() + 1, 50, 100);
          }else{
            trem.setBounds(trem.getX(), trem.getY() + 1, 50, 100);
          } //Fim do else.      
        }else if(trem.getY() > 360 && trem.getY() < 440){
            this.entraRC2(id); //Antes de entrar na zona critica 2, usamos o metodo entraRC2.
            if(trem.getX() < 87){
              trem.setBounds(trem.getX() + 1, trem.getY() + 1, 50, 100);
            }else{
              trem.setBounds(trem.getX(), trem.getY() + 1, 50, 100);
            } //Fim do else.
           //Fim do else.
        }else if(trem.getY() > 460){
          this.deixaRC2(id); //Depois de sair, usamos o metodo deixaRC2.
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
* Metodo: entraRC.
* Funcao: Metodo para controle de entrada do tunel.
* Parametros: id do processo.
* Retorno: void.
********************************************************************* */
  private void entraRC(int processo) throws InterruptedException{
    int outro; //Variavel representando o processo do outro trem.
    outro = 1-processo;
    interesse[processo] = true; //Definimos o interesse em entrar no tunel do processo atual como true.
    vez = processo; //Definimos a vez de entrar no tunel como o trem atual.
    while(vez == processo && interesse[outro] == true){ //Enquanto outro estiver no tunel ele dorme.
      sleep(10);
    } //Fim do while.
  } //Fim do metodo entraRC.

/********************************************************************* 
* Metodo: deixaRC.
* Funcao: Metodo para controle de saida do tunel.
* Parametros: id do processo.
* Retorno: void.
********************************************************************* */

  private void deixaRC(int processo){
      interesse[processo] = false; //O processo deixa de ter interesse no tunel.
  } //Fim do metodo deixaRC.

/********************************************************************* 
* Metodo: entraRC2.
* Funcao: Metodo para controle de entrada do tunel 2.
* Parametros: id do processo.
* Retorno: void.
********************************************************************* */
  private void entraRC2(int processo) throws InterruptedException{
    int outro; //Variavel representando o processo do outro trem.
    outro = 1-processo;
    interesse2[processo] = true; //Definimos o interesse em entrar no tunel 2 do processo atual como true.
    vezdois = processo; //Definimos a vez de entrar no tunel 2 como o trem atual.
    while(vezdois == processo && interesse2[outro] == true){ //Enquanto outro estiver no tunel ele dorme.
        sleep(10);
    } //Fim do while.
  } //Fim do metodo entraRC2.

/********************************************************************* 
* Metodo: deixaRC.
* Funcao: Metodo para controle de saida do tunel 2.
* Parametros: id do processo.
* Retorno: void.
********************************************************************* */

  private void deixaRC2(int processo){
    interesse2[processo] = false; //O processo deixa de ter interesse no tunel2.
  } //Fim do metodo deixaRC2.
} //Fim do tremumpeterson.
