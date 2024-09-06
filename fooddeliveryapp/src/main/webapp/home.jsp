<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Index Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        /* Header styling */
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            color: white;
            padding: 10px 20px;
        }
        header .name {
            font-size: 24px;
        }
        header nav {
            display: flex;
            gap: 15px;
        }
        header nav a {
            color: white;
            text-decoration: none;
            font-size: 18px;
        }
        header nav a:hover {
            text-decoration: underline;
        }
        /* Main content styling */
        main {
            display: flex;
            justify-content: space-around;
            padding: 20px;
            background-color: #f0f0f0;
        }
        .restaurant {
            width: 30%;
        }
        .restaurant img {
            width: 100%;
            height: auto;
            border-radius: 8px;
        }
        .restaurant h3 {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <!-- Header Section -->
    <header>
        <div class="name">Your Name</div>
        <nav>
            <a href="#">Sign In</a>
            <a href="#">Sign Up</a>
        </nav>
    </header>

    <!-- Main Content Section -->
    <main>
        <div class="restaurant">
            <img src="restaurant1.jpg" alt="Restaurant 1">
            <h3>Restaurant 1</h3>
        </div>
        <div class="restaurant">
            <img src="restaurant2.jpg" alt="Restaurant 2">
            <h3>Restaurant 2</h3>
        </div>
        <div class="restaurant">
            <img src="restaurant3.jpg" alt="Restaurant 3">
            <h3>Restaurant 3</h3>
        </div>
    </main>
</body>
</html>
