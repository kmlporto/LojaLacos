package aplicacaoTeste;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Produto;

public class Deletar {
	public Deletar(){
		Fachada.inicializar();
		System.out.println("deletando...");
		try {
			Cliente cliente = Fachada.consultarClientePorNome("Julia");
			Fachada.excluirEmailCliente(cliente);
			System.out.println("Cliente " + cliente.getNome() + " excluiu seu email");
		}catch (Exception e) {System.out.println("1 -->" + e.getMessage()); }
		
		try {
			Cliente cliente = Fachada.consultarClientePorNome("Julia");
			String nome = cliente.getNome();
			Fachada.excluirCliente(cliente);
			System.out.println("Cliente " + nome + " foi deletado(a)");
		}catch (Exception e) {System.out.println("2 -->" + e.getMessage()); }
		
		try {
			Produto produto = Fachada.consultarProdutoDMCL("piranha pequena com estampa de baloes","piranha", "vermelho", 0.05);
			Fachada.excluirProduto(produto);
			System.out.println("Produto deletado com sucesso");
		}catch (Exception e) {System.out.println("3 -->" + e.getMessage()); }
		
		try {
			Cliente cliente = Fachada.consultarClientePorNome("Kamila");
			Produto produto = Fachada.consultarProdutoDMCL("presilha com laco", "presilha","verde", 0.25);
			Fachada.excluirItemDoCarrinho(cliente, produto);
			System.out.println("Item foi excluido do carrinho com sucesso");
		} catch (Exception e) {System.out.println("4 -->" + e.getMessage()); }
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}
	public static void main(String[] args) {
		new Deletar();
	}
}