<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Quản lý Phòng</title>
  <style>
    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<h2>Danh sách phòng</h2>

<table>
  <tr>
    <th>Số phòng</th>
    <th>Tên khách hàng</th>
    <th>Số điện thoại</th>
    <th>Ngày nhận phòng</th>
    <th>Ghi chú</th>
    <th>
<%--      <a href="<c:url value='/room/add'/>">Thêm</a>--%>
    </th>
  </tr>
  <c:forEach var="room" items="${rooms}">
    <tr>
      <td>${room.roomNumber}</td>
      <td>${room.name}</td>
      <td>${room.phone}</td>
      <td>${room.startDate}</td>
      <td>${room.note}</td>
      <td>
        <a href="<c:url value='/room/detail'/>?id=${room.roomNumber}">Xem</a> |
        <a href="<c:url value='/room/edit'/>?id=${room.roomNumber}">Sửa</a> |
        <a href="<c:url value='/room/remove'/>?id=${room.roomNumber}">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>
<a href="/room/list">Quay về</a>
</body>
</html>
