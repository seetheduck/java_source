<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>

<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

boolean b = memberMgr.loginCheck(id, passwd);

if(b){	// 로그인 성공 시
	session.setAttribute("idKey", id);
	response.sendRedirect("login.jsp");
}else{	// 로그인 실패 시
	response.sendRedirect("logfail.html");
}
%>