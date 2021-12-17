package com.usa.Ciclo4.TiendaVirtualMongo.repository;

import com.usa.Ciclo4.TiendaVirtualMongo.interfase.UserInterface;
import com.usa.Ciclo4.TiendaVirtualMongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserInterface userInterface;

    public List<User> getAll(){

        return (List<User>) userInterface.findAll();
    }

    public Optional<User> getUser(int id){

        return userInterface.findById(id);
    }

    public User create(User user){

        return userInterface.save(user);
    }

    public void update(User user){
        userInterface.save(user);
    }

    public void delete(User user){
        userInterface.delete(user);
    }


    public boolean findUserEmail(String email) {
        Optional<User> usuario = userInterface.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password){
        return userInterface.findByEmailAndPassword(email, password);

    }

    public Optional<User> lastUserId(){

        return userInterface.findTopByOrderByIdDesc();
    }

    public Optional<User> findByMonthBirthtDay(String monthBirthDay){

        return userInterface.findByMonthBirthtDay(monthBirthDay);
    }
}
