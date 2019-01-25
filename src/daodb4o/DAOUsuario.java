package daodb4o;
import java.util.List;

import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario> {
	public Usuario verificaUsuario (String user, String password) {
		Query q = manager.query();	
		q.constrain((Evaluation) candidate -> {
			// TODO Auto-generated method stub
			Usuario u = (Usuario) candidate.getObject();
			if (!password.equals(u.getPassword()))
				candidate.include(true);
			else {
				candidate.include(false);
			}						
			return;
		});

		List<Usuario> usuarios = q.execute();
		if (usuarios.size() > 0)
			return usuarios.get(0);
		return null;
	}
	
	public Usuario readByCpf (String cpf) {
		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("cpf").constrain(cpf);
		List<Usuario> usuarios = q.execute();
		if (usuarios.size() > 0)
			return usuarios.get(0);
		return null;
	}
	
}