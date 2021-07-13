<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script>
$(document).ready(function() {
	$("#btnModify").click(function() {
		$("#btnModifyFinish").show(1000);
		$("[name^=b]").prop("readonly", false);
	});
	
	$("#btnDelete").click(function() {
		if (confirm("삭제하시겠습니까?")) {
			location.href = "/board/deleteRun?b_no=${boardVo.b_no}";
		}
	});
});
</script>
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
				<form role="form" action="/board/modifyRun" method="post">
					<input type="hidden" name="user_id" value="${boardVo.user_id }"/>
					<input type="hidden" name="b_no" value="${boardVo.b_no }"/>
					<div class="form-group">
						<span style="font-size:30px"><label style="font-weight:bold">자유게시판</label></span>
						<table class="table">
						<tbody>
							<tr>
								<td align="center">이름</td>
								<td align="center"></td>
								<td><input type="text" class="form-control" id="user_id" name="user_id" value="${boardVo.user_id }" readonly/></td>
							</tr>
							<tr>
								<td align="center">제목</td>
								<td align="center"></td>
								<td><input type="text" class="form-control" id="b_title" name="b_title" value="${boardVo.b_title }" readonly/></td>
							</tr>
							<tr>
								<td align="center">내용</td>
								<td align="center"></td>
								<td>
									<textarea name="b_content" id="editor" rows="10" cols="100" readonly>${boardVo.b_content }</textarea>
								</td>
							</tr>
							
						</tbody>
					</table>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<hr/>
							<button type="button" class="btn btn-success" id="btnCommentList">댓글보기</button>
							<hr/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<button type="button" class="btn btn-primary" id="btnModify">수정</button>
							<button type="submit" class="btn btn-success" id="btnModifyFinish" style="display:none">수정완료</button>
							<button type="button" class="btn btn-danger" id="btnDelete">삭제</button>
							<a class="btn btn-warning" href="freeBoard">목록</a>
						</div>
					</div>
				</form>
				
			<div class="row">
				<div class="col-md-2"></div>
					<div class="col-md-8">
						<input type="text" class="form-control"
							placeholder="댓글을 입력하세요..."
							id="c_content"/>
					</div>
					<div class="col-md-2">
						<button type="button" class="btn btn-primary"
							id="btnCommentInsert">입력</button>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12">
						<table class="table" id="commentTable">
							
							<tbody>
								<tr style="display:none;">
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td><button type="button" class="btn btn-warning btn-sm commentModify">수정</button></td>
									<td><button type="button" class="btn btn-danger btn-sm commentDelete">삭제</button></td>
								</tr>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@ include file="../include/footer.jsp" %>