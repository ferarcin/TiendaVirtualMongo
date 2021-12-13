package com.usa.Ciclo4.TiendaVirtualMongo.interfase;

import com.usa.Ciclo4.TiendaVirtualMongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInterface extends MongoRepository<User, Integer> {
    //Se busca el usuario por Email para crear o ingresar
    Optional<User> findByEmail(String email);
    //Se busca el usuario por Email y Password para autenticacion
    Optional<User> findByEmailAndPassword(String email, String password);
    //Se busca el usuario con el ID más grande para crear uno nuevo (db.usuarios.find().limit(1).sort({natural:-1})
    Optional<User> findTopByOrderByIdDesc();
}
