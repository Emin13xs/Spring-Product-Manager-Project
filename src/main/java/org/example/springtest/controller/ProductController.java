package org.example.springtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springtest.model.dto.ProductV1;
import org.example.springtest.model.dto.ProductV2;
import org.example.springtest.model.entity.Product;
import org.example.springtest.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/v1/products/{id}")
    public ResponseEntity<ProductV1> getProductV1(@PathVariable Long id) {
        Product product = productService.getProductId(id);
        ProductV1 response = new ProductV1(product.getName(), product.getPrice());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/v2/products/{id}")
    public ResponseEntity<ProductV2> getProductV2(@PathVariable Long id) {
        Product product = productService.getProductId(id);
        ProductV2 response = new ProductV2(
                product.getName(),
                product.getPrice(),
                product.getCategory(),
                product.getStock()
        );
        return ResponseEntity.ok(response);
    }

}
