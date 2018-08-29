package com.demo.current;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeSequence {
	
//	private AtomicInteger value = new AtomicInteger(0);
	private static int value;
	
	private final ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	public static synchronized int getNext() throws InterruptedException{
		//threadLocal.set("222");
		//System.out.println(threadLocal.get());
		Thread.sleep(1000);
			if(value>=10){
				return value;
			}
			return value++;
	}
	
	public static void main(String[] args) {
		//UnsafeSequence unsafe = new UnsafeSequence();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(20);
						System.out.println(UnsafeSequence.getNext());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		
	}
	
	abstract class sss{
		
		
	}
	
}
