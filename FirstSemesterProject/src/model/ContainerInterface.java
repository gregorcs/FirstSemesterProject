package model;

public interface ContainerInterface<T> {
	
	//Search
	public T searchForObj(int ID);
	// CRUD methods
	//create could be add instead, since the controller should create the objects
	public void create(T obj);
	public T read(int ID);
	public void delete(T obj);
	public void update(T obj);
	public int getID(T obj);
	
}