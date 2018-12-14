package aplicacaoSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Cliente;

public class TelaConsultarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nomeCliente;
	private JLabel lblNome;
	private JButton btnConsultar;
	private JTextArea textArea;
	private JLabel lblmsg;
	
	/**
	 * Create the frame.
	 */
	public TelaConsultarCliente() {
		Fachada.inicializar();
		setTitle("Consultar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nomeCliente = new JTextField();
		nomeCliente.setBounds(136, 10, 165, 20);
		contentPane.add(nomeCliente);
		nomeCliente.setColumns(10);

		lblNome = new JLabel("Nome Cliente");
		lblNome.setBounds(25, 12, 100, 14);
		contentPane.add(lblNome);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try{
					String text = "";
					String nome = nomeCliente.getText();
					Cliente cliente = Fachada.consultarClientePorNome(nome);
					text += cliente.toString() + cliente.getCarrinho().toString();
					textArea.setText("");
					textArea.setText(text);
			
					nomeCliente.setText("");
					nomeCliente.requestFocus();
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
				Fachada.finalizar();
			}
		});
		btnConsultar.setBounds(445, 12, 90, 23);
		contentPane.add(btnConsultar);
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 50, 510, 174);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(25, 235, 483, 14);
		contentPane.add(lblmsg);
	}
}
