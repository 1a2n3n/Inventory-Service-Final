package com.ust.inventoryservice.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.inventoryservice.exception.ProductAlreadyExistsException;
import com.ust.inventoryservice.exception.ProductNotFoundException;
import com.ust.inventoryservice.model.Product;
import com.ust.inventoryservice.repository.ProductRepository;

@SuppressWarnings("unused")
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository repo;

	@Override
	public boolean addProduct(Product product) throws ProductAlreadyExistsException {
		try {
			Product p = repo.findByCode(product.getCode());
			if (p == null) {
				repo.save(product);
				return true;
			}
			throw new ProductAlreadyExistsException("Product Already Exists");
		} catch (ProductAlreadyExistsException e) {
			throw new ProductAlreadyExistsException("Product Already Exists");
		}
	}

	@Override
	public Product updateProduct(String code, Product product) throws ProductNotFoundException {
		try {
			product.setCode(code);
			return repo.save(product);
		} catch (NoSuchElementException e) {
			throw new ProductNotFoundException("product not found");
		}
	}

	@Override
	public boolean deleteProduct(String code) throws ProductNotFoundException {
		try {
			Product fecthedProduct = repo.findById(code).get();
			if (fecthedProduct != null) {
				repo.delete(fecthedProduct);
			}
		} catch (NoSuchElementException exception) {
			throw new ProductNotFoundException("product does not exists");
		}
		return true;
	}

	@Override
	public Product getproductbycode(String code) throws ProductNotFoundException {
		try {
			return repo.findById(code).get();
		} catch (NoSuchElementException e) {
			throw new ProductNotFoundException("product not found");
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
}