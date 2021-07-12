<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script src="https://cdn.ckeditor.com/ckeditor5/29.0.0/decoupled-document/ckeditor.js"></script>
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
                		<strong><i class="fas fa-paw"></i> 유실/유기동물</strong></a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- 보호중인 동물</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- 동물 신고</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- 습득시 안내</a>
                </div>
            </div>
		</div>
			<div class="col-md-10">
				<form role="form">
					<div class="form-group">
						<span style="font-size:30px"><label style="font-weight:bold">자유게시판</label></span>
						<table class="table">
						<tbody>
							<tr>
								<td align="center">이름</td>
								<td align="center"></td>
								<td><input type="text" class="form-control" id="user_id"/></td>
							</tr>
							<tr>
								<td align="center">제목</td>
								<td align="center"></td>
								<td><input type="text" class="form-control" id="b_title"/></td>
							</tr>
							<tr>
								<td align="center">내용</td>
								<td align="center"></td>
								<td>
								<div id="toolbar-container"></div>

							    <!-- This container will become the editable. -->
							    <div id="editor">
							        <p>내용을 입력해주세요.</p>
							    </div>
							    <script>
							        DecoupledEditor
							            .create( document.querySelector( '#editor' ) )
							            .then( editor => {
							                const toolbarContainer = document.querySelector( '#toolbar-container' );
							
							                toolbarContainer.appendChild( editor.ui.view.toolbar.element );
							            } )
							            .catch( error => {
							                console.error( error );
							            } );
							    </script>
<!-- 								<textarea style="width:1000px;height:400px"></textarea> -->
								</td>
							</tr>
							
						</tbody>
					</table>
<!-- 						<label for="b_title" style="text-align:center"> 제목 </label>  -->
<!-- 						<input type="text" class="form-control" id="b_title" /> -->
					</div>
					<div class="form-group">
					<hr>
<!-- 						<label for="exampleInputPassword1"> 내용 </label> -->
						<br>
						
					</div>
					<button type="submit" class="btn btn-primary">작성완료</button>
				</form>
			</div>
		</div>
	</div>
<%@ include file="../include/footer.jsp"%>