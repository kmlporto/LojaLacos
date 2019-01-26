package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.ItemProduto;
import modelo.Produto;

public class DAOItemProduto extends DAO<ItemProduto>{
	
	public List<ItemProduto> consultarItemComProduto(Produto produto) {
		Query q = manager.query();
		q.constrain(ItemProduto.class);
		q.descend("produto").constrain(produto);
		List<ItemProduto> resultado = q.execute();
		return resultado;
	}
}
