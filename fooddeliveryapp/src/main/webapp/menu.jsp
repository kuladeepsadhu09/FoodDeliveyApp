<%@ page import="java.util.ArrayList"%>
<%@ page import="com.tap.implem.menuDAOimpl"%>
<%@ page import="com.tap.daointerface.daointerfacemenu"%>
<%@ page import="com.tap.model.restaurant"%>
<%@ page import="com.tap.model.menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><% out.print(request.getParameter("restaurntname")); %> Restaurant Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            color: #333;
            margin: 0;
            padding: 20px;
            position: relative; 
        }
        h3 {
            color: orange; 
            font-size: 1.8em;
            margin-bottom: 20px;
        }
        .menu-item {
            margin-bottom: 20px;
            padding: 15px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: flex; 
            align-items: center; 
            justify-content: space-between; 
        }
        .menu-item img {
            max-width: 200px; 
            height: auto; 
            border-radius: 8px;
            margin-right: 20px; 
        }
        .menu-details {
            flex-grow: 1; 
            display: flex;
            flex-direction: column;
        }
        .menu-details p {
            margin: 5px 0;
        }
        .menu-details strong {
            display: inline-block;
            width: 120px;
        }
        .menu-name {
            color: #ff5733;
            font-size: 1.2em;
            margin-top: 10px;
        }
        .add-to-cart {
            margin-top: 10px;
        }
        .add-to-cart input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            transition: background-color 0.3s ease;
        }
        .add-to-cart input[type="submit"]:hover {
            background-color: #45a049;
        }
        .home-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db; 
            color: white;
            text-decoration: none;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            position: absolute;
            top: 20px;
            right: 20px;
            z-index: 10; 
        }
        .home-button:hover {
            background-color: #2980b9; 
        }
    </style>
</head>
<body>
    <a href="index.jsp" class="home-button">Home</a>
    <h3><% out.print(request.getParameter("restaurntname")); %> Restaurant Menu</h3>
    <% 
        daointerfacemenu Menu = new menuDAOimpl();
         int retautarntid=Integer.parseInt(request.getParameter("restaurntid"));
         String retautarntname=request.getParameter("restaurntname");
        session.setAttribute("restaurntid", retautarntid);
        session.setAttribute("restaurntname",retautarntname);
        int menuId = Integer.parseInt(request.getParameter("restaurntid"));
        ArrayList<menu> men = Menu.getSpecfimenu(menuId);
        for(menu menuitem : men) {
    %>
    <div class="menu-item">
        <img alt="Image of <%= menuitem.getMenuName() %>" src="<%= request.getContextPath() %>/swamyfoodappimages/<%=menuitem.getImgPath()%>">

        <div class="menu-details" method="post">
            <div class="menu-name"><%= menuitem.getMenuName() %></div>
            <p>
                <strong>Is Available:</strong> <%= menuitem.getIsAvailable() %><br>
                <strong>Price:</strong> <%= menuitem.getPrice() %><br>
                <strong>Description:</strong> <%= menuitem.getDescrption() %><br>
            </p>
            <div class="add-to-cart">
                <form action="cartservalte" method="post">
                    <input type="hidden" name="itemid" value="<%= menuitem.getMenuId() %>">
                    <input type ="hidden" name="itemid" value="<%=request.getParameter("restaurntid") %>">
                    <input type="submit" value="Add to cart">
                    <input type="hidden" name="action" value="add">
                </form>
            </div>
        </div>
    </div>
    <% } %>
</body>
</html>

