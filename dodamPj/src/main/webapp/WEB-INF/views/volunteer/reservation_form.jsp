<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<!-- datepicker -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script>
$(document).ready(function() {
	$("#v_date").datepicker();	
});
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<img style="margin-top: 10px; text-align: center;"
				src="/resources/img/banner2.jpg">
		</div>
	</div>
	<div class="row" style="margin-top: 10px;">
		<div class="col-md-2">
			<div class="border-end bg-white" id="sidebar-wrapper">
				<div class="list-group list-group-flush">
					<a class="list-group-item" style="background-color: #CCF2F4;">
						<strong><i class="fas fa-paw"></i> 봉사활동</strong>
					</a> <a
						class="list-group-item list-group-item-action list-group-item-light p-3"
						href="/volunteer/reservation">- 봉사활동 예약</a> <a
						class="list-group-item list-group-item-action list-group-item-light p-3"
						href="/volunteer/volunReservList">- 봉사활동 현황</a>
				</div>
			</div>
		</div>
		<div class="col-md-10">
			<div class="jumbotron">
				<h2>봉사활동 신청 양식</h2>
			</div>
			<form id="frmReserv" role="form" action="/volunteer/reservVolun" method="post">
				<div class="form-group">
					<label for="v_name"> 이름 : </label> 
					<input type="text" class="form-control" id="v_name" name="v_name"/>
				</div>
				
				<div class="form-group">
					<label for="v_age"> 나이 : </label> 
					<input type="text"  id="v_age" name="v_age"/> 세
				</div>
				
				<div class="form-group">
					<label for="v_place">신청 지역 : </label> 
					<select name="v_place">
						<option value="남구">남구</option>
						<option value="중구">중구</option>
						<option value="북구">북구</option>
						<option value="동구">동구</option>
						<option value="울주군">울주군</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="v_date"> 신청 날짜 : </label>  
					<input type="text"  id="v_date" name="v_date">
				</div>
				
				<div class="form-group">
					<label for="v_time">신청 시간 : </label> 
					<select name="v_time">
						<option value="09:00 ~ 12:00">09:00 ~ 12:00</option>
						<option value="12:00 ~ 15:00">12:00 ~ 15:00</option>
						<option value="15:00 ~ 18:00">15:00 ~ 18:00</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="v_phonenum"> 연락처 : </label> 
					<input type="text" class="form-control" id="v_phonenum" name="v_phonenum"/>
				</div>
				
				<div class="form-group">
					<label for="v_email"> 이메일 : </label> 
					<input type="text" class="form-control" id="v_email" name="v_email"/>
				</div>
				
				<div class="form-group">
					<label for="v_etc"> 비고 : </label> 
					<input type="text" class="form-control" id="v_etc" placeholder="궁금한 점이나 문의사항이 있으면 글을 남겨주세요." name="v_etc"/>
				</div>
				<button type="submit" class="btn btn-primary" id="finish">신청하기</button>
			</form>
		</div>	
	</div>		
</div>
<%@ include file="../include/footer.jsp"%>