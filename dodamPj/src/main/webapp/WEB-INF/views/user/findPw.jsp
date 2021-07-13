<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 패스워드 찾기 -->
<script>
	$(document).ready(function(){
		$("#btnFind").click(function(e){
			e.preventDefault();
			
			var user_name = $("#user_name").val();
			var phoneNum = $("#phoneNum").val();
			var user_id	= $("#user_id").val();
			var url = "/member/findPwRun";
			var sendData = {
				"user_name" : user_name,
				"phoneNum" : phoneNum,
				"user_id" : user_id
			}
			
			$.get(url,sendData, function(rData){
				console.log(rData.user_id);
				var pw = rData.user_pw;
				$("#findPw").text("회원님의 패스워드는: "+pw+" 입니다").css("color","black");
				$("#btnLogin").show();
			});
			
			$("#btnLogin").click(function(){
				location.href ="/member/memberLogin";
			});
		});
		
	});
</script>
<form action="/member/findIdRun" method="post">
<div>
	<label>가입된 아이디</label>
	<input type="text" id="user_id" name="user_name"/><br/>
</div>
	
	<label>가입된 이름</label>
	<input type="text" id="user_name" name="user_name"/><br/>
	<label>가입된 전화번호</label>
	<input type="text" id="phoneNum" name="phoneNum"/><br/>
	<span id="findPw"></span><br/>
	<button type="button" id="btnFind">찾기</button>
	<button type="button" id="btnLogin" style="display:none">로그인</button>
</form>
	
<%@ include file="../include/footer.jsp"%>