package com.example.repository;

import com.example.spring.entity.Horses;
import org.springframework.data.repository.CrudRepository;
import com.example.entities.Room;

public interface RoomRepo extends CrudRepository<Room, Integer> {
}