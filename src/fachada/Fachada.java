package fachada;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import daojpa.*;

/*
import daodb4o.DAO;
import daodb4o.DAOAdmin;
import daodb4o.DAOCarrinho;
import daodb4o.DAOCliente;
import daodb4o.DAOItemProduto;
import daodb4o.DAOPagamento;
import daodb4o.DAOProduto;
import daodb4o.DAOUsuario;
*/
import modelo.Admin;
import modelo.Carrinho;
import modelo.Cliente;
import modelo.ItemProduto;
import modelo.Pagamento;
import modelo.Produto;
import modelo.Usuario;

public class Fachada {
	private static DAOCliente daocliente = new DAOCliente();
	private static DAOProduto daoproduto = new DAOProduto();
	private static DAOCarrinho daocarrinho = new DAOCarrinho();
	private static DAOItemProduto daoitemproduto = new DAOItemProduto();
	private static DAOPagamento daopagamento = new DAOPagamento();
	private static DAOAdmin daoadmin = new DAOAdmin();
	
	private static Usuario logado;
	
	public static Usuario getLogado() {
		return logado;
	}
	
	public static void inicializar() {
		DAO.open();
	}
	
	public static void finalizar() {
		DAO.close();
	}
	// ....................... Usuario ............................
	
	public static byte[] geraHashBytes (String password) throws NoSuchAlgorithmException,
	UnsupportedEncodingException  {
		MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
		return algoritmo.digest(password.getBytes("UTF-8"));		
	}

	public static String byteToHex (byte[] password) {
		StringBuilder sb = new StringBuilder();
	    for (byte b : password) {
	        sb.append(String.format("%02X", b));
	    }
		return sb.toString();		
	}
	
	public static Usuario realizarLogin (String user, String password) throws Exception {
		DAOUsuario usuarioDAO = new DAOUsuario();
		Usuario usuario = usuarioDAO.verificaUsuario(user, geraHashBytes(password));
		logado = usuario;
		return usuario;
	}
	
	public static void realizarLogoff () throws Exception{
		if (logado == null)
			throw new Exception("Nao ha usuario logado!");
		logado = null;
	}
	
	public static Admin cadastrarAdmin(String user, String password, String nome, String cpf, String email) throws Exception{
		DAO.begin();
		byte[] bytepassword  = geraHashBytes(password);
		Admin admin = daoadmin.consultarAdminPorNome(nome);
		if(admin!= null)
			throw new Exception("cadastrar admin - admin "+ nome + " ja cadastrado");
		admin = new Admin(user, bytepassword, nome, cpf, email);
		daoadmin.create(admin);
		DAO.commit();
		return admin;
	}
	
	// ....................... Cliente ............................
	
	public static Cliente cadastrarCliente(String user, String password, String nome, String cpf, String email) throws Exception{
		DAO.begin();
		Cliente cliente = daocliente.consultarClientePorNome(nome);
		if(cliente != null)
			throw new Exception("cadastrar cliente - cliente "+ nome + " ja cadastrado");
		byte[] bytepassword  = geraHashBytes(password);
		cliente = new Cliente(user, bytepassword, nome, cpf, email);
		daocliente.create(cliente);
		DAO.commit();
		return cliente;
	}
	
	public static void alterarNomeCliente(Cliente cliente, String novonome) throws Exception{
		DAO.begin();
		if (cliente==null)
			throw new Exception("alterar cliente - cliente nao encontrado");
		
		cliente.setNome(novonome); 			
		cliente=daocliente.update(cliente);
		DAO.commit();	
	}
	
	public static void alterarEmailCliente(Cliente cliente, String novoemail) throws Exception{
		DAO.begin();
		if (cliente==null)
			throw new Exception("alterar cliente - cliente nao encontrado");

		cliente.setEmail(novoemail); 			
		cliente=daocliente.update(cliente);
		DAO.commit();	
	}
	
	public static void excluirEmailCliente(Cliente cliente) throws Exception{
		DAO.begin();
		if (cliente==null)
			throw new Exception("alterar cliente - cliente inexistente");

		cliente.setEmail(null); 			
		cliente=daocliente.update(cliente);
		DAO.commit();	
	}
	
	public static Cliente excluirCliente(Cliente cliente) throws Exception{
		DAO.begin();
		if (cliente == null) 
			throw new Exception("apagar cliente - cliente não cadastrado");
		if (!cliente.getCarrinho().isVazio())
			throw new Exception("apagar cliente - cliente está com carrinho ocupado");
		daocarrinho.delete(cliente.getCarrinho());
		daocliente.delete(cliente);
		DAO.commit();
		return cliente;
	}
	
	public static List<Cliente> listarClientes(){
		return daocliente.readAll();
	}
	
	// ......................... Produto .............................
	
	public static Produto cadastrarProduto(String descricao, String modelo, int estoque, String cor, double largura, double preco) throws Exception {
		DAO.begin();
		Produto produto = daoproduto.consultarProdutoDMCL(descricao, modelo, cor, largura);
		if (produto!=null)
			throw new Exception ("cadastrar produto - produto ja cadastrado");
		produto = new Produto(descricao, modelo, estoque, cor, largura, preco);
		daoproduto.create(produto);
		DAO.commit();
		return produto;
	}
	
	public static Produto editarProduto(Produto produto, String novaDescricao, double novoPreco, int novoEstoque) {
		DAO.begin();
		produto.setPreco(novoPreco);
		produto.setDescricao(novaDescricao);
		produto.setEstoque(novoEstoque);
		daoproduto.update(produto);
		DAO.commit();
		return produto;
	}
	
	public static void excluirProduto(Produto produto) throws Exception {
		DAO.begin();
		List<Carrinho> carrinhos = daocarrinho.consultarCarrinhosComItem(produto);
		if (carrinhos.size()>0){
			for (Carrinho c: carrinhos){
				ItemProduto item = daocarrinho.consultarItemNoCarrinho(produto);
				c.remover(item);
				daocarrinho.update(c);
				daoitemproduto.delete(item);
			}
		}
		daoproduto.delete(produto);
		DAO.commit();
	}
	
	public static void alterarEstoqueProduto(Produto produto, int quantidade) throws Exception{
		DAO.begin();
		produto.setEstoque(produto.getEstoque() + quantidade);
		daoproduto.update(produto);
		DAO.commit();
	}
	
	
	public static List<Produto> listarProdutos() {
		return daoproduto.readAll();		
	}
	public static List<Produto> listarProdutosPorModelo(String modelo){
		return daoproduto.consultarProdutosPorModelo(modelo);
	}

	public static Carrinho consultarCarrinhoCliente(Cliente cliente) {
		return daocarrinho.consultarCarrinhoCliente(cliente);
	}
	
	
	// ............................. Item/Carrinho/Pagamento ........................
	
	public static ItemProduto cadastrarItemProduto(Produto produto, int quantidade, Carrinho carrinho, double preco) throws Exception{
		DAO.begin();
		if(produto.getEstoque()<quantidade)
			throw new Exception("cadastrar item - nao possui a quantidade desejada em estoque");
		ItemProduto item = null;
		if(preco > 0)
			item = new ItemProduto(produto, quantidade,carrinho, preco);
		else 
			item = new ItemProduto(produto, quantidade, carrinho);

		daoitemproduto.create(item);
		DAO.commit();
		return item;
	}
	
	public static void adicionarItemNoCarrinho(Cliente cliente, Produto produto, int quantidade, double preco) throws Exception{
		DAO.begin();
		Carrinho carrinho = cliente.getCarrinho();
		ItemProduto item = carrinho.localizar(produto);
		
		if (item == null){
				item = Fachada.cadastrarItemProduto(produto, quantidade, carrinho, preco);
		}
		carrinho.adicionar(item);
		produto.setEstoque(produto.getEstoque()-quantidade);
		carrinho.setFrete(carrinho.getFrete() + (quantidade*2));
		carrinho.setTotal(carrinho.getTotal() + produto.getPreco()*quantidade);

		daoitemproduto.update(item);
		daocarrinho.update(carrinho);
		DAO.commit();
	}
	
	public static void excluirItemDoCarrinho(Cliente cliente, Produto produto) throws Exception{
		DAO.begin();
		
		Carrinho carrinho = cliente.getCarrinho();
		ItemProduto item = carrinho.localizar(produto);
		if (item==null) 
			throw new Exception("exlcuir item do carrinho - produto "+ produto.getDescricao() + " nao existe no carrinho");
		
		carrinho.setFrete(carrinho.getFrete()-(item.getQuantidade()*2));
		carrinho.setTotal(carrinho.getTotal()-item.getQuantidade()*produto.getPreco());
		
		daoitemproduto.delete(item);
		daocarrinho.update(carrinho);
		DAO.commit();
	}
	
	public static List<Carrinho> listarCarrinhos(){
		return daocarrinho.readAll();
	}
	
	
	public static Pagamento adicionarPagamento(String nome, String tipoPagamento) throws Exception{
		DAO.begin();
		
		Cliente cliente = daocliente.consultarClientePorNome(nome);
		if(cliente==null)
			throw new Exception("adicionar pagamento - cliente "+ nome + " nao cadastrado");
		
		Carrinho carrinho = cliente.getCarrinho();
		if(carrinho==null)
			throw new Exception("adicionar pagamento - carrinho esta vazio");
		
		GregorianCalendar c = new GregorianCalendar();
		SimpleDateFormat formatodor = new SimpleDateFormat("dd/MM/yyyy");
		String data = formatodor.format(c.getTime());
		
				
		Pagamento pagamento = new Pagamento(tipoPagamento, data, carrinho.getFrete() + carrinho.getTotal(), true);
		carrinho.setPagamento(pagamento);
		
		daopagamento.create(pagamento);
		daocarrinho.update(carrinho);
		DAO.commit();
		return pagamento;
	}
	
	// ...................... consultas  .......................
	// ................... .... Clientes .......................
	public static Cliente consultarClientePorNome(String nome){
		Cliente result = daocliente.consultarClientePorNome(nome);
		return result;
	}
	
	public static String consultarClientePorParteNome(String caracter){
		List<Cliente> result = daocliente.consultarClientesPorParteNome(caracter);
		String txt="";
		if (result!=null) {
			for (Cliente c :result) {
				txt+= c.toString();
			}
		}else
			txt+= "nao possui cliente que possui "+caracter+" no nome";
		return txt;
	}

	public static Cliente consultarClientePorCpf(String cpf){
		Cliente result = daocliente.consultarClientePorCpf(cpf);
		return result;
	}
	
	public static Cliente consultarClientePorEmail(String email){
		Cliente result = daocliente.consultarClientePorEmail(email);
		return result;
	}
	
	// ...................... Produtos .......................
	public static List<Produto> consultarProdutosPorDescricao(String descricao){
		List<Produto> result = daoproduto.consultarProdutosPorDescricao(descricao);
		return result;
	}
	
	public static String consultarProdutosPorModelo(String modelo) {
		List<Produto> result = daoproduto.consultarProdutosPorModelo(modelo);
		String txt="";
		if (result!=null) {
			for (Produto p :result) {
				txt+= p.toString();
			}
		}else
			txt+= "nao possui produtos do tipo "+modelo;
		return txt;
	}
	
	public static Produto consultarProdutoDMCL(String descricao, String modelo, String cor, double largura){
		Produto result = daoproduto.consultarProdutoDMCL(descricao,modelo,cor,largura);
		return result;
	}
	
	public static int consultarQuantidadeProdutoPorTipo(String tipo) {
		return daoproduto.consultarQuantidadeProdutoPorTipo(tipo);
	}
	
	public static String consultarProdutosPorCor(String cor){
		List<Produto> result = daoproduto.consultarProdutosPorCor(cor);
		String txt="";
		if (result!=null) {
			for (Produto p :result) {
				txt+= p.toString();
			}
		}else
			txt+= "nao possui produtos da cor "+cor;
		return txt;
	}
	
	public static int consultarQuantidadeProdutoPorCor(String cor) {
		int quantidade = daoproduto.consultarQuantidadeProdutoPorTipo(cor);
		return quantidade;
	}
	
	public static String consultarProdutosSemEstoque() {
		String txt = "";
		List<Produto> result = daoproduto.consultarProdutosSemEstoque();
		if (result == null)  
			txt += "consulta vazia";
		else 
			for(Produto p: result)
			txt += "\n" + p;
		return txt;
	}
}