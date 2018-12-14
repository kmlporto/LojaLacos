package aplicacaoSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import modelo.Carrinho;
import modelo.Cliente;
import modelo.Produto;

public class TelaConsultarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtdescricao;
	private JLabel lblDescricao;
	private JButton btnConsultar;
	private JTextArea textArea;
	private JLabel lblmsg;
	
	/**
	 * Create the frame.
	 */
	public TelaConsultarProduto() {
		setTitle("Consultar Produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtdescricao = new JTextField();
		txtdescricao.setBounds(106, 15, 194, 20);
		contentPane.add(txtdescricao);
		txtdescricao.setColumns(10);

		lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(24, 17, 100, 14);
		contentPane.add(lblDescricao);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try{
					String descricao = txtdescricao.getText();
					List<Produto> produtos = Fachada.consultarProdutosPorDescricao(descricao);
					String texto = "Listagem de contas: \n";
					if (produtos.isEmpty())
						texto += "nao possui produtos cadastrados\n";
					else 	
						for(Produto p: produtos) 
							texto +=  p + "\n"; 
					
					textArea.setText("");
					textArea.setText(texto);
			
					txtdescricao.setText("");
					txtdescricao.requestFocus();
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
				Fachada.finalizar();
			}
		});
		btnConsultar.setBounds(407, 12, 128, 23);
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
