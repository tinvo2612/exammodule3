<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết phòng</title>
</head>
<body>
<h2>Chi tiết phòng</h2>

<form>
    <label for="roomNumber">Số phòng:</label><br>
    <input type="text" id="roomNumber" value="${room.roomNumber}" disabled><br>

    <label for="name">Tên khách hàng:</label><br>
    <input type="text" id="name" value="${room.name}" disabled><br>

    <label for="phone">Số điện thoại:</label><br>
    <input type="text" id="phone" value="${room.phone}" disabled><br>

    <label for="startDate">Ngày nhận phòng:</label><br>
    <input type="text" id="startDate" value="${room.startDate}" disabled><br>

    <label for="note">Ghi chú:</label><br>
    <input type="text" id="note" value="${room.note}" disabled><br><br>

    <a href="/room/list">Quay về</a>
</form>
</body>
</html>
