package daodb4o;

import java.util.List;
import com.db4o.query.Query;

import modelo.Admin;

public class DAOAdmin extends DAO<Admin>{
	public Admin consultarAdminPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Admin.class);
		q.descend("nome").constrain(nome);
		List<Admin> resultado = q.execute();
		if (resultado.size()>0)
			return (Admin) resultado.get(0);
		else 
			return null;
	}
}
