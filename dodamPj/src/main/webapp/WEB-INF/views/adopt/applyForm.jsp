<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<script>
$(document).ready(function() {
	var text = "${adoptVo.ad_adoptstate}";
	if(text == "입양완료") {
		$("#noApply").text("※ 입양완료 상태로 상담 예약 불가").css("color", "red");
		$(".readonly").prop("readonly", true);
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
		<h2>입양 예약</h2>
		<hr/>
			<div class="row">
				<div class="col-md-12">
					<form role="form" action="/adopt/insertApplyRun" method="post">	
					<input type="hidden" name="ad_no" value="${adoptVo.ad_no}">
						<div class="form-group">
						<label for="ad_no">일련번호</label>
							<input type="text" class="form-control" id="ad_no" name="ad_no"
								value="${adoptVo.ad_no}" readonly/>
						</div>
						<div class="form-group">
						<label for="ad_adoptstate">입양상태&nbsp;</label><span id="noApply"></span>
							<input type="text" class="form-control" id="ad_adoptstate" name="ad_adoptstate" 
								value="${adoptVo.ad_adoptstate}" readonly/>
						</div>
						<div class="form-group">
						<label for="ad_kind">종류/품종</label>
							<input type="text" class="form-control" id="ad_kind" name="ad_kind"
								value="${adoptVo.ad_species}/${adoptVo.ad_kind}" readonly/>
						</div>
						<div class="form-group">
						<label for="ad_age">성별/나이</label>
							<input type="text" class="form-control" id="ad_age" name="ad_age"
								value="${adoptVo.ad_gender}/${adoptVo.ad_age}" readonly/>
						</div>
						<div class="form-group">
						<label for="user_name">입양자 성명</label>
							<input type="text" class="form-control readonly" id="user_name" name="user_name"/>
						</div>
						<div class="form-group">
						<label for="user_tel">연락처</label>
							<input type="text" class="form-control readonly" id="user_tel" name="user_tel"/>
						</div>
						<div class="form-group">
						<label for="adopt_date">상담 예정 날짜</label>
							<input type="text" class="form-control readonly" id="adopt_date" name="adopt_date"/>
						</div>
						<div class="form-group">
						<label for="adopt_time">상담 예정 시간</label>
							<input type="text" class="form-control readonly" id="adopt_time" name="adopt_time"/>
						</div>
						<div class="form-group">
						<label for="form_title">제목</label>
							<input type="text" class="form-control readonly" id="form_title" name="form_title"/>
						</div>
						<div class="form-group">
						<label for="form_content">내용</label>
							<textarea class="form-control readonly" id="form_content" name="form_content" 
							placeholder="상담하실 동물의 일련번호를 남겨주세요" ></textarea>
						</div>
						<div class="form-group">
						<label for="form_pw">비밀번호</label>
							<input type="password" class="form-control readonly" id="form_pw" name="form_pw"/>
						</div>
						<button type="submit" class="btn btn-success">작성</button>
						<a class="btn btn-info" href="/adopt/applyAdopt" style="margin-right:10px;">목록</a>
					</form>
					</div>
				</div>
			</div>			
		</div>
  	</div>

<%@ include file="../include/footer.jsp" %>