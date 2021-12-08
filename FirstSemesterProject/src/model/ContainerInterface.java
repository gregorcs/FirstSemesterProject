package model;

public interface ContainerInterface<T> {
	
	public T searchForObj(int ID);
	
	public void create(T obj);
	public void delete(T obj);
	public void update(T obj);
	public int getID(T obj);
}