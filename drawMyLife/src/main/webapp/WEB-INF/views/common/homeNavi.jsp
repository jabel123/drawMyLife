<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="gnb">
	<ul>		
		<li <c:if test="${categoryId ==1}">class='active'</c:if>>
			<a href='${contextPath }/'>인사말</a>
		</li>

		<li <c:if test="${categoryId ==2}">class='active'</c:if>>
			<a href='${contextPath }/friendSearch'>친구찾기</a>
		</li>
	</ul>
</div>

