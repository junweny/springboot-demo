package com.demo.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author yang
 *
 */
public class XuanZe {
	
	public static int[] sort(int[] arrs){
		
		//记录当前趟数的最大值的角标
	    int pos ;
	    //交换的变量
	    int temp;
	    //外层循环控制需要排序的趟数
	    for (int i = 0; i < arrs.length - 1; i++) {
	        //新的趟数、将角标重新赋值为0
	        pos = 0;
	        //内层循环控制遍历数组的个数并得到最大数的角标
	        for (int j = 0; j < arrs.length - i; j++) {
	            if (arrs[j] > arrs[pos]) {
	                pos = j;
	            }
	        }
	        //交换
	        temp = arrs[pos];
	        arrs[pos] = arrs[arrs.length - 1 - i];
	        arrs[arrs.length - 1 - i] = temp;
	    }
	    return arrs;
	}
	
	public static void main(String[] args) {
		int[] arr = sort(new int[]{3,2,1,5,3,6});
		System.out.println(Arrays.toString(arr));
	}
}
