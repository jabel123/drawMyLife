<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/top.jsp" %>
<%@include file="../common/homeNavi.jsp" %>
<script>
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
<div style="width:70%; float:left">
<input type="text" name="search" id="search_ani" class="search_ani" onkeyup="hitEnter()" placeholder="아이디 검색..">
</div>
<div style="width:28%; float:left; padding: 10px 10px 10px 10px; border: 3px solid #ccc;">
<h4>최근 가입한 아이디</h4>
<hr>
<c:forEach var="member" items="${memberList }">
		
		<a class="proto" href="${contextPath }/${member.muid}">${member.muid }</a><br>
		<hr>	
</c:forEach>
</div>

</div>
</div>
</div>
</body>
</html>