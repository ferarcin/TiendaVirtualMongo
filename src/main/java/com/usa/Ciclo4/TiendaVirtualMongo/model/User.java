package com.usa.Ciclo4.TiendaVirtualMongo.model;

import com.usa.Ciclo4.TiendaVirtualMongo.Enum.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

//Clase modificada en Dic 12/2021
//Ferney Alexander Arciniegas Molina

@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer id;
    private String identification;
    @NonNull
    private String name;
    private Date birthtDay;
    private String monthBirthtDay;
    private String address;
    private String cellPhone;

    @NonNull
    private String email;

    @NonNull
    private String password;
    private String zone;
    private UserTypeEnum type;
}