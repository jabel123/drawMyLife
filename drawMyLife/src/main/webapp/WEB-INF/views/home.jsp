<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./common/top.jsp"%>
<link class="include" rel="stylesheet" type="text/css"
	href="${contextPath }/resources/css/jquery.jqplot.css" />
<script type="text/javascript" src="${contextPath }/resources/js/jquery.jqplot.js"></script>
<script type="text/javascript" src="${contextPath }/resources/plugins/jqplot.dateAxisRenderer.js"></script>

<script>
	$(function() {
		$.jqplot('graph', [[['2013/12/25',15],['2013/12/26',22]]], {
			title : '그래프 제목옵션',
			axes : {
				xaxis : {
					label : "X 좌표제목",
					// 날짜 형태로 입력을 하기위해서는 Date형식의 Renderer을 사용합니다.
					renderer : $.jqplot.DateAxisRenderer,
					tickOptions : { // 축에관한 옵션                    
						// 입력된 값이 날짜형태로 인식되기 위해서 format 형식을 정해주고 입력값도
						// yyyy/mm/dd 형식으로 입력해야만 정상적으로 나타납니다.
						formatString : '%y/%m/%d'
					}
				},
				yaxis : {
					label : "Y 좌표제목",
					min : 0
				//formatString:'%y/%m/%d'
				}
			}

		}); // jp

	});
</script>

<div class="content">
	<hr>
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
	<table class="bluetop boardList">
		<tr>
			<th>하루평가</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td><a href="${contextPath }/board/detail?dno=${board.boardId}">
						${board.title }<span class="right">${board.writeDate }</span>
				</a></td>
			</tr>
		</c:forEach>
	</table>
	<div id="graph" style="width: 100%; height: 300px;"></div>
</div>
</div>
</div>

</body>
</html>

