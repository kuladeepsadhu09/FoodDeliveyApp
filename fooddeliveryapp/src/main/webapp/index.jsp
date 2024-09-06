<%@page import="java.util.ArrayList"%>
<%@page import="com.tap.implem.restaurantDAOimpl"%>
<%@page import="com.tap.model.usermodel"%>
<%@page import="com.tap.model.restaurant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Swamy Food App</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .top-container {
        background-color: orange;
        color: white;
        padding: 20px;
        text-align: center;
        position: relative;
    }
    .top-container h1 {
        margin: 0;
    }
    .user-info {
        text-align: center;
        margin-top: 20px;
    }
    .user-info h2 {
        margin: 0;
    }
    .top-right-buttons {
        position: absolute;
        top: 20px;
        right: 20px;
    }
    .button-group {
        display: flex;
        gap: 10px;
    }
    .button-group a {
        text-decoration: none;
    }
    .button-group button {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    .button-group button:hover {
        background-color: #0056b3;
    }
    .dropdown-container {
        position: relative;
        display: inline-block;
    }
    .dropdown-button {
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
        border-radius: 5px;
    }
    .dropdown-menu {
        display: none;
        position: absolute;
        top: 100%;
        right: 0; 
        background-color: #ffffff;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
        border-radius: 5px;
        border: 1px solid #ddd;
    }
    .dropdown-menu a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }
    .dropdown-menu a:hover {
        background-color: #f1f1f1;
    }
    
    .dropdown-menu a {
        color: #333;
    }
    .dropdown-menu a:hover {
        background-color: #ddd;
    }
    .restaurant-list {
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        gap: 20px;
        margin: 20px auto;
        width: 80%;
    }
    .restaurant-item {
        text-align: left;
        transition: transform 0.3s ease;
    }
    .restaurant-item img {
        width: 100%;
        height: 200px; 
        object-fit: cover; 
    }
    .restaurant-item p {
        margin: 10px 0;
        color: #555;
    }
    .restaurant-item a {
        display: block;
        text-align: center;
        background-color: #007bff;
        color: #fff;
        padding: 10px;
        border-radius: 8px;
        text-decoration: none;
        margin-top: 10px;
        transition: background-color 0.3s ease;
    }
    .restaurant-item a:hover {
        background-color: #0056b3;
    }
    .restaurant-item:hover {
        transform: scale(1.05);
    }
</style>
</head>
<body>
<div class="top-container">
    <h1>Swamy Food App</h1>
    <div class="top-right-buttons">
        <% usermodel user = (usermodel) session.getAttribute("user"); %>
        <% if (user != null) { %>
            <div class="button-group">
                <a href="cart.jsp"><button>🛒 Cart</button></a>
                <a href="history.jsp"><button> 📜 history</button></a>
                <div class="dropdown-container">
                    <button class="dropdown-button" onclick="toggleDropdown()">👤 Profile</button>
                    <div class="dropdown-menu" id="dropdownMenu">
                        <a href="editprofile.jsp">✏️ Edit Profile</a>
                        <a href="#settings">⚙️ Settings</a>
                        <a href="logout.jsp">🚪 Logout</a>
                    </div>
                </div>
            </div>
        <% } else { %>
            <div class="button-group">
                <a href="login.jsp"><button>🔑 Login</button></a>
                <a href="regsitre.html"><button>📝 Register</button></a>
            </div>
        <% } %>
    </div>
</div>
<div class="user-info">
    <% if (user != null) { %>
        <h2>Welcome <%= user.getUserName() %> 🎉</h2>
    <% } %>
</div>
<div class="container restaurant-list">
    <% restaurantDAOimpl restaurantDao = new restaurantDAOimpl();
       ArrayList<restaurant> restaurants = restaurantDao.getAllRestaurants();
       if (restaurants == null || restaurants.isEmpty()) {
           out.println("<p>No restaurants found</p>");
       } else {
           for (restaurant res : restaurants) { %>
               <div class="restaurant-item">
                   <img alt="Image of <%= res.getRestaurntName() %>" src="<%= request.getContextPath() %>/swamyfoodappimages/<%=res.getImagepath()%>">
                   <p>
                       <strong>Is Active:</strong> <%= res.getIsActive() %><br>
                       <strong>Cuisine Type:</strong> <%= res.getCusineType() %><br>
                       <strong>Delivery Time:</strong> <%= res.getDeliverytime() %> min<br>
                       <strong>Rating:</strong> <%= res.getRating() %>
                   </p>
                   <a href="menu.jsp?restaurntid=<%= res.getRestaurntId()%>&restaurntname=<%= res.getRestaurntName()%>">📜 View menu</a>
               </div>
           <% }
       } %>
</div>

<script>
    function toggleDropdown() {
        var dropdown = document.getElementById('dropdownMenu');
        if (dropdown.style.display === 'block') {
            dropdown.style.display = 'none';
        } else {
            dropdown.style.display = 'block';
        }
    }

    // Close the dropdown if the user clicks outside of it
    window.onclick = function(event) {
        if (!event.target.matches('.dropdown-button')) {
            var dropdown = document.getElementById('dropdownMenu');
            if (dropdown.style.display === 'block') {
                dropdown.style.display = 'none';
            }
        }
    }
</script>
</body>
</html>






