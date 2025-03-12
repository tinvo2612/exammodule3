package com.codegym.controller;

import com.codegym.model.Room;
import com.codegym.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "roomController",
        urlPatterns = {"/room/list", "/room/add", "/room/detail",
                "/room/edit", "/room/remove" , "/room/search"})
public class RoomController extends HttpServlet {
    private final RoomService roomService;

    public RoomController() {
        roomService = new RoomService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getServletPath();
        int roomId = 0;
        Room room = null;

        if (req.getParameter("id") != null) {
            roomId = Integer.parseInt(req.getParameter("id"));
            room = roomService.getRoomById(roomId);
        }

        switch (action) {
            case "/room/list":
                List<Room> rooms = roomService.getRooms();
                req.setAttribute("rooms", rooms);
                req.getRequestDispatcher("/WEB-INF/view/room/list.jsp").forward(req, resp);
                break;
            case "/room/detail":
                req.setAttribute("room", room);
                req.getRequestDispatcher("/WEB-INF/view/room/detail.jsp").forward(req, resp);
                break;
            case "/room/add":
                req.getRequestDispatcher("/WEB-INF/view/room/add.jsp").forward(req, resp);
                break;
            case "/room/edit":
                req.setAttribute("room", room);
                req.getRequestDispatcher("/WEB-INF/view/room/edit.jsp").forward(req, resp);
                break;
            case "/room/remove":
                roomService.removeRoom(roomId);
                resp.sendRedirect(req.getContextPath() + "/room/list");
                break;
            case "/room/search":
                String keyword = req.getParameter("keyword");
                List<Room> searchResults = roomService.searchRooms(keyword);
                req.setAttribute("rooms", searchResults);
                req.getRequestDispatcher("/WEB-INF/view/room/search.jsp").forward(req, resp);
                break;


            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getServletPath();

        switch (action) {
            case "/room/add":
                String addName = req.getParameter("name");
                String addPhone = req.getParameter("phone");
                String addStartDate = req.getParameter("startDate");
                String addNote = req.getParameter("note");

                Room addingRoom = new Room(addName, addPhone, addStartDate, addNote);
                roomService.addRoom(addingRoom);
                resp.sendRedirect(req.getContextPath() + "/room/list");
                break;
            case "/room/edit":
                int roomId = Integer.parseInt(req.getParameter("id"));
                Room currentRoom = roomService.getRoomById(roomId);
                currentRoom.setName(req.getParameter("name"));
                currentRoom.setPhone(req.getParameter("phone"));
                currentRoom.setStartDate(req.getParameter("startDate"));
                currentRoom.setNote(req.getParameter("note"));
                roomService.editRoom(currentRoom);
                req.setAttribute("updatedMessage", "Cập nhật phòng thành công!");
                resp.sendRedirect(req.getContextPath() + "/room/list");
                break;
            default:
                break;
        }
    }
}
