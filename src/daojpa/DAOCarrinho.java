package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Carrinho;
import modelo.Cliente;
import modelo.Produto;

public class DAOCarrinho extends DAO<Carrinho> {
	public List<Carrinho> consultarCarrinhosComItem(Produto produto){
		try{
			Query q = manager.createQuery(
				"select c "
				+ "from Carrinho c JOIN c.itens JOIN i.produto p "
				+ "where i.produto= :n"
			);
			q.setParameter("n", produto);
			List<Carrinho> resultado = q.getResultList();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public Carrinho consultarCarrinhoCliente(Cliente cliente){
		try {
			Query q = manager.createQuery(
					"select c from Carrinho c "
					+ "where c.cliente=:n"
				);
			q.setParameter("n", cliente);
			Carrinho resultado = (Carrinho) q.getSingleResult();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
}
