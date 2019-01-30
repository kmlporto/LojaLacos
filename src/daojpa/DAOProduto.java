package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Produto;


public class DAOProduto extends DAO<Produto>{
	
	public List<Produto> consultarProdutosPorDescricao(String descricao) {
		try {
			Query q = manager.createQuery(
				"select p from Produto p where p.descricao = :n"
			);
			q.setParameter("n", descricao);
			List<Produto> resultado = q.getResultList();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public Produto consultarProdutoDMCL(String descricao,String modelo,  String cor, double largura) {
		try {
			Query q = manager.createQuery(
					"select p from Produto p where p.descricao=:d AND  "
					+ "p.modelo=:m AND p.cor=:c AND  p.largura=:l"
				);
			q.setParameter("d", descricao);
			q.setParameter("m", modelo);
			q.setParameter("c", cor);
			q.setParameter("l", largura);		
			Produto resultado = (Produto) q.getSingleResult();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public List<Produto> consultarProdutosPorModelo(String modelo) {
		try {
			Query q = manager.createQuery(
				"select p from Produto p where p.modelo=:n"
			);
			q.setParameter("n", modelo);
			List<Produto> resultado = q.getResultList();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public int consultarQuantidadeProdutoPorTipo(String tipo) {
		Query q = manager.createQuery(
			"select p from Produto p where p.tipo=:n"
		);
		q.setParameter("n", tipo);
		List<Produto> resultado = q.getResultList();
		int total = 0;
		if (resultado.size()>0) {
			for (Produto r: resultado) {
				total = total + r.getEstoque();
			}
		}	
		return total;
	}

	public List<Produto> consultarProdutosPorCor(String cor){
		try {
			Query q = manager.createQuery(
				"select p from Produto p where p.cor=:n"
			);
			q.setParameter("n", cor);
			List<Produto> resultado = q.getResultList();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public int consultarQuantidadeProdutoPorCor(String cor) {
		Query q = manager.createQuery(
				"select p from Produto p where p.cor=:n"
			);
		q.setParameter("n", cor);
		List<Produto> resultado = q.getResultList();
		int total = 0;
		if (resultado.size()>0) {
			for (Produto r: resultado) {
				total = total + r.getEstoque();
			}
		}	
		return total;
	}
	
	public List<Produto> consultarProdutosSemEstoque(){
		try {
			Query q = manager.createQuery(
					"select p from Produto p where p.estoque > :n"
				);
			q.setParameter("n", 0);
			List<Produto> resultado = q.getResultList();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
}
