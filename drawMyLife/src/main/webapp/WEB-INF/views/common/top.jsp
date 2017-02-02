<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>New Web Project</title>
        <script src="${contextPath }/resources/js/jquery-3.1.1.min.js"></script>
        <style>
        	.wrap{
        		width:100%;   		
        	}
        	.body{
        		width:1000px;
        		margin: 0 auto;
        	}
        	.header{
        		width:100%;
        		height:150px;
        		float:left;
        	}
        	
        	/* 링크에서 밑줄 없애기 */
			
			a { text-decoration:none }

        	
        	.nav{
        		width:100%;
        		margin-bottom:10px;
        	}
        	.nav ul{
        		list-style-type: none;
        	}
        	.nav ul li {
				float: left;
				margin-right: 40px;
				text-align: center;
			}
			.nav ul li a {
				display: block;
				padding-top: 0px;
				padding-right: 20px;
				padding-bottom: 0px;
				padding-left: 20px;
				border: 1px solid #666;
			}
			.nav ul li a:link, .nav ul li a:visited {
				color: #000;
				text-decoration: none;
			}
			.nav ul li a:hover, .nav ul li a:active {
				color: #F00;
				text-decoration: underline;
			}
        	.sidebar{
        		width:150px;
        		height:1000px;
        		background-color:rgb(0,255,255);
        		border: 1px solid gold;
        		float:right;
        	}
        	.content{
        		width:840px;
        		height:1000px;
        		margin-top:20px;
        		-background-color:rgb(0,255,0);
        		float:left;
        	}
        	
        	.boardList{
        		width:100%;
        	}
        	.left{
        		float:left;
        	}
        	.right{
        		float:right;
        	}
        	.front-block{
        		width: 45%;
        		padding: 5px, 5px, 5px, 5px;
        		margin-right: 20px;
        		margin-bottom: 20px;
        		margin-top: 20px;
        		
        	}
        	.front-block2{
        		width: 100%;
        		padding: 5px, 5px, 5px, 5px;
        		margin-right: 20px;
        		margin-bottom: 20px;
        		margin-top: 20px;
        		
        	}
        	.front-border{
        		border: 1px solid red;
        	}
        	.content {font:12px/1.5 굴림, 돋움; color:#000;}
        	
        	.page_navi{
        		margin:0 auto;
        	}
        	.page_navi ul {  
			    list-style:none;  
			    float:left;  
			    display:inline;  
			}  
			.page_navi ul li {  
			    float:left;  
			}  
			.page_navi ul li a {  
			    float:left;  
			    padding:4px;  
			    margin-right:3px;  
			    width:15px;  
			    color:#000;  
			    font:bold 12px tahoma;  
			    border:1px solid #eee;  
			    text-align:center;  
			    text-decoration:none;  
			}  
			.page_navi ul li.active a {  
			    color:#fff;  
			    border:1px solid #000;  
			    background-color:#000;  
			}
			.page_navi ul li a:hover, .page_navi ul li a:focus {  
			    color:#fff;  
			    border:1px solid #000 ;  
			    background-color:#000;  
			}  
        	
        </style>
        
        <script>
        	function movePage(page){  
        		location.href=page;
        		//location.replace(page);   
        	}
        	//이메일 형식 검사
        	function emailcheck(strValue)
        	{
	        	var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	        	//입력을 안했으면
	        	if(!inputLengthCheck(strValue,0))
	        	{return false;}
	        	
	        	//이메일 형식에 맞지않으면
	        	if (!strValue.match(regExp))
	        	{return false;}
	        	return true;
        	}
        	//입력 검사
        	function inputLengthCheck(strValue,len)
        	{
        		if(strValue.length>len)
        		{
        			return true;
        		}
        		else
        		{
        			return false;
        		}
        	}
        	
        	
        	
        </script>
    </head>
    <body>
    	<div class="wrap">
    		<div class="body">
    			
    			<div class="header">
    				
    				
    				<c:if test="${sessionScope.smember == null}">
	    				<button onclick="movePage('${contextPath}/member/login')">로그인</button>
	    				<button onclick="movePage('${contextPath}/member/join')">회원가입</button>
    				</c:if>
    				<c:if test="${sessionScope.smember != null}">    					
    					${sessionScope.smember.mname }
    					<button onclick="movePage('${contextPath}/member/logout')">로그아웃</button>
    				</c:if>
    				<br>
    				<hr>
    				<a href="${contextPath }/">
    					<img src="<%=request.getContextPath()%>/resources/img/logo.jpg" />
    				</a>    				
    				<div class="nav">
    					<ul>
    						<li><a href='/web/board/list?categoryId=1'>공지사항</a></li>    							
    						
							<li><a href='/web/board/list?categoryId=2'>정보게시판</a></li>    	
						</ul>  					
    				</div>
    			</div>
    				
    			<div class="sidebar">
    				
    			</div>
    			