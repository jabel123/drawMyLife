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

<div class="w3-container w3-center w3-animate-right">
  <h1>Draw My Life</h1>
  <p>인생이 순탄치 않은 그대여 혹시 자기인생에 피드백은 주고 계신지!! Draw My Life를 통해 함께 인생을 변화시켜 보아요</p>
  <img src="${contextPath }/resources/img/ju.jpg" class="w3-margin-right" style="height:70px;">
  <img src="${contextPath }/resources/img/kim.jpg" class="w3-margin-right" style="height:70px;">
</div>
<center>
<h4>일기 최다 작성자</h4>
</center>
<hr>
<ul class="w3-ul w3-border">
	<c:forEach var="member" items="${rankList }">
	  <a class="rank" href="${contextPath }/${member.muid}">
		  <li class="w3-padding-16">
		  	  <img src="${contextPath }/resources/img/img_avatar2.png" class="w3-left w3-circle w3-margin-right" style="height:70px;">
		  	  <span class="w3-large">${member.mname }</span><br>
		  	  <span>${member.email }</span><br>
		  	  <span>작성 일기수 : ${member.diaryCnt }</span>
		  </li>
	  </a>
	</c:forEach> 
</ul>

</div>


</div>
</div>
</div>
</body>
</html>