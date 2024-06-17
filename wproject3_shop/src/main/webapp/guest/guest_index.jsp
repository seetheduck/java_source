<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<table>
	<tr>
		<td style="font-size: 24px;">특별 상품 전문 쇼핑몰</td>
	</tr>
</table>

<%@ include file="guest_top.jsp" %>
<table>
	<%
	if(memid != null){	// 로그인 성공 시
		%>
		<tr style="text-align: center;">
			<td>
				<br><br><br><br><br><br><br>
				<%=memid %>님 방문 감사요~
				<img src="../images/pic2.gif"/>
			</td>
		</tr>
		<%
	}else{
		%>
		<tr style="text-align: center;">
			<td style="font-size: 22px; background-image:url(../images/pic.jpg); background-size: 100%">
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				고객님 어서오세요
				<br><br><br>
				로그인 후 이용 바람요,,
			</td>
		</tr>
		<%
	}
	%>
</table>

<%@ include file="guest_bottom.jsp" %>

</body>
</html>