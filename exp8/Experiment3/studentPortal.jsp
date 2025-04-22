<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Attendance Portal</title>
</head>
<body>
<h2>Attendance Submission</h2>
<form action="AttendanceServlet" method="post">
    <label for="studentId">Student ID:</label>
    <input type="text" name="studentId" id="studentId" required><br><br>

    <label for="date">Date:</label>
    <input type="date" name="date" id="date" required><br><br>

    <label for="status">Status:</label>
    <select name="status" id="status" required>
        <option value="Present">Present</option>
        <option value="Absent">Absent</option>
    </select><br><br>

    <input type="submit" value="Submit Attendance">
</form>
</body>
</html>
