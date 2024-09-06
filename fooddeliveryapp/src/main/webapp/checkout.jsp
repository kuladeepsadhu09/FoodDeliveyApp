<%@page import="com.tap.model.cart"%>
<%@page import="com.tap.model.cartitem"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<style>
    /* Base Styles */
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f0f2f5;
        color: #333;
    }
    .container {
        width: 60%;
        margin: 30px auto;
        padding: 30px;
        background-color: #ffffff;
        border-radius: 12px;
        box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 40px;
        font-size: 2.5em;
        font-weight: bold;
    }

    /* Cart Items */
    .cart-items {
        margin-bottom: 40px;
    }
    .cart-items h2 {
        font-size: 1.8em;
        color: #2980b9;
        margin-bottom: 20px;
    }
    .cart-items table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    .cart-items th, .cart-items td {
        padding: 15px;
        text-align: left;
        border-bottom: 1px solid #dcdcdc;
    }
    .cart-items th {
        background-color: #ecf0f1;
        color: #34495e;
        font-weight: 600;
    }
    .cart-items img {
        width: 80px;
        height: auto;
        border-radius: 8px;
    }

    /* Summary */
    .summary {
        padding: 10px; 
        background-color: #f9f9f9;
        border-radius: 8px;
        border: 1px solid #e0e0e0;
    }
    .summary p {
        margin: 0;
        font-size: 0.9em; 
        color: #34495e;
    }
    .summary h2 {
        margin-top: 15px;
        font-size: 2em;
        text-align: right;
        color: #e74c3c;
    }

    /* Form Styles */
    form {
        margin-top: 30px;
    }
    label {
        display: block;
        margin-bottom: 10px;
        color: #2c3e50;
        font-weight: 500;
        font-size: 1.1em;
    }
    input[type="text"], input[type="tel"], input[type="number"], select {
        width: 100%;
        padding: 12px;
        margin-bottom: 20px;
        border: 1px solid #bdc3c7;
        border-radius: 8px;
        font-size: 1em;
        box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.05);
        transition: border-color 0.3s;
    }
    input[type="text"]:focus, input[type="tel"]:focus, input[type="number"]:focus, select:focus {
        border-color: #2980b9;
        outline: none;
    }

    /* Address Box */
    #address {
        height: 60px; 
    }

    /* Radio Buttons */
    .radio-buttons {
        display: flex;
        justify-content: space-between;
        margin-bottom: 20px;
    }
    .radio-buttons label {
        display: flex;
        align-items: center;
        font-size: 1.1em;
        cursor: pointer;
    }
    .radio-buttons input[type="radio"] {
        margin-right: 10px;
        accent-color: #2980b9;
    }

    /* Button Styles */
    .proceed-button {
        text-align: center;
        margin-top: 25px;
    }
    .proceed-button input[type="submit"] {
        background-color: #2980b9;
        color: white;
        padding: 14px 28px;
        border: none;
        border-radius: 25px;
        cursor: pointer;
        font-size: 1.2em;
        font-weight: bold;
        transition: background-color 0.3s ease, box-shadow 0.3s ease;
    }
    .proceed-button input[type="submit"]:hover {
        background-color: #2471a3;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .container {
            width: 90%;
            padding: 20px;
        }
        .cart-items h2, .summary h2 {
            font-size: 1.5em;
        }
        .cart-items th, .cart-items td {
            padding: 10px;
        }
        .proceed-button input[type="submit"] {
            width: 100%;
            padding: 14px;
            font-size: 1.1em;
        }
    }
</style>

</head>
<body>
<div class="container">
    <h1>Billing</h1>
    <%
        cart Cart = (cart) session.getAttribute("Cart");
        if (Cart != null && Cart.getItems() != null && !Cart.getItems().isEmpty()) {
            LinkedHashMap<Integer, cartitem> cartItems = Cart.getItems();
            double totalAmount = 0;
    %>
    <div class="cart-items">
        <h2>Your Items</h2>
        <table>
            <tr>
                <th>Image</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Subtotal</th>
            </tr>
            <%
                for (cartitem item : cartItems.values()) {
                    double subtotal = item.getPrice() * item.getQuaninty();
                    totalAmount += subtotal;
            %>
            <tr>
               <td> <img alt="Image of <%= item.getName() %>" src="<%= request.getContextPath() %>/swamyfoodappimages/<%=item.getImgepath()%>"></td>
                <td><%= item.getName() %></td>
                <td><%= item.getQuaninty() %></td>
                <td>$<%= item.getPrice() %></td>
                <td>$<%= subtotal %></td>
            </tr>
            <% } %>
        </table>
    </div>

    <div class="summary">
        <p>Total items: <%= Cart.getItems().size() %></p>
        <h2>Total: $<%= totalAmount %></h2>
    </div>

    <form action="orderplaced.jsp" method="post">
        <h3>Shipping Information</h3>
        <label for="address">Address</label>
        <input type="text" id="address" name="address" required>
        <input type="hidden" name="totalAmount" value="<%=totalAmount %>">
        <h3>Payment Information</h3>
        <div class="radio-buttons">
            <label>
                <input type="radio" name="paymentMethod" value="card"> Credit/Debit Card
            </label>
            <label>
                <input type="radio" name="paymentMethod" value="cod"> Cash on Delivery
            </label>
        </div>

        <div id="cardDetails" style="display: none;">
            <label for="cardNumber">Card Number</label>
            <input type="text" id="cardNumber" name="cardNumber">
            
            <label for="expDate">Expiration Date (MM/YY)</label>
            <input type="text" id="expDate" name="expDate">
            
            <label for="cvv">CVV</label>
            <input type="password" id="cvv" name="cvv">
        </div>

        <div class="proceed-button">
            <input type="submit" value="Place Order">
        </div>
    </form>
    <% } else { %>
    <p>Your cart is empty. <a href="menu.jsp">Continue Shopping</a></p>
    <% } %>
</div>

<script>
    document.querySelectorAll('input[name="paymentMethod"]').forEach(function(elem) {
        elem.addEventListener('change', function () {
            var cardDetails = document.getElementById('cardDetails');
            if (this.value === 'card') {
                cardDetails.style.display = 'block';
            } else {
                cardDetails.style.display = 'none';
            }
        });
    });
</script>
</body>
</html>

</html>


