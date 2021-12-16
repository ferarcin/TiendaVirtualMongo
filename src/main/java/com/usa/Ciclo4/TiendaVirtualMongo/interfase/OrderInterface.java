package com.usa.Ciclo4.TiendaVirtualMongo.interfase;

import com.usa.Ciclo4.TiendaVirtualMongo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderInterface extends MongoRepository<Order, Integer> {
    //Busca y retorna la o las ordenes de peedido que sean de la zona requerida
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(String zone);

    //Busca la Orden con el ID Maximo para crear una nueva (db.orders.find().limit(1).sort({natural:-1})
    Optional<Order> findTopByOrderByIdDesc();

    //Busca y retorna la orden u ordenes por el codigo del vendedor (salesman)
    @Query("{'salesMan.id': ?0}")
    List<Order> findBySalesMan(Integer id);

    /*//Busca y retorna la orden u ordenes por estado y codigo del vendedor (salesman)
    @Query("{'status': ?0}.and{'salesMan.id': ?1}")
    List<Order> findByStatusAndSalesMan(String status, Integer id);

    //Busca y retorna la orden u ordenes por estado y codigo del vendedor (salesman)
    @Query("{'registerDay':?0, 'salesMan.id': ?1}")
    List<Order> findByRegisterDayAndSalesMan(Date registerDay, Integer id);
*/
}