package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario> {
	public Usuario verificaUsuario (String username, String password) {
		try {
			Query q = manager.createQuery(
					"select u from Usuario u where u.username=:n "
					+ "AND u.password=:password"
				);
			q.setParameter("n", username);
			q.setParameter("password", password);
			Usuario resultado = (Usuario)q.getSingleResult();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public Usuario readByCpf (String cpf) {
		try {
			Query q = manager.createQuery(
					"select u from Usuario u where u.cpf = :n "
				);
			q.setParameter("n", cpf);
			Usuario resultado = (Usuario)q.getSingleResult();
			return resultado;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
}