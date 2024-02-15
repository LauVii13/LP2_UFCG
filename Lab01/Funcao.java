/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Vinícius Gabriel Laureano - 123111119
 */

import java.util.Scanner;

public class Funcao{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();	
		int n3 = sc.nextInt();
		int n4 = sc.nextInt();
		
		if((n1 > n2) && (n2 > n3) && (n3 > n4)){
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		}else if((n1 < n2) && (n2 < n3) && n3 < n4){
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		}else{
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}

		sc.close();
	}
}
