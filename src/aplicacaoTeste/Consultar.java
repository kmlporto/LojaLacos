package aplicacaoTeste;

import fachada.Fachada;


public class Consultar {

	public Consultar(){
		Fachada.inicializar();
		try {
			System.out.println("..........consultas de cliente..........");
			System.out.println(Fachada.consultarClientePorNome("Aretuza"));
			System.out.println(Fachada.consultarClientePorParteNome("a"));
			System.out.println(Fachada.consultarClientePorEmail("yasmin@email.com"));
			System.out.println(Fachada.consultarClientePorCpf("999.999.999-99"));
			System.out.println("...........consultas de produto .........");
			System.out.println("...............por descricao.............");
			System.out.println(Fachada.consultarProdutosPorDescricao("faixa com laco"));
			System.out.println("..........por produto especifico ........");
			System.out.println(Fachada.consultarProdutoDMCL("piranha pequena com estampa de baloes","piranha", "azul", 0.05));
			System.out.println(".................por tipo ...............");
			System.out.println(Fachada.consultarProdutosPorModelo("presilha"));
			System.out.println("..................por cor................");
			System.out.println(Fachada.consultarProdutosPorCor("azul"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}
	public static void main(String[] args) {
		new Consultar();
	}
}