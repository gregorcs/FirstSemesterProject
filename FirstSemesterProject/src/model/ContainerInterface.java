package model;

public interface ContainerInterface<T> {
	
	//Search
	public T searchForObj();
	// CRUD methods
	public void create();
	public T read(int id);
	public T select();
	public void delete(int id);
	public void getArray();
	public void update();
	public int getID();
	
}