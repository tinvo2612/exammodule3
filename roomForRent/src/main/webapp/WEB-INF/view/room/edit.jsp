<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Sửa thông tin phòng</title>
</head>
<body>
<h2>Sửa thông tin phòng</h2>

<form action="<c:url value='/room/edit'/>" method="post">
  <input type="hidden" id="id" name="id" value="${room.roomNumber}">

  <label for="name">Tên khách hàng:</label><br>
  <input type="text" id="name" name="name" value="${room.name}" required><br>

  <label for="phone">Số điện thoại:</label><br>
  <input type="text" id="phone" name="phone" value="${room.phone}" required><br>

  <label for="startDate">Ngày nhận phòng:</label><br>
  <input type="date" id="startDate" name="startDate" value="${room.startDate}" required><br>

  <label for="note">Ghi chú:</label><br>
  <input type="text" id="note" name="note" value="${room.note}"><br><br>

  <input type="submit" value="Cập nhật">
</form>

<a href="/room/list">Quay về</a>
</body>
</html>
