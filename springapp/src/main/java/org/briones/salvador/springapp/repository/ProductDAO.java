package org.briones.salvador.springapp.repository;

import java.util.List;

import org.briones.salvador.springapp.domain.Product;

public interface ProductDAO {
	public List<Product> getProductList();

    public void saveProduct(Product prod);
}
