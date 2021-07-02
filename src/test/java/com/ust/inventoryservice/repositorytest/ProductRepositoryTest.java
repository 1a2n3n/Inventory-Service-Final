package com.ust.inventoryservice.repositorytest;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ust.inventoryservice.model.Product;
import com.ust.inventoryservice.repository.ProductRepository;

@SpringBootTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	Product product = new Product();

	@Before
	public Product setUp() {
		Product product = new Product();
		product.setCode("pp22");
		product.setName("Kellogs");
		product.setPrice(100);
		product.setQuantity(1);
		product.setQuality("ISI");
		product.setDescription("cereal");
		return product;
	}

	@After
	public void tearDown() throws Exception {
		productRepository.deleteAll();
	}

	@Test
	public void registerProductTest() {
		productRepository.save(setUp());
		Product fetchedproduct = productRepository.findById("pp22").get();
		Assertions.assertEquals("pp22", fetchedproduct.getCode());
	}

	@Test
	public void deleteProductTest() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			productRepository.delete(setUp());
			Product fetchedproduct = productRepository.findById("pp22").get();
		});
	}

	@Test
	public void updateProductTest() {
		productRepository.save(setUp());
		Product fetchedproduct = productRepository.findById("pp22").get();
		Assertions.assertEquals("pp22", fetchedproduct.getCode());
	}

	@Test
	public void getProductbyCodeTest() {
		productRepository.save(setUp());
		Product fetchedproduct = productRepository.findById("pp22").get();
		Assertions.assertEquals("pp22", fetchedproduct.getCode());
	}

	@Test
	public void getAllProductTest() {
		List<Product> product = productRepository.findAll();
		Assertions.assertEquals(6, product.size());
	}
}
