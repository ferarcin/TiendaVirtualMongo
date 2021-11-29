package com.usa.Ciclo4.TiendaVirtualMongo.repository;

import com.usa.Ciclo4.TiendaVirtualMongo.interfase.ProductInterfase;
import com.usa.Ciclo4.TiendaVirtualMongo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    @Autowired
    private ProductInterfase productInterfase;

    public List<Product> getAll(){

        return productInterfase.findAll();
    }

    public Optional<Product> getProduct(String reference){
        return productInterfase.findById(reference);
    }

    public Product create(Product producto){

        return productInterfase.save(producto);
    }

    public void update(Product producto){

        productInterfase.save(producto);
    }

    public void delete(Product producto){

        productInterfase.delete(producto);
    }
}
