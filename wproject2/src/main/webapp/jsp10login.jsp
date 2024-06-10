<%@page import="java.util.Base64"%>
<%@page import="java.util.Date"%>
<%@page import="io.jsonwebtoken.Jwts"%>
<%@page import="javax.servlet.*"%>
<%@page import="java.security.Key"%>
<%@page import="io.jsonwebtoken.security.Keys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

// 인증(Authentication) : 실제는 DB 정보를 읽어 확인
String validId = "ok";
String validPassword = "123";

if(id != null && password != null && id.equalsIgnoreCase(validId) && password.equalsIgnoreCase(validPassword)){
	// 인증이 되면 JWT 생성(비밀키와 서명, 만료 시간등을 설정)
	// 생성된 JWT를 클라이언트 storage 또는 cookie에 저장.
	// 이후 성공 페이지로 이동
	// 고정된 비밀키 (예제용) 최소 
	
	// 고정된 비밀 키 사용 (예제용)  최소 256비트 길이의 비밀 키
	//String secretKeyString = "mySuperSecretKey12345678901234567890123456789012";
	//Key secretKey = Keys.hmacShaKeyFor(secretKeyString.getBytes());
	// key byte array를 기반으로 적절한 HMAC 알고리즘을 적용한 Key(java.security.Key) 객체를 생성
	
	// 위의 작업을 주석 처리하고 아래 내용으로 변경하자.
    // 서블릿 컨텍스트에서 Base64로 인코딩된 비밀 키 가져오기  java.util.Base64
    String encodedKey = (String) getServletContext().getAttribute("secretKey");
    byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
    Key secretKey = Keys.hmacShaKeyFor(decodedKey);
	
	
	long expirationTime = 3600000;	// 1시간 (밀리초)
	
	// JWT 생성 : 문자열로 반환되며 인증 및 권한 부여 매커니즘에서 주로 사용
	String jwt = Jwts.builder().
						setSubject(id).	// id, 사용자 식별자, 주제등이 포함된 클레임을 설정
						setIssuedAt(new Date()).	// 클레임 내용 중 lat : 발행시간
						setExpiration(new Date(System.currentTimeMillis() + expirationTime)).	// 클레임 내용 중 exp : 만료시간
						signWith(secretKey).	// 서명 알고리즘, 비밀치 설정(무결성 보장이 목적)
						compact();	// JWT 생성
	// 쿠키에 jwt를 저장
	Cookie jwtCookie = new Cookie("jwt", jwt);
	jwtCookie.setHttpOnly(true);
	jwtCookie.setPath("/");	// 모든 경로에서 쿠키 접근 가능
	response.addCookie(jwtCookie);
	
	
	// 성공한 경우 보여줄 페이지로 이동
	response.sendRedirect("jsp10success.jsp");	// success.html
} else{
	// 실패한 경우 처리 작업
	out.println("<html><body>");
	out.println("<h3>로그인 실패</h3>");
	out.println("<a href='jsp10jwtlogin.html'>다시 시도</a>");
	out.println("</body></html>");
	
}


%>