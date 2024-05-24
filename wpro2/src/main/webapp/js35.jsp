<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<sangpums>
<%
//sangdata 테이블을 읽어 xml 형식으로 출력
Connection conn;
PreparedStatement pstmt;
ResultSet rs;

try{
	Class.forName("org.mariadb.jdbc.Driver");
	
	String url="jdbc:mariadb://localhost:3306/test";
	conn = DriverManager.getConnection(url, "root", "123");
	pstmt = conn.prepareStatement("select * from sangdata");
	rs = pstmt.executeQuery();
	
	//rs.next();
	//out.print(rs.getString("sang"));
	while(rs.next()){
%>	
		<sangpum>
			<code><%= rs.getString("code") %></code>
			<sangirum><%= rs.getString("sang") %></sangirum>
			<su><%= rs.getString("su") %></su>
			<danga><%= rs.getString("dan") %></danga>
		</sangpum>
<%
	}
	
}catch(Exception e){
	System.out.println("에러 : " + e);
}finally{
	
}


%>
</sangpums>