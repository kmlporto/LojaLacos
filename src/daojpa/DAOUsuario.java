package daojpa;
import java.util.List;

import javax.persistence.Query;

import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario> {
	public Usuario verificaUsuario (String user, String password) {
		Query q = manager.createQuery(
				"select u from Usuario u where u.user=:n "
				+ "AND u.password=:password"
			);
		q.setParameter("n", user);
		q.setParameter("password", password);
		Usuario resultado = (Usuario)q.getSingleResult();
		return resultado;
	}
	
	public Usuario readByCpf (String cpf) {
		Query q = manager.createQuery(
				"select u from Usuario u where u.cpf = :n "
			);
		q.setParameter("n", cpf);
		Usuario resultado = (Usuario)q.getSingleResult();
		return resultado;
	}
	
}