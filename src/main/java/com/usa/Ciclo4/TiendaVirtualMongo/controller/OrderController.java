package com.usa.Ciclo4.TiendaVirtualMongo.controller;

import com.usa.Ciclo4.TiendaVirtualMongo.model.Order;
import com.usa.Ciclo4.TiendaVirtualMongo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/* Controlador para el documento Order
Base de datos en MongoDB - Documento order
Author  : Ferney Alexander Arciniegas Molina
Date    : Dic 12/2021
Revision 3
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll(){

        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id){

        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order){

        return orderService.createOrder(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order updateOrder(@RequestBody Order order){

        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteOrder(@PathVariable("id") int id){

        return orderService.deleteOrder(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> findOrderByZone(@PathVariable("zone") String zone){

        return orderService.findOrderByZone(zone);
    }
}