<%@page import="pack.member.ZipcodeDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr"/>

<%
request.setCharacterEncoding("utf-8");

String check = request.getParameter("check");	// y(동이름 입력화면 출력) or n
String dongname = request.getParameter("dongname");

ArrayList<ZipcodeDto> zlist = memberMgr.zipcodeRead(dongname);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/board.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
window.onload = () =>{
	document.querySelector("#btnZipFind").onclick = dongcheck;
	document.querySelector("#btnZipClose").onclick = function(){
		window.close();
	};
	
}

function dongcheck() {
	if(zipForm.dongname.value === ""){
		alert("검색할 동이름을 입력하셋");
		zipForm.dongname.focus();
		return;
	}
	zipForm.submit();
}

function sendFunc(code, a1, a2, a3, a4){
	opener.document.regForm.zipcode.value = code;
	const addr = a1 + " " + a2 + " " + a3 + " " + a4;
	opener.document.regForm.address.value = addr;
	window.close();	// 주소 검색창 닫기
}

</script>
</head>
<body>
<b>*** 우편자료 찾기 ***</b>
<form action="zipcheck.jsp" name="zipForm" method="get">
<table>
	<tr>
		<td>
		동 이름 입력 : <input type="text" name="dongname">
		<input type="button" value="검색" id="btnZipFind">
		<input type="button" value="창닫기" id="btnZipClose">
		<input type="hidden" name="check" value="n">
		</td>
	</tr>
</table>
</form>

<%
if(check.equals("n")){
	if(zlist.isEmpty()){
		%>
		<b>검색 결과가 없습니다 ㅜㅜ 까비</b>
		<%
	}else{
		%>
		<table>
			<tr>
				<td style="text-align: center;">
				검색 자료를 클릭하면 자동으로 주소가 입력됩니당
				</td>
			</tr>
			<tr>
				<td>
				<%
				for(int i=0; i<zlist.size(); i++){
					ZipcodeDto dto = zlist.get(i);
					String zipcode = dto.getZipcode();
					String area1 = dto.getArea1();
					String area2 = dto.getArea2();
					String area3 = dto.getArea3();
					String area4 = dto.getArea4();
					if(area4 == null) area4 = "";
					%>
					<a href="javascript:sendFunc('<%=zipcode %>', '<%=area1 %>', '<%=area2 %>', '<%=area3 %>', '<%=area4 %>')">
					<%=zipcode %> <%=area1 %> <%=area2 %> <%=area3 %> <%=area4 %>
					</a>
					<br>
					<%
				}
				%>
				</td>
			</tr>
		</table>
		<%
	}
}
%>

</body>
</html>