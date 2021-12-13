package com.usa.Ciclo4.TiendaVirtualMongo.repository;

import com.usa.Ciclo4.TiendaVirtualMongo.interfase.OrderInterface;
import com.usa.Ciclo4.TiendaVirtualMongo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderInterface orderInterface;

    public List<Order> getAll(){

        return (List<Order>) orderInterface.findAll();
    }

    public Optional<Order> getOrder(int id){

        return orderInterface.findById(id);
    }

    public Order create(Order order){

        return orderInterface.save(order);
    }

    public void update(Order order){

        orderInterface.save(order);
    }

    public void delete(Order order){

        orderInterface.delete(order);
    }

    public Optional<Order>  lastOrderId(){

        return orderInterface.findTopByOrderByIdDesc();
    }

    public List<Order> findOrderByZone(String zone){

        return orderInterface.findByZone(zone);
    }
}
