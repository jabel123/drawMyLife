<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./common/top.jsp" %>
<%@include file="./common/homeNavi.jsp" %>
<script>
$(function(){
	setInterval(function(){
		$('.text-light').toggleClass('text-red')
		}, 250);
});

function hitEnter() {
	
	if (event.keyCode == 13) {
		alert("구현 예정입니다.");
	} else {
		event.keyCode == 0;
		return;
	}
}


</script>



</div>

<div class="content">
<center>
<h4>만들게된 계기</h4>
</center>
<hr>
	<center>
	<div style="float:left; margin-right:20px;">
		<span class="text-light">↓ ↓ 아래그림을 클릭하시면 예제가 나옵니다. ↓ ↓</span><br><br>
		<a href="${contextPath }/jabel1733">
		<img src="${contextPath }/resources/img/me.jpg" />
		</a>
	</div>
	
	<div id="helloContent" style="width:60%; line-height: 300%; float:left">
	저는 군대에 가기 전까지 아무것도 못하는 사람이었습니다.<br>
	그러나 군대에 가서 수양록을 쓰기 시작하면서 자신이<br>
	한 층 성장하는 듯한 느낌을 받았습니다.<br>
	 군대에서 전역하고서도 일기쓰는 습관을 지속한 결과<br>
	자신에 대한 피드백을 끊임없이 할 수 있었고 그 결과<br>
	졸업할 무렵에는 4점대 학점과 많은 자격증 그리고 <br>
	여러가지 스킬들을 익히게 되었습니다.<br>
	 이러한 경험을 공유하고자 개인 프로젝트를 만들며<br>
	<b>최종 목표</b>는 일기 데이터를 분석하여 자신을 수치적으로<br>
	돌아보는 것입니다.
	</div>
	</center>
</div>


</div>
</div>
</div>
</body>
</html>