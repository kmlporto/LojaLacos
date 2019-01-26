package daodb4o;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;
import com.db4o.query.Query;

import modelo.Carrinho;
import modelo.Cliente;
import modelo.ItemProduto;
import modelo.Pagamento;
import modelo.Produto;

public abstract class DAO<L> implements DAOInterface<L> {
	
	protected static ObjectContainer manager;
	
	public static void open() {
		if (manager == null) {
			abrirBancoLocal();
			//abrirBancoServidor();
		}
	}
	
	public static void abrirBancoLocal() {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().messageLevel(0);
		
		config.common().objectClass(Cliente.class).cascadeOnActivate(true);
		config.common().objectClass(Cliente.class).cascadeOnUpdate(true);
		config.common().objectClass(Cliente.class).cascadeOnDelete(false);

		config.common().objectClass(Carrinho.class).cascadeOnActivate(true);
		config.common().objectClass(Carrinho.class).cascadeOnUpdate(true);
		config.common().objectClass(Carrinho.class).cascadeOnDelete(false);

		config.common().objectClass(ItemProduto.class).cascadeOnActivate(true);
		config.common().objectClass(ItemProduto.class).cascadeOnUpdate(true);
		config.common().objectClass(ItemProduto.class).cascadeOnDelete(false);

		config.common().objectClass(Pagamento.class).cascadeOnActivate(true);
		config.common().objectClass(Pagamento.class).cascadeOnUpdate(true);
		config.common().objectClass(Pagamento.class).cascadeOnDelete(false);

		config.common().objectClass(Produto.class).cascadeOnActivate(true);
		config.common().objectClass(Produto.class).cascadeOnUpdate(true);
		config.common().objectClass(Produto.class).cascadeOnDelete(true);
		
		// indexacao
		config.common().objectClass(Cliente.class).objectField("nome").indexed(true);
		config.common().objectClass(Cliente.class).objectField("cpf").indexed(true);
		config.common().objectClass(Produto.class).objectField("codigo").indexed(true);
		config.common().objectClass(Produto.class).objectField("descricao").indexed(true);
		
		manager = Db4oEmbedded.openFile(config, "banco.db4o");
		IDControl.registrarManager(manager);
	}
	public static void abrirBancoServidor() {
		ClientConfiguration config = Db4oClientServer.newClientConfiguration( );
		config.common().messageLevel(0);
		
		config.common().objectClass(Cliente.class).cascadeOnActivate(true);
		config.common().objectClass(Cliente.class).cascadeOnUpdate(true);
		config.common().objectClass(Cliente.class).cascadeOnDelete(false);

		config.common().objectClass(Carrinho.class).cascadeOnActivate(true);
		config.common().objectClass(Carrinho.class).cascadeOnUpdate(true);
		config.common().objectClass(Carrinho.class).cascadeOnDelete(false);

		config.common().objectClass(ItemProduto.class).cascadeOnActivate(true);
		config.common().objectClass(ItemProduto.class).cascadeOnUpdate(true);
		config.common().objectClass(ItemProduto.class).cascadeOnDelete(false);

		config.common().objectClass(Pagamento.class).cascadeOnActivate(true);
		config.common().objectClass(Pagamento.class).cascadeOnUpdate(true);
		config.common().objectClass(Pagamento.class).cascadeOnDelete(false);

		config.common().objectClass(Produto.class).cascadeOnActivate(true);
		config.common().objectClass(Produto.class).cascadeOnUpdate(true);
		config.common().objectClass(Produto.class).cascadeOnDelete(false);
		
		// indexacao
		config.common().objectClass(Cliente.class).objectField("nome").indexed(true);
		config.common().objectClass(Cliente.class).objectField("cpf").indexed(true);
		config.common().objectClass(Produto.class).objectField("codigo").indexed(true);
		config.common().objectClass(Produto.class).objectField("descricao").indexed(true);
		
		manager = Db4oClientServer.openClient(config, "10.0.4.158", 34000,"usuario1","senha1");
		IDControl.registrarManager(manager);
	}
	
	public static void close() {
		if(manager!=null) {
			manager.close();
			manager = null;
		}
	}
	
	//.......................  C.R.U.D.  .......................
	public void create(L obj) {
		manager.store(obj);
	}
	
	@SuppressWarnings("unchecked")
	public List<L> readAll(){
		Class<L> type = (Class<L>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		return (List<L>) q.execute();
	}
	
	public L update(L obj) {
		manager.store(obj);
		return obj;
	}
	
	public void delete(L obj) {
		manager.delete(obj);
	}
	
	public void refresh(L obj) {
		manager.ext().refresh(obj, Integer.MAX_VALUE);
	}

	
	//..........................  transacao  ........................
	public static void begin() {}
	
	public static void commit() {
		manager.commit();
	}
	
	public static void rollback(){
		manager.rollback();
	}
	
}
