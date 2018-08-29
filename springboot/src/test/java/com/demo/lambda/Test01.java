package com.demo.lambda;

public class Test01 {
	
	TestDao tests = new TestDao(){

		@Override
		public boolean test() {
			
			return false;
		}
		
	};
	
	TestDao test1 = () -> false;
	
}
