<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/top.jsp" %>

<div class="content">
	<table border="1" class="boardList">
		<tr>
			<th colspan="5">${category.categoryName }</th>
		</tr>
		<tr>
			<th>번호</th>
			<th width="65%">제목</th>
			<th width="15%">닉네임</th>
			<th>날짜</th>
			<th>추천</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
		<tr>
			<td>${board.boardId }</td>
			<td><a href="${contextPath}/board/detail?dno=${board.boardId}">${board.title }</a></td>
			<td>${board.mname }</td>
			<td>${board.modifyDate }</td>
			<td>${board.evaluation }</td>
		</tr>
		
		</c:forEach>
		<c:if test="${sessionScope.smember != null}">
		<tr>
			
			<td colspan="5"><div class="right"><button onclick="movePage('${contextPath}/board/insert?category_id=${category.categoryId }')">글쓰기</button></div></td>
		</tr>
		</c:if>
	</table>
</div>
</div>
</div>

</body>
</html>

