package com.shoestore.controller;

import com.shoestore.model.Shoe;
import com.shoestore.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ShoeController {

    private final ShoeRepository shoeRepository;

    @Autowired
    public ShoeController(final ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    @GetMapping
    public List<Shoe> findAll(@RequestParam(required = false) String category) {
        if (category != null && !category.isBlank()) {
            return shoeRepository.findByCategory(category);
        } else {
            return shoeRepository.findAll();
        }
    }

    @PostMapping
    public Shoe create(@RequestBody Shoe shoe) {
        return shoeRepository.save(shoe);
    }

}
