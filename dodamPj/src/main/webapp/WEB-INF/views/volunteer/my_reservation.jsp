<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp" %>
<script>


</script>
<div class="container mt-3">
  <h2>나의 예약 조회</h2>
  <br>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<tbody>
					<tr class="table-warning">
						<td>예약 번호</td>
						<td>${volunteerVo.v_no}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${volunteerVo.v_name}</td>
					</tr>
					<tr>
						<td>나이</td>
						<td>${volunteerVo.v_age}</td>
					</tr>
					<tr>
						<td>신청 지역</td>
						<td>${volunteerVo.v_place}</td>
					</tr>
					<tr>
						<td>신청 날짜</td>
						<td>${volunteerVo.v_date}</td>
					</tr>
					<tr>
						<td>신청 시간</td>
						<td>${volunteerVo.v_time}</td>
					</tr>
					<tr>
						<td>연락처</td>
						<td>${volunteerVo.v_phonenum}</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${volunteerVo.v_email}</td>
					</tr>
					<tr>
						<td>비고</td>
						<td>${volunteerVo.v_etc}</td>
					</tr>	
				</tbody>
			</table>
			<a type="button" class="btn btn-warning">예약 정보 변경</a>
			<a type="button" class="btn btn-danger">예약 취소</a>
		</div>
	</div>

</div>


<%@ include file="../include/footer.jsp" %>