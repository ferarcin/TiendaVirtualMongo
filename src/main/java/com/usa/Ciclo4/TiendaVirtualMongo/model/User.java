package com.usa.Ciclo4.TiendaVirtualMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer id;
    private String identification;
    private String name;
    private String address;
    private String cellPhone;

    @NonNull
    private String email;

    @NonNull
    private String password;
    private String zone;
    private String type;
}
