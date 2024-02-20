/**
 *Laboratório de Programação 2 - Exercicio Extra
 *
 * @author Vinícius Gabriel Laureano - 123111119
 */

import java.util.*;

public class MegaSena{
  
    public static final int NUMEROS = 6;
    public static final int APOSTAS = 10;
    public static final int LIMITE = 60;
    public static void main(String arg[]){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int t = 0; t < n; t++){
            for(int i = 0; i < APOSTAS; i++){

                int[] valores = new int[NUMEROS];
                
                Random rd = new Random();
                for(int j = 0; j < 6; j++){
                    int sorteio = rd.nextInt(LIMITE - 1) + 1;
                    if(!contem(valores, sorteio)){
                      valores[j] = sorteio;     
                    }else{
                      j--;
                    }
                }

                Arrays.sort(valores);

                imprimeAposta(valores);
              }
            System.out.println("-----------------");
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