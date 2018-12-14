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
import modelo.Cliente;

public class TelaDeletarCliente extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeletarCliente frame = new TelaDeletarCliente();
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
	public TelaDeletarCliente() {
		setTitle("Deletar Produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 180);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 14, 77, 14);
		contentPane.add(lblNome);
				
		JTextField txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(107, 12, 195, 20);
		contentPane.add(txtNome);

		JLabel lblcpf = new JLabel("cpf");
		lblcpf.setBounds(12, 46, 77, 14);
		contentPane.add(lblcpf);

		JTextField txtCpf = new JTextField();
		txtCpf.setBounds(107, 44, 108, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		
		JLabel lblmsg = new JLabel("");
		lblmsg.setBounds(12, 108, 290, 14);
		contentPane.add(lblmsg);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try{
					String nome = txtNome.getText();
					String cpf = txtCpf.getText();
					if (!nome.equals("")) {
						Cliente cliente = Fachada.consultarClientePorNome(nome);
						if (cliente != null) {
							Fachada.excluirCliente(cliente);
							lblmsg.setText("deletado com sucesso");
						}
					}else if (!cpf.equals("")) {
						Cliente cliente = Fachada.consultarClientePorCpf(cpf);
						if (cliente != null) {
							Fachada.excluirCliente(cliente);
							lblmsg.setText("deletado com sucesso");
						}
					}else
						lblmsg.setText("digite um valor valido");
					
					txtNome.setText("");
					txtCpf.setText("");
					
					txtNome.requestFocus();
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
