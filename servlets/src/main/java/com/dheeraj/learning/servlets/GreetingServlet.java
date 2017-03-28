package com.dheeraj.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =response.getWriter();
		pw.print("hello");
		ServletContext context = this.getServletContext();
		pw.print(this.getServletContext().getRealPath("abc.html"));
		pw.print(context.getContextPath());
		pw.println("<br/>"+context.getMimeType("abc"));
		pw.println("<br/>"+context.getServerInfo());
		pw.println("<br/>"+context.getServletContextName());
		pw.println("<br/>"+context.getAttributeNames());
		pw.println("<br/>"+context.getServletNames());
		pw.println("<br/>"+request.getCharacterEncoding());
		pw.println("<br/>"+request.getContentLength());
		pw.println("<br/>"+request.getContentType());
		pw.println("<br/>"+request.getInputStream());
		pw.println("<br/>"+request.getProtocol());
		pw.println("<br/>"+request.getRemoteAddr());	
		pw.println("<br/>"+request.getRemoteHost());
		pw.println("<br/>"+request.getScheme());
		pw.println("<br/>"+request.getServerName());	
		pw.println("<br/>"+request.getServerPort());	
	}
}
