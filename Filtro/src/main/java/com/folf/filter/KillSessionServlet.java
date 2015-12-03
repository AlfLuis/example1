package com.folf.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/KillSessionServlet")
public class KillSessionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				System.out.println("Eliminar sessión ::");
				HttpSession session = req.getSession(false);
				if (session != null) {
					session.invalidate();
				}		
	}
}	