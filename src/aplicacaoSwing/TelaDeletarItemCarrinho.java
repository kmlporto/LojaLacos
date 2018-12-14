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

public class TelaDeletarItemCarrinho extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeletarItemCarrinho frame = new TelaDeletarItemCarrinho();
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
	public TelaDeletarItemCarrinho() {
		setTitle("Deletar Item");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 180);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblItem = new JLabel("Item");
		lblItem.setBounds(12, 14, 77, 14);
		contentPane.add(lblItem);
				
		JTextField txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(107, 12, 195, 20);
		contentPane.add(txtDescricao);
		
		JLabel lblmsg = new JLabel("");
		lblmsg.setBounds(12, 108, 290, 14);
		contentPane.add(lblmsg);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try{
					/**String descricao = txtDescricao.getText();
					String modelo = txtModelo.getText();
					String cor = txtCor.getText();
					double largura = Double.parseDouble(txtLargura.getText());
					Produto produto = Fachada.consultarProdutoDMCL(descricao, modelo, cor, largura);
					Fachada.excluirProduto(produto);
					lblmsg.setText("deletado com sucesso");
					
					txtDescricao.setText("");
					txtModelo.setText("");
					txtLargura.setText("");
					txtCor.setText("");
					txtDescricao.requestFocus();
					**/
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
				Fachada.finalizar();
			}
		});
		btnDeletar.setBounds(194, 120, 108, 23);
		contentPane.add(btnDeletar);
		
	}
}
