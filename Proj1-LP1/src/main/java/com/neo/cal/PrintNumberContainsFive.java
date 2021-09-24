package com.neo.cal;

import java.util.Scanner;

public class PrintNumberContainsFive {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scn.nextInt();
		
			printNumbersContains5(n);
		
		scn.close();
	}
	
	public static void printNumbersContains5(int n) {
		System.out.println("PrintNumberContainsFive.printNumbersContains5()");
		for(int i = 1; i < n/5; i++) {
			if( (11/i)%10==0 ) {
				int num = 5 * --i;
				for(int j = i-1; j>0; j--) {
					System.out.print((num++)+"\t");
				}
			}
			else {
				System.out.print((i*5)+"\t");
			}		
		}
	}
	
	public static boolean validateInput(int n) {
		if(n<5) {
			System.out.println("0");
			return false;
		}
		return true;
	}

}
