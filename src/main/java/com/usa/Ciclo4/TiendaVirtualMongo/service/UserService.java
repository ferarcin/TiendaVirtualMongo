package com.usa.Ciclo4.TiendaVirtualMongo.service;

import com.usa.Ciclo4.TiendaVirtualMongo.model.User;
import com.usa.Ciclo4.TiendaVirtualMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public User crearUsuario(User user){
        if(user.getId() == null) {
            return user;
        }else{
            Optional<User> uAux = userRepository.getUser(user.getId());
            if(uAux.isEmpty()){
                if(existeEmail(user.getEmail())==false){
                    return userRepository.create(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }

    public User actualizarUsuario(User user){
        if(user.getId() !=null){
            Optional<User> uAux = userRepository.getUser(user.getId());
            if(!uAux.isEmpty()){
                if(user.getIdentification() != null) {
                    uAux.get().setIdentification(user.getIdentification());
                }

                if(user.getName() != null){
                    uAux.get().setName(user.getName());
                }

                if(user.getAddress() != null){
                    uAux.get().setAddress(user.getAddress());
                }

                if(user.getCellPhone() != null){
                    uAux.get().setCellPhone(user.getCellPhone());
                }

                if(user.getEmail() != null){
                    uAux.get().setEmail(user.getEmail());
                }

                if(user.getPassword() != null){
                    uAux.get().setPassword(user.getPassword());
                }

                if(user.getZone() != null){
                    uAux.get().setZone(user.getZone());
                }

                userRepository.update(uAux.get());
                return uAux.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public boolean deleteUsuario(int id){
        Boolean uAux = getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return uAux;
    }

    public boolean existeEmail(String email){
        return userRepository.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password){
        Optional<User> uaux = userRepository.autenticarUsuario(email, password);

        if(uaux.isEmpty()){
            return new User();
        }else{
            return uaux.get();
        }
    }
}
