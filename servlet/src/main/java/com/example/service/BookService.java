package com.example.service;

import com.example.dao.RequestDAO;
import com.example.dao.RoomDAO;
import com.example.entities.Room;
import com.example.entities.Request;

public class BookService {
    private RequestDAO requestDAO = new RequestDAO();
    private RoomDAO roomDAO = new RoomDAO();

    public boolean bookRoom(int idRoom, int idRequest) {
        Room room = roomDAO.findRoom(idRoom);
        Request request = requestDAO.findRequest(idRequest);
        if (!room.isBooked() && !request.isApproved()) {
            room.setBooked(true);
            request.setApproved(true);
            request.setIDROOM(room.getID());
            request.setPrice(room.getPrice());

            requestDAO.updateRequestIdRoom(request.getID(), room.getID());
            requestDAO.updateRequestPrice(request.getID(), room.getPrice());
            requestDAO.updateRequestApproved(request.getID(), true);

            roomDAO.updateRoomBooked(room.getID(), true);
            return true;
        } else {
            return false;
        }
    }
}
