package aplicacaoTeste;

import fachada.Fachada;


public class Listar {

	public Listar(){
		Fachada.inicializar();
		try {
			System.out.println(Fachada.listarClientes());
			System.out.println(Fachada.listarProdutos());
			System.out.println(Fachada.listarCarrinhos());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

