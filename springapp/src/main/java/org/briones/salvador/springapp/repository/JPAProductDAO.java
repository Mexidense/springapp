package org.briones.salvador.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.briones.salvador.springapp.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "ProductDAO")
public class JPAProductDAO implements ProductDAO{

	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Product> getProductList() {
    	return em.createQuery("select p from Product p order by p.id").getResultList();
	}
    
    @Transactional(readOnly = false)
	public void saveProduct(Product prod) {
		em.merge(prod);
	}

}
