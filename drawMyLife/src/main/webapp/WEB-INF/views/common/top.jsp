<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>DrawMyLife</title>
        <script src="${contextPath }/resources/js/jquery-3.1.1.min.js"></script>  
        <script src="${contextPath }/resources/js/main.js?v=2"></script>
        
        
        
        <script>
        
        
        </script>
        <link rel="stylesheet" type="text/css" href="${contextPath }/resources/css/w3c.css">          
		<link rel="stylesheet" type="text/css" id="login-css" href="${contextPath }/resources/css/main.css" />
		
               	    
    </head>
    <body>
    	<div class="wrap">
    		<div class="body">
    			
    			<div class="header">
    				
    				
    				<c:if test="${sessionScope.smember == null}">
    					<form id="target" action="${contextPath }/member/login" method="post">
	    					<input class="input_ani" type="text" name="email" id="email" placeholder="아이디" onkeypress="hitEnterKey('${contextPath}')">
	    					<input class="input_ani" type="password" name="pwd" id="pwd" placeholder="패스워드" onkeypress="hitEnterKey('${contextPath}')">
	    					<button class="btn" type="button" onclick="login('${contextPath}')">로그인</button>
		    				<%-- <button onclick="movePage('${contextPath}/member/login')">로그인</button> --%>
		    				<button class="btn" type="button" onclick="movePage('${contextPath}/member/join')">회원가입</button>
    					</form>    					 
    				</c:if>
    				<c:if test="${sessionScope.smember != null}">    					
    					
    					<div>
    						${sessionScope.smember.mname }
    						<button class="btn" onclick="movePage('${contextPath}/member/logout')">로그아웃</button>
    					</div>
    				</c:if>    			
	    				<a href="${contextPath }/">
	    					<img src="${contextPath }/resources/img/logo.jpg" />
	    				</a>    
    				
    				<div class="clear"></div>		
    				<div class="gnb">
    					<ul>
    						<li <c:if test="${category.categoryId ==1}">class='active'</c:if>>
    							<a href='${contextPath }/board/list?categoryId=1'>하루평가</a>
    						</li>    							
    						
							<li <c:if test="${category.categoryId ==2}">class='active'</c:if>>
								<a href='${contextPath }/board/list?categoryId=2'>잡담게시판</a>
							</li>    	
						</ul>  					
    				</div>
    			</div>    			