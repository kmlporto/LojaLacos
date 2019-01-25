package daojpa;
import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario> {
//	public Usuario verificaUsuario (String user, byte [] password) {
//		Query q = manager.createQuery(
//				"select u from Usuario u where u.user like :user "
//				+ "AND u.password = :password"
//			);
//		q.setParameter("user", user);
//		q.setParameter("password", password);
//		List<Usuario> resultado = q.getResultList();
//		if (resultado.size()>0)
//			return (Usuario) resultado.get(0);
//		else 
//			return null;
////		Query q = manager.query();	
////		q.constrain((Evaluation) candidate -> {
////			// TODO Auto-generated method stub
////			Usuario u = (Usuario) candidate.getObject();
////			for (int j = 0; j < password.length; j++)
////				if (password[j] == u.getPassword()[j])
////					continue;
////				else {
////					candidate.include(false);
////					return;
////				}						
////			candidate.include(true);
////		});
////
////		List<Usuario> usuarios = q.execute();
////		if (usuarios.size() > 0)
////			return usuarios.get(0);
////		return null;
//	}
//	
//	public Usuario readByCpf (String cpf) {
//		Query q = manager.query();
//		q.constrain(Usuario.class);
//		q.descend("cpf").constrain(cpf);
//		List<Usuario> usuarios = q.execute();
//		if (usuarios.size() > 0)
//			return usuarios.get(0);
//		return null;
//	}
//	
}