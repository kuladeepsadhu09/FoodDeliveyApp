<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Swamy Foods</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-image: url('<%= request.getContextPath() %>/swamyfoodappimages/loginpage image.webp'); 
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-color: #f5f5f5; 
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9); 
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        .logo {
            font-size: 50px;
            color: #F57C00; /* Orange color */
        }

        .title {
            font-size: 24px;
            color: #F57C00; /* Orange color */
            margin: 10px 0;
        }

        .subtitle {
            font-size: 14px;
            color: #777;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-size: 14px;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: auto;
            padding: 8px 16px;
            background-color: #F57C00; /* Orange color */
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #e64a19; 
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="logo">🍴</div>
        <div class="title">Swamy Foods</div>
        <div class="subtitle">Foodies</div>
        <div class="form-group">
            <form action="loginservelete">
                <label for="firstField">Email</label>
                <input type="email" id="firstField" name="email" placeholder="Enter email here">
                <label for="secondField">Password</label>
                <input type="password" id="secondField" name="password" placeholder="Enter password here">
                <input type="submit" value="Login">
            </form>
        </div>
    </div>
</body>
</html>
