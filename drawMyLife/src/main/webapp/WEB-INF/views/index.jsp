<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./common/top.jsp" %>


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