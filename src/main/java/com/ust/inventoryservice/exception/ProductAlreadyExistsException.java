package com.ust.inventoryservice.exception;

@SuppressWarnings("serial")
public class ProductAlreadyExistsException extends Exception {
	public ProductAlreadyExistsException(String message) {
		super(message);
	}
}
