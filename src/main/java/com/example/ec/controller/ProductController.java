package com.example.ec.controller;

import com.example.ec.entity.Product;
import com.example.ec.form.ProductForm;
import com.example.ec.repository.ProductRepository;
import com.example.ec.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    // 一覧
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products/list";
    }

    // 登録画面
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "products/new";
    }

    // 登録
    @PostMapping
    public String create(@Valid @ModelAttribute("productForm") ProductForm form,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "products/new";
        }

        Product p = new Product();
        p.setName(form.getName());
        p.setPrice(form.getPrice());
        p.setDescription(form.getDescription());
        productRepository.save(p);

        return "redirect:/products";
    }

    // 編集画面
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Product p = productService.findByIdOrThrow(id);

        ProductForm form = new ProductForm();
        form.setName(p.getName());
        form.setPrice(p.getPrice());
        form.setDescription(p.getDescription());

        model.addAttribute("productId", id);
        model.addAttribute("productForm", form);
        return "products/edit";
    }

    // 更新
    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("productForm") ProductForm form,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("productId", id);   // edit画面で必要
            return "products/edit";
        }

        productService.update(id, form);
        return "redirect:/products";
    }
    // 削除
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
