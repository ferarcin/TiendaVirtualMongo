package com.usa.Ciclo4.TiendaVirtualMongo.service;

import com.usa.Ciclo4.TiendaVirtualMongo.model.Order;
import com.usa.Ciclo4.TiendaVirtualMongo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll(){

        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id){

        return orderRepository.getOrder(id);
    }

    public Order createOrder(Order order){
        //Buscamos el valor mas alto de la columna ID
        Optional<Order> orderIdMax = orderRepository.lastOrderId();

        //Si el ID de la orden entregada es NULL se coloca el orderIdMax + 1
        //si la tabla está vacia agrega el valor 1 al ID
        if(order.getId() == null){
            if(orderIdMax.isEmpty()){
                order.setId(1);
            }else{
                order.setId(orderIdMax.get().getId() + 1);
            }
        }

        Optional<Order> oAux = orderRepository.getOrder(order.getId());
        if(oAux.isEmpty()){
            return orderRepository.create(order);
        }else{
            return order;
        }
    }

    public Order updateOrder(Order order){
        //se comprueba  que se envie el ID de la orden
        if(order.getId() != null){
            Optional<Order> oAux = orderRepository.getOrder(order.getId());
            if(!oAux.isEmpty()){
                if(order.getStatus() != null){
                    oAux.get().setStatus(order.getStatus());
                }
                orderRepository.update(oAux.get());
                return oAux.get();
            }else{
                return order;
            }
        }else{
            return order;
        }
    }

    public boolean deleteOrder(int id){
        Boolean oAux = getOrder(id).map(order ->{
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return oAux;
    }

    public List<Order> findOrderByZone(String zone){

        return orderRepository.findOrderByZone(zone);
    }
}
