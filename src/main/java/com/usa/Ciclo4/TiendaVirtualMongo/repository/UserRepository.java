package com.usa.Ciclo4.TiendaVirtualMongo.repository;

import com.usa.Ciclo4.TiendaVirtualMongo.interfase.ProductInterfase;
import com.usa.Ciclo4.TiendaVirtualMongo.interfase.UserInterfase;
import com.usa.Ciclo4.TiendaVirtualMongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserInterfase userInterfase;

    public List<User> getAll(){

        return (List<User>) userInterfase.findAll();
    }

    public Optional<User> getUser(int id){

        return userInterfase.findById(id);
    }

    public User create(User user){

        return userInterfase.save(user);
    }

    public void update(User user){
        userInterfase.save(user);
    }

    public void delete(User user){
        userInterfase.delete(user);
    }


    public boolean existeEmail(String email) {
        Optional<User> usuario = userInterfase.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password){
        return userInterfase.findByEmailAndPassword(email, password);
    }
}
