package com.demo.current;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.alibaba.fastjson.util.IOUtils;

public class Test {
	 
    public static final Object obj = new Object();
    
    public static void main(String[] args) throws FileNotFoundException {
          
       new Thread( new Produce()).start();
       new Thread( new Consumer()).start();
      
    }
}
