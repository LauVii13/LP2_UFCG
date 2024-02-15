/**
 * Laboratório de Programaçao 2 - Lab 1
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 */

import java.util.Scanner;

public class Wally{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String resposta;

		while(true){
			resposta = "?";
			String linhasNomes = sc.nextLine();

			String[] listaNomes = linhasNomes.split(" ");

			for(String nome : listaNomes){
				if(nome.length() == 5){
					resposta = nome;
				}
			}

			if(!(resposta.equals("wally"))){
				System.out.println(resposta);
			}else{
				break;
			}
		}

		sc.close();
	}
}
