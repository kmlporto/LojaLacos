package aplicacaoSwing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fachada.Fachada;
import modelo.Carrinho;
import modelo.Cliente;
import modelo.Produto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipalAdmin extends JFrame{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalAdmin window = new TelaPrincipalAdmin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipalAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Loja Lacos - Kamila Freitas");
		try {
			setContentPane(new FundoTela("src/img/foto.jpeg"));
		} catch (IOException e1) {
		}	

		setBounds(100, 100, 450, 386);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnProduto = new JMenu("      Produto      ");
		menuBar.add(mnProduto);

		JMenuItem cadastrarProduto = new JMenuItem("    Cadastrar  ");
		cadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroProduto j = new TelaCadastroProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(cadastrarProduto);

		JMenuItem listarProduto = new JMenuItem("       Listar ");
		listarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemProduto j = new TelaListagemProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(listarProduto);
		
		JMenuItem procurarProduto = new JMenuItem("     Procurar");
		procurarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultarProduto j = new TelaConsultarProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(procurarProduto);
		
		JMenuItem editarProduto = new JMenuItem("       Editar");
		editarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEditarProduto j = new TelaEditarProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(editarProduto);
		
		JMenuItem deletarProduto = new JMenuItem("      Deletar");
		deletarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDeletarProduto j = new TelaDeletarProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(deletarProduto);
		
		JMenuItem alterarEstoque = new JMenuItem("Alte. Estoque");
		alterarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlterarEstoqueProduto j = new TelaAlterarEstoqueProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(alterarEstoque);
		
		JMenu mmCliente = new JMenu("    Cliente     ");
		menuBar.add(mmCliente);

		JMenuItem listarCliente = new JMenuItem("     Listar    ");
		listarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemCliente j = new TelaListagemCliente();
				j.setVisible(true);
			}
		});
		mmCliente.add(listarCliente);
		
		JMenuItem excluirCliente = new JMenuItem("     Excluir   ");
		excluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDeletarCliente j = new TelaDeletarCliente();
				j.setVisible(true);
			}
		});
		mmCliente.add(excluirCliente);

		
		JMenu mnCarrinho = new JMenu("   Carrinhos   ");
		menuBar.add(mnCarrinho);

		JMenuItem listarCarrinho = new JMenuItem("     Listar     ");
		listarCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemCarrinho j = new TelaListagemCarrinho();
				j.setVisible(true);
			}
		});
		mnCarrinho.add(listarCarrinho);
		
		JMenu mnConta = new JMenu("     Conta     ");
		menuBar.add(mnConta); 

		JMenuItem sairConta = new JMenuItem("      Sair     ");
		sairConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TelaSairConta j = new TelaSairConta();
				//j.setVisible(true);
			}
		});
		mnConta.add(sairConta);
	}
}
