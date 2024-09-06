<%@page import="com.tap.model.menu"%>
<%@page import="com.tap.implem.menuDAOimpl"%>
<%@page import="com.tap.daointerface.daointerfacemenu"%>
<%@page import="com.tap.model.orderitem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tap.implem.orderItemDAOimpl"%>
<%@page import="com.tap.daointerface.daointerfaceorderitem"%>
<%@page import="com.tap.model.usermodel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Order History</title>
<style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        color: #333;
        margin: 0;
        padding: 20px;
    }

    h1 {
        color: #007bff;
        font-size: 32px;
        text-align: center;
        margin-bottom: 40px;
    }

    .order-item {
        display: flex;
        align-items: center;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
        padding: 20px;
        transition: transform 0.2s;
    }

    .order-item:hover {
        transform: translateY(-5px);
    }

    .order-item img {
        width: 150px;
        height: 150px;
        border-radius: 8px;
        margin-right: 20px;
        object-fit: cover;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .order-item-details {
        flex-grow: 1;
    }

    .order-item-details p {
        margin: 8px 0;
        font-size: 16px;
        color: #555;
    }

    .order-item-details p strong {
        color: #333;
    }

    .order-total {
        text-align: right;
        font-size: 24px;
        color: #28a745;
        font-weight: bold;
        margin-top: 20px;
    }

    .order-total span {
        color: #007bff;
    }
</style>
</head>
<body>
<h1>Your Order History</h1>
<%
    String orderIdParam = request.getParameter("orderid");
    int orderid = Integer.parseInt(orderIdParam);
    usermodel user = (usermodel) session.getAttribute("user");
    daointerfaceorderitem orderitems = new orderItemDAOimpl();
    daointerfacemenu menuit = new menuDAOimpl();
    ArrayList<orderitem> orderitemhis = orderitems.getspecificorder(orderid);
    for(int i=0;i<orderitemhis.size();i++){
    	orderitem orderitems1=orderitemhis.get(i);
        menu menuitems = menuit.getspecficmenuitem(orderitems1.getMenuId());
       
%>
    <div class="order-item">
        <img alt="Image of item" src="<%= request.getContextPath() %>/swamyfoodappimages/<%=menuitems.getImgPath()%>">
        <div class="order-item-details">
            <p><strong>Item Name:</strong> <%=menuitems.getMenuName() %></p>
            <p><strong>Quantity:</strong> <%= orderitems1.getQuantity() %></p>
            <p><strong>Item Price:</strong> <%=menuitems.getPrice() %></p>
            <p><strong>Subtotal:</strong> <%= orderitems1.getSubTotal() %></p>
        </div>
    </div>
<% 
    }
%>
    <div class="order-total">
        Total Amount: <span><%=request.getParameter("totalAmount") %></span>
    </div>
</body>
</html>


