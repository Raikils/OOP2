package com.example.controller;

import com.example.entities.Room;
import com.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity addRoom(@RequestBody Room room){
        try {
            roomService.addRoom(room);
            return ResponseEntity.ok("Room successfully added!!!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Room add error");
        }
    }

    @GetMapping()
    public ResponseEntity getRooms(){
        try {
            return ResponseEntity.ok(roomService.getRooms());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
