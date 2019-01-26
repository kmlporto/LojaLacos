package daojpa;

import java.util.List;

import javax.persistence.Query;

import modelo.Admin;

public class DAOAdmin extends DAO<Admin>{
	public Admin consultarAdminPorNome(String nome) {
		Query q = manager.createQuery(
				"select a from Admin a where a.nome=:n"
			);
		q.setParameter("n", nome);
		List<Admin> resultado = q.getResultList();
		if (resultado.size()>0)
			return (Admin) resultado.get(0);
		else 
			return null;	
	}
}
