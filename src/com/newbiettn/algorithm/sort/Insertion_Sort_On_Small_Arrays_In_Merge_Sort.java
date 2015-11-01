package com.newbiettn.algorithm.sort;

import java.util.Scanner;

/**
 * Coarsen the leaves of recursion by using insertion sort 
 * within merge sort when subproblems become sufficiently small
 * 
 * @author newbiettn
 *
 */
public class Insertion_Sort_On_Small_Arrays_In_Merge_Sort {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the size: ");
		int size = sc.nextInt();
		System.out.print("Enter k: ");
		int k = sc.nextInt();
		
		int[] input_list = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the number " + i + ": ");
			input_list[i] = sc.nextInt(); 
		}
		
		input_list = sort_sublist(input_list, k);
		int[] output = merge_sort(input_list);
		
		for (int i = 0; i < size; i++) {
			System.out.print(output[i] + " ");
		}
	}
	
	/**
	 * Divide list into k-length sublists, and perform 
	 * insertion sort for each sublist
	 *  
	 * @param list
	 * @param k
	 */
	public static int[] sort_sublist(int[] list, int k) {
		int n = list.length;
		for (int i = 0; i < n/k; i++) {
			int[] sublist = new int[k];
			
			int j = i*k;
			for (; j < (i+1)*k && j < n; j++) {
				sublist[j-i*k]= list[j];
			}
			
			sublist = insertion_sort(sublist);
			
			for (; j < (i+1)*k && j < n; j++) {
				list[j] = sublist[j-i*k];
			}
		}
		return list;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
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
	
	/**
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
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
	
	/**
	 * Perform insertion sort 
	 * 
	 * @param list
	 * @return
	 */
	public static int[] insertion_sort(int[] list) {
		int length = list.length;
		for (int i=1; i < length; i++) {
			int key = list[i];
			int j = i - 1;
			for (; j >= 0 && key < list[j]; j--) {
				if (list[j] > key) {
					list[j+1] = list[j];
				}
			}
			list[j+1] = key;
		}
		return list;
	}
}
