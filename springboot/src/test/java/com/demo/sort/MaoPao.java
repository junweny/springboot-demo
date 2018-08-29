package com.demo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author yang
 *
 */
public class MaoPao {
	
	public static int[] sort(int[] arrs){
		int temp;
		for (int i = 0; i < arrs.length; i++) {
			for (int j = 0; j < arrs.length-i-1; j++) {
				if(arrs[j]>arrs[j+1]){
					temp = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = temp;
				}
			
			}
			
		}
		return arrs;
	}
	
	public static void main(String[] args) {
		int[] arr = sort(new int[]{3,2,1,5,3,6});
		System.out.println(Arrays.toString(arr));
	}
}
