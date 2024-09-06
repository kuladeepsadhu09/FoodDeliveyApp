package com.tap.serveluates;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daointerface.daointerfaceuser;
import com.tap.implem.UserDaoImpl;
import com.tap.model.usermodel;

@WebServlet("/updateprofile")
public class editprofileservalate extends HttpServlet {
	private HttpSession session;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
	    session=request.getSession();
		if(password.equals(cpassword) && password!=null) {
			System.out.println("in jsp email");
			String name=request.getParameter("name");
			String email= request.getParameter("email");
			String addres= request.getParameter("addres");
			String mn=request.getParameter("mobilenumber");
			usermodel us= new usermodel(name,email,mn,password,addres);
			daointerfaceuser usda= new UserDaoImpl();
			int status=usda.updateuser(us);
			if(status!=0) {
				response.sendRedirect("updateSucees.jsp");
			}
			else {
				response.sendRedirect("SomethingWrong.jsp");
			}
			
		}
		else {
			response.sendRedirect("WrongCPassword.jsp");
			
		}
	}

}
