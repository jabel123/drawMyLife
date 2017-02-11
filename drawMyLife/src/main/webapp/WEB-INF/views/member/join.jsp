<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/top.jsp" %>
<style>
			
			.agreement .content {
				background-color:rgb(255,255,230);
				width: 100%;
				height : 300px;
				overflow: scroll;
				overflow-x:hidden
			}
		</style>
<div class="content">
	<hr>
	
	
	<h2>회원가입</h2>
	<%@include file="./privateAgreement.jsp" %>
	<br><br>
	<form id="joinForm" action="${contextPath }/member/join" method="post">
	<table  border="1" class="bluetop boardList">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" class="input_form_large" name="email" id="email_form" placeholder="ex) drawMyLife@naver.com">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" class="input_form_large" name="mname" id="mname" placeholder="ex) 주현태">
			</td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td>
				<input type="password" class="input_form_large" name="pwd" id="pwd_form" placeholder="********">
			</td>
		</tr>
		<tr>
			<td>패스워드확인</td>
			<td>
				<input type="password" class="input_form_large" name="pwdcheck" id="pwdcheck" placeholder="********">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onclick="join()">회원가입</button>
			</td>
		</tr>
		</form>
	</table>
	
	<script>
		function join(){
			
			if(!$("#agreementCheck").is(":checked"))
			{			
				alert('개인정보 방침에 동의하셔야 합니다.');
				return;
			}
			if(!emailcheck( $('#email_form').val() ))
			{
				alert('이메일 형식이 아닙니다.');
				$('#email_form').val('');
				$('#email_form').focus();
				return;
			}
			if(!inputLengthCheck($('#mname').val(),1))
			{
				alert('이름을 두 자 이상 입력하시오');
				$('#mname').val('');
				$('#mname').focus();
				return;
			}
			if($('#pwdcheck').val() != $('#pwd_form').val())
			{
				alert('비밀번호와 비밀번호체크가 같지 않습니다.');
				$('#pwdcheck').val('');
				$('#pwdcheck').focus();
				return;
			}
			$("#joinForm").submit();
			
		}
		
	</script>
</div>
</div>
</div>

</body>
</html>

