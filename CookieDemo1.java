package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cartlink")
public class CookieDemo1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String product=req.getParameter("product");
		String price=req.getParameter("price");
		String add=req.getParameter("add");
		String show=req.getParameter("show");
		
		if(add!=null){
			Cookie c1 = new Cookie(product, price);
			resp.addCookie(c1);
			resp.sendRedirect("index.html");
		}else {
			Cookie[] data = req.getCookies();
			PrintWriter pw = resp.getWriter();
			for(int a=0;a<data.length;a++){
				pw.print("<h1>"+data[a].getName()+"\t\t"+data[a].getValue()+"</h1>");
			}
		}
		
	}
	
	

}
