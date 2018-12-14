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

public class TelaCadastroCliente extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setTitle("Cadastrar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 282, 227);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 12, 57, 14);
		contentPane.add(lblNome);
				
		JTextField txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(63, 12, 197, 20);
		contentPane.add(txtNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(12, 38, 57, 17);
		contentPane.add(lblCpf);

		JTextField txtCpf = new JTextField();
		txtCpf.setBounds(63, 38, 130, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		
		JLabel lblemail = new JLabel("email");
		lblemail.setBounds(12, 67, 57, 17);
		contentPane.add(lblemail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(63, 68, 197, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblUser = new JLabel("user");
		lblUser.setBounds(12, 96, 57, 17);
		contentPane.add(lblUser);
		
		JTextField txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(63, 97, 130, 19);
		contentPane.add(txtUser);
		
		JLabel lblSenha = new JLabel("senha");
		lblSenha.setBounds(12, 125, 57, 17);
		contentPane.add(lblSenha);
		
		JTextField txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(63, 126, 130, 19);
		contentPane.add(txtSenha);
		
		JLabel lblmsg = new JLabel("");
		lblmsg.setBounds(11, 154, 249, 14);
		contentPane.add(lblmsg);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try{
					String nome = txtNome.getText();
					String cpf = txtCpf.getText();
					String email = txtEmail.getText();
					String user = txtUser.getText();
					String senha = txtSenha.getText();
					
					Cliente cliente = Fachada.cadastrarCliente(user, senha, nome, cpf, email);
					lblmsg.setText("cadastrado: "+ cliente.getNome());
					
					txtNome.setText("");
					txtCpf.setText("");
					txtEmail.setText("");
					txtUser.setText("");
					txtSenha.setText("");
					txtNome.requestFocus();
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
				Fachada.finalizar();
			}
		});
		btnCadastrar.setBounds(152, 169, 108, 23);
		contentPane.add(btnCadastrar);
		

		
	}
}
