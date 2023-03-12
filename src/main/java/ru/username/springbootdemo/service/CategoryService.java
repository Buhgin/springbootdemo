package ru.username.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.username.springbootdemo.model.Category;
import ru.username.springbootdemo.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> select() {
        return categoryRepository.findAll();
    }

    public Category selectID(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

public List<Category> getCategoriesByIds(List<Long> ids){
     var categories = new ArrayList<Category>();
    //ids.forEach(aLong -> categories.add(selectID(aLong)));
        for(Long l : ids){categories.add(selectID(l));}
return categories;
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

}
