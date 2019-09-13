package com.app.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.entity.Product;
import com.app.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Product> allProducts() {

		return productService.getAllProducts();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public List<Product> createProduct(@RequestBody Product product) {

		productService.create(product);

		return productService.getAllProducts();
	}

	@RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
	public Resource<Product> getOne(@PathVariable int id) {

		Product product = productService.getOneProduct(id);

		if (product == null) {

			throw new NoProductFoundException("no product");
		}

		Resource<Product> resource = new Resource<Product>(product);

		ControllerLinkBuilder builder = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).allProducts());

		resource.add(builder.withRel("for All Products Cilck Here"));

		return resource;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Product deleteOne(@PathVariable int id) {

		return productService.deleteOneProduct(id);
	}

}
