package ru.username.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.username.springbootdemo.model.Product;

import ru.username.springbootdemo.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping("/products")
    public String findAllProduct(Model model) {
        List<Product> products = productService.select();
        model.addAttribute("products", products);
        return "product/products-list";
    }

    @GetMapping("/product-create")
    public String productCreateForm(Product product) {
        return "product/product-create";

    }

    @PostMapping("/product-create")
    public String createProduct(Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("product-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteId(id);
        return "redirect:/products";
    }

    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.selectId(id);
        model.addAttribute("product", product);
        return "product/product-update";
    }

    @PostMapping("/product-update")
    public String updateProduct(Product product) {
        productService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/category-product/product-value/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.selectId(id);
        var values = product.getValues();
          model.addAttribute("product", product);
        model.addAttribute("values", values);

        return "redirect:product/product-value";
    }
    @GetMapping("product-value/{id}")
    public String productInfo1(@PathVariable Long id, Model model) {
        Product product = productService.selectId(id);
        var values = product.getValues();
        model.addAttribute("product", product);
        model.addAttribute("values", values);

        return "redirect:product/product-value";
    }
}
