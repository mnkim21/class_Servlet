package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03_Receive extends HttpServlet {
	
	// 어긋나면 405 Error 발생
	// GET -> doGet() 호출
	// POST -> doPost() 호출
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 사용자가 입력한 한글이 깨지지 않도록
		req.setCharacterEncoding("UTF-8");
		
		// 사용자가 보낸 데이터를 서버에서 수신하는 방법
		String name = req.getParameter("name"); // <label>이름: <input type="text" name="name"></label>
		String age = req.getParameter("age"); // <label>나이: <input type="number" name="age"></label>
		
		// 브라우저에게 돌려줄 페이지의 한들이 깨지지 않도록
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1>결과페이지</h1>\r\n"
				+ "    \r\n"
				+ "    <div>이름: " + name + "</div>\r\n"
				+ "    <div>나이: " + age + "세</div>\r\n"
				+ "    <div>성인여부: " + (Integer.parseInt(age) >= 19 ? "성인" : "미성년") +"</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		writer.close();
	}

}
