package org.example.springtest.Service;

import lombok.RequiredArgsConstructor;
import org.example.springtest.exception.ResourceNotFoundException;
import org.example.springtest.model.dto.ProductUpdateDto;
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
                .orElseThrow(() -> new ResourceNotFoundException("Məhsul tapılmadı: " + id));
    }

    @Transactional
    public Product updateProduct(Long id, ProductUpdateDto dto){
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Məhsul tapılmadı: "+ id));
        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }
}
