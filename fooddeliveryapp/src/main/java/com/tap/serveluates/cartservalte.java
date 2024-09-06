package com.tap.serveluates;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.cartitem;
import com.tap.model.menu;
import com.mysql.cj.Session;
import com.tap.daointerface.daointerfacemenu;
import com.tap.implem.menuDAOimpl;
import com.tap.model.cart;
@WebServlet("/cartservalte")
public class cartservalte extends HttpServlet {
	private menu menuitem;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		cart Cart = (cart)session.getAttribute("cart");
		if(Cart==null) {
			Cart= new cart();
			session.setAttribute("Cart", Cart);
			
		}
		String action= request.getParameter("action");
		if("add".equals(action)) {
			additemtocart(request,Cart);
		}
		else if("update".equals(action)) {
			updateitem(request,Cart);
		}
		else if("remove".equals(action)) {
			removeItem(request,Cart);
		}
		session.setAttribute("Cart", Cart);
		response.sendRedirect("cart.jsp");
	}

	private void removeItem(HttpServletRequest request, cart cart) {
		int itemid=Integer.parseInt(request.getParameter("itemId"));
		cart.remove(itemid);
		request.getSession().setAttribute("cart", cart);
	}

	private void updateitem(HttpServletRequest request, cart cart) {
		int itemid=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		cart.update(itemid, quantity);
		request.getSession().setAttribute("cart", cart);
	}

	private void additemtocart(HttpServletRequest request, cart cart) {
		int itemid=Integer.parseInt(request.getParameter("itemid"));
		daointerfacemenu menu= new menuDAOimpl();
		menuitem=menu.getspecficmenuitem(itemid);
		//HttpSession session = request.getSession();
		//session.setAttribute("restaruntId", menuitem.getResturantId());
		if(menuitem!=null) {
			cartitem item= new cartitem(
					menuitem.getMenuId(),
					menuitem.getResturantId(),
					menuitem.getMenuName(),
					menuitem.getPrice(),
					1,
					menuitem.getPrice()*1,
					menuitem.getImgPath()
					);
			cart.add(item);
			request.getSession().setAttribute("cart", cart);
		}
		
		
	}

}
