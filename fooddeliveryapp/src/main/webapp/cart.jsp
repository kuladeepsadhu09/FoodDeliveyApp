<%@page import="com.tap.model.cart"%>
<%@page import="com.tap.model.cartitem"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
}

.container {
    width: 80%;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
}

.cart-item {
    display: flex;
    align-items: center;
    padding: 15px;
    border-bottom: 1px solid #ddd;
    margin-bottom: 10px;
    background-color: #ffe5b4; 
    border-radius: 8px;
}

.cart-item:nth-child(even) {
    background-color: #ffd9b3; 
}

.cart-item img {
    width: 150px; 
    height: auto;
    border-radius: 4px;
    margin-right: 15px;
}

.cart-item .details {
    flex: 1;
}

.cart-item .details p {
    margin: 5px 0;
}

.cart-item .actions {
    display: flex;
    gap: 10px;
}

.cart-item .actions form {
    display: inline;
}

.cart-item .actions input[type="number"] {
    width: 60px;
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

.cart-item .actions input[type="submit"] {
    padding: 5px 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 0.9em;
    transition: background-color 0.3s ease;
}

.cart-item .actions .update-button {
    background-color: #28a745;
    color: white;
}

.cart-item .actions .update-button:hover {
    background-color: #218838;
}

.cart-item .actions .remove-button {
    background-color: #dc3545;
    color: white;
}

.cart-item .actions .remove-button:hover {
    background-color: #c82333;
}

.cart-item .actions a {
    display: inline-block;
    text-decoration: none;
}

.cart-item .actions a button {
    background-color: #007bff;
    color: white;
    padding: 5px 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 0.9em;
    transition: background-color 0.3s ease;
}

.cart-item .actions a button:hover {
    background-color: #0056b3;
}

.total {
    text-align: right;
    font-size: 1.2em;
    margin-top: 20px;
    padding-top: 10px;
    border-top: 1px solid #ddd;
}

.ProceedPay {
    text-align: center;
    margin-top: 20px;
}

.ProceedPay input[type="submit"] {
    background-color: #007bff;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1em;
    transition: background-color 0.3s ease;
}

.ProceedPay input[type="submit"]:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
<h1>Your Cart</h1>
<div class="container">
    <%
        cart Cart = (cart) session.getAttribute("Cart");
        if (Cart != null && Cart.getItems() != null && !Cart.getItems().isEmpty()) {
            LinkedHashMap<Integer, cartitem> cartItems = Cart.getItems();
            double totalAmount = 0;
    %>
    <%
        for (cartitem item : cartItems.values()) {
            double subtotal = item.getPrice() * item.getQuaninty();
            totalAmount += subtotal;
    %>
    <div class="cart-item">
         <img alt="Image of <%= item.getName() %>" src="<%= request.getContextPath() %>/swamyfoodappimages/<%=item.getImgepath()%>">
        <div class="details">
            <p><strong>Item Name:</strong> <%= item.getName() %></p>
            <p><strong>Quantity:</strong> <%= item.getQuaninty() %></p>
            <p><strong>Price:</strong> <%= item.getPrice() %></p>
            <p><strong>Subtotal:</strong> <%= subtotal %></p>
        </div>
        <div class="actions">
            <form action="cartservalte" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <input type="number" name="quantity" value="<%= item.getQuaninty() %>" min="1">
                <input type="submit" value="Update" class="update-button">
            </form>
            <form action="cartservalte" method="post">
                <input type="hidden" name="action" value="remove">
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <input type="submit" value="Remove" class="remove-button">
            </form>
            <a href="menu.jsp?restaurntid=<%= item.getRestrantId() %>&restaurntname=<%= session.getAttribute("restaurntname") %>" class="add-more-button"><button>Add More</button></a>
        </div>
    </div>
    <% } %>
    <div class="total">
        <h2>Total: <%= totalAmount %></h2>
    </div>
    <div class="ProceedPay">
        <form action="checkout.jsp">
            <input type="submit" value="Proceed to Pay">
        </form>
    </div>
    <% } else { %>
    <p>Your cart is empty.</p>
    <% } %>
</div>
</body>
</html>

