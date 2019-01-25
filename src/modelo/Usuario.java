package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String nome;
	private String cpf;
	private String email;
	
	public Usuario() {}
	
	public Usuario(String user, String password, String nome, String cpf, String email) {
		super();
		this.username = user;
		this.password = password;
		this.nome = nome;
		this.cpf = cpf;
		this.setEmail(email);
	}

	public String getUser() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setUser(String user) {
		this.username = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Usuario\n user: " + username + "\n password: " + password + "\n nome: " + nome + "\n cpf: " + cpf;
	}

}