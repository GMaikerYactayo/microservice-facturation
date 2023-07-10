package com.product.service.service;

import com.product.service.domain.Category;
import com.product.service.domain.Product;
import com.product.service.repository.CategoryRepository;
import com.product.service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public Product save(Product product) {
        Category category = categoryRepository.findById(product.getCategory().getCategory_id())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        product.setCategory(category);

        log.info("Creating / Updating product");
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        log.info("Executing findAll product");
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int productId) {
        return productRepository.findById(productId);
    }

}
