<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- <!-- 공지사항 리스트 쓰이는곳 많음 -->
<style>
#btnWrite {
	margin-left: 50px;
}

#search {
	
}
</style>
<script>
	$(document).ready(function() {
		// 페이지 번호
		$(".pagination > li > a").click(function(e) {
			e.preventDefault(); // 페이지 이동 막기
			var page = $(this).attr("href");
			var frmPaging = $("#frmPaging");
			frmPaging.find("[name=page]").val(page);
			frmPaging.submit();
			// -> 주소창에 : http://localhost/board/listAll?page=1&perPage=10&searchType=&keyword=
		});

		// 글제목  (10개)
		$(".a_title").click(function(e) {
			e.preventDefault(); // prevent:막다, 방지하다, default: 기본
			// $(this) -> 10개 중에서 클릭한 .a_title
			// attr: attribute(속성)
			var n_no = $(this).attr("data-nno"); // 489
			$("#frmPaging > input[name=n_no]").val(n_no);
			$("#frmPaging").attr("action", "/notice/content");
			$("#frmPaging").submit();
		});
	});
</script>
<br />
<br />
<br />
<form id="frmPaging" action="/notice/noticeList" method="get">
	<input type="hidden" name="page" value="${pagingDto1.page}" /> <input
		type="hidden" name="perPage" value="${pagingDto1.perPage}" /> <input
		type="hidden" name="searchType" value="${pagingDto1.searchType}" /> <input
		type="hidden" name="keyword" value="${pagingDto1.keyword}" /> <input
		type="hidden" name="n_no" />
</form>

<div class="row">
	<div class="col-md-12">
		<h2>공지사항</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성시간</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${noticeList }">
					<tr>

						<th class="border">${list.n_no }</th>
						<th class="border"><a class="a_title" href="#"
							data-nno="${list.n_no}">${list.n_title }</a></th>
						<th class="border">${list.n_readcount }</th>
						<th class="border">${list.n_date }</th>
					</tr>
				</c:forEach>
				${pagingDto1}
			</tbody>
		</table>
	</div>
</div>
<div class="row">
		<div class="col-md-12">
			<nav>
				<ul class="pagination justify-content-center">
				<c:if test="${pagingDto1.startPage != 1}">
					<li class="page-item">
						<a class="page-link" 
							href="${pagingDto1.startPage - 1}">&laquo;</a>
					</li>
				</c:if>
				<c:forEach var="v" begin="${pagingDto1.startPage}" 
								   end="${pagingDto1.endPage}">
					<li 
					
						<c:choose>
							<c:when test="${pagingDto1.page == v}">
								class="page-item active"
							</c:when>
							<c:otherwise>
								class="page-item"
							</c:otherwise>
						</c:choose>
						
					>
						<a class="page-link" href="${v}">${v}</a>
					</li>
				</c:forEach>
				<c:if test="${pagingDto1.endPage < pagingDto1.totalPage}">	
					<li class="page-item">
						<a class="page-link" 
							href="${pagingDto1.endPage + 1}">&raquo;</a>
					</li>
				</c:if>
				</ul>
			</nav>
		</div>
	</div>

<%@ include file="../include/footer.jsp"%>