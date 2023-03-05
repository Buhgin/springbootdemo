package ru.username.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.username.springbootdemo.model.Product;
import ru.username.springbootdemo.repository.ProductRepository;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;
     @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> select(){
    return  productRepository.findAll();
    }
    public Product selectId(Long id){
         return productRepository.findById(id).orElse(null);
    }
    public Product save(Product product){
    return productRepository.save(product);
    }
    public void deleteId(Long id){
         productRepository.deleteById(id);
    }
}
