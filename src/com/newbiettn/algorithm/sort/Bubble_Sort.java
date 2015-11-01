package com.newbiettn.algorithm.sort;

import java.util.Scanner;

/**
 * Implement bubble sort 
 * 
 * @author newbiettn
 *
 */
public class Bubble_Sort {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the size: ");
		int size = sc.nextInt();
		int[] input_list = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the number " + i + ": ");
			input_list[i] = sc.nextInt(); 
		}
		
		int[] output = bubble_sort(input_list);
		
		for (int i = 0; i < size; i++) {
			System.out.print(output[i] + " ");
		}
		
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	
	public static int[] bubble_sort(int[] list) {
		int n = list.length;
		for (int i = 0; i < n; i++) {
			for (int j = n-1; j > i; j--) {
				if (list[j] < list[j-1]) {
					int temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}
			}
		}
		return list;
	}
}
