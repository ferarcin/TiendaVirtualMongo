package com.usa.Ciclo4.TiendaVirtualMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cleaningproducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @NonNull
    private String reference;
    private String brand;
    private String category;
    private String material;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;
}

