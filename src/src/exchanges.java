package src;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quartz.*;

@WebServlet("/api/renew")
public class Exchanges extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		try {
			out.print(this.getServletContext().getAttribute("Crawling"));
		} catch (Exception e) {
			
		} finally {
			out.close();
		}
		
		//서블릿 컨텍스트
				//HttpSession session -> 요청이 몇번 들어와도 같은 브라우저에서 온 거는 계속 세션에 저장됨. 
		//ServletContext context = new ServletContext();
				//context.setAttribute("crawlingResult", jsonMaker(map) + jsonMaker2(calculator)); set을 크롤러에서 해주고 겟으로 exchanges에서 받아줌. set이 되기 전에 get을 하는 
				//경우를 대비해 예외 처리.
				
	}
}
