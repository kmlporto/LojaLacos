package dao;

import com.db4o.query.Query;
import java.util.List;

import modelo.Produto;


public class DAOProduto extends DAO<Produto>{
	
	public List<Produto> consultarProdutosPorDescricao(String descricao) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("descricao").constrain(descricao);
		List<Produto> resultado = q.execute();
		if (resultado.size()>0)
			return resultado;
		else 
			return null;
	}
	
	public Produto consultarProdutoDMCL(String descricao,String modelo,  String cor, double largura) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("descricao").constrain(descricao);
		q.descend("modelo").constrain(modelo);
		q.descend("cor").constrain(cor);
		q.descend("largura").constrain(largura);
		List<Produto> resultado = q.execute();
		if(resultado.size()==0)
			return null;
		else
			return resultado.get(0);
	}
	
	public List<Produto> consultarProdutosPorTipo(String tipo){
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("tipo").constrain(tipo);
		List<Produto> resultado = q.execute();
		if (resultado.size()>0)
			return resultado;
		else 
			return null;
	}
	
	public int consultarQuantidadeProdutoPorTipo(String tipo) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("tipo").constrain(tipo);
		List<Produto> resultado = q.execute();
		int total = 0;
		if (resultado.size()>0) {
			for (Produto r: resultado) {
				total = total + r.getEstoque();
			}
		}	
		return total;
	}
	
	public List<Produto> consultarProdutosPorCor(String cor){
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("cor").constrain(cor);
		List<Produto> resultado = q.execute();
		if (resultado.size()>0)
			return resultado;
		else 
			return null;
	}
	
	public int consultarQuantidadeProdutoPorCor(String cor) {
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("cor").constrain(cor);
		List<Produto> resultado = q.execute();
		int total = 0;
		if (resultado.size()>0) {
			for (Produto r: resultado) {
				total = total + r.getEstoque();
			}
		}	
		return total;
	}
	
	public List<Produto> consultarProdutosSemEstoque(){
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("estoque").constrain(1).smaller();
		List<Produto> resultado = q.execute();
		if (resultado.size()>0)
			return resultado;
		else 
			return null;
	}
	
}
