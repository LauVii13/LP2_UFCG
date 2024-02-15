/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Vinícius Gabriel Laureano - 123111119
 */

import java.util.Scanner;

public class Media{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		float n1 = sc.nextFloat();
		float n2 = sc.nextFloat();

		float media = (n1 + n2) / 2;

		if(media >= 7.0){
			System.out.println("pass: True!");
		}else{
			System.out.println("pass: False!");
		}

		sc.close();
	}
}
