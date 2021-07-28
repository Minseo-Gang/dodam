
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminHeader.jsp"%>
<!-- 공지사항 수정처리 / 관리자 페이지에서 사용 -->

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<img style="margin-top: 10px; text-align: center;"
				src="/resources/img/centerBanner.jpg">
			<div class="row" style="margin-top: 10px;">
				<div class="col-md-2">
					<div class="border-end bg-white" id="sidebar-wrapper">
						<div class="list-group list-group-flush">
							<a class="list-group-item" style="background-color: #CCF2F4;">
								<strong><i class="fas fa-paw"></i> 봉사활동</strong>
							</a> <a
								class="list-group-item list-group-item-action list-group-item-light p-3"
								href="/notice/noticeList">- 공지사항</a> <a
								class="list-group-item list-group-item-action list-group-item-light p-3"
								href="/notice/procedure">- 보호절차</a> <a
								class="list-group-item list-group-item-action list-group-item-light p-3"
								href="/notice/map">- 오시는길</a>
						</div>
					</div>
				</div>

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
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>