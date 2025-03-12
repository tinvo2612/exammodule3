package com.codegym.service;

import com.codegym.dao.RoomDao;
import com.codegym.model.Room;

import java.util.List;

public class RoomService {
    private final RoomDao roomDao;

    public RoomService() {
        this.roomDao = new RoomDao();
    }

    public List<Room> getRooms() {
        return roomDao.findAll();
    }

    public Room getRoomById(int roomNumber) {
        return roomDao.findById(roomNumber);
    }

    public void addRoom(Room room) {
        roomDao.insert(room);
    }

    public void editRoom(Room room) {
        roomDao.update(room);
    }

    public void removeRoom(int roomNumber) {
        roomDao.delete(roomNumber);
    }

    public List<Room> searchRooms(String keyword) {
        return roomDao.searchRooms(keyword);
    }
}
