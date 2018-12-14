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

public class TelaCadastroProduto extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
		setTitle("Cadastrar Produto");
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
		
		JLabel lblPreco = new JLabel("R$");
		lblPreco.setBounds(239, 109, 32, 16);
		contentPane.add(lblPreco);
		
		JTextField txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(277, 110, 39, 20);
		contentPane.add(txtPreco);
		
		
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

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try{
					String descricao = txtDescricao.getText();
					String modelo = txtModelo.getText();
					int estoque = Integer.parseInt(txtQuantidade.getText());
					String cor = txtCor.getText();
					double largura = Double.parseDouble(txtLargura.getText());
					double preco = Double.parseDouble(txtPreco.getText());
					Produto p = Fachada.cadastrarProduto(descricao, modelo, estoque, cor, largura, preco);
					lblmsg.setText("cadastrado "+ p.getDescricao());
					
					txtDescricao.setText("");
					txtModelo.setText("");
					txtQuantidade.setText("");
					txtLargura.setText("");
					txtPreco.setText("");
					txtDescricao.requestFocus();
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
				Fachada.finalizar();
			}
		});
		btnCadastrar.setBounds(211, 155, 108, 23);
		contentPane.add(btnCadastrar);
		
	}
}
