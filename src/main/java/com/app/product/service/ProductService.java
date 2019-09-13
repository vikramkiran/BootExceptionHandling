package com.app.product.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.product.entity.Product;

@Service
public class ProductService {

	private static List<Product> list = new ArrayList<>();

	static {

		list.add(new Product(1, "Phone", 10000));
		list.add(new Product(2, "Phone2", 20000));
		list.add(new Product(3, "Phone3", 30000));

	}

	public List<Product> getAllProducts() {
		return list;

	}

	public Product create(Product product) {

		list.add(product);
		return product;
	}

	public Product getOneProduct(int id) {

		for (Product product : list) {

			if (product.getProdId() == id) {

				return product;

			}
		}

		return null;
	}

	public Product deleteOneProduct(int id) {

		Iterator<Product> iterator = list.iterator();

		while (iterator.hasNext()) {
			Product product = iterator.next();

			if (product.getProdId() == id) {
				iterator.remove();

			}
		}

		return null;
	}

}
