package com.example.service;

import com.example.entities.Room;
import com.example.entities.Request;
import com.example.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.RoomRepo;
import com.example.repository.RequestRepo;

@Service
public class BookService {
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private RequestRepo requestRepo;

    public boolean bookRoom(Booking booking) {
        Room room = roomRepo.findById(booking.getIdRoom()).get();
        Request request = requestRepo.findById(booking.getIdRequest()).get();

        if (!room.isBooked() && !request.isApproved()) {
            room.setBooked(true);
            request.setApproved(true);
            request.setIDROOM(room.getID());
            request.setPrice(room.getPrice());

            roomRepo.deleteById(booking.getIdRoom());
            roomRepo.save(room);
            requestRepo.deleteById(booking.getIdRequest());
            requestRepo.save(request);
            return true;
        } else {
            return false;
        }
    }
}
