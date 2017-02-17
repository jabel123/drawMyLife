<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/top.jsp" %>

<div class="content">
	<table class="bluetop boardList">
		<tr>
			<th colspan="5">${category.categoryName }</th>
		</tr>
		<tr>
			<th width="10%">번호</th>
			<th width="60%">제목</th>
			<th width="10%">닉네임</th>
			<th width="12%">날짜</th>
			<th width="8%">조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
		<tr>
			<td><center>${board.boardId }</center></td>
			<td><a href="${contextPath}/board/detail?dno=${board.boardId}">${board.title }</a></td>
			<td>${board.mname }</td>
			<td>${board.modifyDate }</td>
			<td>${board.hit }</td>
		</tr>
		
		</c:forEach>
		
		<tr>	
			
			<c:if test="${sessionScope.smember != null}">				
				<td colspan="5">
					
					<div class="right"><button onclick="diaryCheck('${category.categoryId }','${contextPath }','${sessionScope.smember.email}')">글쓰기</button>
					</div>
					
				</td>
			</c:if>
		</tr>	
		<tr>
			<td colspan="5">
			<!--  페이지 네비게이션 -->
			<span class="page_navi">
			
			<ul>
				<c:if test="${cPage != 1 }">
					<li><a href="javascript:movePage('${contextPath }/board/list?categoryId=${category.categoryId }&page=1');">&#60;&#60;</a></li>
				</c:if>
				<c:if test="${cPage - 1 > 0 }">
					<li><a href="javascript:movePage('${contextPath }/board/list?categoryId=${category.categoryId }&page=${cPage - 1 }');">&#60;</a></li>
				</c:if>

				<c:forEach var="value" begin="${sPage }" end="${ePage }" step="1">
					<c:choose>
						<c:when test="${cPage == value }">
							<li class="active"><a>${value}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:movePage('${contextPath }/board/list?categoryId=${category.categoryId }&page=${value}');">${value}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${cPage + 1 <= tPage }">
					<li><a href="javascript:movePage('${contextPath }/board/list?categoryId=${category.categoryId }&page=${cPage + 1 }');">&#62;</a></li>
				</c:if>
				<c:if test="${cPage != tPage && tPage != 0 }">
					<li><a href="javascript:movePage('${contextPath }/board/list?categoryId=${category.categoryId }&page=${tPage }');">&#62;&#62;</a></li>
				</c:if>
			</ul>
			</span>
			<!--  페이지 네비게이션 끝 -->
			</td>
		</tr>
			
		
	</table>
</div>
</div>
</div>


<script>
function diaryCheck(categoryId,contextPath,email)
{
	//일기쓰기 이므로 오늘쓴 일기가 있나 체크한다.
	if(categoryId==1){
		
		if(email!='jabel1733@gmail.com') //나만 일기를 쓰도록	
		{
			alert('주현태님만 일기를 작성할 수 있습니다.');
			return;
		}
		
		$.ajax({
			url : contextPath + '/board/diaryCheck',
			type : 'post',
			dataType : 'json',
			success : function(data) {				
				if (data.writtenDiary == 'yes') {
					alert('오늘은 이미 일기를 작성하였습니다.');
					return;					
				}
				movePage('${contextPath}/board/insert?category_id='+categoryId);
			}
		});
	}else{
		movePage('${contextPath}/board/insert?category_id='+categoryId);
	}
	
		
}


</script>

</body>
</html>

