package com.example.controller;


import com.example.entities.Request;
import com.example.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/request")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping
    public ResponseEntity addRequest(@RequestBody Request request){
        try {
            requestService.addRequest(request);
            return ResponseEntity.ok("Request successfully added!!!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Request add error");
        }
    }

    @GetMapping()
    public ResponseEntity getRequests(){
        try {
            return ResponseEntity.ok(requestService.getRequests());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
