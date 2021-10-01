package br.ucsal.pooa.finance;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DolarServidor {

	public static void main(String[] args) throws Exception {
		
		ServerSocket escuta = new ServerSocket(4444);
		System.out.println("subiu o servidor");
		while(true) {
		
			Socket cliente = escuta.accept();
			System.out.println("cliente conectado");
			
			InputStream comandos = cliente.getInputStream();
			OutputStream dados =  cliente.getOutputStream();
			BufferedReader is = new BufferedReader(new InputStreamReader(comandos));
			PrintWriter os = new PrintWriter(dados);
		
			System.out.println(is.readLine());
			
			os.println("5,45");
			os.flush();
			
			//cliente.close();
			
		}
	}
}
