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
import javax.swing.JList;

public class TelaAlterarEstoqueProduto extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarEstoqueProduto frame = new TelaAlterarEstoqueProduto();
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
	public TelaAlterarEstoqueProduto() {
		setTitle("Alterar Estoque do Produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 347, 217);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(12, 14, 77, 14);
		contentPane.add(lblDescricao);
				
		JTextField txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(107, 12, 209, 20);
		contentPane.add(txtDescricao);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 46, 77, 14);
		contentPane.add(lblModelo);

		JTextField txtModelo = new JTextField();
		txtModelo.setBounds(107, 44, 108, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblQuant = new JLabel("qtd");
		lblQuant.setBounds(12, 110, 39, 18);
		contentPane.add(lblQuant);
		
		JTextField txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(62, 108, 49, 20);
		contentPane.add(txtQuantidade);
		
		
		JLabel lblCor = new JLabel("cor");
		lblCor.setBounds(12, 79, 32, 17);
		contentPane.add(lblCor);
		
		JTextField txtCor = new JTextField();
		txtCor.setBounds(62, 77, 70, 19);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		JLabel lblLargura = new JLabel("largura");
		lblLargura.setBounds(162, 79, 70, 15);
		contentPane.add(lblLargura);
		
		JTextField txtLargura = new JTextField();
		txtLargura.setBounds(239, 77, 77, 19);
		contentPane.add(txtLargura);
		txtLargura.setColumns(10);
		
		JLabel lblmsg = new JLabel("");
		lblmsg.setBounds(12, 140, 321, 14);
		contentPane.add(lblmsg);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try{
					String descricao = txtDescricao.getText();
					String modelo = txtModelo.getText();
					int quantidade = Integer.parseInt(txtQuantidade.getText());
					String cor = txtCor.getText();
					double largura = Double.parseDouble(txtLargura.getText());
					Produto produto = Fachada.consultarProdutoDMCL(descricao, modelo, cor, largura);
					Fachada.alterarEstoqueProduto(produto, quantidade);
					lblmsg.setText("estoque alterado - novo estoque:"+ produto.getEstoque());
					
					txtDescricao.setText("");
					txtModelo.setText("");
					txtQuantidade.setText("");
					txtLargura.setText("");
					txtDescricao.requestFocus();
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
				Fachada.finalizar();
			}
		});
		btnAlterar.setBounds(211, 155, 108, 23);
		contentPane.add(btnAlterar);
		
	}
}
