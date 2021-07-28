<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>간단한 지도 표시하기</title>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=hnzhq1px47"></script>
</head>
<body>
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

					<div class="col-md-10">
						<div class="jumbotron">
							<h2>오시는길</h2>
						</div>
						<div id="map" style="w idth: 50%; height: 350px;"></div>
					</div>

				</div>
			</div>
		</div>
	</div>


	<script>
		var mapOptions = {
			center : new naver.maps.LatLng(37.3595704, 127.105399),
			zoom : 10
		};

		var map = new naver.maps.Map('map', mapOptions);

		var markerOptions = {
			position : new naver.maps.LatLng(37.3595704, 127.105399),
			map : map
		}

		var marker = new naver.maps.Marker(markerOptions);
	</script>
<%@ include file="../include/footer.jsp"%>