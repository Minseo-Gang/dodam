<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

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
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- 보호중인 동물</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/loseAnimal/reportList">- 분실 신고</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" 
                    	href="/loseAnimal/infoGetAnimal">- 습득시 안내</a>
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
					<form role="form" action="/loseAnimal/reportAnimalRun" method="post">
						<div class="form-group">
						<label for="b_title">제목</label>
						<input type="text" class="form-control" id="b_title" name="b_title"/>
						</div>
						<div class="form-group">
						<label for="b_title">작성자</label>
						<input type="text" class="form-control" id="b_title" name="b_title"/>
						</div>
						<div class="form-group">
						<label for="p-name">동물 이름</label>
						<input type="text" class="form-control" id="p-name" name="p-name"/>
						</div>
						<div class="form-group">
						<label for="p-species">품종</label>
						<input type="text" class="form-control" id="p-species" name="p-species"/>
						</div>
						<div class="form-group">
						<label for="p-gender">성별</label>
						<input type="text" class="form-control" id="p-gender" name="p-gender"/>
						</div>
						<div class="form-group">
						<label for="p-age">나이</label>
						<input type="text" class="form-control" id="p-age" name="p-age"/>
						</div>
						<div class="form-group">
						<label for="p-lostdate">실종 날짜</label>
						<input type="text" class="form-control" id="p-lostdate" name="p-lostdate"/>
						</div>
						<div class="form-group">
						<label for="p-lostplace">실종 장소</label>
						<input type="text" class="form-control" id="p-lostplace" name="p-lostplace"/>
						</div>
						<div class="form-group">
						<label for="p-character">특징</label>
						<textarea class="form-control" id="p-character" name="p-character"></textarea>
						</div>
						<label for="photo">사진 첨부</label> 
						<input type="file" class="form-control-file" id="photo" name="photo"/>
							<p class="help-block" style="font-size:16px;">사진은 최대 10MB까지 첨부 가능합니다.</p>
						</div>
						<a class="btn btn-info" href="/loseAnimal/reportList" style="margin-right:10px;">목록</a>
						<button type="submit" class="btn float-right btn-success">등록</button>
					</form>
				</div>
			</div>			
		</div>
  	</div>

<%@ include file="../include/footer.jsp" %>