package modelo;

import javax.persistence.Entity;

@Entity
public class Admin extends Usuario{
	public Admin() {
		super();
	}
	

	@Override
	public String toString() {
		return "Admin"
				+ "\n nome:" + this.getNome()
				+ "\n cpf: " + this.getCpf() 
				+ "\n email: " + this.getEmail();
				
	}

	public Admin(String user, String password, String nome, String cpf, String email) {
		super(user, password, nome, cpf, email);
		// TODO Auto-generated constructor stub
	}
}
