package com.example.service;

import com.example.entities.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.RequestRepo;

@Service
public class RequestService {
    @Autowired
    private RequestRepo requestRepo;

    public Request addRequest(Request request){
        return requestRepo.save(request);
    }

    public Iterable<Request> getRequests(){
        return requestRepo.findAll();
    }

    public Request getRoom(int id) {
        Request request = requestRepo.findById(id).get();
        if(request == null){
            return null;
        }
        return request;
    }

}
