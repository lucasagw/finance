package br.ucsal.pooa.finance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class SocketExemplo {

	public static void main(String[] args) throws Exception {
		//Socket socket = new Socket("mariojp.com.br", 80);
		//PrintWriter os = new PrintWriter(socket.getOutputStream());
		//BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
//		os.println("GET / HTTP/1.1\n\n");
//		os.flush();
		
//		String linha = "";
//		while((linha = is.readLine()) != null){
//			System.out.println(linha);
//		}
//		
		//socket.close();
		
		//Web Scrapping por url socket
		URL url = new URL("https://dolarhoje.com/");

		BufferedReader is = new BufferedReader(new InputStreamReader(url.openStream()));

		String linha = "";
		while ((linha = is.readLine()) != null) {
			if(linha.contains("<input type=\"text\" id=\"nacional\"")) {
				int tam = "id=\"nacional\" value=\"".length();
				int inicial = linha.lastIndexOf("id=\"nacional\" value=\"");
				int ultimo = linha.indexOf("/>", inicial);
				System.out.println(linha.substring(inicial+tam, ultimo-1));
			}		
		
		}
		
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());

		//Pegando dados de Ip e host
		InetAddress[] address2 = InetAddress.getAllByName("DESKTOP-4IAMGOF");
		for (InetAddress inetAddress : address2) {
			System.out.println(inetAddress.getHostName());
			System.out.println(inetAddress.getHostAddress());
		}
	
		System.out.println(InetAddress.getByName("ucsal.br").getHostAddress());
	}
}
