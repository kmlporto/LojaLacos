package modelo;

import java.util.Arrays;

import javax.persistence.Entity;
@Entity
public class Usuario {
	private String user;
	private byte[] password;
	private String nome;
	private String cpf;
	private String email;
	
	
	public Usuario(String user, byte[] password, String nome, String cpf, String email) {
		super();
		this.user = user;
		this.password = password;
		this.nome = nome;
		this.cpf = cpf;
		this.setEmail(email);
	}

	public String getUser() {
		return user;
	}

	public byte[] getPassword() {
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
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Usuario\n user: " + user + "\n password: " + Arrays.toString(password) + "\n nome: " + nome + "\n cpf: " + cpf;
	}

}