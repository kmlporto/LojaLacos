package daojpa;

import java.util.List;

import javax.persistence.Query;

import modelo.Cliente;

public class DAOCliente extends DAO<Cliente>{
	
	public Cliente consultarClientePorNome(String nome) {
		Query q = manager.createQuery(
				"select c from Cliente c where c.nome=:n"
			);
		q.setParameter("n", nome);
		List<Cliente> resultado = q.getResultList();
		if (resultado.size()>0)
			return (Cliente) resultado.get(0);
		else 
			return null;
	}
	
	public  List<Cliente> consultarClientesPorParteNome(String caract) {
		Query q = manager.createQuery(
				"select c from Cliente c where c.nome like :n"
			);
		String caracteres = "%" + caract + "%";
		q.setParameter("n", caracteres);
		List<Cliente> resultado = q.getResultList();
		System.out.println(resultado);
		return resultado;
	}
	
	public Cliente consultarClientePorCpf(String cpf) {
		Query q = manager.createQuery(
				"select c from Cliente c where c.cpf=:n"
			);
		q.setParameter("n", cpf);
		Cliente resultado = (Cliente) q.getSingleResult();
		return resultado;
	}
	
	public Cliente consultarClientePorEmail(String email) {
		Query q = manager.createQuery(
				"select c from Cliente c where c.email=:n"
			);
		q.setParameter("n", email);
		Cliente resultado = (Cliente) q.getSingleResult();
		return resultado;
	}
}
