package com.usa.Ciclo4.TiendaVirtualMongo.service;

import com.usa.Ciclo4.TiendaVirtualMongo.model.Product;
import com.usa.Ciclo4.TiendaVirtualMongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(String reference){
        return productRepository.getProduct(reference);
    }

    public Product createProduct(Product product){
        if(product.getReference() == null){
            return product;
        }else if(product.getReference() == "") {
            return product;
        }else{
            return productRepository.create(product);
        }
    }

    public Product updateProduct(Product product){
        if(product.getReference() != null){
            Optional<Product> pAux = productRepository.getProduct(product.getReference());

            if(!pAux.isEmpty()){
                if(product.getBrand() != null){
                    pAux.get().setBrand(product.getBrand());
                }

                if(product.getCategory() != null){
                    pAux.get().setCategory(product.getCategory());
                }

                if(product.getDescription() != null){
                    pAux.get().setDescription(product.getDescription());
                }

                if(product.getMaterial() != null){
                    pAux.get().setMaterial(product.getMaterial());
                }

                /*if(cP.getReference() != null){
                    cPAux.get().setReference(cP.getReference());
                }*/

                if(product.getPrice() != 0.0){
                    pAux.get().setPrice(product.getPrice());
                }

                if(product.getQuantity() != 0){
                    pAux.get().setQuantity(product.getQuantity());
                }

                if(product.getPhotography() != null){
                    pAux.get().setPhotography(product.getPhotography());
                }

                pAux.get().setAvailability(product.isAvailability());
                productRepository.update(pAux.get());
                return pAux.get();
            }else{
                return product;
            }
        }else{
            return product;
        }
    }

    public boolean deleteProduct(String reference){
        Boolean pAux = getProduct(reference).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
        return pAux;
    }

    public Optional<Product> findProductByPriceGreaterThanEqual(Integer price){

        return productRepository.findProductByPriceGreaterThanEqual(price);
    }

    public List<Product> findProductByDescription(String description){

        return productRepository.findProductByDescription(description);
    }

}
