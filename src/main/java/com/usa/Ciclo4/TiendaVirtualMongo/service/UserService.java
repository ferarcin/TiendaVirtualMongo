package com.usa.Ciclo4.TiendaVirtualMongo.service;

import com.usa.Ciclo4.TiendaVirtualMongo.model.User;
import com.usa.Ciclo4.TiendaVirtualMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public User createUser(User user){
        Optional<User>  userMaxId;

        //si el ID del usuario es vacio, se busca el ID mas grande
        if(user.getId() == null){
            userMaxId = userRepository.lastUserId();
            //si no existe un usuario en la tabla, se devuelve el código 1
            //caso contrario se devuelve el valor ID mas alto y se le suma 1
            if(userMaxId.isEmpty()){
                user.setId(1);
            }else{
                user.setId(userMaxId.get().getId() + 1);
            }
        }

        Optional<User> uAux = userRepository.getUser(user.getId());
        if(uAux.isEmpty()){
            if(existsEmail(user.getEmail())==false){
                return userRepository.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public User updateUser(User user){
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

    public boolean deleteUserBefore(int id){
        Boolean uAux = getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return uAux;
    }

    public boolean deleteUser(int id){
        Optional<User> usuario = getUser(id);
        if(usuario.isEmpty()){
            return false;
        }else{
            userRepository.delete(usuario.get());
            return true;
        }
    }

    public boolean existsEmail(String email){
        return userRepository.findUserEmail(email);
    }

    public User autenticateUser(String email, String password){
        Optional<User> uaux = userRepository.autenticateUser(email, password);

        if(uaux.isEmpty()){
            return new User();
        }else{
            return uaux.get();
        }
    }

    public List<User> findByMonthBirthtDay(String monthBirthDay){

        return userRepository.findByMonthBirthtDay(monthBirthDay);
    }
}
