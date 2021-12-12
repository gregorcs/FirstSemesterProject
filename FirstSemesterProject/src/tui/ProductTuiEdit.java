package tui;

import controller.ProductController;

public class ProductTuiEdit {
	
	ProductController prodController;
	
	public ProductTuiEdit() {
	}
	
	public void start() {	
		writeTuiEdit();
		prodController = new ProductController();
		prodController.updateObj();
	}
	
	private void writeTuiEdit() {
		System.out.println("****** Edit Product Details ******");
        System.out.println(" (1) Edit amount");
        System.out.println(" (2) Edit name");
        System.out.println(" (3) Edit location");
        System.out.println(" (4) Edit price");
        System.out.println(" (5) Edit minimum & maximum amount");
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice:");
	}
}
