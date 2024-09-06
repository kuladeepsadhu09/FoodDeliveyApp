<%@page import="com.tap.model.usermodel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    form {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    table {
        width: 100%;
    }

    td {
        padding: 10px;
    }

    .form-label {
        font-weight: bold;
        display: inline-block;
        margin-bottom: 5px;
    }

    .form-input {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .form-input:focus {
        border-color: #007BFF;
        outline: none;
    }

    .form-button {
        background-color: #007BFF;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }

    .form-button:hover {
        background-color: #0056b3;
    }

    input[type="hidden"] {
        display: none;
    }
</style>
</head>
<body>
<% usermodel user = (usermodel) session.getAttribute("user"); %>
<form action="updateprofile" method="post">
    <h2>Edit Profile</h2>
    <table>
        <tr>
            <td><label for="name" class="form-label">Name</label></td>
            <td><input type="text" id="name" name="name" placeholder="<%=user.getUserName() %>" class="form-input"></td>
        </tr>
        <tr>
            <td><label for="mobilenumber" class="form-label">Mobile Number</label></td>
            <td><input type="tel" id="mobilenumber" name="mobilenumber" placeholder="<%=user.getPhoneNumber() %>" class="form-input"></td>
        </tr>
        <tr>
            <td><label for="addres" class="form-label">Address</label></td>
            <td><input type="text" id="addres" name="addres" placeholder="Enter your Address" class="form-input"></td>
        </tr>
        <tr>
            <td><label for="password" class="form-label">New Password</label></td>
            <td><input type="password" id="password" name="password" placeholder="Enter your new password" class="form-input"></td>
        </tr>
        <tr>
            <td><label for="cpassword" class="form-label">Confirm Password</label></td>
            <td><input type="password" id="cpassword" name="cpassword" placeholder="Confirm your password" class="form-input"></td>
        </tr>
        <tr>
            <td><input type="hidden" name="email" value="<%=user.getEmail()%>"></td>
            <td><button type="submit" class="form-button">Update</button></td>
        </tr>
    </table>
</form>
</body>
</html>
