package com.example.service;

import com.example.dao.RoomDAO;
import com.example.entities.Room;

import java.util.Vector;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    public Vector<Room> findAllRooms() {
        return roomDAO.findAllRooms();
    }
}
