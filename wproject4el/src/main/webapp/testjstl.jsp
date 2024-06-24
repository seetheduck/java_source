<%@page import="pack.Student"%>
<%@page import="pack.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전통적 : Hi <%=request.getAttribute("irum") %>
<%
out.println(request.getAttribute("irum"));
%>
<br>
EL : Hello ${irum} ${requestScope.irum }
<br><br>
전통적 : <% Person p = (Person)request.getAttribute("person"); %>
<%=p.getName() %>
<% Student s = (Student)request.getAttribute("student"); %>
<%=s.getAge() %>
<br>
EL : ${requestScope.person.name} ${student.age} 
<br><br>
동물 : ${ani[0]} ${ani[1]} ${ani["2"]}
<br><br>
<c:if test="${list != null}">
	<c:forEach var="a" items="${list}">
		${a[0]}, ${a[1]}, ${a[2]}
	</c:forEach>
</c:if>
<br>
<c:if test="${list != null}">
	<c:forEach var="a" items="${list}">
		<c:forEach var="b" items="${a}">
			${b}
		</c:forEach>
		<br>
	</c:forEach>
</c:if>
<br>
<c:choose>
	<c:when test="${list eq null}">자료 없음</c:when>
	<c:otherwise>자료 있음</c:otherwise>
</c:choose>

<hr>
예외 처리<br>
<c:catch var="myErr">
	<%
	int a = 10 / 0;
	out.println("a : " + a);
	%>
</c:catch>
<c:if test="${myErr != null}">
	에러 발생 : ${myErr.message}
</c:if>
<hr>
계속
<br>다른 문서 포함<br>
include 지시어 사용 : <%@include file="poham.jsp" %>
<br>
jstl 사용 : <c:import url="poham.jsp"/>
<hr>
<!-- 
<c:import url="https://daum.net"></c:import>
 -->
<c:set var="url" value="https://www.naver.com"/>
<c:import url="${url}" var="u"/>
<c:out value="${url}"></c:out>
<c:out value="${u}"></c:out>

</body>
</html>

