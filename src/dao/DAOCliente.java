package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Cliente;

public class DAOCliente extends DAO<Cliente>{
	
	public Cliente consultarClientePorNome(String nome) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("nome").constrain(nome);
		List<Cliente> resultado = q.execute();
		if (resultado.size()>0)
			return (Cliente) resultado.get(0);
		else 
			return null;
	}
	public  List<Cliente> consultarClientesPorParteNome(String caracteres) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("nome").constrain(caracteres).like();
		List<Cliente> resultado = q.execute(); 
		return resultado;
	}
	
	public Cliente consultarClientePorCpf(String cpf) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("cpf").constrain(cpf);
		List<Cliente> resultado = q.execute();
		if (resultado.size()>0)
			return (Cliente) resultado.get(0);
		else 
			return null;
	}
	
	public Cliente consultarClientePorEmail(String email) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("email").constrain(email);
		List<Cliente> resultado = q.execute();
		if (resultado.size()>0)
			return (Cliente) resultado.get(0);
		else 
			return null;
	}
}
