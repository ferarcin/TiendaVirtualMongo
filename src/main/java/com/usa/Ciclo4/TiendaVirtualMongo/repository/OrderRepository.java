package com.usa.Ciclo4.TiendaVirtualMongo.repository;

import com.usa.Ciclo4.TiendaVirtualMongo.interfase.OrderInterface;
import com.usa.Ciclo4.TiendaVirtualMongo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderInterface orderInterface;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    public List<Order> findOrderBySalesMan(Integer idSalesMan){

        return orderInterface.findBySalesMan(idSalesMan);
    }

    public List<Order> findByStatusAndSalesMan(String status, Integer idSalesMan){
        /*return orderInterface.findByStatusAndSalesMan(status, idSalesMan);*/
        Query query = new Query();
        Criteria criteria  = Criteria.where("salesMan.id").is(idSalesMan) .and("status").is(status);
        query.addCriteria(criteria);

        List<Order> orders  = mongoTemplate.find(query, Order.class);
        return orders;

    }

    public List<Order> findByRegisterDayAndSalesMan(String registerDay, Integer idSalesMan){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria criteria  = Criteria.where("registerDay")
                .gt(LocalDate.parse(registerDay,dateTimeFormatter).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(registerDay,dateTimeFormatter).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(idSalesMan);
        query.addCriteria(criteria);

        List<Order> orders  = mongoTemplate.find(query, Order.class);
        return orders;
    }
}
