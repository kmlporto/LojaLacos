package daojpa;

import java.util.List;

import javax.persistence.Query;

import modelo.Carrinho;
import modelo.Cliente;
import modelo.ItemProduto;
import modelo.Produto;

public class DAOCarrinho extends DAO<Carrinho> {
	public List<Carrinho> consultarCarrinhosComItem(Produto produto){
		Query q = manager.createQuery(
				"select c "
				+ "from carrinho c JOIN c.itens i JOIN i.produto p"
				+ "where p= :n"
			);
		q.setParameter("n", produto);
		List<Carrinho> resultado = q.getResultList();
		return resultado;
	}
	
	public ItemProduto consultarItemNoCarrinho(Carrinho carrinho, Produto produto) {
		Query q = manager.createQuery(
				"select c "
				+ "from carrinho c JOIN c.itens i JOIN i.produto p"
				+ "where p= :n"
			);
		q.setParameter("n", produto);
		q.setParameter("m", carrinho);
		ItemProduto resultado = (ItemProduto) q.getSingleResult();
		return resultado;
	}
	
	public Carrinho consultarCarrinhoCliente(Cliente cliente){
		Query q = manager.createQuery(
				"select c from carrinho c"
				+ "where c.cliente=:n"
			);
		q.setParameter("n", cliente);
		Carrinho resultado = (Carrinho) q.getSingleResult();
		return resultado;
	}
}
