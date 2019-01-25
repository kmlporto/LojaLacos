package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Usuario{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Carrinho carrinho;
	
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
	public Cliente() {
		super();
	}

	public Cliente(String user, String password, String nome, String cpf, String email) {
		super(user, password, nome, cpf, email);
		this.carrinho = new Carrinho();
		this.carrinho.setCliente(this);
		// TODO Auto-generated constructor stub
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
}