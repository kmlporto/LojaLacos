package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cliente;

public class DAOCliente extends DAO<Cliente>{
	
	public Cliente consultarClientePorNome(String nome) {
		try {
			Query q = manager.createQuery(
					"select c from Cliente c where c.nome=:n"
				);
			q.setParameter("n", nome);
			Cliente resultado = (Cliente) q.getSingleResult();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public  List<Cliente> consultarClientesPorParteNome(String caract) {
		try {
			Query q = manager.createQuery(
					"select c from Cliente c where c.nome like :n"
				);
			String caracteres = "%" + caract + "%";
			q.setParameter("n", caracteres);
			List<Cliente> resultado = q.getResultList();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public Cliente consultarClientePorCpf(String cpf) {
		try {
			Query q = manager.createQuery(
					"select c from Cliente c where c.cpf=:n"
				);
			q.setParameter("n", cpf);
			Cliente resultado = (Cliente) q.getSingleResult();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public Cliente consultarClientePorEmail(String email) {
		try {
			Query q = manager.createQuery(
					"select c from Cliente c where c.email=:n"
				);
			q.setParameter("n", email);
			Cliente resultado = (Cliente) q.getSingleResult();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
}
