package com.tap.serveluates;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.tap.daointerface.daointerfaceuser;
import com.tap.implem.UserDaoImpl;
import com.tap.model.usermodel;
@WebServlet("/loginservelete")
public class loginservelete extends HttpServlet {
	private usermodel usdata;
	private HttpSession session;
	private PrintWriter pr;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email= req.getParameter("email");
			String password= req.getParameter("password");
			daointerfaceuser us=new UserDaoImpl();
			usdata=us.getuser(email);
			session=req.getSession();
			if(usdata.getPassword().equals(password)) {
				resp.sendRedirect("index.jsp");
				session.setAttribute("user",usdata);
			}
			else {
				resp.sendRedirect("WrongPassword.jsp");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("WrongPassword.jsp");
		}
		
	}

}
