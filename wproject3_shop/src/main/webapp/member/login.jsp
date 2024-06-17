<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = (String)session.getAttribute("idKey");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/board.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
<script type="text/javascript">
window.onload = () =>{
	//document.querySelector("#btnLogin").addEventListner("click", funcLogin);
	document.querySelector("#btnLogin").onclick = funcLogin;
	document.querySelector("#btnNewmember").onclick = funcNewmember;
	
}
</script>
</head>
<body>
<%
if(id != null){	// 로그인 한 경우
	%>
	<!-- 
	<b><%=id %></b>님~~ 환영해유~~~~~~<p/>
	이제부터 저희의 기능들을 이용할 수 있겠네용 ㅎㅎ<br>
	<a href="logout.jsp">로그아웃</a>
	 -->
	 <script type="text/javascript">
	 	location.href="../guest/guest_index.jsp";
	 </script>
	 	
	<%
}else{	// 안 한 경우
	%>
	<form name="loginForm">
	<table>
		<tr>
			<td colspan="2">* 회원 로그인 *</td>
		</tr>
		<tr>
			<td>아이디 : </td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type="text" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="로 그 인" id="btnLogin">
				<input type="button" value="회원가입" id="btnNewmember">
			</td>
		</tr>
	</table>
	</form>
	<%
}

%>
</body>
</html>