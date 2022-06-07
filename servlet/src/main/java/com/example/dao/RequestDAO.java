package com.example.dao;

import com.example.entities.Request;
import com.example.entities.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class RequestDAO {
    public Vector<Request> findAllRequests() {
        Vector<Request> requestVector = new Vector<>();
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM REQUESTS");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Request request = getRequest(resultSet);
                requestVector.add(request);
            }
            con.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return requestVector;
    }

    public boolean updateRequestApproved(int id, boolean approved) {
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("UPDATE REQUESTS SET APPROVED = ? WHERE ID = ?");
            statement.setBoolean(1, approved);
            statement.setInt(2, id);
            statement.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException | ClassNotFoundException e){
            return false;
        }
    }

    public boolean updateRequestIdRoom(int id, int idRoom) {
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("UPDATE REQUESTS SET IDROOM = ? WHERE ID = ?");
            statement.setInt(1, idRoom);
            statement.setInt(2, id);
            statement.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException | ClassNotFoundException e){
            return false;
        }
    }

    public boolean updateRequestPrice(int id, double price) {
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("UPDATE REQUESTS SET PRICE = ? WHERE ID = ?");
            statement.setDouble(1, price);
            statement.setInt(2, id);
            statement.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException | ClassNotFoundException e){
            return false;
        }
    }

    public Request findRequest(int id) {
        Request request = null;
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM REQUESTS WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                request = getRequest(resultSet);
            }
            con.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return request;
    }

    public boolean addRequest(Request request) {
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("INSERT INTO REQUESTS (ID, PLACES, CLASS, APPROVED, PRICE, IDROOM) VALUES(?, ?, ?, ?, ?, ?)");
            statement.setInt(1, request.getID());
            statement.setInt(2, request.getPlace());
            statement.setInt(3, request.getClas());
            statement.setBoolean(4, request.isApproved());
            statement.setDouble(5, request.getPrice());
            statement.setInt(6, request.getIDROOM());
            statement.executeUpdate();
            con.close();
        }
        catch (SQLException | ClassNotFoundException e){
            return false;
        }
        return true;
    }

    private Request getRequest(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int places = resultSet.getInt(2);
        int clas = resultSet.getInt(3);
        boolean approved = resultSet.getBoolean(4);
        float price = resultSet.getFloat(5);
        int idRoom = resultSet.getInt(6);
        Request request = new Request(id, places, clas, approved, price, idRoom);
        return request;
    }

}
