<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 지도 -->
<div id="map" style="width:50%;height:350px;"></div>
<!-- 지도 -->

<div class="listU margin_auto tmgn10 bmgn10" style="width:942px;">
	<p><em>교통정보</em></p>
	<ul>
				<li style="list-style-type:square !important; line-height:18px; margin:5px 0 5px 20px"><span class="bold lspacing05">주&nbsp;&nbsp;&nbsp;소</span> :  (446-77) 울산광역시 남구 삼산로35번길 19 (신정동)</li>
				<li style="list-style-type:square !important; line-height:18px; margin:5px 0 5px 20px"><span class="bold lspacing05">버&nbsp;&nbsp;&nbsp;스</span> :
		<div>
			<strong>- 지선 :</strong> 921<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>922<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>928<br>
			<strong>- 일반 :</strong> 106<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>107<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>124<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>126<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>127<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>134<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>205<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>205 (지원)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>216<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>226<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>235<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>235 (지원)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>256<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>266<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>307<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>317<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>327<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>337<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;357<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>401<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>406<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>411<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>412<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>413<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>415<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>417<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>417 (지원)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>426<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>427<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>432<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;432 (지원)(달천농공단지입구-율리공영차고지종점)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>432 (지원)(율리공영차고지-달천회관앞)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>433<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>453<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;453 (지원)(달천농공단지입구-율리공영차고지종점)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>453 (지원)(율리공영차고지-달천농공단지입구)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>472<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>482<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>527<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>527 (지원)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;705<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>708<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>708 (지원)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>713<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>714<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>715<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>718<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>718 (지원)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>724<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>728<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>732<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>732 (지원)<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>733<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>744<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>807<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>824<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>837<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;837 (지원)(LH2단지,호반베르디움-태화강역)<br>
			<strong>- 좌석 :</strong> 1127<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>1137<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>1401<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>1703<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>1713<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>1723<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>2100<span class="gray">&nbsp;&nbsp;|&nbsp;&nbsp;</span>2300<br>
			<strong>- 급행 :</strong> 5004
		</div>
		</li>
	</ul>
</div>
<!-- 지도 스크립트 위치 바꾸면 지도 안나옴 -->
<script>
var mapOptions = {
									//지도 좌표 건들지 마세요
    center: new naver.maps.LatLng(35.535078472924496, 129.31086858555648),
    zoom: 150
};



var map = new naver.maps.Map('map', mapOptions);

var markerOptions = {
										//지도 좌표 건들지 마세요
		position: new naver.maps.LatLng(35.535078472924496, 129.31086858555648),
        map: map
}

var marker = new naver.maps.Marker(markerOptions);
</script>
<%@ include file="../include/footer.jsp"%>