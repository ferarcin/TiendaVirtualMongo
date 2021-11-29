package com.usa.Ciclo4.TiendaVirtualMongo.interfase;

import com.usa.Ciclo4.TiendaVirtualMongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInterfase extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
