package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Thread03 {
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("线程执行！");
			}
		}).start();
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		//features.forEach(System.out::println);
		
		/*List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		 
	    System.out.println("Languages which starts with J :");
	    filter(languages, (str)->((String) str).startsWith("J"));
	 
	    System.out.println("Languages which ends with a ");
	    filter(languages, (str)->((String) str).endsWith("a"));
	 
	    System.out.println("Print all languages :");
	    filter(languages, (str)->true);
	 
	    System.out.println("Print no language : ");
	    filter(languages, (str)->false);
	 
	    System.out.println("Print language whose length greater than 4:");
	    filter(languages, (str)->((String) str).length() > 4);*/
	}
		   
	public static void filter(List<String> names, Predicate<String> condition) {
		for(String name: names)  {
			if(condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void filters(List names, Predicate condition) {
	    names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
	        System.out.println(name + " ");
	    });
	}
}
