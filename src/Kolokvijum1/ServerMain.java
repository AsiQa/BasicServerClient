package Kolokvijum1;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	
	public ServerMain() throws Exception{
		
		
		int broj = 72%24+1300;
		ServerSocket serverSocket = new ServerSocket(broj);
		
		System.out.println("Otvoren je port " + broj);
		
		 int redniBroj = 1;
		 
		 while(true) {	
			 
			 Socket socket = serverSocket.accept();
			 
			 ServerThread serverThread = new ServerThread(socket, redniBroj++);
			 
			 Thread thread = new Thread(serverThread);
			 
			 thread.start();
			 
		 }
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				new ServerMain();
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
	}

}

