package ru.username.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.username.springbootdemo.model.Value;
import ru.username.springbootdemo.repository.ValueRepository;

import java.util.List;

@Service
public class ValueService {
    private final ValueRepository valueRepository;

    @Autowired
    public ValueService(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }
    public List<Value> select(){
        return valueRepository.findAll();
    }
    public Value selectId(Long id){
        return valueRepository.findById(id).orElse(null);
    }
    public Value save(Value value){
        return valueRepository.save(value);
    }
    public void delete(Long id){
        valueRepository.deleteById(id);
    }
}
