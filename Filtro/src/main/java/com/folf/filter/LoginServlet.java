package com.folf.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String userName = "admin";
	private final String userPassword = "admin";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hola ::");
		// recuperamos los valores del usuario
		String user = request.getParameter("usuario");
		String pass = request.getParameter("password");
		if (userName.equals(user) && userPassword.equals(pass)) {
			System.out.println("Nombre ::" + user + "Pass ::" + pass);
			HttpSession session = request.getSession();
			session.setAttribute("usuario", user);
			// tiempo de expiración de la sesión
			session.setMaxInactiveInterval(1 * 60);
			Cookie userName = new Cookie("usuario", user);
			userName.setMaxAge(1 * 60);
			response.addCookie(userName);
		}
	}
}
