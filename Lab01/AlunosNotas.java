/**
 * Laboratório de Programaçao 2 - Lab 1
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 */

import java.util.Scanner;

public class AlunosNotas{
	public static void main(String[] agrs){
		Scanner sc = new Scanner(System.in);

		int maior = 0, menor = 1000, acima = 0, abaixo = 0, soma = 0;
		double media = 0;

		while (true) {
			String linhaAluno = sc.nextLine();
			
			if(linhaAluno.equals("-")) break;

			String[] lista = linhaAluno.split(" ");
			int nota = Integer.parseInt(lista[1]);

			if(nota > maior) maior = nota;
			if(nota < menor) menor = nota;
			if(nota >= 700) acima += 1;
			if(nota < 700) abaixo += 1;

			soma += nota;
		}

		media = soma / (acima + abaixo);

		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.printf("media: %.0f\n", media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);


		sc.close();
	}
}
