<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/top.jsp" %>

<div class="content">
	<table class="bluetop boardList">
		<tr>
			<td><b>${board.boardId }. ${board.title }</b>			
				<c:if test="${smember.mno == board.memberId}">
					<span class="right">				
						<button onclick="movePage('${contextPath}/board/update?boardId=${board.boardId }&categoryId=${category.categoryId}')">수정</button>
						<button onclick="movePage('${contextPath}/board/delete?boardId=${board.boardId }&categoryId=${category.categoryId}')">삭제</button>				
					</span>
				</c:if>
				<span class="right">조회수 : ${board.hit }</span> 
			</td>
		</tr>
		<tr>
			<td>
				작성자. ${board.mname }
				<c:if test="${category.categoryId==1 }">
					<span class="right">평가.${board.evaluation }</span>
				</c:if>
				<span class="right">${board.writeDate } /</span>
				
			</td>
		</tr>
		<tr>			
			<td>${board.content }</td>
		</tr>

	</table>
	<c:if test="${sessionScope.smember != null}">
	<b>의견작성</b> 				
		<form action="${contextPath }/board/comment" method="post">	
    		<textarea id="comment" name="comment" rows="5" cols="100" style="width:100%" ></textarea>
    		<input type="hidden" name="boardId" value=${board.boardId } />
 			<input type="hidden" name="memberId" value=${sessionScope.smember.mno } />
 			<button>확인</button>   
		</form>
    	
    	<hr>
    </c:if>
	<b>의견</b>
	<c:forEach var="comment" items="${commentList }">
		<hr>
		${comment.memberName } : ${comment.comment } 
		<span class="right">${comment.creDate }</span>
	</c:forEach>

</div>
</div>
</div>

</body>
</html>

