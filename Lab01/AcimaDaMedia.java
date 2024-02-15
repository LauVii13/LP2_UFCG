/**
 * Laboratório de Programaçao 2 - Lab 1
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 */

import java.util.Scanner;

public class AcimaDaMedia{
	public static void main(String[] agrs){
		Scanner sc = new Scanner(System.in);
		
		String linha = sc.nextLine();
		String[] texto = linha.split(" ");		

		int[] numeros = new int[texto.length];

		int somador = 0;
		for(int i = 0; i < texto.length; i++){
			numeros[i] = Integer.parseInt(texto[i]);
			somador += numeros[i];
		}

		double media = somador / texto.length;
		
		boolean primeiro = true;
		for (int numero : numeros) {
            		if (numero > media) {
				if(primeiro){
					System.out.print(numero);
					primeiro = false;
				}else{
                			System.out.print(" " + numero);
				}
            		}
        	}	

			System.out.print("\n");
		sc.close();
	}
}
