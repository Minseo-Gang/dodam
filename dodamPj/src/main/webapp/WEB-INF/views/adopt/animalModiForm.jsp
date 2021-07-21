<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<script>
$(document).ready(function() {
	var text = "${adoptVo.ad_adoptstate}";
	console.log(text);
	if(text == "입양가능") {
		$("#ad_adoptstate").text("입양가능").css("color", "red");
	} else if(text == "입양완료") {
		$("#ad_adoptstate").text("입양완료").css("color", "blue");
	}
});
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12" style="margin-top:10px; text-align:center;" >
			<img src="/resources/img/adoptBanner.jpg">
		</div>
	</div>
	<div class="row" style="margin-top:10px;">
		<div class="col-md-2">
 			<div class="border-end bg-white" id="sidebar-wrapper">
   				<div class="list-group list-group-flush">
                	<a class="list-group-item" style="background-color:#CCF2F4;">
                		<strong><i class="fas fa-paw"></i> 입양 관리</strong></a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/adopt/adoptInfo">- 입양 안내</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/adopt/applyAdopt">- 입양 신청</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/adopt/applyList">- 입양 신청 조회</a>
                </div>
            </div>
		</div>
	<div class="col-md-10">
		<h2>입양 가능 동물 등록</h2>
		<hr/>
			<div class="row">
				<div class="col-md-12">
					<form role="form" action="/adopt/animalModifyRun" method="post">
					<input type="hidden" name="ad_no" value="${adoptVo.ad_no}">
						<div class="form-group">
						<label for="ad_species">종류</label><br>
							<input type="text" class="form-control" id="ad_species" name="ad_species"
								value="${adoptVo.ad_species}" readonly/>
						</div>
						<div class="form-group">
						<label for="ad_kind">품종</label>
							<input type="text" class="form-control" id="ad_kind" name="ad_kind" value="${adoptVo.ad_kind}"/>
						</div>
						<div class="form-group">
						<label for="ad_color">색상</label>
							<input type="text" class="form-control" id="ad_color" name="ad_color" value="${adoptVo.ad_color}"/>
						</div>
						<div class="form-group">
						<label for="ad_gender">성별</label><br>
							<input type="text" class="form-control" id="ad_gender" name="ad_gender" 
								value="${adoptVo.ad_gender}" readonly/>
						</div>
						<div class="form-group">
						<label for="ad_age">나이</label>
							<input type="text" class="form-control" id="ad_age" name="ad_age" value="${adoptVo.ad_color}"/>
						</div>
						<div class="form-group">
						<label for="ad_weight">체중</label>
							<input type="text" class="form-control" id="ad_weight" name="ad_weight" value="${adoptVo.ad_weight}"/>
						</div>
						<div class="form-group">
						<label for="ad_findplace">발견장소</label>
							<input type="text" class="form-control" id="ad_findplace" name="ad_findplace" value="${adoptVo.ad_findplace}"/>
						</div>
						<div class="form-group">
						<label for="ad_resqueday">구조일</label>
							<input type="text" class="form-control" id="ad_resqueday" name="ad_resqueday" value="${adoptVo.ad_resqueday}"/>
						</div>
						<div class="form-group">
						<label for="ad_adoptpossible">입양가능일</label>
							<input type="text" class="form-control" id="ad_adoptpossible" name="ad_adoptpossible" value="${adoptVo.ad_adoptpossible}"/>
						</div>
						<div class="form-group">
						<label for="ad_adoptstate">입양상태</label><br>
							현재 상태 : <span id="ad_adoptstate"></span><br>
							<input type="radio" name="ad_adoptstate" value="입양가능" checked/>입양 가능&nbsp;
							<input type="radio" name="ad_adoptstate" value="입양완료"/>입양 완료
						</div>
						<div class="form-group">
						<label for="ad_etc">기타정보</label>
							<textarea class="form-control" id="ad_etc" name="ad_etc">${adoptVo.ad_etc}</textarea>
						</div>
						<button type="submit" class="btn btn-success">수정</button>
						<a class="btn btn-info" href="/adopt/applyAdopt" style="margin-right:10px;">목록</a>
					</form>
					</div>
				</div>
			</div>			
		</div>
  	</div>

<%@ include file="../include/footer.jsp" %>