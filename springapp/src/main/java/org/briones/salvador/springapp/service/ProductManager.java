package org.briones.salvador.springapp.service;

import java.io.Serializable;
import java.util.List;

import org.briones.salvador.springapp.domain.Product;

public interface ProductManager extends Serializable {

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();

}