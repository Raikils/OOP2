package com.example.service;

import com.example.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.RoomRepo;

@Service
public class RoomService {
    @Autowired
    private RoomRepo roomRepo;

    public Room addRoom(Room room){
        return roomRepo.save(room);
    }

    public Iterable<Room> getRooms(){
        return roomRepo.findAll();
    }

    public Room getRoom(int id) {
        Room room = roomRepo.findById(id).get();
        if(room == null){
            return null;
        }
        return room;
    }

}