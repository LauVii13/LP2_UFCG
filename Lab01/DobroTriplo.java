/**
 * Laboratório de Programaçao 2 - Lab 1
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 */

import java.util.Scanner;

public class DobroTriplo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int dobro = 2 * x;
		int triplo = 3 * x;

		System.out.println("dobro: " + dobro + ", triplo: " + triplo);

		sc.close();
	}
}
