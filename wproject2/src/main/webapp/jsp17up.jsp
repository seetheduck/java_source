<%@page import="pack.sangpumDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String code = request.getParameter("code"); %>
<jsp:useBean id="connP" class="pack.ConnPooling"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
sangpumDto dto = connP.updateData(code);
if(dto == null){
	%>
	<script type="text/javascript">
	alret("등록된 상품 코드가 아닌디 ㅋㅋ\n 수정 불가 ㅋㅋ");
	//history.back();
	location.href="jsp17dbcp.jsp";
	</script>
	
	<%
	return;
}
%>

** 상품 수정 **<br>
<form action="jsp17upok.jsp" method="post">
코드 : <%=dto.getCode() %><br>
<input type="hidden" name="code" value="<%=dto.getCode()%>">
품명 : <input type="text" name="sang" value="<%=dto.getSang()%>"><br>
수량 : <input type="text" name="su" value="<%=dto.getSu()%>"><br>
단가 : <input type="text" name="dan" value="<%=dto.getDan()%>"><br>
<br>
<input type="submit" value="자료 수정">
<input type="button" value="수정 취소" onclick="javascript:location.href='jsp17dbcp.jsp'">

</form>
</body>
</html>