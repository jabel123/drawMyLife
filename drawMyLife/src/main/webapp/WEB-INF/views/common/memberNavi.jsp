<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="gnb">
	<ul>
		<li <c:if test="${category.categoryId ==1}">class='active'</c:if>>
			<a href='${contextPath }/${member.muid}/board/list?categoryId=1'>하루평가</a>
		</li>

		<li <c:if test="${category.categoryId ==2}">class='active'</c:if>>
			<a href='${contextPath }/${member.muid}/board/list?categoryId=2'>잡담게시판</a>
		</li>
	</ul>
</div>
</div>
