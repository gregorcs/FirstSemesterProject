package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;
import tui.ProductTui;

class TestProductContainer {

	int testSize = 10;

	//ProductForSale testProduct = new ProductForSale(getRandInt(), "yo", null, getRandInt(), true, getRandInt(), getRandInt());
	ProductForSale prodForSale = new ProductForSale(5, "hammer", null, 2, true, 4, 5);

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testProductController() {
	}

	@Test
	void testCreateObj() {
		for (int i = 0; i <= 5; i++) {
			ProductContainer.getInstance().create(prodForSale);
		}
		ProductTui pTui = new ProductTui();
		pTui.printAllProductsForSale();
		System.out.println("++++++++++++++++++++++++++++");
		int databaseSize = ProductContainer.getInstance().arraySize() - 1;
		assertEquals(5, databaseSize);
	}

	@Test
	void testUpdateProduct() {
	}

	@Test
	void testDeleteProduct() {

			ProductContainer.getInstance().delete(prodForSale);
		
		int databaseSize = ProductContainer.getInstance().arraySize() - 1;
		ProductTui pTui = new ProductTui();
		pTui.printAllProductsForSale();
		assertEquals(4, databaseSize);
	}

	@Test
	void testPrintProductForSale() {
	}
}
