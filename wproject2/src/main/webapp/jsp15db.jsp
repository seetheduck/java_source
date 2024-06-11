<%@page import="pack.connClass2"%>
<%@page import="pack.jikwonDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="connClass2" class="pack.connClass2"/>
<%
String buser = request.getParameter("buser");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b><%=buser %></b>내 근무 직원<br>
<table border="1">
	<tr>
		<th>직원번호</th><th>직원명</th><th>직급</th><th>성별</th>
	</tr>
	<%
	ArrayList<jikwonDto> jlist = connClass2.getData(buser);
	
	for(jikwonDto jik:jlist){
	%>
	<tr>
		<td><%=jik.getNo() %></td>
		<td><%=jik.getName() %></td>
		<td><%=jik.getJik() %></td>
		<td><%=jik.getGen() %></td>
	</tr>
	<%	
	}
	
	%>
</table>
근무 인원수 : <%=jlist.size() %>명 <br>
최대 연봉 : <%=connClass2.max %>만원 &nbsp;&nbsp;
최소 연봉 : <%=connClass2.min %>만원
</body>
</html>