package controller;

public interface InterfaceController<T> {
	public void createObj();
	public T getObj();
	public void updateObj();
	public void deleteObj();
}
