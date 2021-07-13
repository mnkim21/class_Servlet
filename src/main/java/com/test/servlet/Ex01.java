package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. 서블릿 클래스 선언
// a. javax.servlet.http.HttpServlet
public class Ex01 extends HttpServlet {
	
	// 2, doGet/ doPost 메소드 선언
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// 3. 동적 HTML 문서 작성 구현
		PrintWriter writer = response.getWriter();
		
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<h1>Number</h1>");
		Random rnd = new Random();
		writer.write("<div>num: " + rnd.nextInt(100) + "</div>");
		writer.write("</body>");
		writer.write("</html>");
		
		writer.close();
		
	}
}
