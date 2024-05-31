package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Function;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

@WebServlet("/res")
public class res extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int num = Integer.parseInt(request.getParameter("num"));
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		
		HttpSession session = request.getSession(true);
		
		ArrayList<score> exs = (ArrayList<score>)session.getAttribute("grade");
		
		if(exs == null) {	// goods 객체를 담을 glist 생성
			exs = new ArrayList<score>();
		}
		
		exs.add(new score(num, name, kor, eng));
		session.setAttribute("grade", exs);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p><table width='80%'>");
		out.println("<tr><th>번호</th><th>이름</th><th>국어</th><th>영어</th><th>총점</th></tr>");
		int cnt = 0;
		for(int i=0; i<exs.size(); i++) {
			score sco = exs.get(i);
			out.println("<tr><td>" + sco.getNum() + "</td>");
			out.println("<td>" + sco.getName() + "</td>");
			out.println("<td>" + sco.getKor() + "</td>");
			out.println("<td>" + sco.getEng() + "</td>");
			out.println("<td>" + (sco.getKor() + sco.getEng()) + "</td></tr>");
			cnt++;
		}
		out.println("</table>");
		out.println("인원 수 : " + cnt);
		out.println("<br><br>[<a href='exam.html'>새로 입력</a>]&nbsp;&nbsp;");
		out.println("[<a href='clrS'>세션 삭제</a>]");
		
		out.println("</body></html>");
		out.close();
	}

	
}



