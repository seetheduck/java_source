<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
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
JSTL은 JavaServer Pages Standard Tag Library의 약어
Java 코드를 바로 사용하지 않고 HTML 태그 형태로 직관적인 코딩을 지원하는 라이브러리다.
Java EE 기반의 웹 애플리케이션 개발 플랫폼을 위한 컴포넌트 모음
XML 데이터 처리와 조건문, 반복문, 국제화와 지역화와 같은 일을 처리하기 위한 JSP 태그 라이브러리
자신만의 태그를 추가할 수 있는 기능을 제공한다.

<br>
변수, 제어문 사용이 가능. 일반적으로 EL과 함께 사용!
<hr>
** 변수 처리 **<br>
<c:set var="irum" value="이기자" scope="page"></c:set>	<%-- page, request, session, application --%>
이름 : <c:out value="${irum}"></c:out>
<br>
<c:set var="ir" scope="session">
공기밥
</c:set>
이름 : <c:out value="${ir }"/>
<br>
<c:remove var="irum"/>
이름 : <c:out value="${irum }"></c:out>
<br>
<c:remove var="ir" scope="session"/>
이름 : <c:out value="${ir }"></c:out>
<br>
<c:set var="abc" value="${header['User-Agent']}" scope="page"></c:set>
abc 값은 (현재 사용 중인 브라우저 정보) : <c:out value="${abc }"></c:out>
<br>
<c:set var="su1" value="10"/>
<c:set var="su2" value="20"/>
두 수의 합은 ${su1 + su2}

<hr>
** 조건 판단문 if **<br>
<c:set var="nice" value="star"></c:set>

<c:if test="${nice == 'star' }"> <%-- ${nice eq 'star' }--%>
	if 연습 : nice 값은 <c:out value="${nice }"></c:out>
</c:if>
<p/>
** 조건 판단문 choose **<br>
<c:choose>
	<c:when test="${nice == 'moon' }">
		달 <c:out value="${nice}"></c:out>
	</c:when>
	<c:when test="${nice == 'star' }">
		별 <c:out value="${nice}"></c:out>
	</c:when>
	<c:otherwise>어떠한 조건도 만족 못하면 ㅜ</c:otherwise>
</c:choose>
<br>
<c:choose>
	<c:when test="${empty param.myid }">
		<form>
			아이디 : <input type="text" name="myid">
			<input type="submit">
		</form>
	</c:when>
	<c:when test="${param.myid == 'admin' }">
		와우 관리자군욤 ㅋㅋ
	</c:when>
	<c:otherwise>
		환영요 ㅋ 회원 <c:out value="${param.myid }"/>님
	</c:otherwise>
</c:choose>
<hr>
** 반복문 forEach **<br>
연습 1 : 
<c:forEach var="i" begin="1" end="10" step="2">
	${i}&nbsp;&nbsp;
</c:forEach>
<br>
구구단 3단<br>
<c:forEach var="i" begin="1" end="9">
	3 * ${i} = ${3 * i}<br>
</c:forEach>
<br>
<%
HashMap<String, Object> map = new HashMap<>();
map.put("name", "한국인");
map.put("today", new Date());

%>

<c:set var="m" value="<%=map %>"></c:set>
<c:forEach var="i" items="${m}">
	${i.key} - ${i.value}<br>
</c:forEach>
<br>
배열 생성 후 출력<br>
<c:set var="arr" value="<%=new int[]{1,2,3,4,5} %>"/>
<c:forEach var="a" items="${arr}" begin="2" end="4" step="1">
	${a}&nbsp;
</c:forEach>
<br>
* 문자열 분할 후 출력 * <br>
<c:forTokens var="animal" items="horse,dog,cat,lion,tiger,pig" delims=",">
	동물 : ${animal}&nbsp;
</c:forTokens>

<hr>
** 숫자 및 날짜 서식 **<br>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
숫자 : <fmt:formatNumber value="12345.678" type="number"/><br>
숫자 : <fmt:formatNumber value="12345.678" type="number" pattern="#,##0"/><br>
숫자 : <fmt:formatNumber value="12345.678" type="currency"/><br>
숫자 : <fmt:formatNumber value="0.123" type="percent"/><br>
숫자 : <fmt:formatNumber value="12345.678" pattern="#,##0.0"/><br>
숫자 : <fmt:formatNumber value="12345.678" pattern="0,000.0"/><br>
숫자 : <fmt:formatNumber value="12" pattern="0,000.0"/><br>
<br>
<c:set var="now" value="<%=new Date() %>"/>

날짜 : <fmt:formatDate value="${now}" type="date"/><br>
시간 : <fmt:formatDate value="${now}" type="time"/><br>
모두 : <fmt:formatDate value="${now}" type="both"/><br>
모두 : <fmt:formatDate value="${now}" type="both" pattern="yyyy년 MM월 dd일"/><br>





</body>
</html>