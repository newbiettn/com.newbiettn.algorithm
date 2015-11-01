package com.newbiettn.algorithm.sort;

import java.util.Scanner;

/**
 * @author newbiettn
 *
 */
public class Merge_Sort {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the size: ");
		int size = sc.nextInt();
		int[] input_list = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the number " + i + ": ");
			input_list[i] = sc.nextInt(); 
		}
		
		int[] output = merge_sort(input_list);
		
		for (int i = 0; i < size; i++) {
			System.out.print(output[i] + " ");
		}
		
	}
	public static int[] merge_sort(int[] list) {
		int length = list.length;
		
		if (length == 1) {
			return list;
		}
		
		int divider = length / 2;
		
		int[] sub_list_1 = new int[divider];
		int[] sub_list_2 = new int[length-divider];
		
		for (int i = 0; i < divider; i++) {
			sub_list_1[i] = list[i];
		}
		for (int j = divider; j < length; j++) {
			sub_list_2[j-divider] = list[j];
		}
		
		sub_list_1 = merge_sort(sub_list_1);
		sub_list_2 = merge_sort(sub_list_2);
		
		return merge(sub_list_1, sub_list_2);
	}
	
	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int k = 0, l = 0, m = 0;
		
		while (k < left.length && l < right.length) {
			if (left[k] <= right[l]) {
				result[m] = left[k];
				k++;
			} else {
				result[m] = right[l];
				l++;
			}
			m++;
		}
		while (k < left.length) {
			result[m] = left[k];
			m++;
			k++;
		}
		while (l < right.length) {
			result[m] = right[l];
			l++;
			m++;
		}
		return result;
	}
}
