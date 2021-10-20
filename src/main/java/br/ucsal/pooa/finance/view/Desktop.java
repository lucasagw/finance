package br.ucsal.pooa.finance.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.ucsal.pooa.finance.controller.Controller;
import br.ucsal.pooa.finance.model.Lancamento;

public class Desktop extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Controller controller;
	private boolean iniciar = false;

	private JTextField tipo = new JTextField();
	private JTextField descricao = new JTextField();
	private JTextField valor = new JTextField();
	private JTable grid;
	private Tabela tabela;

	public Desktop(Controller controller) {
		super("Finance");
		this.controller = controller;
		this.setSize(800, 600);
		menuInit();

		// Componente container, que agrupa outros
		JPanel cadastroPanel = new JPanel();
		cadastroPanel.setBackground(Color.BLUE);

		JPanel camposPanel = new JPanel(new GridLayout(3, 2));
		camposPanel.add(new JLabel("Descrição"));
		camposPanel.add(descricao);
		camposPanel.add(new JLabel("Valor"));
		camposPanel.add(valor);
		camposPanel.add(new JLabel("Tipo"));
		camposPanel.add(tipo);

		cadastroPanel.add(camposPanel);
		JButton salvar = new JButton("Salvar");
		cadastroPanel.add(salvar);

		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tipo = Desktop.this.tipo.getText();
				String descricao = Desktop.this.descricao.getText();
				BigDecimal valor = new BigDecimal(Desktop.this.valor.getText());
				Lancamento lancamento = new Lancamento(tipo, valor, descricao);
				controller.add(lancamento);
				tabela.setData(controller.lista());
				grid.updateUI(); // atualiza a tela

			}
		});

		// Adcionar painel na janela no topo
		this.add(cadastroPanel, BorderLayout.NORTH);

		System.out.println(controller.lista().size());
		
		tabela = new Tabela(controller.lista());

		grid = new JTable(tabela);
		grid.setDragEnabled(false);
		//this.add(grid, BorderLayout.CENTER);

		//Create the scroll pane and add the table to it.	
		JScrollPane scrollPane = new JScrollPane(grid);
		//scrollPane.setOpaque(true);
		//Add the scroll pane to this panel.
		add(scrollPane,BorderLayout.CENTER);

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
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		sistema.add(cadastrar);
		sistema.add(listar);
		sistema.add(saldo);
		sistema.add(sair);
		getJMenuBar().add(sistema);
	}
}
