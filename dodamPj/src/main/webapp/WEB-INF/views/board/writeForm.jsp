<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script src="https://cdn.ckeditor.com/ckeditor5/23.0.0/classic/ckeditor.js?ver=2"></script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<img style="margin-top:10px; text-align:center;" src="/resources/img/banner.jpg">
		</div>
	</div>
	<div class="row" style="margin-top:10px;">
		<div class="col-md-2">
        	<div class="border-end bg-white" id="sidebar-wrapper">
                <div class="list-group list-group-flush">
                	<a class="list-group-item" style="background-color:#CCF2F4;">
		                		<strong><i class="fas fa-paw"></i> 커뮤니티</strong></a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/board/freeBoard">- 자유게시판</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- 동물 정보/뉴스</a>
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- 고객센터</a>
                </div>
            </div>
		</div>
			<div class="col-md-10">
				<form role="form" action="/board/writeRun" method="post">
				<input type="hidden" name="user_id" value="${sessionScope.loginVo.user_id }">
					<div class="form-group">
						<span style="font-size:30px"><label style="font-weight:bold">자유게시판</label></span>
						<table class="table">
						<tbody>
							<tr>
								<td align="center">이름</td>
								<td align="center"></td>
								<td><input type="text" class="form-control" id="user_id" name="user_id" value="user_id"/></td>
							</tr>
							<tr>
								<td align="center">제목</td>
								<td align="center"></td>
								<td><input type="text" class="form-control" id="b_title" name="b_title" required/></td>
							</tr>
							<tr>
								<td align="center">내용</td>
								<td align="center"></td>
								<td>
									<textarea name="b_content" id="editor" rows="10" cols="100" placeholder="내용을 입력하세요."></textarea>
									<script>
								    ClassicEditor
								        .create( document.querySelector( '#editor' ) )
								        .catch( error => {
								            console.error( error );
								        } );
									</script>
								</td>
							</tr>
							
						</tbody>
					</table>
					</div>
					<button type="submit" class="btn btn-primary">작성완료</button>
				</form>
			</div>
		</div>
	</div>
<%@ include file="../include/footer.jsp"%>