package daojpa;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import javax.persistence.Query;


public abstract class DAO<L> implements DAOInterface<L> {
	protected static EntityManager manager;
	protected static EntityManagerFactory factory;
	public DAO(){}
	
	public static void open() {
		if (manager == null) {
			HashMap<String,String> properties = new HashMap<String,String>();		
			factory = Persistence.createEntityManagerFactory("loja-eclipselink", properties);
			manager = factory.createEntityManager();
		}
	}
		
	public static void close() {
		if(manager!=null) {
			manager.close();
			factory.close();
		}
	}
	
	//.......................  C.R.U.D.  .......................
	public void create(L obj) {
		manager.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public L read(Object chave){	// localizar pela chave primaria
		Class<L> type = (Class<L>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return manager.find(type, chave);
	}
	
	@SuppressWarnings("unchecked")
	public List<L> readAll(){
		Class<L> type = (Class<L>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
		return (List<L>) query.getResultList();
	}
	
	public L update(L obj) {
		return manager.merge(obj);
	}
	
	public void delete(L obj) {
		manager.remove(obj);
	}

	
	//..........................  transacao  ........................
	public static void begin() {
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}
	
	public static void commit() {
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear();		// ---- esvaziar o cache de objetos
		}
	}
	
	public static void rollback(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}
	
}
