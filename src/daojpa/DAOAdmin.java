package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Admin;

public class DAOAdmin extends DAO<Admin>{
	public Admin consultarAdminPorNome(String nome) {
		try {
			Query q = manager.createQuery(
					"select a from Admin a where a.nome=:n"
				);
			q.setParameter("n", nome);
			Admin resultado = (Admin) q.getSingleResult();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
		
	}
}
