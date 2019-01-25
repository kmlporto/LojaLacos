package daojpa;

import java.util.List;

import javax.persistence.Query;

import modelo.Pagamento;

public class DAOPagamento extends DAO<Pagamento> {
	public List<Pagamento> consultarPagamentoPorTipo(String tipo) {
		Query q = manager.createQuery(
				"select p from Pagamento p where p.nome like :n"
			);
		q.setParameter("n", tipo);
		List<Pagamento> resultado = q.getResultList();
		if (resultado.size()>0) {
			return resultado;
		}else { 
			return null;
		}
	}
	
}
