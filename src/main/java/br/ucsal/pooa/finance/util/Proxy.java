package br.ucsal.pooa.finance.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Proxy extends ServerSocket implements Runnable {

	private String cotacao = "5,45";

	public Proxy() throws IOException {
		super(4444);
	}

	@Override
	public void run() {
		try {
			while (true) {

				Socket cliente = this.accept();
				System.out.println("cliente conectado");

				InputStream comandos = cliente.getInputStream();
				OutputStream dados = cliente.getOutputStream();
				BufferedReader is = new BufferedReader(new InputStreamReader(comandos));
				PrintWriter os = new PrintWriter(dados);

				System.out.println(is.readLine());

				os.println(cotacao);
				os.flush();

				cliente.close();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("subiu o servidor");
		

	}

}
