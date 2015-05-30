package model;

import java.util.Random;
import java.util.Scanner;

public class Solution {

	static int costTable[][];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What size table would you like?");
		int size = scan.nextInt();
		costTable = new int[size][size];
		//BruteForce bruteForce = new BruteForce();
		DivideConquer divideConquer = new DivideConquer();
		
		setMatrix(size);
		
		print(size);
		
		System.out.println("\n");
		
		//bruteForce.solve(costTable);
		divideConquer.solve(costTable);
		
		scan.close();
	}
	
	private static void setMatrix(int size) {
		Random rand = new Random();
		
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (i == j)
					costTable[i][j] = 0;
				else
					costTable[i][j] = rand.nextInt(size)+1;
			}
		}
	}
	
	private static void print(int size) {
		System.out.println("Table Weights");
		System.out.println("_____________");
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(costTable[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
