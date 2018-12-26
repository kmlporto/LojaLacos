package aplicacaoSwing;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Cliente;
import modelo.ItemProduto;
import modelo.Produto;

public class TelaAdicionarItem extends JFrame {
	private JTextField txtQtd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionarItem frame = new TelaAdicionarItem();
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
	public TelaAdicionarItem() {
		setTitle("Adicionar Item");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 382, 197);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		List<Produto> produtos = Fachada.listarProdutos();

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 14, 48, 14);
		contentPane.add(lblModelo);

		List<String> modelos = new ArrayList<String>();
		JComboBox<String> comboBoxModelo = new JComboBox<String>();
		comboBoxModelo.setBounds(68, 11, 108, 20);
		comboBoxModelo.addItem("----");
		if (produtos !=null)
			for(Produto p: produtos)
				if (!modelos.contains(p.getModelo()))
					modelos.add(p.getModelo());
		for (String c: modelos)
			comboBoxModelo.addItem(c);
		contentPane.add(comboBoxModelo);
		String modelo = String.valueOf(comboBoxModelo.getSelectedItem());


		produtos = Fachada.listarProdutosPorModelo(modelo);
		JLabel lblNome = new JLabel("Produto");
		lblNome.setBounds(10, 42, 77, 14);
		contentPane.add(lblNome);

		JComboBox<String> comboBoxProd = new JComboBox<String>();
		comboBoxProd.setBounds(68, 39, 203, 20);
		comboBoxProd.addItem("----");
		if (produtos !=null)
			for(Produto p: produtos)
				comboBoxProd.addItem(p.getDescricao());
		contentPane.add(comboBoxProd);
		String descricao = String.valueOf(comboBoxProd.getSelectedItem());

		JLabel lblcor = new JLabel("Cor");
		lblcor.setBounds(209, 14, 48, 14);
		contentPane.add(lblcor);

		List<String> cores = new ArrayList<String>();
		JComboBox<String> comboBoxCor = new JComboBox<String>();
		comboBoxCor.setBounds(246, 11, 108, 20);
		comboBoxCor.addItem("----");
		if (produtos !=null)
			for(Produto p: produtos)
				if (!cores.contains(p.getCor()))
					cores.add(p.getCor());
		for (String c: cores)
			comboBoxCor.addItem(c);
		contentPane.add(comboBoxCor);
		String cor = String.valueOf(comboBoxCor.getSelectedItem());

		JLabel lblLargura = new JLabel("Largura");
		lblLargura.setBounds(10, 70, 77, 14);
		contentPane.add(lblLargura);

		List<Double> larguras = new ArrayList<>();
		JComboBox<Double> comboBoxLargura = new JComboBox<Double>();
		comboBoxLargura.setBounds(68, 68, 108, 20);
		contentPane.add(comboBoxLargura);
		if (produtos != null)
			for(Produto p: produtos)
				if (!larguras.contains(p.getLargura()))
					larguras.add(p.getLargura());
		for (Double c: larguras)
			comboBoxLargura.addItem(c);
		contentPane.add(comboBoxLargura);
		Double largura = (Double)(comboBoxLargura.getSelectedItem());

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(220, 70, 86, 14);
		contentPane.add(lblQuantidade);

		txtQtd = new JTextField();
		txtQtd.setBounds(307, 68, 59, 20);
		contentPane.add(txtQtd);
		txtQtd.setColumns(10);

		JLabel lblmsg = new JLabel("");
		lblmsg.setBounds(10, 133, 353, 14);
		contentPane.add(lblmsg);

		JButton btnDeletar = new JButton("Adicionar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Produto prod = Fachada.consultarProdutoDMCL(descricao, modelo, cor, largura);
					Cliente cliente = (Cliente)Fachada.getLogado();
					int quantidade = Integer.parseInt(txtQtd.getText());

					if (prod != null) {
						double preco = prod.getPreco();
						Fachada.adicionarItemNoCarrinho(cliente, prod, quantidade, preco);
						lblmsg.setText("Item adicionado com sucesso");
					}else
						lblmsg.setText("Item n�o encontrado");

					txtQtd.setText("");
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		btnDeletar.setBounds(255, 99, 108, 23);
		contentPane.add(btnDeletar);

	}
}
