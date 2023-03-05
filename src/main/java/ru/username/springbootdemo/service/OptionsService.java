package ru.username.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.username.springbootdemo.model.Category;
import ru.username.springbootdemo.model.Option;
import ru.username.springbootdemo.repository.OptionRepository;

import java.util.List;

@Service
public class OptionsService {
    private final OptionRepository optionRepository;

    @Autowired
    public OptionsService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public Option save(Option option) {
        return optionRepository.save(option);
    }

    public List<Option> select() {
        return optionRepository.findAll();
    }

    public Option selectId(Long id) {
        return optionRepository.findById(id).orElse(null);
    }
    public void deleteId(Long id){
        optionRepository.deleteById(id);
    }
}
