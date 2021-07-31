package Kolokvijum1;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {
	
	private Socket socket;
	private int redniBroj;
	
	
	public ServerThread(Socket socket, int redniBroj) {
		this.socket=socket;
		this.redniBroj = redniBroj;
}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			System.out.println("Povezao se klijent: " + redniBroj + " sa adresom " + socket.getInetAddress().getHostAddress());
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
			out.println("Dobrodosao! Tvoj redni broj je " + redniBroj);
	
			
			String message = "aaa";
			
			
			
			String temp = null;
			
			
			String smallest = "";
			
			int j = 0;
			
		
			while(!message.equals("KRAJ")) {
				
				
				message = in.readLine();
				System.out.println("Klijent " + redniBroj+ " kaze: " + message);
				
				if(message.equals("KRAJ")) {
					out.println("KRAJ");
				}
				
				for(int k=0; k<message.length(); k++) {
					temp = temp + message.charAt(k);
					
					if(message.charAt(k) != '-') {
						temp = temp + message.charAt(k);
						j=k;
						smallest = temp;
						temp = "";
						break;
						
					}
				
				}
				
				
				
				
				
				for(int i=j; i<message.length();i++) {
					
					if(message.charAt(i) != '-') {
						temp = temp + message.charAt(i);
					
					}
					else {
						if(temp.length() < smallest.length()) {
							smallest = temp;
							temp = "";
							}
						temp = "";
					}
					
					
				}
				
				
				
				
				
				out.println(smallest);
				
			}
			
			
			out.println("KRAJ");
			
			
			socket.close();
			System.out.println("Socket je zatvoren");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}
	

}