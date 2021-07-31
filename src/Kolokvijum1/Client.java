package Kolokvijum1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public Client() throws Exception{
		
		int port = 72 % 24 + 1300;
		
		Socket socket = new Socket("192.168.1.137", port);
		System.out.println("Povezan na server uspesno");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		Scanner tastatura = new Scanner(System.in);
		String message = in.readLine();
		
		System.out.println("Server kaze: " + message);
		
		System.out.println("Za izlaz uneti KRAJ");
		
		
		while(!message.equals("KRAJ")) {
			
			System.out.println("Uneti string za analizu: ");
			
			message = tastatura.nextLine();
			out.println(message);
			
			message = in.readLine();
			System.out.println("Server: " + message);
			
		}
		
		socket.close();
		System.out.println("Socket je zatvoren");
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Client();
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();	
		}
	}

}
