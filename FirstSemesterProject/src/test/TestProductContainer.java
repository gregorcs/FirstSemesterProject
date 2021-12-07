package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controller.ProductController;
import model.ProductFolder.ProductContainer;
import model.ProductFolder.ProductForSale;
import tui.ProductTui;

class TestProductContainer {

	int testSize = 10;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testProductController() {
	}

	@Test
	void testCreateObj() {
		for (int i = 0; i < testSize; i++) {
			ProductContainer.getInstance().create(new ProductForSale(getRandInt(), "yo", null, getRandInt(), true, getRandInt(), getRandInt()));
		}
		ProductTui pTui = new ProductTui();
		pTui.printAllProductsForSale();
		assertEquals(testSize, ProductContainer.getInstance().arraySize());
	}

	@Test
	void testUpdateProduct() {
	}

	@Test
	void testDeleteProduct() {
	}

	@Test
	void testPrintProductForSale() {
	}

	//create random inputs
	private int getRandInt() {
		return (int) (Math.random() * (testSize - 1 + 1) + 1);
	}

	
	
}
