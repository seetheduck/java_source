<!-- 
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	아래 내용은 소스 코드를 까보면 이 영역 내에 
}
 -->

<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 출력용 자바:jsp, 내부 처리용 자바:서블릿 -->
<h1>JSP의 이해</h1>
<%	// scriptlet : 자바 코드를 입력할 수 있는 영역
String irum = "한국인";	// service 메소드 내에 선언된 지역번수
System.out.println(irum);	// 서버 컴의 콘솔로 출력(개발자가 뭔가 출력하고자 할 때 사용)
// PrintWriter 객체 타입의 내장 객체 중 하나
out.println(irum + "님의 홈페이지닷"); // 클라이언트 브라우저로 출력
%>
<br>
<!-- expression(표현식), 출력문 1개만 적음, 출력문 뒤에 ;은 적지 않음 -->
<%= irum + "님의 홈페이지닷" %>
<br>
<h1>자바 만세</h1>
<h2>자바 만세</h2>
<h3>자바 만세</h3>
<h4>자바 만세</h4>
<h5>자바 만세</h5>
<h6>자바 만세</h6>

<%
for(int i=1; i<7; i++){
	out.print("<h" + i + ">");
	out.print("자바 파이팅");
	out.println("</h" + i + ">");
}
%>

현재 날짜 및 시간 <%= new Date() %>
<br>
<%
int a=0, sum=0;
do{
	a++;
	sum += a;
}while(a < 10);
out.println("10까지의 합은 " + sum);
%>
<br>
<%="10까지의 합은 " + sum %>

<hr>
<%= irum + "님의 전화번호는 " + junhwa %>

<%!
// 선언
String junhwa = "123-4432";	// 전역(멤버)변수

// 클래스 멤버 메소드
public int dataAdd(int su1, int su2){
	return su1 + su2;
}
%>

<%
/* error : 메소드 내의 메소드는 사용 불가
public int dataAdd(int su1, int su2){
	return su1 + su2;
}
*/
%>
<br>
<%= dataAdd(10, 20) %>



</body>
</html>