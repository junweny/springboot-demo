package test;

import java.util.Arrays;

public class Test05 {
	
	public String d;
	
	public static void main(String[] args) {
		int[] arr = {45,5,6,9,8};
		Arrays.parallelSort(arr);
		System.out.println(Arrays.toString(arr));
		
		Test05 test05 = new Test05();
		test05.d = "sss";
		change(test05);
		System.out.println(test05.d);
	}
	
	private static void change(Test05 test05){
		test05.d = "s";
	}
	
}
