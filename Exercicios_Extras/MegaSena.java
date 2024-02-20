/**
 *Laboratório de Programação 2 - Exercicio Extra
 *
 * @author Vinícius Gabriel Laureano - 123111119
 */

import java.util.*;

public class MegaSena{
  
  public static final int NUMBERS = 6;
  public static final int BETS = 10;
  public static final int LIMIT = 60;
  public static void main(String arg[]){
        
    Scanner sc = new Scanner(System.in);
    int loops = sc.nextInt();

    for(int t = 0; t < loops; t++){
          
      for(int i = 0; i < BETS; i++){
        int[] valores = new int[NUMBERS];  
        
        makeBat(valores);
        
        Arrays.sort(valores);

        imprimeAposta(valores);
      }
      System.out.println("-----------------");
    }
    sc.close();
  }

    public static void makeBat(int[] valores){
      Random rd = new Random();

      for(int j = 0; j < NUMBERS; j++){
        int sorteio = rd.nextInt(LIMIT - 1) + 1;
        if(!contem(valores, sorteio)){
          valores[j] = sorteio;     
        }else{
          j--;
        }
      }
    }

    public static boolean contem(int[] array, int numero) {
      for (int i : array) {
        if (i == numero) {
          return true;
        }
      }
      return false;
  }

  public static void imprimeAposta(int[] valores) {
		for(int numero : valores) {
			System.out.print(numero + " ");
		}
		System.out.println();
	}
}