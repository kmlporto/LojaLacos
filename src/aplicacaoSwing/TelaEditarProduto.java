package aplicacaoSwing;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Produto;

public class TelaEditarProduto extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarProduto frame = new TelaEditarProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaEditarProduto() {
		setTitle("Editar produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 271);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDadosProduto = new JLabel("Dados Produto");
		lblDadosProduto.setBounds(107, 0, 125, 15);
		contentPane.add(lblDadosProduto); 
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(12, 27, 77, 14);
		contentPane.add(lblDescricao);
				
		JTextField txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(107, 25, 209, 20);
		contentPane.add(txtDescricao);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 57, 77, 14);
		contentPane.add(lblModelo);

		JTextField txtModelo = new JTextField();
		txtModelo.setBounds(107, 55, 108, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		
		JLabel lblCor = new JLabel("cor");
		lblCor.setBounds(12, 85, 32, 17);
		contentPane.add(lblCor);
		
		JTextField txtCor = new JTextField();
		txtCor.setBounds(62, 83, 70, 19);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		JLabel lblLargura = new JLabel("largura");
		lblLargura.setBounds(162, 85, 70, 15);
		contentPane.add(lblLargura);
		
		JTextField txtLargura = new JTextField();
		txtLargura.setBounds(239, 83, 77, 19);
		contentPane.add(txtLargura);
		txtLargura.setColumns(10);
		
		JLabel lblmsg = new JLabel("");
		lblmsg.setBounds(12, 199, 301, 14);
		contentPane.add(lblmsg);
		
		JLabel lblNovosDados = new JLabel("Novos Dados");
		lblNovosDados.setBounds(107, 114, 108, 15);
		contentPane.add(lblNovosDados);
		
		JLabel lblNovaDesc = new JLabel("Descrição");
		lblNovaDesc.setBounds(12, 143, 77, 14);
		contentPane.add(lblNovaDesc);
		
		JTextField txtNovaDesc = new JTextField();
		txtNovaDesc.setColumns(10);
		txtNovaDesc.setBounds(107, 141, 209, 20);
		contentPane.add(txtNovaDesc);
		
		JLabel lblEstoque = new JLabel("estoque");
		lblEstoque.setBounds(12, 169, 68, 18);
		contentPane.add(lblEstoque);
		
		JTextField txtEstoq = new JTextField();
		txtEstoq.setColumns(10);
		txtEstoq.setBounds(98, 169, 49, 20);
		contentPane.add(txtEstoq);
		
		JTextField txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(267, 169, 49, 20);
		contentPane.add(txtPreco);
		
		JLabel lblPreco = new JLabel("preco");
		lblPreco.setBounds(187, 169, 68, 18);
		contentPane.add(lblPreco);
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try{
					String descricao = txtDescricao.getText();
					String modelo = txtModelo.getText();
					String cor = txtCor.getText();
					double largura = Double.parseDouble(txtLargura.getText());
					Produto produto = Fachada.consultarProdutoDMCL(descricao, modelo, cor, largura);
					String novaDescricao = txtNovaDesc.getText();
					double novoPreco = Double.parseDouble(txtPreco.getText());
					int novoEstoque = Integer.parseInt(txtEstoq.getText());
					Fachada.editarProduto(produto, novaDescricao, novoPreco, novoEstoque);
					lblmsg.setText("produto alterado");
					
					txtDescricao.setText("");
					txtModelo.setText("");
					txtCor.setText("");
					txtLargura.setText("");
					txtNovaDesc.setText("");
					txtPreco.setText("");
					txtEstoq.setText("");
					txtDescricao.requestFocus();
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		btnAlterar.setBounds(208, 208, 108, 23);
		contentPane.add(btnAlterar);
		
	}
}
