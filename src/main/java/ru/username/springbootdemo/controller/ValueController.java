package ru.username.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.username.springbootdemo.model.Product;
import ru.username.springbootdemo.model.Value;
import ru.username.springbootdemo.service.ValueService;

import java.util.List;

@Controller
public class ValueController {

    private final ValueService valueService;
  @Autowired
    public ValueController(ValueService valueService) {
        this.valueService = valueService;
    }
    @GetMapping("/values")
    public String findAllValue(Model model) {
        List<Value> valueList = valueService.select();
        model.addAttribute("values", valueList);
        return "value/values-list";
    }

    @GetMapping("/value-create")
    public String valueCreateForm(Value value) {
        return "value/value-create";

    }

    @PostMapping("/value-create")
    public String createValue(Value value) {
        valueService.save(value);
        return "redirect:/values";
    }

    @GetMapping("value-delete/{id}")
    public String deleteValue(@PathVariable("id") Long id) {
        valueService.delete(id);
        return "redirect:/values";
    }

    @GetMapping("/value-update/{id}")
    public String updateValueForm(@PathVariable("id") Long id, Model model) {
       Value value = valueService.selectId(id);
        model.addAttribute("value", value);
        return "value/value-update";
    }

    @PostMapping("/value-update")
    public String updateValue(Value value) {
       valueService.save(value);
        return "redirect:/values";
    }

}


