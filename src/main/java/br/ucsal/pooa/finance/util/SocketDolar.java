package br.ucsal.pooa.finance.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDolar implements Runnable {

	@Override
	public void run() {
		while (true) { // fazer rodar a cada 3 segundos
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			Socket socketCliente;
			try {
				socketCliente = new Socket("localhost", 4444);
				PrintWriter os = new PrintWriter(socketCliente.getOutputStream());
				BufferedReader is = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

				os.println("DOLAR:REAL");
				os.flush();

				String linha = "";
				while ((linha = is.readLine()) != null) {
					System.out.println(linha);
				}

				os.println("DOLAR:REAL");
				os.flush();

			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
