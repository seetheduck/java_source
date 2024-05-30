$(document).ready(function(){
	// html 문서를 text로 읽기
	$('#test1').click(function(){
		//alert("a");
		$("#disp").empty();
		
		//$("disp").load("jq04.html");
		$("#disp").hide().load("jq04.html", function(){
			$(this).fadeIn();	// effect 처리
		});
		
	});
	
	// json 읽기
	$('#test2').click(function(){
		$("#disp").empty();
		
		$.getJSON('jq04json.jsp', function(datas){
			//alert(datas);
			//$('#disp').text(datas);
			
			let items = [];
			let str = "<ul>";
			$.each(datas.sangpum, function(index, data){
				//alert(index + " " + data);
				str += "<li>" + (index + 1) + ") " + data["code"] + " " + data["sang"] + " " + data["su"] + " " + data.dan + "</li>";
				items.push(str);
			});
			str += items.join('') + "</ul>";
			// 배열의 모든 항목을 하나의 문자열로 결합
				
			$("#disp").html(items);
		});
		
	});
	
	// xml 읽기
	$('#test3').click(function(){
		//alert("3");
		$.get('jq04xml.jsp', function(datas){
			//alert(datas);
			// 하위 element(요소)를 검색할 때 find()
			//alert($(datas).find('sangpum').length);
			$("disp").empty();
			
			$(datas).find('sangpum').each(function(){
				let sangpum = $(this);
				let str = "<div>";
				str += sangpum.find('code').text() + " ";
				str += sangpum.find('sangirum').text() + " ";
				str += sangpum.find('su').text() + " ";
				str += sangpum.find('dan').text() + " ";
				str += "</div>";
				$("#disp").append(str);
			});
		}).fail(function(){
			$('#disp').text('test3 처리 오류');
		});	
	});
	
	// json 읽기 2
	$('#test4').click(function(){
		//alert('4');
		$("#disp").empty();
		
		$.ajax({
			type:"post",		// 요청 방식 post
			url:'jq04json.jsp',
			//data:{'code':3, 'sang':'book'},	// jq04json.jsp?code=3
			dataType:'json',	// 반환 type
			success:function(datas){
				//alert(datas);
				let str = "";
				let count = 0;
				str += "<table border='1'>";
				str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
				
				$.each(datas.sangpum, function(idx, data){
					str += "<tr>";
					str += "<td>" + data['code'] + "</td>";
					str += "<td>" + data['sang'] + "</td>";
					str += "<td>" + data['su'] + "</td>";
					str += "<td>" + data['dan'] + "</td>";
					str += "</tr>";
					count++;
				});
				str += "</table>";
				$('#disp').append(str);
				$('#disp').append(`건수 : ${count}`);
				
				
			},error:function(){
				$("disp").text('test4 처리오류');
			}
		});
		
	});
	
	// xml 읽기 2
	$('#test5').on("click", function(){
		//alert('5');
		$("#disp").empty();
		
		$.ajax({
			type:"post",		// 요청 방식 post
			url:'jq04xml.jsp',
			//data:{'code':3, 'sang':'book'},	// jq04json.jsp?code=3
			dataType:'xml',	// 반환 type
			success:function(datas){
				//alert(datas);
				let count = 0;
				let str = "<table border='1'>";
				str += "<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>";
				
				$(datas).find('sangpum').each(function(){
					str += "<tr>";
					str += "<td>" + $(this).find("code").text() + "</td>";
					str += "<td>" + $(this).find("sangirum").text() + "</td>";
					str += "<td>" + $(this).find("su").text() + "</td>";
					str += "<td>" + $(this).find("danga").text() + "</td>";
					str += "</tr>";
					count++;
				});
				str += "</table>";
				$('#disp').append(str);
				$('#disp').append(`건수(xml) : ${count}`);
				
				
			},error:function(){
				$("disp").text('test5 처리오류');
			}
		});
		
		
		
	});
	
	
});