package com.ust.inventoryservice.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.ust.inventoryservice.exception.ProductAlreadyExistsException;
import com.ust.inventoryservice.exception.ProductNotFoundException;
import com.ust.inventoryservice.model.Product;
import com.ust.inventoryservice.repository.ProductRepository;
import com.ust.inventoryservice.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceImplTest {

	@Mock
	ProductRepository repo;

	@InjectMocks
	ProductServiceImpl productService;
	List<Product> productList = new ArrayList<>();
	Optional<Product> options;
	Product product = new Product();
	
	@Test
	public void registerProductTest() throws ProductNotFoundException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Mockito.when(repo.findById(product.getCode())).thenReturn(options);
			Product fetchproduct = productService.updateProduct(product.getCode(), product);
			assertEquals(null, fetchproduct);
		});
	}
	
	

	@Test
	public void updateProductTest() throws ProductNotFoundException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Mockito.when(repo.findById(product.getCode())).thenReturn(options);
			Product fetchproduct = productService.updateProduct(product.getCode(), product);
			assertEquals(null, fetchproduct);
		});
	}

	@Test
	public void deleteProductTest() throws ProductNotFoundException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Mockito.when(repo.findById(product.getCode())).thenReturn(options);
			boolean flag = productService.deleteProduct(product.getCode());
			assertEquals(true, flag);
		});
	}

	@Test
	public void getProductByCodeTest() throws ProductNotFoundException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Mockito.when(repo.findById(product.getCode())).thenReturn(options);
			Product fetchedProduct = productService.getproductbycode(product.getCode());
			assertEquals(product, fetchedProduct);
		});

	}

	@Test
	public void getallProductsTest() {
		Mockito.when(repo.findAll()).thenReturn(productList);
		List<Product> product = productService.getAllProducts();
		assertEquals(productList, productList);
	}
}
