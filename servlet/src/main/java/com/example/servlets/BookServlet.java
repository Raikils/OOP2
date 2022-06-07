package com.example.servlets;

import com.example.entities.Booking;
import com.example.service.BookService;

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
import com.example.service.AuthorizationService;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookService bookService;
    private AuthorizationService authorizationService;

    @Override
    public void init() throws ServletException {
        super.init();
        bookService = new BookService();
        authorizationService = new AuthorizationService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException, JsonIOException {
        resp.setContentType("application/json");
        if(authorizationService.hasAuthority(req, "admin")) {
            PrintWriter out = resp.getWriter();
            Gson gson = new Gson();
            InputStreamReader reader = new InputStreamReader(req.getInputStream());
            Booking booking = gson.fromJson(reader, Booking.class);
            System.out.println(booking);
            boolean result = bookService.bookRoom(booking.getIdRoom(), booking.getIdRequest());
            reader.close();
        }
    }
}
