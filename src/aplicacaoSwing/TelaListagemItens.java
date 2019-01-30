package aplicacaoSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Carrinho;
import modelo.Cliente;
import modelo.ItemProduto;

public class TelaListagemItens extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnListar;

	public TelaListagemItens() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				btnListar.doClick();
			}
		});
		setTitle("Listar Itens");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try{
				Cliente cliente = (Cliente)Fachada.getLogado();
				Carrinho car = Fachada.consultarCarrinhoCliente(cliente);
				String texto;
				texto = "Listagem de itens no carrinho: \n";
				if (car != null)
					for (ItemProduto i : car.getItens() ) {
						texto +=   i.toString() + '\n';
					}
				else 	
					texto += "Carrinho esta vazio\n";

				textArea.setText(texto);
			}
			catch(Exception erro){
				JOptionPane.showMessageDialog(null,erro.getMessage());
			}
		}
	});

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 510, 174);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
	}
}
