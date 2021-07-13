<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%-- ${list } --%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<img style="margin-top:10px; text-align:center;" src="/resources/img/banner.jpg">
		</div>
	</div>
		<div class="row">
			<div class="col-md-8"></div>
			<div class="col-md-4">
				<!--검색 -->
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown">제목</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					 <a class="dropdown-item searchType" href="t">제목</a> 
					 <a class="dropdown-item searchType" href="tc">제목+내용</a> 
					 <a class="dropdown-item searchType" href="u">작성자</a> 
					</div>
					<form
                     class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                     <div class="input-group">
                         <input type="text" class="form-control bg-light border-0 small" placeholder="검색어를 입력하세요"
                             aria-label="Search" aria-describedby="basic-addon2"
                             id="txtSearch" value="${pagingDto.keyword}">
                         <div class="input-group-append">
                             <button class="btn btn-default" type="button" id="btnSearch">
                                 <i class="fas fa-search fa-sm"></i>
                             </button>
                             <a class="btn btn-primary" href="/board/writeForm">글쓰기</a>
                         </div>
                     </div>
                 </form>
				</div>
			</div>
		</div>
			<div class="row">
				<div class="col-md-2">
		        	<div class="border-end bg-white" id="sidebar-wrapper">
		                <div class="list-group list-group-flush">
		                	<a class="list-group-item" style="background-color:#CCF2F4;">
		                		<strong><i class="fas fa-paw"></i> 커뮤니티</strong></a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- 자유게시판</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- 동물 정보/뉴스</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- 고객센터</a>
		                </div>
		            </div>
				</div>
				<div class="col-md-10">
					<table class="table">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>날짜</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>하위</td>
								<td>유니</td>
								<td>오늘</td>
								<td>1</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<nav>
					<ul class="pagination justify-content-center">
						<li class="page-item"><a class="page-link" href="#">&laquo;</a>
						</li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
					</ul>
				</nav>
			</div>
		</div>
<%@ include file="../include/footer.jsp" %>