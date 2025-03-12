package com.codegym.model;

public class Room {
    private int roomNumber;
    private String name;
    private String phone;
    private String startDate;
    private String note;

    public Room() {
    }

    public Room(int roomNumber, String name, String phone, String startDate, String note) {
        this.roomNumber = roomNumber;
        this.name = name;
        this.phone = phone;
        this.startDate = startDate;
        this.note = note;
    }

    public Room(String name, String phone, String startDate, String note) {
        this.name = name;
        this.phone = phone;
        this.startDate = startDate;
        this.note = note;
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", startDate='" + startDate + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}