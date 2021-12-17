package com.usa.Ciclo4.TiendaVirtualMongo.interfase;

import com.usa.Ciclo4.TiendaVirtualMongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductInterface extends MongoRepository<Product, String> {
    //Se usa para buscar el  produto por precio de venta.
    Optional<Product> findProductByPriceGreaterThanEqual(Integer price);

    /*@Query(value= "{'description': ?0}")*/
    List<Product> findProductByDescriptionLike(String description);
}
