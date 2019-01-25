package aplicacaoTeste;

import fachada.Fachada;
import modelo.Cliente;

public class Cadastrar {

	public Cadastrar(){
		Fachada.inicializar();
		System.out.println("cadastrando...");
		
		try {
			Fachada.cadastrarProduto("faixa com laco", "faixa", 8, "vermelho", 0.10, 17);
			Fachada.cadastrarProduto("faixa com laco", "faixa", 8, "azul", 0.10, 17);
			Fachada.cadastrarProduto("faixa com laco", "faixa", 8, "branco", 0.10, 17);
			Fachada.cadastrarProduto("faixa com laco", "faixa", 8, "amarelo", 0.10, 17);
			Fachada.cadastrarProduto("porta-coquete com flores", "porta-coquete", 18, "vermelho", 0.05, 15);
			Fachada.cadastrarProduto("porta-coquete com flores", "porta-coquete", 18, "azul", 0.05, 15);
			Fachada.cadastrarProduto("porta-coquete com flores", "porta-coquete", 18, "branco", 0.05, 15);
			Fachada.cadastrarProduto("porta-coquete com flores", "porta-coquete", 18, "amarelo", 0.05, 15);
			Fachada.cadastrarProduto("piranha pequena com estampa de baloes","piranha" , 10, "vermelho", 0.05, 10);
			Fachada.cadastrarProduto("piranha pequena com estampa de baloes","piranha" , 10, "azul", 0.05, 10);
			Fachada.cadastrarProduto("piranha pequena com estampa de baloes","piranha" , 10, "branco", 0.05, 10);
			Fachada.cadastrarProduto("piranha pequena com estampa de baloes","piranha" , 10, "amarelo", 0.05, 10);
			Fachada.cadastrarProduto("tiara para bebe", "tiara", 14, "branco", 0.10, 14);
			Fachada.cadastrarProduto("tiara para bebe", "tiara", 14, "azul", 0.10, 14);
			Fachada.cadastrarProduto("faixa com estampa de ursinho", "faixa", 20, "azul", 0.10, 17.0);
			Fachada.cadastrarProduto("faixa com estampa de ursinho", "faixa", 20, "rosa", 0.10, 17.0);
			Fachada.cadastrarProduto("presilha com laco", "presilha", 5, "marrom", 0.15, 12.0);
			Fachada.cadastrarProduto("presilha com laco", "presilha", 5, "marrom", 0.25, 12.0);
			Fachada.cadastrarProduto("presilha com laco", "presilha", 5, "verde", 0.15, 12.0);
			Fachada.cadastrarProduto("presilha com laco", "presilha", 5, "verde", 0.25, 12.0);
			System.out.println("Produtos - foi!");
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		try {
//			Fachada.cadastrarCliente(user, password, nome, cpf, email)
			Fachada.cadastrarCliente("kmlporto", "123456" ,"Kamila", "999.999.999-99", "kamila@email.com");
			Fachada.cadastrarCliente("areta", "123456","Aretuza", "888.888.888-88", "aretuza@email.com");
			Fachada.cadastrarCliente("malu", "123456","Maria Luiza", "777.777.777-77", "malu@email.com");
			Fachada.cadastrarCliente("mim", "123456","Yasmin", "666.666.666-66", "yasmin@email.com");
			Fachada.cadastrarCliente("bia", "123456","Beatriz", "555.555.555-55", "beatriz@email.com");
			Fachada.cadastrarCliente("juh", "123456","Julia", "444.444.444-44", "julia@email.com");
			Fachada.cadastrarAdmin("AdM", "admin123", "admin master", "90909090", "admin123@master.com");
			System.out.println("Clientes - foi!");
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		try {
			String nome = "Kamila";
			Cliente c = Fachada.consultarClientePorNome(nome);
			if (c!=null) {
				Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("tiara para bebe", "tiara","branco", 0.10), 3, 0);
				Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("piranha pequena com estampa de baloes","piranha", "azul", 0.05), 2, 0);
				Fachada.adicionarItemNoCarrinho(c, Fachada.consultarProdutoDMCL("presilha com laco", "presilha","verde", 0.25), 1, 0);
			}else System.out.println("Cliente "+ nome+" nao encontrado");

			nome = "Maria Luiza";
			c = Fachada.consultarClientePorNome(nome);
			if (c!=null) {
				Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("piranha pequena com estampa de baloes","piranha", "azul", 0.05), 1, 0);
				Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("piranha pequena com estampa de baloes","piranha", "vermelho", 0.05), 1, 0);
				Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("piranha pequena com estampa de baloes","piranha", "branco", 0.05), 1, 0);
			}else System.out.println("Cliente "+ nome+" nao encontrado");
			
			nome = "Yasmin";
			c = Fachada.consultarClientePorNome(nome);
			if (c!=null) {
			Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("porta-coquete com flores", "porta-coquete", "branco", 0.05), 1, 0);
			Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("presilha com laco", "presilha", "verde", 0.15), 2, 0);
			}else System.out.println("Cliente "+ nome+" nao encontrado");
			
			nome = "Beatriz";
			c = Fachada.consultarClientePorNome(nome);
			if (c!=null) {
				Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("presilha com laco", "presilha", "marrom", 0.15), 2, 0);
				Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("tiara para bebe", "tiara","branco", 0.10), 5, 0);
			}else System.out.println("Cliente "+ nome+" nao encontrado");
			
			nome = "Aretuza";
			c = Fachada.consultarClientePorNome(nome);
			if (c!=null) {
				Fachada.adicionarItemNoCarrinho(c,Fachada.consultarProdutoDMCL("presilha com laco","presilha","marrom",0.15), 1, 0);
			}else System.out.println("Cliente "+ nome+" nao encontrado");
			
			System.out.println("itens no carrinho - foi!");
		} catch (Exception e) {System.out.println(e.getMessage());}
		try {
			Fachada.adicionarPagamento("Kamila", "dinheiro");
			Fachada.adicionarPagamento("Beatriz", "dinheiro");	
			System.out.println("pagamento - foi!");
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}