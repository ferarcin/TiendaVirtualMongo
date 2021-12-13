package com.usa.Ciclo4.TiendaVirtualMongo.interfase;

import com.usa.Ciclo4.TiendaVirtualMongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductInterface extends MongoRepository<Product, String> {

}
