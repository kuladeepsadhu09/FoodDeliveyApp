<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Mismatch</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
            color: #333;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }

        .container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #e74c3c;
            margin-bottom: 20px;
        }

        a {
            text-decoration: none;
        }

        button {
            padding: 12px 24px;
            background-color: #3498db;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Password and Confirm Password Not Matched</h1>
        <a href="regsitre.html"><button>Register</button></a>
    </div>
</body>
</html>
