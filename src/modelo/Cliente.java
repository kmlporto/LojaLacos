package modelo;

public class Cliente extends Usuario{
	private Carrinho carrinho;
	
	public Cliente(String user, byte[] password, String nome, String cpf, String email) {
		super(user, password, nome, cpf, email);
		this.carrinho = new Carrinho();
		this.carrinho.setCliente(this);
	}
	
	@Override
	public String toString() {
		return "\nCliente"
				+ "\n nome:" + this.getNome()
				+ "\n cpf: " + this.getCpf() 
				+ "\n email: " + this.getEmail()	
				+ "\n itens carrinho: "+ this.getCarrinho().getItens().size();
				
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
}