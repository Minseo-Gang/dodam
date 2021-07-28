<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<style>
#fileDrop {
	width: 80%;
	height: 100px;
	border: 1px solid #000;
}
	
.divUploaded {
	width: 150px;
	float: left;
}
</style>
<script src="/resources/js/my-script.js"></script>
<script>
$(document).ready(function() {
	$("#fileDrop").on("dragenter dragover", function(e) {
		e.preventDefault();
	});
	
	$("#fileDrop").on("drop", function(e) {
		e.preventDefault();
		console.log(e);
		var file = e.originalEvent.dataTransfer.files[0];
		console.log(file);
		var formData = new FormData();
		formData.append("file", file);
		
		// 파일을 비동기 방식으로 전송
		// enctype="multipart/form-data"
		var url = "/lostAnimal/uploadAjax";
		$.ajax({
			"processData" : false,
			"contentType" : false,
			"url" : url,
			"method" : "post",
			"data" : formData,
			"success" : function(receivedData) {
				console.log(receivedData);
				var fileName = receivedData.substring(receivedData.lastIndexOf("_") + 1);
				var cloneDiv = $("#uploadedList").prev().clone();
				var img = cloneDiv.find("img");
				// 이미지인 경우
				if(isImage(fileName)) {
					img.attr("src", "http://localhost/lostAnimal/displayImage?fileName=" + receivedData);
				}
				cloneDiv.find("span").text(fileName);
				cloneDiv.find(".a_times").attr("href", receivedData);
				$("#uploadedList").append(cloneDiv.show());
			}
		});
	});
	
	$("#uploadedList").on("click", ".a_times", function(e) {
		e.preventDefault();
		var that = $(this);
		var fileName = $(this).attr("href");
		var url = "/lostAnimal/deleteFile?fileName=" + fileName;
		$.get(url, function(receivedData) {
			if(receivedData == "success") {
				that.parent().remove();
			}
		});
	});
	
	$("#frmWrite").submit(function() {
		var div = $("#uploadedList .divUploaded");
		$(this).find("[names^=files]").remove();
		div.each(function(index) {
			var fileName = $(this).find(".a_times").attr("href");
			var html = "<input type='hidden' name='files[" + index + "]' value='" + fileName + "'/>";
			$("#frmWrite").prepend(html);
		});
		//return false; // 폼전송 막기
	});
	
});
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12" style="margin-top:10px; text-align:center;" >
			<img src="/resources/img/banner.jpg">
		</div>
	</div>
	<div class="row" style="margin-top:10px;">
		<div class="col-md-2">
 			<div class="border-end bg-white" id="sidebar-wrapper">
   				<div class="list-group list-group-flush">
                	<a class="list-group-item" style="background-color:#CCF2F4;">
                		<strong><i class="fas fa-paw"></i> 유실/유기동물</strong></a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/lostAnimal/protectAnimal">- 보호중인 동물</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/lostAnimal/reportList">- 분실 신고</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/lostAnimal/infoGetAnimal">- 습득시 안내</a>
                </div>
            </div>
		</div>
	<div class="col-md-10">
		<h2>분실 신고서 작성</h2>
		<hr/>
			<ul>
				<li>동물을 분실한 경우 동물정보를 올려 분실 동물을 찾을 수 있는 공간입니다.</li>
				<li>동물을 분실한 경우 동물보호법 제12조 제1항 및 같은 법 시행규칙 제8조 제1항 및 제9조 제2항에 따라 등록대상동물을
					10일 이내 시장, 군수, 구청장에게 분실 신고하셔야 합니다.<br>
					(다만, 동물보호관리시스템에서 소유자가 직접 동물상태 수정 가능)</li>
				<li>로그인 후 분실신고를 등록할 수 있습니다.</li>
			</ul>
			<br>
			<div class="row">
				<div class="col-md-12">
					<form role="form" action="/lostAnimal/reportRun" method="post" id="frmWrite">
						<div class="form-group">
						<label for="b_title">제목</label>
						<input type="text" class="form-control" id="b_title" name="b_title"/>
						</div>
						<div class="form-group">
						<label for="user_name">작성자</label>
						<input type="text" class="form-control" id="user_name" name="user_name"/>
						</div>
						<div class="form-group">
						<label for="user_tel">연락처</label>
						<input type="text" class="form-control" id="user_tel" name="user_tel"/>
						</div>
						<div class="form-group">
						<label for="user_email">e-mail</label>
						<input type="text" class="form-control" id="user_email" name="user_email"/>
						</div>
						<div class="form-group">
						<label for="p_name">동물 이름</label>
						<input type="text" class="form-control" id="p_name" name="p_name"/>
						</div>
						<div class="form-group">
						<label for="p_species">품종</label>
						<input type="text" class="form-control" id="p_species" name="p_species"/>
						</div>
						<div class="form-group">
						<label for="p_gender">성별</label>
						<input type="radio" name="p_gender" value="수컷" checked/>수컷
						<input type="radio" name="p_gender" value="암컷"/>암컷
						</div>
						<div class="form-group">
						<label for="p_age">나이</label>
						<input type="text" class="form-control" id="p_age" name="p_age"/>
						</div>
						<div class="form-group">
						<label for="p_lostdate">실종 날짜</label>
						<input type="text" class="form-control" id="p_lostdate" name="p_lostdate"/>
						</div>
						<div class="form-group">
						<label for="p_lostplace">실종 장소</label>
						<input type="text" class="form-control" id="p_lostplace" name="p_lostplace"/>
						</div>
						<div class="form-group">
						<label for="p_character">특징</label>
						<textarea class="form-control" id="p_character" name="p_character"
							placeholder="중성화, 미용상태, 피부상태 등 아이 파악에 도움될 정보를 작성해주세요."></textarea>
						</div>
						<label for="photo">사진 첨부</label><br>
							<div>
								<label>첨부할 파일을 드래그 &amp;드롭 하세요.<br>
									(사진은 최대 10MB까지 첨부 가능합니다.)</label>
								<div id="fileDrop"></div>
							</div><br>
							
							<div style="display:none;" class="divUploaded">
								<img height="100" src="/resources/img/no_image.png" class="img-rounded"/><br>
								<span>default</span>
								<a href="#" class="a_times">&times;</a>
							</div>
							
							<div id="uploadedList">
							
							</div>
						</div>						
						
						<a class="btn btn-info" href="/lostAnimal/reportList" style="margin-right:10px;">목록</a>
						<button type="submit" class="btn float-right btn-success">등록</button>
					</form>
				</div>
			</div>			
		</div>
  	</div>

<%@ include file="../include/footer.jsp" %>