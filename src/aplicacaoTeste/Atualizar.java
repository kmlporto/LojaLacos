package aplicacaoTeste;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Produto;

public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		System.out.println("alterando...");
		
		// .................. Cliente .....................
		try {	
			Cliente cliente = Fachada.consultarClientePorNome("Yasmin");
			String novoemail = "novo@yasmin.com";
			Fachada.alterarEmailCliente(cliente, novoemail);
			System.out.println("Cliente " + cliente.getNome() + " recebeu um novo email: " + novoemail);
		}catch (Exception e) {System.out.println("1 -->" + e.getMessage()); }
		
		try {
			Cliente cliente = Fachada.consultarClientePorNome("Kamila");
			String novonome = "Kamila Freitas";
			Fachada.alterarNomeCliente(cliente, novonome);
			System.out.println("Cliente " + cliente.getNome() + " modificou seu nome: " + novonome);
		}catch (Exception e) {System.out.println("2 -->" + e.getMessage());}
		
		try {
			Cliente cliente = Fachada.consultarClientePorNome("Beatriz");
			Fachada.excluirEmailCliente(cliente);
		}catch (Exception e) {System.out.println("3 -->" + e.getMessage());}

		// .................. Produto .....................
		try {
			Produto produto = Fachada.consultarProdutoDMCL("piranha pequena com estampa de baloes","piranha", "branco", 0.05);
			Cliente cliente = Fachada.consultarClientePorNome("Maria Luiza");
			Fachada.excluirItemDoCarrinho(cliente, produto);
			System.out.println("Produto " + produto.getDescricao() + " na cor " + produto.getCor() + " foi removido do carrinho");
		}catch (Exception e) {System.out.println("4 -->" + e.getMessage());}
		
		try{
			Produto produto = Fachada.consultarProdutoDMCL("piranha pequena com estampa de baloes","piranha", "branco", 0.05);
			Fachada.alterarEstoqueProduto(produto, 30);
		}catch (Exception e) {System.out.println("5 -->" + e.getMessage());}
		
		try {
			Produto produto = Fachada.consultarProdutoDMCL("faixa com laco", "faixa", "amarelo", 0.10);
			String novaDescricao = "faixa com dois lacos";
			double novoPreco = 15;
			int novoEstoque = 7;
			Fachada.editarProduto(produto, novaDescricao, novoPreco, novoEstoque);
		} catch (Exception e) {System.out.println("6 -->" + e.getMessage());}
			
			// .................. ItemCarrinho ........................
		try {
			Cliente cliente = Fachada.consultarClientePorNome("Maria Luiza");
			Produto produto = Fachada.consultarProdutoDMCL("faixa com laco", "faixa", "amarelo", 0.10);
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

