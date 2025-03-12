package com.codegym.dao;

import com.codegym.connection.JdbcConnection;
import com.codegym.model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomDao {
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection()) {
            String query = "SELECT * FROM room";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("roomNumber"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("startDate"),
                        resultSet.getString("note")
                );
                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public Room findById(int roomNumber) {
        Room room = null;
        try (Connection connection = JdbcConnection.getConnection()) {
            String query = "SELECT * FROM room WHERE roomNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, roomNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                room = new Room(
                        resultSet.getInt("roomNumber"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("startDate"),
                        resultSet.getString("note")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }

    public void insert(Room room) {
        try (Connection connection = JdbcConnection.getConnection()) {
            String query = "INSERT INTO room (name, phone, startDate, note) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, room.getName());
            preparedStatement.setString(2, room.getPhone());
            preparedStatement.setString(3, room.getStartDate());
            preparedStatement.setString(4, room.getNote());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Room room) {
        try (Connection connection = JdbcConnection.getConnection()) {
            String query = "UPDATE room SET name = ?, phone = ?, startDate = ?, note = ? WHERE roomNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, room.getName());
            preparedStatement.setString(2, room.getPhone());
            preparedStatement.setString(3, room.getStartDate());
            preparedStatement.setString(4, room.getNote());
            preparedStatement.setInt(5, room.getRoomNumber());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int roomNumber) {
        try (Connection connection = JdbcConnection.getConnection()) {
            String query = "DELETE FROM room WHERE roomNumber = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, roomNumber);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Room> searchRooms(String keyword) {
        List<Room> rooms = new ArrayList<>();

        if (keyword == null || keyword.trim().isEmpty()) {
        return findAll();
        }

        try {
        int roomNumber = Integer.parseInt(keyword);
        Room room = findById(roomNumber);
        if (room != null) {
            rooms.add(room);
        }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return rooms;
    }


}
