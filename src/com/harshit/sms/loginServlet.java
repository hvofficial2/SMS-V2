package com.harshit.sms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		processRequest(req,res);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = null;
		session	= ((HttpServletRequest) req).getSession();
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		if(name!=null && !name.trim().equals("") && pass.equals("admin")) {	
			session.setAttribute("log", "in");
			req.getRequestDispatcher("StudentController").include(req, res);
		}
		else {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.println("Incorrect Username or Password!");
			req.getRequestDispatcher("login").include(req, res);
			out.close();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		processRequest(req,res);
	}

}
