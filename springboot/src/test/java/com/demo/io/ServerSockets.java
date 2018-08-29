package com.demo.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockets {
	
	public static void main(String[] args) throws IOException {
		testSocketClient();
		//testSocketServer();
	}
	
	public static void testSocketClient() throws IOException{
		InetAddress address = InetAddress.getByName("127.0.0.1");
		Socket socket = new Socket(address,8888);
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,"GB2313"));
		while(true){
			String sss = reader.readLine();
			if(sss==null){
				break;
			}
			System.out.println(sss);
		}
		reader.close();
		in.close();
		socket.close();
	}
	
	public static void testSocketServer() throws IOException{
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = serverSocket.accept();
		InputStream in = new FileInputStream("C:\\Users\\yang\\Desktop\\面试笔记.txt");
		byte[] bytes = new byte[1024];
		int len = 0;
		OutputStream out = socket.getOutputStream();
		while((len = in.read(bytes)) != -1){
			out.write(bytes, 0, len);
		}
		out.close();
		in.close();
		socket.close();
		serverSocket.close();
	}
}
