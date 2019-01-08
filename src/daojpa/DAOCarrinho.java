package daojpa;

import java.util.List;

import com.db4o.query.Query;

import modelo.Carrinho;
import modelo.Cliente;
import modelo.ItemProduto;
import modelo.Produto;

public class DAOCarrinho extends DAO<Carrinho> {
	public List<Carrinho> consultarCarrinhosComItem(Produto produto){
		Query q  =  manager.query();
		q.constrain(Carrinho.class);
		q.descend("itens").constrain(produto);
		List<Carrinho> resultado = q.execute();
		return resultado;
	}
	public ItemProduto consultarItemNoCarrinho(Produto produto) {
		Query q  =  manager.query();
		q.constrain(Carrinho.class);
		q.constrain(ItemProduto.class);
		q.descend("produto").constrain(produto);
		List<ItemProduto> resultado = q.execute();
		if(resultado.size()>0)
			return resultado.get(0);
		return null;
	}
	
	public Carrinho consultarCarrinhoCliente(Cliente cliente){
		String cpf = cliente.getCpf();
		Query q = manager.query();
		q.constrain(Carrinho.class);
		q.descend("cliente").descend("cpf").constrain(cpf);
		List<Carrinho> resultado = q.execute();
		if(resultado.size()>0)
			return resultado.get(0);
		return null;
	}
}
