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
Revision 2
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
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProduct(@PathVariable("reference") String reference){
        return productService.deleteProduct(reference);
    }

    @GetMapping("/price/{price}")
    public List<Product> findProductByPrice(@PathVariable("price") Integer price){
        return productService.findProductByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Product> getProductByDescription(@PathVariable("description") String description){

        return productService.findProductByDescription(description);
    }


}
