package com.example.repository;

import com.example.spring.entity.Horses;
import org.springframework.data.repository.CrudRepository;
import com.example.entities.Request;

public interface RequestRepo extends CrudRepository<Request, Integer> {
}