package org.briones.salvador.springapp.repository;

import java.util.List;

import static org.junit.Assert.*;

import org.briones.salvador.springapp.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JPAProductDAOTests {
	 private ApplicationContext context;
	 private ProductDAO productDao;
	 
	 @Before
	 public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		productDao = (ProductDAO) context.getBean("productDao");
	 }

    @Test
    public void testGetProductList() {
        List<Product> products = productDao.getProductList();
        assertEquals(products.size(), 3, 0);	   
    }

	    @Test
	    public void testSaveProduct() {
	        List<Product> products = productDao.getProductList();

	        Product p = products.get(0);
	        Double price = p.getPrice();
	        p.setPrice(200.12);
	        productDao.saveProduct(p);

	        List<Product> updatedProducts = productDao.getProductList();
	        Product p2 = updatedProducts.get(0);
	        assertEquals(p2.getPrice(), 200.12, 0);

	        p2.setPrice(price);
	        productDao.saveProduct(p2);
	    }
}
