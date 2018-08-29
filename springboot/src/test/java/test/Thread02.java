package test;

public class Thread02 implements Runnable{

	@Override
	public void run() {
		System.out.println("线程执行！");
		
	}
	
	public static void main(String[] args) {
		new Thread(new Thread02()).start();
	}
}
