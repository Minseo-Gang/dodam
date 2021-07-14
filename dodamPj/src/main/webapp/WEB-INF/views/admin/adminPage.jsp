<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/adminHeader.jsp"%>
<!-- 관리자용 헤더 사용 -->
<style>
	.border{
		border-bottom: 1px solid red;
	}
</style>

	<div class="container-fluid" style="margin-top: 20px">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="carousel slide" id="carousel-977979">
					<ol class="carousel-indicators">
						<li data-slide-to="0" data-target="#carousel-977979"
							class="active"></li>
						<li data-slide-to="1" data-target="#carousel-977979"></li>
						<li data-slide-to="2" data-target="#carousel-977979"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100" alt="Carousel Bootstrap First"
								src="https://www.layoutit.com/img/sports-q-c-1600-500-1.jpg" />
							<div class="carousel-caption">
								<h4>First Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" alt="Carousel Bootstrap Second"
								src="https://www.layoutit.com/img/sports-q-c-1600-500-2.jpg" />
							<div class="carousel-caption">
								<h4>Second Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
						<div class="carousel-item">
							<img class="d-block w-100" alt="Carousel Bootstrap Third"
								src="https://www.layoutit.com/img/sports-q-c-1600-500-3.jpg" />
							<div class="carousel-caption">
								<h4>Third Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
					</div>
					<a class="carousel-control-prev" href="#carousel-977979"
						data-slide="prev"><span class="carousel-control-prev-icon"></span>
						<span class="sr-only">Previous</span></a> <a
						class="carousel-control-next" href="#carousel-977979"
						data-slide="next"><span class="carousel-control-next-icon"></span>
						<span class="sr-only">Next</span></a>
				</div>
				<h2>공지사항</h2>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>조회수</th>
							<th>작성시간</th>
						</tr>
					</thead>
					<tbody>
<!-- 					jstl 쓸려면 c 태그 추가  -->
						<c:forEach var="list" items="${noticeList }">
							<tr>

								<th class="border">${list.n_no }</th>
								<th class="border"><a href="/notice/content?n_no=${list.n_no }">${list.n_title }</a></th>
								<th class="border">${list.n_readcount }</th>
								<th class="border">${list.n_date }</th>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<a class="btn" href="/notice/noticeList">더보기 »</a>
				</p>
				<h2>입양 현황</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn" href="#">View details »</a>
				</p>
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn" href="#">View details »</a>
				</p>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>

<%@ include file="../include/footer.jsp"%>
