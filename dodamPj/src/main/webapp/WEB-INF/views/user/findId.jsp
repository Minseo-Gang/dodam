<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 아이디 찾기 -->
<script>
	$(document).ready(function(){
		$("#btnFind").click(function(e){
			e.preventDefault();
			
			var user_name = $("#user_name").val();
			var phoneNum = $("#phoneNum").val();
			var url = "/member/findIdRun";
			var sendData = {
				"user_name" : user_name,
				"phoneNum" : phoneNum
			}
			var msg = "${msg}";
			$.get(url,sendData, function(rData){
				if(rData==""){
					$("#findId").text("정보와 일치 하는 아이디가 없습니다").css("color","red");
				} else {
					console.log(msg);
					console.log(rData);
					var id = rData;
					$("#findId").text("회원님의 아이디는: "+id+"입니다").css("color","black");
					$("#btnLogin").show();
				}
				
				
// 					$("#findId").text("정보와 일치 하는 아이디가 없습니다").css("color","red");
			
					
			
				
				
			});
			
			$("#btnLogin").click(function(){
				location.href ="/member/memberLogin";
			});
		});
		
	});
</script>
<form action="/member/findIdRun" method="post">
	<label>가입된 이름</label>
	<input type="text" id="user_name" name="user_name"/><br/>
	<label>가입된 전화번호</label>
	<input type="text" id="phoneNum" name="phoneNum"/><br/>
	<span id="findId"></span><br/>
	<button type="button" id="btnFind">찾기</button>
	<button type="button" id="btnLogin" style="display:none">로그인</button>
</form>
	
<%@ include file="../include/footer.jsp"%>