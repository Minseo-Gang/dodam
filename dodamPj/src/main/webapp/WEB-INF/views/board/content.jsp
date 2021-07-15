<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script src="/resources/js/my-script.js"></script>
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
	
<<<<<<< Updated upstream
	// 댓글 목록
=======
	// 댓글목록
>>>>>>> Stashed changes
	$("#btnCommentList").click(function() {
		var url = "/comment/getCommentList/${boardVo.b_no}";
		
		$.get(url, function(receivedData) {
			var cloneTr;
			$("#commentTable > tbody > tr:gt(0)").remove();
			$.each(receivedData, function() {
				var cloneTr = $("#commentTable > tbody > tr:first").clone();
				var td = cloneTr.find("td");
				td.eq(0).text(this.c_no);
				td.eq(1).text(this.c_content);
				td.eq(2).text(this.user_id);
				td.eq(3).text(changeDateString(this.c_regdate));
				td.eq(5).find("button").attr("data-cno", this.c_no);
				
				$("#commentTable > tbody").append(cloneTr);
				cloneTr.show("slow");
			});
			
		});
		
	});
	
	// 댓글 입력
	$("#btnCommentInsert").click(function() {
		var c_content = $("#c_content").val();
		var b_no = parseInt("${boardVo.b_no}");
		var url = "/comment/insertComment";
		var sendData = {
				"c_content" : c_content,
				"b_no"	    : b_no
		};
		console.log(sendData);
		console.log(JSON.stringify(sendData));
		
		$.ajax({
			"url" : url,
			"headers" : {
				"Content-Type" : "application/json"
			},
			"method" : "post",
			"dataType" : "text",
			"data" : JSON.stringify(sendData),
			"success" : function(receivedData) {
				console.log(receivedData);
<<<<<<< Updated upstream
				// 처리가 잘 되었다면, 댓글 목록 버튼을 클릭시켜서 목록을 새로 얻음
=======
>>>>>>> Stashed changes
				if (receivedData == "success") {
					$("#btnCommentList").trigger("click");
				}
			}
		});
<<<<<<< Updated upstream
=======
		
>>>>>>> Stashed changes
	});
	
	// 댓글 삭제
	$("#commentTable").on("click", ".commentDelete", function() {
		var c_no = $(this).attr("data-cno");
		console.log(c_no);
		var url = "/comment/deleteComment/" + c_no + "/${boardVo.b_no}";
<<<<<<< Updated upstream
		if (confirm("댓글을 삭제하시겠어요?")) {
			$.get(url, function(receivedData) {
				console.log(receivedData);
				if (receivedData == "success") {
=======
		if(confirm("댓글을 삭제합니다.")) {
			$.get(url, function(receivedData) {
				console.log(receivedData);
				if(receiveData == "success") {
>>>>>>> Stashed changes
					$("#btnCommentList").trigger("click");
				}
			});
		}
	});
	
<<<<<<< Updated upstream
	// 댓글 수정
	$("#commentTable").on("click", ".commentModify", function() {
		$("#updateCommentText").show(1000);
	});
	
=======
>>>>>>> Stashed changes
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
		                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/board/newsBoard">- 동물 정보/뉴스</a>
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
					
<<<<<<< Updated upstream
					<c:choose>
				<c:when test="${empty sessionScope.loginVo }">
			
				</c:when>
					<c:otherwise>
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
							
					</c:otherwise>
				</c:choose>
=======
			<div class="row">
				<div class="col-md-2"></div>
					<div class="col-md-8">
					<c:choose>
						<c:when test="${empty sessionScope.loginVo.user_id}">

						</c:when>
						<c:otherwise>
							<input type="text" class="form-control"
							placeholder="댓글을 입력하세요"
							id="c_content"/>
						</c:otherwise>
					</c:choose>
					</div>
					<div class="col-md-2">
					<c:choose>
						<c:when test="${empty sessionScope.loginVo.user_id}">

						</c:when>
						<c:otherwise>
							<button type="button" class="btn btn-primary"
							id="btnCommentInsert">입력</button>
						</c:otherwise>
					</c:choose>
<!-- 						<button type="button" class="btn btn-primary" -->
<!-- 							id="btnCommentInsert">입력</button> -->
					</div>
				</div>
>>>>>>> Stashed changes
				
				<div class="row">
					<div class="col-md-12">
						<table class="table" id="commentTable">
							
							<tbody>
								<tr style="display:none;">
									<td></td>
									<td><input type="text" id="updateCommentText" style="display:none"/></td>
									<td></td>
									<td></td>
									<c:if test="${loginVo.user_id == commentVo.user_id}">
									<td><button type="button" class="btn btn-warning btn-sm commentModify">수정</button></td>
									<td><button type="button" class="btn btn-danger btn-sm commentDelete">삭제</button></td>
									</c:if>
								</tr>
								
							</tbody>
						</table>
					</div>
				</div>
<<<<<<< Updated upstream
=======
				
>>>>>>> Stashed changes
					
					<div class="row">
						<div class="col-md-12">
						<c:if test="${loginVo.user_id == boardVo.user_id }">
							<button type="button" class="btn btn-primary" id="btnModify">수정</button>
							<button type="submit" class="btn btn-success" id="btnModifyFinish" style="display:none">수정완료</button>
							<button type="button" class="btn btn-danger" id="btnDelete">삭제</button>
						</c:if>
<<<<<<< Updated upstream
							<a class="btn btn-warning" href="freeBoard">목록</a>
						</div>
					</div>
				</form>
				
				
=======
									<a class="btn btn-warning" href="freeBoard">목록</a>
						</div>
					</div>
				</form>
>>>>>>> Stashed changes
			</div>
		</div>
	</div>
<%@ include file="../include/footer.jsp" %>