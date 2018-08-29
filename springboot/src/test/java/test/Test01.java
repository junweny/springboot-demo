package test;

public class Test01 {
	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		boolean b = !(i++ == 3) ^ (i++ ==2) && (i++==3);
		System.out.println(b);
		System.out.println(i);
		String s = Integer.toBinaryString(20);
		System.out.println(s);
		System.out.println(Integer.parseInt("11111010", 2));
		System.out.println(i|j);
		System.out.println(i==1|j==3);
		 byte m  =5;
         
	        System.out.println(Integer.toBinaryString(m)); //5的二进制是00000101,所以取非即为11111010,即为-6
	         
	        System.out.println(~m);
	        System.out.println(2>>1);
	}
}
