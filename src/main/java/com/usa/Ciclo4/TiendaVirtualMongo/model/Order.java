package com.usa.Ciclo4.TiendaVirtualMongo.model;

import com.usa.Ciclo4.TiendaVirtualMongo.Enum.OrderStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    //public static String PENDING = "Pendiente";
    //public static String APROVED = "Aprobada";
    //public static String REJECTED = "Rechazada";

    @Id
    @NonNull
    private Integer id;
    private Date registerDay;
    private OrderStatusEnum status;
    private User salesMan;

    private Map<String, Product> products;
    private Map<String, Integer> quantities;
}
