package com.usa.Ciclo4.TiendaVirtualMongo.controller;

import com.usa.Ciclo4.TiendaVirtualMongo.model.Product;
import com.usa.Ciclo4.TiendaVirtualMongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/* Controlador para el documento Producto
Base de datos en MongoDB - Documento cleaningproduct
Author  : Ferney Alexander Arciniegas Molina
Date    : Nov 28/2021
 */

@RestController
@RequestMapping("/api/cleaningproduct")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){

        return productService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Product> getProduct(@PathVariable("reference") String reference){
        return productService.getProduct(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createCleaningProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateCleaningProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCleaningProduct(@PathVariable("reference") String reference){
        return productService.deleteProduct(reference);
    }

}
