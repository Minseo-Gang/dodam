<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<script>
$(document).ready(function() {
// 	$(".pagination > li > a").click(function(e) {
// 		e.preventDefault();
// 		var page = $(this).attr("href");
// 		var frmPaging = $("#frmPaging");
// 		frmPaging.find("[name=page]").val(page);
// 		frmPaging.submit();
// 	});
	
// 	$(".searchType").click(function(e) {
// 		e.preventDefault();
// 		var searchType = $(this).attr("href");
// 		$("#frmPaging > input[name=searchType]").val(searchType);
// 		$("#spanSearchType").text($(this).text());
// 	});
	
// 	$("#btnSearch").click(function() {
// 		var searchType = $("#frmPaging > input[name=searchType]").val();
// 		if(searchType == "") {
// 			alert("검색 옵션을 선택해 주세요");
// 			return;
// 		}
// 		var keyword = $("#searchTxt").val().trim();
// 		if(keyword == "") {
// 			alert("검색어를 입력해 주세요");
// 			return;
// 		}
		
// 		$("#frmPaging > input[name=keyword]").val(keyword);
// 		$("#frmPaging > input[name=page]").val("1");
// 		$("#frmPaging").submit();
// 	});
});
</script>

<form id="frmPaging" action="/adopt/applyAdopt" method="get">
	<input type="hidden" name="page" value="${aPagingDto.page}"/>
	<input type="hidden" name="perPage" value="${aPagingDto.perPage}"/>
	<input type="hidden" name="searchType" value="${aPagingDto.searchType}"/>
	<input type="hidden" name="keyword" value="${aPagingDto.keyword}"/>
</form>

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
	<div class="col-md-10" style="margin-bottom:0px;">
		<h2>입양 신청</h2>
		<hr/>		
		<div class="row">
			<div class="col-md-12">
				<section class="py-5">
					<div class="container px-4 px-lg-5 mt-5">
						<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
						<c:forEach var="adoptVo" items="${adList}">
							<div class="col mb-5">
								<div class="card h-100">
									<a href="/adopt/animalCont?ad_no=${adoptVo.ad_no}"><img class="card-img-top" src="http://localhost/adopt/displayImage?fileName=${adoptVo.ad_picture}" alt="..." /></a>
									<div class="card-body" style="padding:0px; margin-top:5px; margin-right:5px;">
										<ul style="padding-left:30px;">
											<li><span>종류 : </span>${adoptVo.ad_species}</li>
											<li><span>품종 : </span>${adoptVo.ad_kind}</li>
											<li><span>성별/나이 : </span>${adoptVo.ad_gender}/${adoptVo.ad_age}</li>
											<li><span>입양상태 : </span>${adoptVo.ad_adoptstate}</li>
										</ul>
									</div>
									<div class="card-footer pt-0 border-top-0 bg-transparent">
										<div class="text-center">
										<a class="btn btn-outline-dark mt-auto" style="margin-bottom:2px;"
													href="/adopt/applyForm?ad_no=${adoptVo.ad_no}">상담 예약</a><br>
											<a class="btn btn-sm btn-outline-warning" href="/adopt/animalModiForm?ad_no=${adoptVo.ad_no}">수정</a>
											<a class="btn btn-sm btn-outline-danger" href="/adopt/animalDeleteRun?ad_no=${adoptVo.ad_no}">삭제</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>						
						</div>
					</div>
				</section>
			</div>
		</div>
		<a class="btn btn-primary" href="/adopt/animalInsertForm">+ 새 동물</a>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>