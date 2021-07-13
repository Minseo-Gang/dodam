<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminHeader.jsp"%>
<!-- 공지사항 수정처리 / 관리자 페이지에서 사용 -->
<div class="row">
	<div class="col-md-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성시간</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list2 }">
					<tr>
						<td>${list.n_no }</td>
						<td>${list.n_title }</td>
						<td>${list.n_date }</td>
						<td><a href="/notice/noticeModifyForm?n_no=${list.n_no }">수정</a>
						<td><a href="/notice/noticeDeleteRun?n_no=${list.n_no }">삭제</a>

					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>

