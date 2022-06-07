package com.example.controller;

import com.example.entities.Booking;
import com.example.entities.Request;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity addBooking(@RequestBody Booking booking){
        try {
            bookService.bookRoom(booking);
            return ResponseEntity.ok("Room successfully booked!!!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }
}
