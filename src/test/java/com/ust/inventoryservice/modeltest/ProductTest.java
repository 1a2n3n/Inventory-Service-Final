package com.ust.inventoryservice.modeltest;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import com.ust.inventoryservice.model.Product;

public class ProductTest {
	Product product = new Product();

	@Test
	public void ProductTest() {
		new BeanTester().testBean(Product.class);
	}
}
