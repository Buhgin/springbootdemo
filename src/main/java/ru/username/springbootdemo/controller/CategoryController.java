package ru.username.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.username.springbootdemo.model.Category;
import ru.username.springbootdemo.model.Option;
import ru.username.springbootdemo.model.Product;
import ru.username.springbootdemo.service.CategoryService;
import ru.username.springbootdemo.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class CategoryController {

    private final CategoryService categoryService;


    @Autowired
    public CategoryController( CategoryService categoryService) {

        this.categoryService = categoryService;

    }

    @GetMapping("/categories")
    public String findAll(Model model) {
        List<Category> categories = categoryService.select();
        model.addAttribute("categories", categories);
        return "category/categories-list";
    }

    @GetMapping("/category-create")
    public String categoryCreateForm(Category category) {
        return "category/category-create";

    }

    @PostMapping("/category-create")
    public String createCategory(Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("category-delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }

    @GetMapping("/category-update/{id}")
    public String updateCategoryForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.selectID(id);
        model.addAttribute("category", category);
        return "category/category-update";
    }

    @PostMapping("/category-update")
    public String updateCategory(Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/category-product/{id}")
    public String categoryIdInfo(@PathVariable Long id, Model model) {
        Category category = categoryService.selectID(id);
        var products=category.getProducts();
        var options = category.getOptions();
        model.addAttribute("products", products);
        model.addAttribute("options", options);
        return "category/category-product";

    }
    @GetMapping("/process-categories")
    public String categoryFilter(@RequestParam(name = "selectedCategories", required = true) List<Long> selectedCategoryIds, Model model) {
        if(Objects.isNull(selectedCategoryIds)){
            return  "redirect:/categories";
        }

        List<Category> categories = categoryService.getCategoriesByIds(selectedCategoryIds);
        List<Option> options = categories.stream()
                .flatMap(category -> category.getOptions().stream())
                .toList();
        List<Product> products = categories.stream()
                .flatMap(category -> category.getProducts().stream())
                .toList();
        model.addAttribute("options", options);
        model.addAttribute("products", products);


        return "category/categories-products";



    }
}
