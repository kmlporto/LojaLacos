package daojpa;


import java.util.List;

import javax.persistence.Query;

import modelo.Cliente;
import modelo.Produto;


public class DAOProduto extends DAO<Produto>{
	
	public List<Produto> consultarProdutosPorDescricao(String descricao) {
		Query q = manager.createQuery(
			"select p from Produto p where p.descricao like :n;"
		);
		q.setParameter("n", descricao);
		List<Produto> resultado = q.getResultList();
		if (resultado.size()>0)
			return resultado;
		else 
			return null;
	}
	
	public Produto consultarProdutoDMCL(String descricao,String modelo,  String cor, double largura) {
		Query q = manager.createQuery(
				"select p from Produto p where p.descricao like :d AND  "
				+ "p.modelo like :m AND p.cor like :c AND  p.largura= :l"
			);
		q.setParameter("d", descricao);
		q.setParameter("m", modelo);
		q.setParameter("c", cor);
		q.setParameter("l", largura);
		Produto resultado = (Produto) q.getSingleResult();
		return resultado;
	}
	
	public List<Produto> consultarProdutosPorModelo(String modelo) {
		Query q = manager.createQuery(
			"select p from Produto p where p.modelo like :n;"
		);
		q.setParameter("n", modelo);
		List<Produto> resultado = q.getResultList();
		if (resultado.size()>0)
			return resultado;
		else 
			return null;
	}

	public int consultarQuantidadeProdutoPorTipo(String tipo) {
		Query q = manager.createQuery(
			"select p from Produto p where p.tipo like :n;"
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
//	
	public List<Produto> consultarProdutosPorCor(String cor){
		Query q = manager.createQuery(
			"select p from Produto p where p.cor like :n;"
		);
		q.setParameter("n", cor);
		List<Produto> resultado = q.getResultList();
		if (resultado.size()>0)
			return resultado;
		else 
			return null;
	}

	public int consultarQuantidadeProdutoPorCor(String cor) {
		Query q = manager.createQuery(
				"select p from Produto p where p.cor like :n;"
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
	Query q = manager.createQuery(
			"select p from Produto p where p.estoque > :n;"
		);
		q.setParameter("n", 0);
		List<Produto> resultado = q.getResultList();
		if (resultado.size()>0)
			return resultado;
		else 
			return null;
	}
	
}
