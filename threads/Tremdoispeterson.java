package threads;
import static tela.Peterson.trem2;
import static tela.Peterson.interesse;
import static tela.Peterson.vez;
import static tela.Peterson.vezdois;
import static tela.Peterson.interesse2;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 07 de maio de 2021
Alteracao: 09 de maio de 2021
Nome.....: Tremdoispeterson, onde as funcoes da thread do segundo trem da solucao de peterson sao configuradas (Movimentacao, acesso, etc.).
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Tremdoispeterson extends Thread{
private int id = 1; //Id do trem.
  public static int velocidadetremdois = 150; //Variavel que contem o valor da velocidade do trem, controlada pelo sleep.
    public void run(){
      while(true){
        try {
          sleep(velocidadetremdois); //Sleep representando a velocidade, onde cada vez que passa, a posicao do trem muda.
          //Verificacoes das posicoes do trem, para animacao.
          if(trem2.getY() < 570 && trem2.getY() > 440){
            this.entraRC2(id); //Antes de entrar na zona critica 2, usamos o metodo entraRC2.
            if(trem2.getX() > 100){
              trem2.setBounds(trem2.getX() - 1, trem2.getY() - 1, 50 ,100);
            } //Fim do if.
            trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
            //Fim do else.
          }else if(trem2.getY() < 430 && trem2.getY() > 250){
            this.deixaRC2(id); //Depois de sair, usamos o metodo deixaRC2.
            if(trem2.getX() < 140){
              trem2.setBounds(trem2.getX() + 1, trem2.getY() - 1, 50 ,100);
            } //Fim do if.
            trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);
          }else if(trem2.getY() < 260 && trem2.getY() > 100){
            this.entraRC(id); //Antes de entrar na zona critica, usamos o metodo entraRC.
            if(trem2.getX() > 90){
              trem2.setBounds(trem2.getX() - 1, trem2.getY() - 1, 50 ,100);
            } //Fim do if.
            trem2.setBounds(trem2.getX(), trem2.getY() - 1, 50 ,100);  
          }else if(trem2.getY() < 110 && trem2.getY() > 20){  
            this.deixaRC(id); //Depois de sair, usamos o metodo deixaRC.
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
  } //Fim do metodo entra RC2.

/********************************************************************* 
* Metodo: deixaRC.
* Funcao: Metodo para controle de saida do tunel 2.
* Parametros: id do processo.
* Retorno: void.
********************************************************************* */

  private void deixaRC2(int processo){
    interesse2[processo] = false; //O processo deixa de ter interesse no tunel2.
  } //Fim do metodo deixaRC2.
}//Fim da classe Tremdoispeterson.
