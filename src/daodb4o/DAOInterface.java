package daodb4o;

import java.util.List;

public interface DAOInterface <L> {
	public void create(L object);
	public List<L> readAll();
	public L update(L object);
	public void delete(L object);
}
