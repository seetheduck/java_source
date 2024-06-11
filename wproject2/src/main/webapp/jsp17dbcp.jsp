<%@page import="pack.sangpumDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="connP" class="pack.ConnPooling" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function funcUp() {
	let code = prompt("수정할 코드번호 입력", "");
	if(code !== "" && code !== null){
		location.href="jsp17up.jsp?code=" + code;
	}
	
}

function funcDel() {
	let code = prompt("삭제할 코드번호 입력","");
	if(code !== "" && code !== null){
		if(confirm("진짜로 삭제하나요;;")){
			location.href="jsp17del.jsp?code=" + code;
		}
	}
	
}

</script>
</head>
<body>
<h2>* 상품 정보(DBCP) *</h2>
클라이언트와 서버 사이드인 웹 어플리케이션에서 사용자의 요청에 따라 Connection이 생성된다면 수 많은 사용자가 요청을 했을 때 서버에 과부하가 걸리게 된다.
이러한 상황을 예방하기 위해 미리 일정 갯수의 Connection 객체를 만들어 Pool에 저장하고 사용자의 요청이 발생하면 Connection을 제공하고 사용자와의 연결이 종료된다면 Pool에 다시 반환하여 보관하는 것을 의미한다.
<hr>
<a href="jsp17ins.html">추가</a>&nbsp;&nbsp;
<a href="javascript:funcUp()">수정</a>&nbsp;&nbsp;
<a href="javascript:funcDel()">삭제</a>
<br><br>
<table border="1">
	<tr>
		<th>코드</th><th>품명</th><th>수량</th><th>단가</th>
	</tr>
	<%
	ArrayList<sangpumDto> slist = connP.getDataAll();
	//out.println(slist.size());
	for(sangpumDto s:slist){
		%>
		<tr>
			<td><%=s.getCode() %></td>
			<td><%=s.getSang() %></td>
			<td><%=s.getSu() %></td>
			<td><%=s.getDan() %></td>
		</tr>
		<%
	}
	
	%>
</table>

</body>
</html>