package ru.username.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.username.springbootdemo.model.Option;
import ru.username.springbootdemo.model.Product;
import ru.username.springbootdemo.service.OptionsService;

import java.util.List;
@Controller
public class OptionController {
    private final OptionsService optionsService;

   @Autowired
    public OptionController(OptionsService optionsService) {
        this.optionsService = optionsService;
    }
    @GetMapping("/options")
    public String findAllOption(Model model) {
        List<Option> options = optionsService.select();
        model.addAttribute("options", options);
        return "option/options-list";
    }

    @GetMapping("/option-create")
    public String optionCreateForm(Option option) {
        return "option/option-create";

    }

    @PostMapping("/option-create")
    public String createOption(Option option) {
      optionsService.save(option);
        return "redirect:/options";
    }

    @GetMapping("option-delete/{id}")
    public String deleteOption(@PathVariable("id") Long id) {
    optionsService.deleteId(id);
        return "redirect:/options";
    }

    @GetMapping("/option-update/{id}")
    public String updateOptionForm(@PathVariable("id") Long id, Model model) {
    Option option = optionsService.selectId(id);
        model.addAttribute("option", option);
        return "option/option-update";
    }

    @PostMapping("/option-update")
    public String updateOption(Option option) {
        optionsService.save(option);
        return "redirect:/options";
    }

    @GetMapping("/category-product/option-product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        var option = optionsService.selectId(id);
        var values = option.getValue();
        model.addAttribute("option", option);
        model.addAttribute("values", values);

        return "redirect:option/option-product";
    }
}
