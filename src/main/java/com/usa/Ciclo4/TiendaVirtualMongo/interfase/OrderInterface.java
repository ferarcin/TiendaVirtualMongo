package com.usa.Ciclo4.TiendaVirtualMongo.interfase;

import com.usa.Ciclo4.TiendaVirtualMongo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderInterface extends MongoRepository<Order, Integer> {
    //Busca y retorna la o las ordenes de peedido que sean de la zona requerida
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(String zone);

    //Busca la Orden con el ID Maximo para crear una nueva (db.orders.find().limit(1).sort({natural:-1})
    Optional<Order> findTopByOrderByIdDesc();
}
