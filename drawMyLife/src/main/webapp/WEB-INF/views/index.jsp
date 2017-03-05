<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./common/top.jsp" %>

<input type="text" name="search" class="search_ani" placeholder="아이디 검색..">
</div>

<div class="content">
<c:forEach var="member" items="${memberList }">
		
		<a class="proto" href="${contextPath }/${member.muid}">${member.muid }</a><br>
		
</c:forEach>

</div>
</div>
</div>
</body>
</html>