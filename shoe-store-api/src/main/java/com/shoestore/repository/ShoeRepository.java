package com.shoestore.repository;

import com.shoestore.model.Shoe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoeRepository extends MongoRepository<Shoe, String> {

    List<Shoe> findByCategory(String category);

}
