<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>

<%
String id = request.getParameter("id");
boolean b = memberMgr.idCheckProcess(id);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>id검사요</title>
<link href="../css/board.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
</head>
<body style="text-align: center; margin-top: 30px;">
<b><%=id %></b>
<%
if(b){
	%>
	: 이미 사용중인 아이디요.......<p/>
	<a href="#" onclick="opener.document.regForm.id.focus();window.close()">닫기</a>
	<%
}else{
	%>
	: 사용 가 능 한 아 이 딩<p/>
	<a href="#" onclick="opener.document.regForm.passwd.focus();window.close()">닫기</a>
	
	<%
}
%>
</body>
</html>