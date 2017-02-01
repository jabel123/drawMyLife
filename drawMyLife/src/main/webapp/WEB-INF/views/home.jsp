<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./common/top.jsp" %>

<div class="content">
<hr>	
	<div class="left front-block" >
		<iframe width="100%" height="300px" src="https://www.youtube.com/embed/VAmnTRtWCS0" frameborder="0" allowfullscreen></iframe>
	</div>
	<div class="left front-block">
		<iframe width="100%" height="300px" src="https://www.youtube.com/embed/YzQDVLzcr_c" frameborder="0" allowfullscreen></iframe>
	</div>
	<div class="left front-block front-border">
		<h3>공지사항</h3>
		<c:forEach var="board" items="${boardList }">
			<hr>
			<td><a href="${contextPath }/board/detail?dno=${board.boardId}">${board.title }</a></td>
		</c:forEach>
	</div>
	
</div>
</div>
</div>

</body>
</html>

