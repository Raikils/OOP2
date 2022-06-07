package com.example.dao;

import com.example.entities.Request;
import com.example.entities.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class RoomDAO {
    public Vector<Room> findAllRooms() {
        Vector<Room> roomVector = new Vector<>();
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM ROOMS");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Room room = getRoom(resultSet);
                roomVector.add(room);
            }
            con.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return roomVector;
    }

    public boolean updateRoomBooked(int id, boolean booked) {
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("UPDATE ROOMS SET BOOKED = ? WHERE ID = ?");
            statement.setBoolean(1, booked);
            statement.setInt(2, id);
            statement.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException | ClassNotFoundException e){
            return false;
        }
    }

    public boolean updateRoomPrice(int id, double price) {
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("UPDATE ROOMS SET PRICE = ? WHERE ID = ?");
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

    public Room findRoom(int id) {
        Room room = null;
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM ROOMS WHERE ID = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                room = getRoom(resultSet);
            }
            con.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return room;
    }

    private Room getRoom(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int places = resultSet.getInt(2);
        int clas = resultSet.getInt(3);
        boolean booked = resultSet.getBoolean(4);
        float price = resultSet.getFloat(5);
        Room room = new Room(id, places, clas, booked, price);
        return room;
    }
}
