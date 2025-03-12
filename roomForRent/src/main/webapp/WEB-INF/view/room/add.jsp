<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Thêm mới phòng</title>
</head>
<body>
<h2>Thêm mới phòng</h2>

<form action="<c:url value='/room/add'/>" method="post">
  <label for="name">Tên phòng:</label><br>
  <input type="text" id="name" name="name" placeholder="Nhập tên phòng" required><br>

  <label for="phone">Số điện thoại:</label><br>
  <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại" required><br>

  <label for="startDate">Ngày nhận phòng:</label><br>
  <input type="date" id="startDate" name="startDate" required><br>

  <label for="note">Ghi chú:</label><br>
  <textarea id="note" name="note" placeholder="Nhập ghi chú"></textarea><br><br>

  <input type="submit" value="Thêm mới">
</form>

<a href="/room/list">Quay về</a>
</body>
</html>