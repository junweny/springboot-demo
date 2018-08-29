package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.util.DigestUtils;

public class Test {
	public static void main(String[] args) throws IOException {
		String ip_str = "192.168.10.34";
		String ip_str1 = ip_str.replaceAll("(\\d)+", "00$1");
		System.out.println(ip_str1);
		String ip_str2 = ip_str.replaceAll("(\\d+)", "00$1");
		System.out.println(ip_str2);
		
		String ip = "12";
		System.out.println(ip.length());
		
		System.out.println((int)((Math.random())*10000000));
		
		String path1 = "D:\\lol.txt";
		String path2 = "D:\\lol2.txt";
		
		InputStream in = new FileInputStream(path1);
		
		InputStream in1 = new FileInputStream(path2);
		
		String md5 = DigestUtils.md5DigestAsHex(in);
		
		String md52 = DigestUtils.md5DigestAsHex(in1);
		
		System.out.println(md5);
		
		System.out.println(md52);
	}
}
