<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
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
	
						<label for="exampleInputEmail1"> 제목 </label> 
						<input type="text" class="form-control" id="exampleInputEmail1" />
					</div>
					<div class="form-group">
	
						<label for="exampleInputPassword1"> 내용 </label>
						<textarea>
							
						</textarea>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
<%@ include file="../include/footer.jsp"%>