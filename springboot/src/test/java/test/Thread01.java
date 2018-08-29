package test;

public class Thread01 extends Thread{
	
	public static void main(String[] args) {
		Thread01 thread = new Thread01();
		thread.setName("线程1");		
		thread.start();
	}
	
	public void run(){
		System.out.println(this.getName()+"====线程执行！");
	}
}
