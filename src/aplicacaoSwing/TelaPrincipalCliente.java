package aplicacaoSwing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipalCliente extends JFrame{
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalCliente window = new TelaPrincipalCliente();
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
	public TelaPrincipalCliente() {
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

		setBounds(100, 100, 435, 376);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnProduto = new JMenu("          Produto            ");
		menuBar.add(mnProduto);

		JMenuItem listarProduto = new JMenuItem("            Listar           ");
		listarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemProduto j = new TelaListagemProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(listarProduto);
		
		JMenuItem procurarProduto = new JMenuItem("          Procurar      ");
		procurarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultarProduto j = new TelaConsultarProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(procurarProduto);

		
		JMenu mnCarrinho = new JMenu("   Meu Carrinho     ");
		menuBar.add(mnCarrinho);

		JMenuItem adicionarItem = new JMenuItem("   Adicionar Item ");
		adicionarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdicionarItem j = new TelaAdicionarItem();
				j.setVisible(true);
			}
		});
		mnCarrinho.add(adicionarItem);
		
		JMenuItem listarItens = new JMenuItem("          Listar ");
		mnCarrinho.add(listarItens);
		listarItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemItens j = new TelaListagemItens();
				j.setVisible(true);
			}
		});
		mnCarrinho.add(listarItens);
		
		JMenuItem excluirItem = new JMenuItem("     Excluir Item ");
		excluirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				TelaListagemItens j = new TelaListagemItens();
//				j.setVisible(true);
			}
		});
//		mnCarrinho.add(excluirItem);

	}
}
