package com.secor.ecomcatalogservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogRepository productCatalogRepository;

    @GetMapping
    public List<ProductCatalog> getAllProducts() {
        return productCatalogRepository.findAll();
    }

    @GetMapping("/{productId}")
    public ProductCatalog getInventoryForProductId(@PathVariable Long productId) {
        return productCatalogRepository.findByProductId(productId);
    }

    @PostMapping
    public ProductCatalog addProduct(@RequestBody ProductCatalog product) {
        return productCatalogRepository.save(product);
    }

    @PutMapping("/{id}")
    public ProductCatalog updateProduct(@PathVariable Long id, @RequestBody ProductCatalog productDetails) {
        ProductCatalog product = productCatalogRepository.findById(id).orElseThrow();
        product.setProductName(productDetails.getProductName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        return productCatalogRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productCatalogRepository.deleteById(id);
    }
}

