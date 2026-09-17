package org.example.springtest.Service;

import lombok.RequiredArgsConstructor;
import org.example.springtest.exception.ProductNotFoundException;
import org.example.springtest.model.entity.Product;
import org.example.springtest.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProductId(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Məhsul tapılmadı: " + id));
    }
}
