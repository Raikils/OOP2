package com.example.servlets;

import com.example.entities.Booking;
import com.example.entities.Room;
import com.example.service.RoomService;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.service.RequestService;
import com.example.entities.Request;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    private RequestService requestService;

    @Override
    public void init() throws ServletException {
        super.init();
        requestService = new RequestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        String json = null;
        Gson gson = new Gson();
        Vector<Request> requestVector = requestService.findAllRequests();
        json = gson.toJson(requestVector);
        out.print(json);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException, JsonIOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        InputStreamReader reader = new InputStreamReader(req.getInputStream());
        Request request = gson.fromJson(reader, Request.class);
        System.out.println(request);
        boolean result = requestService.addRequest(request);
        reader.close();
    }
}
