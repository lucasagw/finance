package br.ucsal.pooa.finance.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import br.ucsal.pooa.finance.controller.Controller;

public class JanelaDesktop extends JFrame {

	private Controller controller;
	private boolean iniciar = false;

	public JanelaDesktop(Controller controller) {
		super("Finance");
		// setLayout(new FlowLayout());
		setLayout(null);
		this.controller = controller;
		this.setSize(800, 600);
		menuInit();

		JButton cadastro = new JButton("Clique aqui");
		cadastro.setBounds(100, 100, 200, 150);

		cadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (cadastro.getX() == 100 && cadastro.getY() == 100) {
					cadastro.setBounds(400, 400, 200, 150);
				} else {
					cadastro.setBounds(100, 100, 200, 150);

				}
			}

		});

		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					if(iniciar) {
						cadastro.setBounds((int) (Math.random() * 800), (int) (Math.random() * 600), 200, 150);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}).start();

		cadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(JanelaDesktop.this, "Voce clicou no BOTÃO");

			}
		});

		this.add(cadastro);

		this.add(new Button("1"), BorderLayout.NORTH);
		this.add(new Button("1.1"), BorderLayout.NORTH);
		this.add(new Button("2"), BorderLayout.SOUTH);
		this.add(new Button("3"), BorderLayout.WEST);
		this.add(new Button("4"), BorderLayout.EAST);
		this.add(new Button("5"), BorderLayout.CENTER);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void menuInit() {
		this.setJMenuBar(new JMenuBar());
		JMenu sistema = new JMenu("Sistema");

		JMenu cadastrar = new JMenu("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciar = true;
			}
		});

		JMenu listar = new JMenu("Listar");
		listar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciar = false;
			}
		});

		JMenu saldo = new JMenu("Saldo");
		JMenu sair = new JMenu("Sair");
		sistema.add(cadastrar);
		sistema.add(listar);
		sistema.add(saldo);
		sistema.add(sair);
		getJMenuBar().add(sistema);
	}
}
