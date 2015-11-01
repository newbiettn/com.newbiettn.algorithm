package com.newbiettn.algorithm.sort;

import java.util.Scanner;

/**
 * Perform insertion sort naively
 * @author newbiettn
 *
 */
public class Insertion_Sort {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the size: ");
		int size = sc.nextInt();
		int[] input_list = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the number " + i + ": ");
			input_list[i] = sc.nextInt(); 
		}
		
		int[] output = insertion_sort(input_list);
		
		for (int i = 0; i < size; i++) {
			System.out.print(output[i] + " ");
		}
		
	}
	public static int[] insertion_sort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int key = list[i];
			int j = i - 1;
			for (; j >= 0 && key < list[j]; --j) {
				list[j+1] = list[j];
			}
			list[j+1] = key;
		}
		return list;
	}
}
