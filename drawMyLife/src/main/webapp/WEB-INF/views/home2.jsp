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
		<c:if test="${sessionScope.smember != null}">
			$.ajax({
	            url : '${contextPath}/member/graph',
	            type : 'get',
	            dataType : 'json',	            
	            success:function(data){	            		          	           
	            	
	            	$.jqplot('graph', [data.line], {
	        			title : '나의 상태',
	        			axes : {
	        				xaxis : {
	        					label : "날짜",
	        					// 날짜 형태로 입력을 하기위해서는 Date형식의 Renderer을 사용합니다.
	        					renderer : $.jqplot.DateAxisRenderer,
	        					tickOptions : { // 축에관한 옵션                    
	        						// 입력된 값이 날짜형태로 인식되기 위해서 format 형식을 정해주고 입력값도
	        						// yyyy/mm/dd 형식으로 입력해야만 정상적으로 나타납니다.
	        						formatString : '%y/%m/%d'
	        					}
	        				},
	        				yaxis : {
	        					label : "평가",
	        					min : 0
	        				//formatString:'%y/%m/%d'
	        				}
	        			}

	        		}); // jp
	            }
	        });		
		</c:if>
		
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
	<div id="graph" class="left" style="width: 100%; "></div>
	
	
	<table id="boardList" class="bluetop boardList left">
		<tr>
			<th>하루평가</th>
		</tr>
	</table>
	
</div>
</div>
</div>

</body>
</html>

