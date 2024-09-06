<%@page import="com.tap.model.orderitem"%>
<%@page import="com.tap.implem.orderItemDAOimpl"%>
<%@page import="com.tap.daointerface.daointerfaceorderitem"%>
<%@page import="com.tap.model.orderhistory"%>
<%@page import="com.tap.implem.orderhistoryDAOimpl"%>
<%@page import="com.tap.daointerface.daointerfaceorderhistory"%>
<%@page import="com.tap.model.cartitem"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.tap.model.order"%>
<%@page import="com.tap.implem.orderDAOimpl"%>
<%@page import="com.tap.daointerface.daointerfaceorder"%>
<%@page import="com.tap.model.cart"%>
<%@page import="com.tap.model.usermodel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmed</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        text-align: center;
        background-color: #fff;
        padding: 40px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 100%;
    }
    h1 {
        font-size: 2em;
        color: #28a745;
        margin-bottom: 20px;
    }
    p {
        font-size: 1.2em;
        color: #333;
    }
    .emoji {
        font-size: 3em;
        margin: 20px 0;
    }
    .error {
        font-size: 1.5em;
        color: red;
        margin-bottom: 20px;
    }
    .button-group {
        margin-top: 20px;
    }
    .button-group a {
        text-decoration: none;
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border-radius: 5px;
        margin: 0 10px;
        transition: background-color 0.3s ease;
    }
    .button-group a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<% 
    usermodel user = (usermodel) session.getAttribute("user"); 
    cart Cart= (cart)session.getAttribute("Cart");
    String totalam=(String)request.getParameter("totalAmount");
    daointerfaceorder order;
    double totalamount=Double.parseDouble(totalam);
    order orderh=null;
    if (Cart != null && Cart.getItems() != null && !Cart.getItems().isEmpty()&& user!=null) {
        LinkedHashMap<Integer, cartitem> cartItems = Cart.getItems();
         order=new orderDAOimpl();
        for(cartitem items:cartItems.values()){
        	 orderh=new order(items.getRestrantId(),user.getUserId(),totalamount,"sucess");        	 
        }
        int x=order.addorder(orderh);
        int orderId=order.getMaxorderId();
        daointerfaceorderhistory orderhistory=new orderhistoryDAOimpl();
        orderhistory orderhistorsyclass= new orderhistory(orderId,user.getUserId(),totalamount,"sucees");
        orderhistory.addhistory(orderhistorsyclass);
        daointerfaceorderitem orderItem= new orderItemDAOimpl();
         orderitem orderItemtable=null;
        for(cartitem items:cartItems.values()){
        	orderItemtable= new orderitem(orderId,items.getItemId(),items.getQuaninty(),items.getSubtotal()*items.getQuaninty());
        	orderItem.addOrderItem(orderItemtable);
       }
        
        cartItems.clear();
        
    }
    if (user != null) { 
	
%> 
    <div class="container">
        <h1>Order Confirmed! ✅</h1>
        <div class="emoji">🎉🎊🥳</div>
        <p>Thank you, <%= user.getUserName()%>. Your order has been placed successfully.</p>
        <p>You will be redirected to the home page shortly.</p>
    </div>
    <script>
        setTimeout(function() {
            window.location.href = 'index.jsp'; 
        }, 5000); 
    </script>
<% 
    } else { 
%>
    <div class="container">
        <h1 class="error">Login Required ⚠️</h1>
        <p>Please log in or register to proceed with your order.</p>
        <div class="button-group">
            <a href="login.jsp">Login</a>
            <a href="regsitre.html">Register</a>
        </div>
    </div>
<% 
    } 
%>
</body>
</html>


