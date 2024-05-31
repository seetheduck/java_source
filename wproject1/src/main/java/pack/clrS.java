package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class clrS
 */
@WebServlet("/clrS")
public class clrS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) return;
		
		ArrayList<score> exs = (ArrayList<score>)session.getAttribute("grade");
		if(exs == null) return;
		
		session.removeAttribute("grade");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p><table width='80%'>");
		out.println("<tr><th>번호</th><th>이름</th><th>국어</th><th>영어</th><th>총점</th></tr>");
		int cnt = 0;
		out.println("<br></table>");
		out.println("인원 수 : " + cnt);
		out.println("<br><br>[<a href='exam.html'>새로 입력</a>]&nbsp;&nbsp;");
		out.println("[<a href='#'>세션 삭제</a>]");
		out.println("</body></html>");
		out.close();
	}

}
