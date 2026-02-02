package com.example.ec.service;

import com.example.ec.entity.Product;
import com.example.ec.form.ProductForm;
import com.example.ec.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findByIdOrThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("商品が見つかりません: id=" + id));
    }

    public void update(Long id, ProductForm form) {
        Product p = findByIdOrThrow(id);
        p.setName(form.getName());
        p.setPrice(form.getPrice());
        p.setDescription(form.getDescription());
        productRepository.save(p);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
