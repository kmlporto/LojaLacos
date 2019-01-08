package daojpa;

import java.util.List;

import com.db4o.query.Query;

import modelo.Pagamento;

public class DAOPagamento extends DAO<Pagamento> {
	public List<Pagamento> consultarPagamentoPorTipo(String tipo) {
		Query q = manager.query();
		q.constrain(Pagamento.class);
		q.descend("tipo").constrain(tipo);
		List<Pagamento> resultado = q.execute();
		return resultado;
	}
}
