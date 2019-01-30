package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Pagamento;

public class DAOPagamento extends DAO<Pagamento> {
	public List<Pagamento> consultarPagamentoPorTipo(String tipo) {
		try {
			Query q = manager.createQuery(
					"select p from Pagamento p where p.nome=:n"
				);
			q.setParameter("n", tipo);
			List<Pagamento> resultado = q.getResultList();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
}
