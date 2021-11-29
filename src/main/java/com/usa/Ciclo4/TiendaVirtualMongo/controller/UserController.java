package com.usa.Ciclo4.TiendaVirtualMongo.controller;

import com.usa.Ciclo4.TiendaVirtualMongo.model.User;
import com.usa.Ciclo4.TiendaVirtualMongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/* Controlador para el documento Usuario
Base de datos en MongoDB - Documento User
Author  : Ferney Alexander Arciniegas Molina
Date    : Nov 28/2021
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(int id){
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.crearUsuario(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user){
        return userService.actualizarUsuario(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUser(@PathVariable("id") int id){
        return userService.deleteUsuario(id);
    }

    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticarUsuario(email, password);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return userService.existeEmail(email);
    }
}
