package com.example.service;

import com.example.dao.RequestDAO;
import com.example.entities.Request;

import java.util.Vector;

public class RequestService {
    private RequestDAO requestDAO = new RequestDAO();

    public Vector<Request> findAllRequests() {
        return requestDAO.findAllRequests();
    }

    public boolean addRequest(Request request) {
        return requestDAO.addRequest(request);
    }
}
