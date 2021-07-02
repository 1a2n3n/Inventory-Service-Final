package com.ust.inventoryservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ust.inventoryservice.exception.ProductNotFoundException;
import com.ust.inventoryservice.model.Product;
import com.ust.inventoryservice.service.ProductService;

@RestController

public class ProductController {

	@Autowired
	ProductService service;

	@Autowired
	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Product product) {
		try {
			service.addProduct(product) ;
			return new ResponseEntity<String>("Created", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<?> update(@PathVariable() String id, @RequestBody Product product) {
		try {
			return new ResponseEntity<Product>(service.updateProduct(id, product), HttpStatus.OK);
		} catch (ProductNotFoundException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> delete(@PathVariable() String id) {
		try {
			service.deleteProduct(id);
			return new ResponseEntity<String>("Successfully Deleted Product with id: " + id, HttpStatus.OK);
		} catch (ProductNotFoundException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<?> getproductbycode(@PathVariable() String id) {
		try {
			return new ResponseEntity<Product>(service.getproductbycode(id), HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/product/Allproducts")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> products = service.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}

}