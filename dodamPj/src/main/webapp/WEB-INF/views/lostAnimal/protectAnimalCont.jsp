<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<style>  
table, tr, th, td { 
  border: 1px solid black; 
  border-collapse: collapse;
  margin-top: 10px;
}

table.table th {  
  background-color: silver;
}  

</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12" style="margin-top:5px; text-align:center;" >
			<img src="/resources/img/lostBanner.jpg">
		</div>
	</div>
	<div class="row" style="margin-top:10px;">
		<div class="col-md-2">
 			<div class="border-end bg-white" id="sidebar-wrapper">
   				<div class="list-group list-group-flush">
                	<a class="list-group-item" style="background-color:#CCF2F4;">
                		<strong><i class="fas fa-paw"></i> 유실/유기동물</strong></a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/lostAnimal/protectAnimal">- 보호중인 동물</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/lostAnimal/reportList">- 분실 신고</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/lostAnimal/infoGetAnimal">- 습득시 안내</a>
                </div>
            </div>
		</div>
	<div class="col-md-10" style="margin-bottom:0px;">
		<h2>동물 상세보기</h2>
		<hr/>
		<br>
			<div class="boardDetail">
				<div class="publicPhotoArea" style="text-align:center;">
					<img class="photoArea" src="/resources/img/mung.jpg" alt="분실된 동물사진" />
				</div>
				<table class="table">
					<colgroup>
						<col width="120"/>
						<col width="*"/>
						<col width="120"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>품종</th>
						<td colspan="3">[개]믹스견</td>
					</tr>
					<tr>
						<th>색상</th>
						<td colspan="3">연갈색</td>
					</tr>
					<tr>
						<th>성별</th>
						<td colspan="3">수컷</td>
					</tr>
					<tr>
						<th>나이/체중</th>
						<td colspan="3">6개월(추정)&nbsp;/ 1.2(Kg)</td>
					</tr>
					<tr>
						<th>발견장소</th>
						<td colspan="3">중구 성안동 886</td>
					</tr>
					<tr>
						<th scope="row">접수일시</th>
						<td>2021-07-10&nbsp;</td>
						<th scope="row">중성화</th>
						<td>아니오&nbsp;</td>
					</tr>
					<tr>
						<th>특징</th>
						<td colspan="3">입가에 피부병</td>
					</tr>
					<tr>
						<th>상태</th>
						<td colspan="3">보호중</td>
					</tr>
				</table>
			</div>
			<a class="btn btn-primary" href="/lostAnimal/protectAnimal">목록</a>
		</div>
  </div>
</div>  
<%@ include file="../include/footer.jsp" %>