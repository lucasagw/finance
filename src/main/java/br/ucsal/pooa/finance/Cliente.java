package br.ucsal.pooa.finance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) throws Exception {
		Socket socketCliente = new Socket("localhost", 4444);

		PrintWriter os = new PrintWriter(socketCliente.getOutputStream());
		BufferedReader is = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

		os.println("DOLAR:REAL");
		os.flush();

		String linha = "";
		while ((linha = is.readLine()) != null) {
			System.out.println(linha);
		}
	}
}
