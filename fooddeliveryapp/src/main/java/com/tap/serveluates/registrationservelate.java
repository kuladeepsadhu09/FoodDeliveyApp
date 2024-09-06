package com.tap.serveluates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.tap.daointerface.daointerfaceuser;
import com.tap.implem.UserDaoImpl;
import com.tap.model.usermodel;

/**
 * Servlet implementation class registrationservelate
 */
@WebServlet("/regester")
public class registrationservelate extends HttpServlet {
	private PrintWriter pw;
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		pw=resp.getWriter();
		if(password.equals(cpassword) && password!=null) {
			String name=req.getParameter("name");
			String email= req.getParameter("email");
			String addres= req.getParameter("addres");
			String mn=req.getParameter("mobilenumber");
			usermodel us= new usermodel(name,email,mn,password,addres);
			daointerfaceuser usda= new UserDaoImpl();
			int status=usda.adduser(us);
			if(status!=0) {
				resp.sendRedirect("index.jsp");	
			}
			else {
				resp.sendRedirect("SomethingWrong.jsp");
			}
			
		}
		else {
			resp.sendRedirect("WrongCPassword.jsp");
			
		}
		
	}

}
