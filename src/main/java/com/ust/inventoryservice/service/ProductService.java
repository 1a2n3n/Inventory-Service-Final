package com.ust.inventoryservice.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ust.inventoryservice.exception.ProductAlreadyExistsException;
import com.ust.inventoryservice.exception.ProductNotFoundException;
import com.ust.inventoryservice.model.Product;

@Service
@SuppressWarnings("unused")
public interface ProductService {

	boolean addProduct(Product product) throws ProductAlreadyExistsException;

	Product updateProduct(String code, Product product) throws ProductNotFoundException;

	boolean deleteProduct(String code) throws ProductNotFoundException;

	Product getproductbycode(String code) throws ProductNotFoundException;

	public List<Product> getAllProducts();
}
