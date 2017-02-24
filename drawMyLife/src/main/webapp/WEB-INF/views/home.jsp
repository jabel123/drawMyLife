<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./common/top.jsp"%>
<link class="include" rel="stylesheet" type="text/css"
	href="${contextPath }/resources/css/jquery.jqplot.css" />
<script type="text/javascript" src="${contextPath }/resources/js/jquery.jqplot.js"></script>
<script type="text/javascript" src="${contextPath }/resources/plugins/jqplot.dateAxisRenderer.js"></script>

<script>
	$(function() {			
		// 로그인을 하였을 경우에만 그래프를 그려주도록 한다.
		//<c:if test="${sessionScope.smember != null}"> 사용자에따라 그래프를 다르게할
		//drawMainBoard('${contextPath}');
		//</c:if>
			drawMainBoard('${contextPath}');
		
	});
	
	
</script>

<div class="content">
	<div class="left front-block">
		<iframe width="100%" height="300px"
			src="https://www.youtube.com/embed/VAmnTRtWCS0" frameborder="0"
			allowfullscreen></iframe>
	</div>
	<div class="right front-block">
		<iframe width="100%" height="300px"
			src="https://www.youtube.com/embed/YzQDVLzcr_c" frameborder="0"
			allowfullscreen></iframe>
	</div>
	
<%-- 	<c:if test="${sessionScope.smember != null}"> 사용자에따라 그래프를 다르게할--%>
		<div class="clear"></div>
		<hr>	
		<div id="graph" class="left" style="width: 100%; "></div>
			
		<div class="clear"></div>
		<hr>
		<br>
		<br>
		
		<table id="boardList" class="bluetop boardList left">
			<tr>
				<th>하루평가</th>
			</tr>
		</table>
<%-- 	</c:if>사용자에따라 그래프를 다르게할 --%>
	
</div>
</div>
</div>

</body>
</html>

