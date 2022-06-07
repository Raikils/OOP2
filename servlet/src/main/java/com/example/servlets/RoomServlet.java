package com.example.servlets;

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
import com.example.service.RoomService;
import com.example.entities.Room;

@WebServlet("/room")
public class RoomServlet extends HttpServlet {
    private RoomService roomService;

    @Override
    public void init() throws ServletException {
        super.init();
        roomService = new RoomService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        String json = null;
        Gson gson = new Gson();
        Vector<Room> roomVector = roomService.findAllRooms();
        json = gson.toJson(roomVector);
        out.print(json);
        out.close();
    }
}
