package ru.boostbrain.ejb;

import ru.boostbrain.domain.Product;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ProductManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;
    public Product createProduct(String name, int quantity){
        Product product = new Product();
        product.setName(name);
        product.setQuantity(quantity);
        entityManager.persist(product);
        return product;
    }

    public List<Product> getProducts(){
        TypedQuery<Product> query = entityManager.createQuery("SELECT c FROM Product c",Product.class);
        return query.getResultList();
    }
}
