package test;

public class Test04 {
	
	public static double pow(double x, int n){
		if(n == 0) 
			return 1;
		if(n < 0)
			return 1/x * pow(1/x, -(n+1));
		/*if(n % 2 == 0)
			return pow(x * x, n/2);
		else return pow(x * x, n/2) * x;*/
		else return x * pow(x, n-1);
	}
	public static void main(String[] args) {
		double d = pow(3,4);
		System.out.println(d);
	}
}
