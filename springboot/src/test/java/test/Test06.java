package test;

import java.util.HashSet;
import java.util.Set;

public class Test06 {
	public static int lengthOfLongestSubstring(String s) {
        int lenth = s.length();
		Set<Character> set = new HashSet<Character>();
		int start = 0, end = 0, max = 0;
		while(start<lenth && end<lenth){
			if(set.contains(s.charAt(end))){
				set.remove(s.charAt(start++));
			}else{
				set.add(s.charAt(end++));
				max = Math.max(max, end-start);
			}
		}
		return max;
    }
	
	public static boolean valid(int[]... arr){
		return false;
	}
	public static void main(String[] args) {
		int result = lengthOfLongestSubstring("abcabc");
		System.out.println(result);
	}
}
