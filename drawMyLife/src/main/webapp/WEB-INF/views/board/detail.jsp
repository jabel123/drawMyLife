<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/top.jsp" %>

<div class="content">
	<table border="1" class="boardList">
		<tr>
			<td>${board.boardId }. ${board.title }</td>
		</tr>
		<tr>
			<td>
				작성자. ${board.mname }
				<span class="right">평가.${board.evaluation }</span>
				<span class="right">${board.writeDate } /</span>
				
			</td>
		</tr>
		<tr>
			<td>${board.content }</td>
		</tr>
	</table>
</div>
</div>
</div>

</body>
</html>

