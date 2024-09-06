<%@page import="com.tap.model.menu"%>
<%@page import="com.tap.implem.menuDAOimpl"%>
<%@page import="com.tap.daointerface.daointerfacemenu"%>
<%@page import="com.tap.model.usermodel"%>
<%@page import="com.tap.model.orderhistory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tap.implem.orderhistoryDAOimpl"%>
<%@page import="com.tap.daointerface.daointerfaceorderhistory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            color: #333;
            margin: 0;
            padding: 0;
        }
        h3 {
            color: #333;
            font-size: 28px;
            margin: 20px 0;
            text-align: center;
        }
        .order-history {
            background-color: #ffffff;
            border-radius: 10px;
            padding: 20px;
            margin: 20px auto;
            max-width: 800px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: box-shadow 0.3s ease, transform 0.3s ease;
        }
        .order-history:hover {
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
            transform: translateY(-5px);
        }
        .order-history p {
            margin: 10px 0;
            font-size: 16px;
            line-height: 1.6;
        }
        .order-history strong {
            color: #444;
        }
        .order-history button {
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
            font-size: 16px;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .order-history button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h3>Order History</h3>
    <% 
    usermodel user = (usermodel) session.getAttribute("user");
    daointerfaceorderhistory orderhistory = new orderhistoryDAOimpl();
    daointerfacemenu menuit = new menuDAOimpl();
    ArrayList<orderhistory> ordhisst = orderhistory.getspecifichistory(user.getUserId());
    for(orderhistory ordhis : ordhisst) {
    %>
    <div class="order-history">
        <p><strong>Order ID:</strong> <%= ordhis.getOrderId() %></p>
        <p><strong>Order Date:</strong> <%= ordhis.getDate() %></p>
        <p><strong>Status:</strong> <%= ordhis.getStatus() %></p>
        <p><strong>Total Amount:</strong> <%= ordhis.getTotalAmount() %></p>
        <a href="detailhistory.jsp?orderid=<%=ordhis.getOrderId()%>&totalAmount=<%=ordhis.getTotalAmount()%>">
            <button>View Detail</button>
        </a>
    </div>
    <% } %>
</body>
</html>

