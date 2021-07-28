<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminHeader.jsp"%>
<!-- 공지사항 등록 화면  -->
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

				<div id="layoutSidenav_content">
					<main>
					<div class="container-fluid px-2">
						<div class="form-group">
							<form action="/notice/noticeWriteRun" method="post" />
							<div class="form-group">
								<label for="n_title">제목</label> <input type="text"
									class="form-control" id="n_title" name="n_title"
									placeholder="제목을 작성해주세요.">
							</div>
							<div class="form-group">
								<label for="n_content">내용</label>
								<textarea class="form-control" id="n_content" name="n_content"
									rows="10"></textarea>
							</div>
							<button type="submit" class="btn btn-info">등록하기</button>
							<a href="/admin/adminPage" class="btn btn-secondary">메인으로</a>
							</form>
						</div>

					</div>
					</main>


					<footer class="py-4 bg-light mt-auto">
						<div class="container-fluid px-4">
							<div
								class="d-flex align-items-center justify-content-between small">
								<div class="text-muted">Copyright &copy; Your Website 2021</div>
								<div>
									<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
										&amp; Conditions</a>
								</div>
							</div>
						</div>
					</footer>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
	crossorigin="anonymous"></script>
<script src="/resources2/assets/demo/chart-area-demo.js"></script>
<script src="/resources2/assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
	crossorigin="anonymous"></script>
<script src="/resources2/js/datatables-simple-demo.js"></script>
</body>
</html>