package com.usa.Ciclo4.TiendaVirtualMongo.repository;

import com.usa.Ciclo4.TiendaVirtualMongo.interfase.ProductInterface;
import com.usa.Ciclo4.TiendaVirtualMongo.model.Order;
import com.usa.Ciclo4.TiendaVirtualMongo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    @Autowired
    private ProductInterface productInterface;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> getAll(){

        return productInterface.findAll();
    }

    public Optional<Product> getProduct(String reference){
        return productInterface.findById(reference);
    }

    public Product create(Product producto){

        return productInterface.save(producto);
    }

    public void update(Product producto){

        productInterface.save(producto);
    }

    public void delete(Product producto){

        productInterface.delete(producto);
    }

    public Optional<Product> findProductByPriceIsLessThanEqual(Integer price){

        return productInterface.findProductByPriceIsLessThanEqual(price);
    }

    public List<Product> findProductByDescription(String description){
        return productInterface.findProductByDescriptionLike(description);

        /*Query query = new Query();
        Criteria criteria  = Criteria.where("desciption").regex('^');
        query.addCriteria(criteria);

        List<Product> products  = mongoTemplate.find(query, Product.class);
        return products;*/
    }
}
